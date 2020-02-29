<template>
    <section>
        <div class="sub-section">
            <h2 class="block-title">Информация о профиле</h2>
            <form class="form" @submit.prevent="userSubmit">
                <text-field v-model="userInfo.fullName" name="fullName" class="form-group" type="text" label="ФИО"/>
                <div class="form-group">
                    <text-field v-model="userInfo.city" class="form-group-left" name="city" type="text" label="Город"/>
                    <text-field v-model="userInfo.street" class="form-group-right" name="street" type="text" label="Улица"/>
                </div>
                <div class="form-group">
                    <text-field v-model="userInfo.house" class="form-group-left" name="house" type="text" label="Дом"/>
                    <text-field v-model="userInfo.apartmentNumber" pattern="[0-9]+"
                                class="form-group-right" name="apartment" type="text" label="Квартира"/>
                </div>
                <text-field v-model="userInfo.username" class="form-group" name="username" type="email" label="E-mail"/>
                <div class="form-group">
                    <input class="checkbox" v-model="userInfo.notify" type="checkbox" id="spam">
                    <label class="checkbox-label" for="spam">Получать уведомления на почту</label>
                </div>
                <div class="form-group">
                    <input type="submit" value="Сохранить">
                </div>
                <alert v-bind="profileAlert" @close="profileAlert.isShow = false"/>
            </form>
        </div>
        <div class="sub-section">
            <h2 class="block-title">Смена пароля</h2>
            <form class="form" @submit.prevent="passwordSubmit">
                <text-field v-model="oldPassword" min="5" max="15"
                            class="form-group" type="password"
                            label="Старый пароль"/>
                <div class="form-group">
                    <text-field v-model="newPassword"
                                min="5" max="15" class="form-group-left"
                                type="password" label="Новый пароль"/>
                    <text-field v-model="confirmPassword"
                                min="5" max="15" class="form-group-right"
                                type="password" label="Повторите пароль"/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Изменить пароль">
                </div>
                <alert v-bind="passwordAlert" @close="passwordAlert.isShow = false"/>
            </form>
        </div>
        <div class="sub-section">
            <h2 class="block-title">Платежные данные</h2>
            <form class="form" @submit.prevent="cardSubmit">
                <text-field v-model="cardNumber" pattern="[0-9]{4}( [0-9]{4}){3}" class="form-group" type="text" label="Номер карты"/>
                <div class="form-group">
                    <text-field v-model="cardDate" pattern="([0-9]{2})/([0-9]{2})" class="form-group-left" type="text" label="Срок действия"/>
                    <text-field v-model="cardCvv" pattern="[0-9]{3}" class="form-group-right" type="password" label="CVV"/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Сохранить карту">
                </div>
                <alert v-bind="cardAlert" @close="cardAlert.isShow = false"/>
            </form>
        </div>
    </section>
</template>

<script>
    import TextField from "../../TextField.vue";
    import Alert from "../../Alert.vue";
    import '../../../methods';
    import {FormAlert, showAlert} from "../../../methods";

    export default {
        name: "BlockProfile",
        components: {TextField, Alert},
        data() {
            return {
                profileAlert: new FormAlert(),
                passwordAlert: new FormAlert(),
                cardAlert: new FormAlert(),
                userInfo: {},
                oldPassword: '',
                newPassword: '',
                confirmPassword: '',
                cardCvv: '',
                cardNumber: '',
                cardDate: '',
            }
        },
        watch: {
            cardDate(newValue) {
                if (newValue.match(/^[0-9]{2}$/)) {
                    this.cardDate += '/';
                }
            },
            cardNumber(newValue) {
                if (newValue.match(/[0-9]{4}$/) && newValue.length < 16) {
                    this.cardNumber += ' ';
                }
            }
        },
        created() {
            this.$http.get('/users').then(result => {
                let res = result.data,
                    apartment = res.apartment,
                    house = apartment.house,
                    card = res.card;
                this.userInfo = res;

                this.userInfo.city = house.city;
                this.userInfo.street = house.street;
                this.userInfo.house = house.house;

                this.userInfo.apartmentNumber = apartment.number.toString();

                if (card !== null) {
                    let cardNumber = card.number,
                        cardDate = new Date(card.date);
                    for (let i = 0; i < 16; i++) {
                        this.cardNumber += cardNumber[i];
                        if ((i + 1) % 4 === 0 && i < 15) {
                            this.cardNumber += ' ';
                        }
                    }
                    this.cardDate = cardDate.toLocaleDateString('en', {
                            month: '2-digit',
                            year: '2-digit'
                        });
                }
            });
        },
        methods: {
            userSubmit() {
                this.$http.put('/users/profile', this.userInfo).then(result => {
                    if (!result.data) {
                        showAlert(this.profileAlert, true, false, 'Данный e-mail уже используется');
                    } else {
                        showAlert(this.profileAlert, true, true, 'Данные успешно изменены');
                    }
                });
            },
            passwordSubmit() {
                if (this.newPassword !== this.confirmPassword) {
                    showAlert(this.passwordAlert, true, false, 'Пароли не совпадают');
                } else {
                    this.$http.put('/users/password', {}, {
                        params: {
                            oldPassword: this.oldPassword,
                            newPassword: this.newPassword
                        }
                    }).then(result => {
                            if (!result.data) {
                                showAlert(this.passwordAlert, true, false, 'Старый пароль введен неверно');
                            } else {
                                showAlert(this.passwordAlert, true, true, 'Пароль успешно изменен');
                            }
                    });
                }
            },
            cardSubmit() {
                let date = new Date();
                date.setFullYear(Number.parseInt(this.cardDate.split('/')[1]) + 2000,
                    Number.parseInt(this.cardDate.split('/')[0]) - 1, 1);
                let card = {
                    number: this.cardNumber.replace(/ /g, ''),
                    date: date,
                    cvv: this.cardCvv
                };

                this.$http.put('/users/card', card).then(result => {
                    showAlert(this.cardAlert, true, true, 'Карта успешно сохранена');
                });
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';

    .sub-section {
        border-bottom: 2px dashed @primary;
        margin-bottom: 10px;

        &:last-child {
            border: none;
            margin: 0;
        }
    }
    .form {
        margin: 20px 10px 10px;
    }
</style>