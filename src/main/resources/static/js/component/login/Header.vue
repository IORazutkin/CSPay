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

<style lang="less" scoped>
    @import '~styles/varibles';

    .modal-header {
        height: 60px;
        background-color: white;
        border-bottom: 1px solid @main-border-color;
        box-shadow: 0 0 5px black;
        display: flex;
        position: relative;

        &::after {
            content: '';
            transition: transform 150ms linear;
            position: absolute;
            bottom: -1px; left: 0;
            width: 50%; height: 5px;
            background-color: @primary;
         }
        &.sign-up__mode::after {
            transform: translateX(100%);
        }
    }
</style>