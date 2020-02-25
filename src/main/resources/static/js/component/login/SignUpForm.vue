<template>
    <form @submit.prevent="formSubmit">
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
            <text-field v-model="userInfo.password" min="5" max="15" class="form-group-left" type="password" label="Пароль"/>
            <text-field v-model="confirm" class="form-group-right" type="password" label="Повторите пароль"/>
        </div>
        <div class="form-group">
            <input v-model="userInfo.notify" type="checkbox" id="spam">
            <label for="spam">Получать уведомления на почту</label>
        </div>
        <div class="form-group">
            <input type="submit" value="Зарегистрироваться">
            <input type="reset" value="Сброс" @click="clearClick">
        </div>
        <alert v-bind="alert" @close="alert.isShow = false"/>
    </form>
</template>

<script>
    import TextField from "../TextField.vue";
    import Alert from "./Alert.vue";
    export default {
        name: "SignUpForm",
        components: {TextField, Alert},
        data() {
            return {
                alert: {
                    isShow: false,
                    isSuccess: false,
                    text: ''
                },
                userInfo: {},
                confirm: ''
            }
        },
        methods: {
            clearClick() {
                document.querySelector('form input').focus();
            },
            formSubmit() {
                if (this.userInfo.password !== this.confirm) {
                    this.showAlert(true, false, 'Пароли не совпадают');
                } else {
                    this.showAlert(false);
                    this.$http.post('/users', this.userInfo).then(result => {
                        if (!result.data) {
                            this.showAlert(true, false, 'Данный e-mail уже используется');
                        } else {
                            document.querySelector('form').reset();
                            this.clearClick();
                            this.showAlert(true, true, 'Регистрация прошла успешно!');
                            setTimeout(() => this.showAlert(false), 2000);
                        }
                    });
                }
            },
            showAlert(isShow, isSuccess = false, text = '') {
                this.alert = { isShow, isSuccess, text }
            }
        }
    }
</script>

<style scoped>
    input[type="checkbox"] {
        display: none;
    }
    input[type="checkbox"] + label {
        padding-left: 40px;
        line-height: 28px;
        font-weight: normal;
    }
    input[type="checkbox"]:hover + label::before {
        box-shadow: inset 0 0 5px black;
    }
    input[type="checkbox"]:checked + label::before {
        content: '✔';
        border-color: #c85000;
        background-color: rgba(200, 80, 0, 0.1);
    }
    input[type="checkbox"] + label::before {
        content: '';
        box-sizing: border-box;
        text-align: center;
        line-height: 25px;
        font-size: 20px;
        color: #c85000;
        position: absolute;
        left: 0;
        width: 25px;
        height: 25px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        border-radius: 5px;
    }
</style>