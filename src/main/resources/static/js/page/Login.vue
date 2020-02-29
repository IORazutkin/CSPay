<template>
    <transition name="fade">
        <div v-if="showModal" class="modal" @click.self="$router.back()">
            <transition appear name="scale">
                <section class="modal-page">
                    <modal-window-header @change="changeMode"/>
                    <transition mode="out-in">
                        <component class="form" :is="currentMode"/>
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

<style lang="less" scoped>
    @import '~styles/varibles';
    @import '~styles/animations';

    .scale(v, 100ms; 0.9);
    .opacity(v, 100ms);
    .opacity(fade);
    .scale(scale);

    .modal {
        position: fixed;
        width: 100%; height: 100%;
        z-index: 9999;
        background-color: @main-border-color;

        display: flex;
        justify-content: center;
        align-items: center;
    }
    .modal-page {
        width: 600px; height: auto;
        background-color: @secondary;
        border-radius: 20px;
        box-shadow: 0 0 5px black;
        overflow: hidden;
    }
    .form {
        margin: 20px;
    }
</style>