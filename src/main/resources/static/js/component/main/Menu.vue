<template>
    <nav class="main-menu">
        <input @change="change('/pay')" id="pay" type="radio" name="nav" class="nav-btn pay" checked/>
        <label for="pay">Оплата</label>
        <input @change="change('/stats')" id="stats" type="radio" name="nav" class="nav-btn stats"/>
        <label for="stats">Статистика</label>
        <input @change="change('/profile')" id="settings" type="radio" name="nav" class="nav-btn settings"/>
        <label for="settings">Профиль</label>
    </nav>
</template>

<script>
    export default {
        name: "Menu",
        methods: {
            change(target) {
                this.$emit('change', target);
            }
        },
        mounted() {
            let menuItems = document.querySelectorAll('input[type="radio"]');
            if (this.$route.path === '/stats') {
                menuItems[1].checked = true;
            } else if (this.$route.path === '/profile') {
                menuItems[2].checked = true;
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';

    .main-menu {
        position: fixed;
        left: 0; top: 60px;
        width: 110px; height: calc(100% - 60px);
        background-color: @primary-opacity;
        border-right: 2px solid @primary;
        box-shadow: 0 0 10px @primary;
        display: flex;
        justify-content: center;
        flex-direction: column;
        transition: transform 100ms linear;

        &.nav-open {
            transform: translateX(0);
        }
        @media handheld, (max-width: 700px) {
            transform: translateX(-130px);
            background-color: lighten(@primary, 50%);
        }
    }
    label {
        display: inline-block;
        box-sizing: border-box;
        border-bottom: 1px solid fade(@primary, 30%);
        height: 100px;
        text-align: center;
        font-size: 12px;
        text-transform: uppercase;
        font-weight: bold;
        color: @primary;
        padding-top: 80px;
        position: relative;

        &::before {
            display: block;
            content: '';
            width: 50px; height: 50px;
            position: absolute;
            top: 15px; left: 30px;
            background: no-repeat center;
            background-size: contain;
        }
        &:last-child {
            border: none;
        }
    }
    .nav-btn {
        display: none;

        &:checked + label {
            background-color: @primary;
            color: white;
            &::before {
                filter: grayscale(1) brightness(10);
            }
        }
    }
    .pay + label::before {
        background-image: url(http://localhost:8000/images/pay.png);
    }
    .stats + label::before {
        background-image: url(http://localhost:8000/images/stats.png);
    }
    .settings + label::before {
        background-image: url(http://localhost:8000/images/profile.png);
    }
</style>