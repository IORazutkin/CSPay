<template>
    <header class="page-header">
        <div class="container">
            <p class="page-slogan">Оплачивайте счета <br>с CSPay</p>
            <a class="login-button" href="/pay">Начать</a>
        </div>
    </header>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';

    .page-header {
        background: @header-gradient no-repeat;
        text-align: center;
        font-weight: bold;
        line-height: 80px;

        .container {
            padding-top: 50px;
            padding-bottom: 40px;
        }
    }
    .page-slogan {
        color: @secondary;
        font-size: 70px;
        margin: 0;
        padding-bottom: 55px;
        text-shadow: 0 0 5px black;

        @media (max-width: 800px) {
            font-size: 50px;
            line-height: 60px;
        }
        @media (max-width: 600px) {
            font-size: 40px;
            line-height: 50px;
        }
    }
    .login-button {
        display: inline-block;
        text-decoration: none;
        background-color: @secondary;
        width: 400px; height: 80px;
        border-radius: 35px;
        box-shadow: 0 0 5px black;
        color: @primary;
        font-size: 36px;
        text-transform: uppercase;

        &:hover {
            background-color: #e3e3e3;
            box-shadow: inset 0 0 5px black;
        }
        &:active {
            background-color: white;
        }
    }
</style>