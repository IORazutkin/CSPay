<template>
    <transition name="fade">
        <div v-if="showModal" class="modal" @click.self="$router.back()">
            <transition appear name="scale">
                <section class="modal-page">
                    <modal-window-header @change="changeMode"/>
                    <transition mode="out-in">
                        <component class="modal-page__form" :is="currentMode"/>
                    </transition>
                </section>
            </transition>
        </div>
    </transition>
</template>

<script>
    import ModalWindowHeader from '../component/login/Header.vue';
    import SignInForm from "../component/login/SignInForm.vue";
    import SignUpForm from "../component/login/SignUpForm.vue";

    SignUpForm.mounted = SignInForm.mounted = function() {
        setTimeout(() => {
            let inputs = document.querySelectorAll('form input'),
                firstInput = inputs[0],
                lastInput = inputs[inputs.length - 1];

            firstInput.focus();
            lastInput.addEventListener('keydown', function (evt) {
                evt.preventDefault();
                firstInput.focus();
            });
        }, 200);
    };

    export default {
        name: "Login",
        components: {ModalWindowHeader, SignInForm, SignUpForm},
        data() {
            return {
                currentMode: SignInForm,
                showModal: true
            }
        },
        methods: {
            changeMode(isAuth) {
                this.currentMode = isAuth ? SignInForm : SignUpForm;
            }
        }
    }
</script>

<style>
    .form-group {
        position: relative;
        display: flex;
        flex-wrap: wrap;
    }
    .modal-page__form > * {
        margin-bottom: 15px;
    }
    .modal-page__form :last-child {
        margin-bottom: 0;
    }
    .modal-page__form .form-group-left,
    .modal-page__form .form-group-right {
        display: flex;
        flex-wrap: wrap;
        flex-grow: 1;
    }
    .modal-page__form .form-group-left {
        margin-right: 15px;
    }
    .modal-page__form input[type="submit"],
    .modal-page__form input[type="reset"] {
        height: 40px;
        border: none;
        outline: none;
        background-color: #c85000;
        border-radius: 5px;
        color: white;
        font: inherit;
        font-weight: bold;
        font-size: 16px;
        line-height: 40px;
        text-transform: uppercase;
        flex-grow: 1;
    }
    .modal-page__form input[type="submit"]:hover,
    .modal-page__form input[type="submit"]:focus {
        background-color: #953c00;
        box-shadow: inset 0 0 5px black;
    }
    .modal-page__form input[type="submit"]:active {
        background-color: #ffae00;
    }
    .modal-page__form .form-group input[type="reset"]
    .modal-page__form .form-group input[type="submit"] {
        flex-grow: 1;
    }
    .modal-page__form .form-group input[type="reset"] {
        background-color: #f0f0f0;
        color: #c85000;
        border: 1px solid rgba(0, 0, 0, 0.3);
        margin-left: 15px;
    }
    .modal-page__form .form-group input[type="reset"]:hover,
    .modal-page__form .form-group input[type="reset"]:focus {
        background-color: rgba(0, 0, 0, 0.05);
        box-shadow: inset 0 0 5px black;
    }
    .modal-page__form .form-group input[type="reset"]:active {
        background-color: white;
    }
</style>
<style scoped>
    .v-enter-active, .v-leave-active {
        transition: 100ms linear;
    }
    .v-enter, .v-leave-to {
        opacity: 0;
        transform: scale(0.9);
    }
    .v-enter-to, .v-leave {
        opacity: 1;
        transform: scale(1);
    }
    .fade-enter-active, .fade-leave-active, .scale-enter-active {
        transition: 200ms linear;
    }
    .fade-enter, .fade-leave-to {
        opacity: 0;
    }
    .fade-enter-to, .fade-leave {
        opacity: 1;
    }
    .scale-enter {
        transform: scale(0);
    }
    .scale-enter-to {
        transform: scale(1);
    }
    .modal {
        position: fixed;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        z-index: 9999;
        background-color: rgba(0, 0, 0, 0.3);

        display: flex;
        justify-content: center;
        align-items: center;
    }
    .modal-page {
        width: 600px;
        height: auto;
        background-color: #f0f0f0;
        border-radius: 20px;
        box-shadow: 0 0 5px black;
        overflow: hidden;
    }
    form {
        margin: 20px;
        display: flex;
        flex-direction: column;
    }
</style>