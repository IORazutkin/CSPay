<template>
    <form @submit.prevent="formSubmit">
        <text-field v-model="username" class="form-group" name="username" type="email" label="E-mail"/>
        <text-field v-model="password" class="form-group" name="password" type="password" label="Пароль"/>
        <div class="form-group">
            <input type="submit" value="Вход">
        </div>
        <alert v-bind="alert" @close="alert.isShow = false"/>
    </form>
</template>

<script>
    import TextField from "../TextField.vue";
    import Alert from "../Alert.vue";
    import {FormAlert, showAlert} from "../../methods";

    export default {
        name: "SignInForm",
        components: {Alert, TextField},
        data() {
            return {
                alert: new FormAlert(),
                username: '',
                password: ''
            }
        },
        methods: {
            formSubmit() {
                let formData = new FormData();
                formData.append("username", this.username);
                formData.append("password", this.password);

                this.$http.post('/login', formData).then(
                    result => {
                        this.$router.replace('/pay');
                    },
                    error => {
                        showAlert(this.alert, true, false, 'Неверный логин или пароль');
                        setTimeout(() => showAlert(this.alert, false), 2000);
                    });
            }
        }
    }
</script>

<style scoped>

</style>