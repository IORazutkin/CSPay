<template>
    <tr>
        <td class="item-title" :data-unit="unit">{{title}}</td>
        <td class="item-price">{{price}}</td>
    </tr>
</template>

<script>
    export default {
        name: "AppPriceListItem",
        props: ['title', 'price', 'unit']
    }
</script>

<style scoped>
    td {
        padding: 20px 0;
    }
    .item-price {
        padding-right: 10px;
        text-align: right;
        color: #c85000;
        font-weight: bold;
    }
    .item-price::after {
        content: "₽";
    }
    .item-title {
        padding-left: 65px;
        position: relative;
    }

    .item-title::before {
        content: '';
        position: absolute;
        top: 19px;
        left: 20px;
        width: 22px;
        height: 100%;
        background-size: contain;
        background-repeat: no-repeat;
        background-position: top center;
    }
    @media (min-width: 600px) {
        .item-title::after {
            content: ' (' attr(data-unit) ')';
        }
    }
    .item__2 .item-title::before {
        background-image: url(http://localhost:8000/images/cold-water.png);
    }
    .item__1 .item-title::before {
        background-image: url(http://localhost:8000/images/hot-water.png);
    }
    .item__3 .item-title::before {
        background-image: url(http://localhost:8000/images/gas.png);
    }
    .item__4 .item-title::before {
        background-image: url(http://localhost:8000/images/power.png);
    }
</style>