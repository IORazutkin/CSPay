<template>
    <section class="price">
        <div class="container">
            <h2 class="section-title">Стоимость услуг</h2>
            <table class="price-list">
                <tr class="price-list__item" is="PriceListItem" v-for="priceItem in priceList"
                    :key="priceItem.id" v-bind="priceItem" :class="'item__' + priceItem.id"></tr>
            </table>
        </div>
    </section>
</template>

<script>
    import PriceListItem from "./PriceListItem.vue";
    export default {
        name: "PriceList",
        components: {PriceListItem},
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

<style lang="less" scoped>
    @import '~styles/varibles';

    .price .container {
        padding-top: 30px;
        padding-bottom: 50px;
    }
    .price-list {
        margin-top: 20px;
        border-collapse: collapse;
        width: 100%;
        font-size: 28px;
    }
    .price-list__item {
        border-bottom: 1px solid #424242;
        filter: grayscale(1) brightness(80%);

        &:hover {
            filter: none;
            border-color: @primary;
            background-color: @primary-opacity;
        }
    }
</style>