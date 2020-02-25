<template>
    <section>
        <div class="container">
            <h2 class="section-title">Стоимость услуг</h2>
            <table>
                <tr is="AppPriceListItem" v-for="priceItem in priceList"
                    :key="priceItem.id" v-bind="priceItem" :class="'item__' + priceItem.id"></tr>
            </table>
        </div>
    </section>
</template>

<script>
    import AppPriceListItem from "./PriceListItem.vue";
    export default {
        name: "AppPriceList",
        components: {AppPriceListItem},
        data() {
            return {
                priceList: []
            }
        },
        mounted() {
            this.$http.get('/services').then(result => {
                this.priceList = result.data;
            });
        }
    }
</script>

<style scoped>
    .container {
        padding-top: 30px;
        padding-bottom: 50px;
    }
    table {
        margin-top: 20px;
        border-collapse: collapse;
        width: 100%;
        font-size: 28px;
    }
    tr {
        border-bottom: 1px solid #424242;
        filter: grayscale(1) brightness(80%);
    }
    tr:hover {
        filter: none;
        border-color: #c85000;
        background-color: rgba(200, 80, 0, 0.1);
    }
</style>