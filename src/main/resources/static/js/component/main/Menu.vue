<template>
    <nav>
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
        }
    }
</script>

<style scoped>
    nav {
        position: fixed;
        left: 0;
        top: 60px;
        width: 110px;
        height: calc(100% - 60px);
        background-color: rgba(200, 80, 0, 0.1);
        border-right: 2px solid rgba(200, 80, 0, 1);
        box-shadow: 0 0 10px rgba(200, 80, 0, 1);
        display: flex;
        justify-content: center;
        flex-direction: column;
    }
    label {
        display: inline-block;
        box-sizing: border-box;
        height: 100px;
        border-bottom: 1px solid rgba(200, 80, 0, 0.3);
        text-align: center;
        font-size: 12px;
        text-transform: uppercase;
        font-weight: bold;
        color: rgb(200, 80, 0);
        padding-top: 80px;
        position: relative;
    }
    label::before {
        display: block;
        content: '';
        width: 50px;
        height: 50px;
        position: absolute;
        top: 15px;
        left: 30px;
        background: no-repeat center;
        background-size: contain;
    }
    label:last-child {
        border: none;
    }
    .nav-btn {
        display: none;
    }
    .nav-btn:checked + label {
        background-color: rgba(200, 80, 0, 1);
        color: white;
    }
    .nav-btn:checked + label::before {
        filter: grayscale(1) brightness(10);
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