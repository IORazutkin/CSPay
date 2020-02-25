<template>
    <li>
        <fieldset>
            <legend>{{title}}</legend>
            <ul class="data">
                <li v-for="(c, index) in stringValue" :key="index" :class="{'red': (length - index) <= red }">
                    {{c}}
                </li>
            </ul>
            <b>{{unit}}</b>
            <br>
            <time>28.01.2020</time>
        </fieldset>
    </li>
</template>

<script>
    export default {
        name: "PrevPayItem",
        props: ['title', 'unit', 'value', 'length', 'red'],
        computed: {
            stringValue() {
                return this.value.toString().padStart(this.length, '0');
            }
        }
    }
</script>

<style scoped>
    fieldset {
        border-radius: 10px;
        font-size: 20px;
        position: relative;
    }
    legend {
        padding-left: 22px;
    }
    legend::before {
        content: '';
        position: absolute;
        top: 0;
        left: 20px;
        width: 12px;
        height: 100%;
        background-size: contain;
        background-repeat: no-repeat;
        background-position: top center;
        filter: grayscale(1) brightness(80%);
    }
    time {
        font-size: 16px;
        color: #888;
    }
    .item__2 legend::before {
        background-image: url(http://localhost:8000/images/hot-water.png);
    }
    .item__3 legend::before {
        background-image: url(http://localhost:8000/images/cold-water.png);
    }
    .item__1 legend::before {
        background-image: url(http://localhost:8000/images/gas.png);
    }
    .item__4 legend::before {
        background-image: url(http://localhost:8000/images/power.png);
    }
    .data {
        list-style: none;
        margin: 0;
        padding: 0;
        background-color: black;
        border-radius: 5px;
        border: 1px solid black;
        overflow: hidden;
        display: inline-block;
    }
    .data li {
        display: inline-block;
        font-size: 20px;
        line-height: 30px;
        font-family: 'Times New Roman', sans-serif;
        height: 30px;
        width: 20px;
        background: linear-gradient(white, #ddd);
        color: black;
        margin-right: 1px;
        text-align: center;
    }
    b {
        font-size: 16px;
        line-height: 32px;
        vertical-align: top;
        margin-left: 5px;
    }
    .data li:last-child {
        margin: 0;
    }
    li.red {
        background: linear-gradient(#ff5058, red);
        color: white;
    }
</style>

<!--Вода, газ - 8/3-->
<!--Электричество 6/1-->