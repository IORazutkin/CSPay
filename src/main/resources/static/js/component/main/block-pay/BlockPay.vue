<template>
    <section>
        <h2 class="block-title">Показания счетчиков</h2>
        <ul class="services__data">
            <prev-pay-item :class="'item__' + service.service.id" :key="service.service.id"
                           v-for="service in services"
                           :service="service.service" :value="service.value"
                           :date="service.formationDate"
            />
        </ul>
        <form class="form" @submit.prevent="formSubmit">
            <text-field v-model="formData[index]"
                        class="value-field" v-for="(item, index) in services"
                        :key="item.service.id"
                        :label="item.service.title"
                        :name="item.service.title"
                        :required="false"/>
            <label class="total">
                Итого:
                <output class="total-price">{{totalPrice.toFixed(2)}}₽</output>
            </label>
            <div class="clearfix">
                <input :disabled="!canPay" class="make-pay" type="submit" value="Оплатить">
                <input class="make-change" type="reset" @click="changeData" value="Изменить">
                <i class="pay-date" :class="{'red-date': canPayDate}">До <time>{{payDate.toLocaleDateString()}}</time></i>
            </div>
            <alert style="margin-top: 15px;" v-bind="alert" @close="alert.isShow = false"/>
        </form>
    </section>
</template>

<script>
    import PrevPayItem from "./PrevPayItem.vue";
    import TextField from "../../TextField.vue";
    import Alert from "../../Alert.vue";
    import {FormAlert, showAlert} from "../../../methods";
    export default {
        name: "BlockPay",
        components: {TextField, PrevPayItem, Alert},
        data() {
            return {
                services: [],
                lastReceipt: {},
                lastPayReceipt: {},
                payDate: new Date(),
                formData: [],
                alert: new FormAlert(),
                user: {}
            }
        },
        mounted() {
            this.$http.get('/receipts').then(result => {
                this.lastReceipt = result.data[0];
                this.lastPayReceipt = result.data[1];
                this.payDate = new Date(this.lastReceipt.formationDate);
                this.payDate.setMonth(this.payDate.getMonth() + 1);

                this.services = this.lastReceipt.receiptServices;
            });
            this.$http.get('/users').then(result => this.user = result.data);
        },
        computed: {
            canPayDate() {
                return (this.payDate - Date.now()) / (1000 * 3600 * 24) < 7;
            },
            canPay() {
                let b1 = this.services.every(i => i.formationDate !== null);
                return b1 && this.canPayDate;
            },
            totalPrice() {
                let price = 0, rs = this.lastReceipt.receiptServices;

                if (rs) {
                    for (let item of rs) {
                        price += item.value * item.service.price;
                    }

                    if (this.lastPayReceipt) {
                        rs = this.lastPayReceipt.receiptServices;
                        for (let item of rs) {
                            price -= item.value * item.service.price;
                        }
                    }
                }

                return Math.abs(price);
            }
        },
        methods: {
            changeData() {
                if (this.formData.every(v =>
                    v.match(/^([0-9]+((\.|,)[0-9]+)?)?$/))) {
                    if (this.formData.some(v => !!v)) {
                        this.formData.forEach((v, i) => {
                            this.lastReceipt.receiptServices[i].formationDate = new Date();
                            this.lastReceipt.receiptServices[i].value = v.replace(/,/g, '.');
                        });
                        this.$http.put('/receipts/value', this.lastReceipt).then(result => {
                            this.lastReceipt = result.data;
                            showAlert(this.alert, true, true, 'Показания счетчиков изменены');
                        });
                    } else {
                        showAlert(this.alert, true, false, 'Заполните поля');
                    }
                } else {
                    showAlert(this.alert, true, false, 'Неверный формат данных');
                }
            },
            formSubmit() {
                if (!this.user.card) {
                    showAlert(this.alert, true, false, 'Заполните данные карты в профиле')
                } else {
                    this.$http.put('/receipts/pay', {}).then(result => {
                        this.lastReceipt = result.data[0];
                        this.lastPayReceipt = result.data[1];
                        this.payDate = new Date(this.lastReceipt.formationDate);
                        this.payDate.setMonth(this.payDate.getMonth() + 1);

                        this.services = this.lastReceipt.receiptServices;
                    });
                }
            }
        }
    }
</script>

<style lang="less" scoped>
    .services__data {
        list-style: none;
        padding: 0; margin: 0;
        display: flex;
        flex-wrap: wrap;

        li {
            flex: 1 0 300px;
            margin: 10px;
        }
    }
    .pay-date {
        float: right;
        font-size: 18px;
        line-height: 40px;
        text-transform: lowercase;
        color: #666;

        &.red-date {
            color: red;
            font-weight: bold;
        }
    }
    .make-pay, .make-change {
        height: 40px; width: 150px;
        float: right;
    }
    .make-change {
        margin-left: 20px;
        margin-right: 10px;
    }
    .service-value-form {
        margin-top: 5px;
    }
    .value-field {
        display: flex;
        flex-wrap: wrap;
        margin-bottom: 15px;
    }
    .total {
        line-height: 40px;
        font-weight: bold;

        .total-price {
            display: inline-block;
            border: 1px solid black;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.5);
            text-align: right;
            padding-right: 10px;
            width: 140px;
            font-weight: normal;
            margin-left: 10px;
        }
    }
    .clearfix {
        margin-top: 10px;
    }
</style>