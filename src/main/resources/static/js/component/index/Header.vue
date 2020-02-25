<template>
    <section class="page-header">
        <div class="container">
            <p>Оплачивайте счета <br>с CSPay</p>
            <a class="login-button" href="/pay">Начать</a>
        </div>
    </section>
</template>

<script>
    export default {
        name: "AppHeader"
    }
</script>

<style scoped>
    .page-header {
        background: linear-gradient(#ff6600, #ffae00 400px) no-repeat;
        text-align: center;
        font-weight: bold;
        line-height: 80px;
    }
    .container {
        padding-top: 50px;
        padding-bottom: 40px;
    }
    p {
        color: #f0f0f0;
        font-size: 70px;
        margin: 0;
        padding-bottom: 55px;
        text-shadow: 0 0 5px black;
    }
    @media (max-width: 800px) {
        p {
            font-size: 50px;
            line-height: 60px;
        }
    }
    @media (max-width: 600px) {
        p {
            font-size: 40px;
            line-height: 50px;
        }
    }
    .login-button {
        display: inline-block;
        text-decoration: none;
        background-color: #f0f0f0;
        width: 400px;
        height: 80px;
        border-radius: 35px;
        box-shadow: 0 0 5px black;
        color: #c85000;
        font-size: 36px;
        text-transform: uppercase;
    }
    .login-button:hover {
        background-color: #e3e3e3;
        box-shadow: inset 0 0 5px black;
    }
    .login-button:active {
        background-color: white;
    }
</style>