<template>
    <div class="modal-header" :class="{'sign-up__mode': !authChecked}" >
        <header-radio :label="'Авторизация'" :name="'mode'"
                                   :id="'sign-in'" :checked="authChecked"
                                   @change="change"/>
        <header-radio :label="'Регистрация'" :name="'mode'"
                                   :id="'sign-out'" :checked="!authChecked" @change="change"/>
    </div>
</template>

<script>
    import HeaderRadio from "./HeaderRadio.vue";
    export default {
        name: "ModalWindowHeader",
        components: {HeaderRadio},
        data() {
            return {
                authChecked: true
            }
        },
        methods: {
            change() {
                this.authChecked = !this.authChecked;
                this.$emit('change', this.authChecked);
                this.$router.replace(this.authChecked ? '/login' : '/registration');
            }
        },
        mounted() {
            if (this.$route.path === '/registration') {
                this.authChecked = false;
                this.$emit('change', this.authChecked);
            }
        }
    }
</script>

<style scoped>
    .modal-header {
        height: 60px;
        background-color: white;
        border-bottom: 1px solid rgba(0, 0, 0, 0.3);
        box-shadow: 0 0 5px black;
        display: flex;
        position: relative;
    }
    .modal-header::after {
        content: '';
        transition: transform 150ms linear;
        position: absolute;
        bottom: -1px;
        left: 0;
        width: 50%;
        height: 5px;
        background-color: #c85000;
    }
    .modal-header.sign-up__mode::after {
        transform: translateX(100%);
    }
</style>