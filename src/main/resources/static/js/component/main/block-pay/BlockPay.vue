<template>
    <section>
        <h2 class="block-title">Показания счетчиков</h2>
        <ul class="prev-data">
            <prev-pay-item :class="'item__' + (index + 1)" :key="index"
                           v-for="(service, index) in services"
                           v-bind="service" value="0"/>
        </ul>
        <form method="post" action="#">
            <text-field class="text-field" v-for="item in services" :key="item.id"
                        :label="item.title"
                        :name="item.title"/>
            <label>
                Итого:
                <output>1000₽</output>
            </label>
            <div class="clearfix">
                <input class="make-pay" type="submit" value="Оплатить">
                <input class="make-change" type="submit" value="Изменить">
                <i>До <time>01.02.2020</time></i>
            </div>
        </form>
    </section>
</template>

<script>
    import PrevPayItem from "./PrevPayItem.vue";
    import TextField from "../../TextField.vue";
    export default {
        name: "BlockPay",
        components: {TextField, PrevPayItem},
         data() {
            return {
                services: []
            }
         },
        mounted() {
            this.$http.get('/services').then(result => {
                this.services = result.data;
            });
        }
    }
</script>

<style scoped>
    .prev-data {
        list-style: none;
        padding: 0;
        margin: 0;
        display: flex;
        flex-wrap: wrap;
    }
    .prev-data li {
        flex: 1 0 300px;
        margin: 10px;
    }
    i {
        float: right;
        font-size: 18px;
        line-height: 40px;
        text-transform: lowercase;
        color: #666;
    }
    .make-pay,
    .make-change {
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
        float: right;
    }
    .make-pay:hover,
    .make-pay:focus {
        background-color: #953c00;
        box-shadow: inset 0 0 5px black;
    }
    .make-pay:active {
        background-color: #ffae00;
    }
    .make-change {
        background-color: #f0f0f0;
        color: #c85000;
        border: 1px solid rgba(0, 0, 0, 0.3);
        margin-left: 20px;
        margin-right: 10px;
    }
    .make-change:hover,
    .make-change:focus {
        background-color: rgba(0, 0, 0, 0.05);
        box-shadow: inset 0 0 5px black;
    }
    .make-change:active {
        background-color: white;
    }
    form {
        margin-top: 5px;
    }
    .text-field {
        display: flex;
        flex-wrap: wrap;
        margin-bottom: 15px;
    }
    label {
        line-height: 40px;
        font-weight: bold;
    }
    label output {
        display: inline-block;
        border: 1px solid black;
        border-radius: 5px;
        background-color: rgba(255, 255, 255, 0.5);
        text-align: right;
        padding-right: 10px;
        width: 140px;
        font-weight: normal;
    }
    .clearfix {
        margin-top: 10px;
    }
</style>