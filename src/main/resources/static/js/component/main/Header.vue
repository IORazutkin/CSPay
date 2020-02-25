<template>
    <header class="clearfix">
        <button class="header-menu" @click="$emit('menu')">
            &#9776;
        </button>
        <div class="logo">
            CSPay
        </div>
        <div class="logout">
            <a href="/logout"></a>
        </div>
        <div class="address">
            Казань, Пушкина 32, кв. 245
        </div>
    </header>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>
    header {
        background: linear-gradient(#ff6600, #ffae00) no-repeat;
        height: 60px;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        z-index: 1;
    }
    .header-menu {
        outline: none;
        display: block;
        float: left;
        font-size: 40px;
        color: white;
        text-shadow: 0 0 5px black;
        width: 60px;
        height: 60px;
        line-height: 60px;
        text-align: center;
        margin-right: -10px;
        border: none;
        background-color: transparent;
    }
    .header-menu:hover {
        background-color: rgba(0, 0, 0, 0.1);
    }
    .header-menu:active {
        background-color: rgba(0, 0, 0, 0.2);
    }
    .logo {
        float: left;
        color: #f0f0f0;
        font-size: 30px;
        line-height: 60px;
        margin-left: 20px;
        text-shadow: 0 0 5px black;
    }
    .address, .logout {
        float: right;
    }
    .address {
        color: #f0f0f0;
        font-size: 18px;
        line-height: 60px;
        margin-right: 20px;
        text-shadow: 0 0 5px black;
    }
    .logout {
        margin-right: 20px;
    }
    .logout a {
        display: inline-block;
        width: 40px;
        height: 40px;
        border-radius: 50%;
        margin-top: 10px;
        background: url(http://localhost:8000/images/logout.png) no-repeat center;
        background-size: 24px;
    }
    .logout a:hover {
        background-color: rgba(0, 0, 0, 0.1);
    }
    .logout a:active {
        filter: opacity(0.8);
    }
    @media (min-width: 700px) {
        .header-menu {
            display: none;
        }
        .address {
            font-size: 20px;
        }
    }
</style>Казань, Пушкина 32, кв. 245