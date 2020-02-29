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
            <input class="checkbox" v-model="userInfo.notify" type="checkbox" id="spam">
            <label class="checkbox-label" for="spam">Получать уведомления на почту</label>
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
    import Alert from "../Alert.vue";
    import {FormAlert, showAlert} from "../../methods";
    export default {
        name: "SignUpForm",
        components: {TextField, Alert},
        data() {
            return {
                alert: new FormAlert(),
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
                    showAlert(this.alert, true, false, 'Пароли не совпадают');
                } else {
                    showAlert(this.alert, false);
                    this.$http.post('/users', this.userInfo).then(result => {
                        if (!result.data) {
                            showAlert(this.alert, true, false, 'Данный e-mail уже используется');
                        } else {
                            document.querySelector('form').reset();
                            this.clearClick();
                            showAlert(this.alert, true, true, 'Регистрация прошла успешно!');
                        }
                    });
                }
            }
        }
    }
</script>

<style scoped>

</style>