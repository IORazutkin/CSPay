<template>
    <form @submit.prevent="formSubmit">
        <text-field v-model="username" class="form-group" name="username" type="email" label="E-mail"/>
        <text-field v-model="password" class="form-group" name="password" type="password" label="Пароль"/>
        <input type="submit" value="Вход">
        <alert v-bind="alert" @close="alert.isShow = false"/>
    </form>
</template>

<script>
    import TextField from "../TextField.vue";
    import Alert from "./Alert.vue";

    export default {
        name: "SignInForm",
        components: {Alert, TextField},
        data() {
            return {
                alert: {
                    isShow: false,
                    isSuccess: false,
                    text: ''
                },
                username: '',
                password: ''
            }
        },
        methods: {
            showAlert(isShow, isSuccess = false, text = '') {
                this.alert = { isShow, isSuccess, text }
            },
            formSubmit() {
                let formData = new FormData();
                formData.append("username", this.username);
                formData.append("password", this.password);

                this.$http.post('/login', formData).then(
                    result => {
                        this.$router.replace('/pay');
                    },
                    error => {
                        this.showAlert(true, false, 'Неверный логин или пароль');
                        setTimeout(() => this.showAlert(false), 2000);
                    });
            }
        }
    }
</script>

<style scoped>

</style>