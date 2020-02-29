<template>
    <li>
        <fieldset class="service__item">
            <legend class="service__title">{{service.title}}</legend>
            <ul class="service__value">
                <li v-for="(c, index) in stringValue" :key="index" :class="{'red': (service.length - index) <= service.red }">
                    {{c}}
                </li>
            </ul>
            <b class="service__unit">{{service.unit}}</b><br>
            <time class="service__date">{{(!!date) ? new Date(date).toLocaleDateString() : 'Нет данных'}}</time>
        </fieldset>
    </li>
</template>

<script>
    export default {
        name: "PrevPayItem",
        props: ['service', 'value', 'date'],
        computed: {
            stringValue() {
                return Math.round(this.value * (10 ** this.service.red)).toString().padStart(this.service.length, '0');
            }
        }
    }
</script>

<style lang="less" scoped>
    .service__item {
        border-radius: 10px;
        font-size: 20px;
        position: relative;
    }
    .service__title {
        padding-left: 22px;
        &::before {
            content: '';
            position: absolute;
            top: 0; left: 20px;
            width: 12px; height: 100%;
            background-size: contain;
            background-repeat: no-repeat;
            background-position: top center;
            filter: grayscale(1) brightness(80%);
        }
    }
    .service__date {
        font-size: 16px;
        color: #888;
    }
    .item__1 .service__title::before {
        background-image: url(http://localhost:8000/images/hot-water.png);
    }
    .item__2 .service__title::before {
        background-image: url(http://localhost:8000/images/cold-water.png);
    }
    .item__3 .service__title::before {
        background-image: url(http://localhost:8000/images/gas.png);
    }
    .item__4 .service__title::before {
        background-image: url(http://localhost:8000/images/power.png);
    }
    .service__value {
        list-style: none;
        margin: 0; padding: 0;
        background-color: black;
        border-radius: 5px;
        border: 1px solid black;
        overflow: hidden;
        display: inline-block;
        li {
            display: inline-block;
            font-size: 20px;
            line-height: 30px;
            font-family: 'Times New Roman', sans-serif;
            height: 30px; width: 20px;
            background: linear-gradient(white, darken(white, 20%));
            color: black;
            margin-right: 1px;
            text-align: center;
        }
        li:last-child {
            margin: 0;
        }
        li.red {
            background: linear-gradient(lighten(red, 17%), red);
            color: white;
        }
    }
    .service__unit {
        font-size: 16px;
        line-height: 32px;
        vertical-align: top;
        margin-left: 5px;
    }
</style>