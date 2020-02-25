<template>
    <section>
        <h2 class="block-title">Показания счетчиков</h2>
        <ul class="prev-data">
            <prev-pay-item :class="'item__' + (index + 1)" :key="index"
                           v-for="(service, index) in services"
                           v-bind="service" value="0"/>
        </ul>
        <div class="clearfix">
            <input type="button" value="Изменить">
            <i>До <time>01.02.2020</time></i>
        </div>
    </section>
</template>

<script>
    import PrevPayItem from "./PrevPayItem.vue";
    export default {
        name: "BlockPay",
        components: {PrevPayItem},
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
        margin-right: 20px;
        line-height: 40px;
        text-transform: lowercase;
        color: #666;
    }
    input {
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
        width: 150px;
        float: right;
    }
    input:hover {
        background-color: #953c00;
        box-shadow: inset 0 0 5px black;
    }
    input:active {
        background-color: #ffae00;
    }
</style>