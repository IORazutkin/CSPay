<template>
    <tr>
        <td class="item__title" :data-unit="unit">{{title}}</td>
        <td class="item__price">{{price}}</td>
    </tr>
</template>

<script>
    export default {
        name: "PriceListItem",
        props: ['title', 'price', 'unit']
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';

    td {
        padding: 20px 0;
    }
    .item__price {
        padding-right: 10px;
        text-align: right;
        color: @primary;
        font-weight: bold;

        &::after {
             content: "₽";
        }
    }
    .item__title {
        padding-left: 65px;
        position: relative;

        &::before {
            content: '';
            position: absolute;
            top: 19px; left: 20px;
            width: 22px; height: 100%;
            background-size: contain;
            background-repeat: no-repeat;
            background-position: top center;
        }
        @media (min-width: 600px) {
            &::after {
                content: ' (' attr(data-unit) ')';
            }
        }
    }
    .item__1 .item__title::before {
        background-image: url(http://localhost:8000/images/hot-water.png);
    }
    .item__2 .item__title::before {
        background-image: url(http://localhost:8000/images/cold-water.png);
    }
    .item__3 .item__title::before {
        background-image: url(http://localhost:8000/images/gas.png);
    }
    .item__4 .item__title::before {
        background-image: url(http://localhost:8000/images/power.png);
    }
</style>