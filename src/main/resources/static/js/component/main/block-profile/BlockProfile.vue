<template>
    <section>
        <h2 class="block-title">Информация о профиле</h2>
        <form class="modal-page__form">
            <text-field v-model="userInfo.fullName" name="fullName" class="form-group" type="text" label="ФИО"/>
            <div class="form-group">
                <text-field v-model="userInfo.city" class="form-group-left" name="city" type="text" label="Город"/>
                <text-field v-model="userInfo.street" class="form-group-right" name="street" type="text" label="Улица"/>
            </div>
            <div class="form-group">
                <text-field v-model="userInfo.house" class="form-group-left" name="house" type="text" label="Дом"/>
                <text-field v-model="userInfo.apartmentNumber" pattern="[0-9]+"
                            class="form-group-right" name="apartment" type="text" label="Квартира"/>
            </div>
            <div class="form-group">
                <text-field v-model="userInfo.username" class="form-group-left" name="username" type="email" label="E-mail"/>
                <text-field v-model="userInfo.password" min="5" max="15" class="form-group-right" type="password" label="Пароль"/>
            </div>
            <div class="form-group">
                <input v-model="userInfo.notify" type="checkbox" id="spam">
                <label for="spam">Получать уведомления на почту</label>
            </div>
            <text-field name="cardNumber" class="form-group" type="text" label="Номер карты"/>
            <div class="form-group">
                <text-field class="form-group-left" name="username" type="text" label="Срок действия"/>
                <text-field min="3" max="3" class="form-group-right" type="text" label="CVV"/>
            </div>
            <div class="clearfix">
                <input type="submit" value="Сохранить">
                <input type="button" value="Изменить">
            </div>
            <alert/>
        </form>
    </section>
</template>

<script>
    import TextField from "../../TextField.vue";
    import Alert from "../../login/Alert.vue";

    export default {
        name: "BlockProfile",
        components: {TextField, Alert},
        data() {
            return {
                userInfo: {}
            }
        }
    }
</script>

<style scoped>
    .form-group {
        position: relative;
        display: flex;
        flex-wrap: wrap;
    }
    .modal-page__form {
        margin: 20px 10px 10px;
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
    .clearfix input {
        float: right;
        height: 40px;
        width: 150px;
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
    }
    input[type="submit"]:hover,
    input[type="submit"]:focus {
        background-color: #953c00;
        box-shadow: inset 0 0 5px black;
    }
    input[type="submit"]:active {
        background-color: #ffae00;
    }
    input[type="button"] {
        background-color: #f0f0f0;
        color: #c85000;
        border: 1px solid rgba(0, 0, 0, 0.3);
        margin-right: 10px;
    }
    input[type="button"]:hover,
    input[type="button"]:focus {
        background-color: rgba(0, 0, 0, 0.05);
        box-shadow: inset 0 0 5px black;
    }
    input[type="button"]:active {
        background-color: white;
    }
    input[type="checkbox"] {
        display: none;
    }
    input[type="checkbox"] + label {
        padding-left: 40px;
        line-height: 28px;
        font-weight: normal;
    }
    input[type="checkbox"]:hover + label::before {
        box-shadow: inset 0 0 5px black;
    }
    input[type="checkbox"]:checked + label::before {
        content: '✔';
        border-color: #c85000;
        background-color: rgba(200, 80, 0, 0.1);
    }
    input[type="checkbox"] + label::before {
        content: '';
        box-sizing: border-box;
        text-align: center;
        line-height: 25px;
        font-size: 20px;
        color: #c85000;
        position: absolute;
        left: 0;
        width: 25px;
        height: 25px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        border-radius: 5px;
    }
</style>