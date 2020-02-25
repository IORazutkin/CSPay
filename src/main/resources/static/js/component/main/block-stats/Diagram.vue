<template>
    <div>
        <div class="center">
            <h3 class="month">Январь</h3>
            <svg :width="width"
                 :height="width">
                <circle class="back" :r="r"
                        :stroke-width="strokeWidth + 2">
                </circle>
                <g class="diagram">
                    <circle v-for="circle in createDiagram()"
                            :stroke="circle.color"
                            :stroke-width="strokeWidth" :r="r"
                            :stroke-dasharray="circle.dashArray"
                            :stroke-dashoffset="circle.dashOffset">
                    </circle>
                    <text class="text" x="50%" y="50%">{{totalPrice}}₽</text>
                </g>
            </svg>
        </div>
        <ul class="diagram-description">
            <li v-for="item in data" :style="{color: item.color}">
                <span>{{item.title}}<b class="diagram-price"> - {{item.price}}</b></span>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "Diagram",
        props: ['r', 'data', 'stroke-width'],
        computed: {
            width() {
                return 2 * (this.r + this.strokeWidth / 2) + 10;
            },
            totalPrice() {
                return this.data.map(i => i.price)
                    .reduce((sum, current) => {
                    return sum + current;
                }, 0);
            }
        },
        methods: {
            createDiagram() {
                let arr = [],
                    circleLength = Math.PI * this.r * 2,
                    offset = 0;

                for (let item of this.data) {
                    let s = {},
                        percent = item.price / this.totalPrice,
                        length = percent * circleLength;

                    s.color = item.color;
                    s.dashArray = [length,
                        circleLength * (1 - percent)
                    ];
                    s.dashOffset = offset;
                    offset -= length;
                    arr.push(s);
                }

                return arr;
            }
        }
    }
</script>

<style scoped>
    circle {
        cx: 50%;
        cy: 50%;
    }
    .back {
        fill: white;
        fill-opacity: 0.5;
        stroke: black;
    }
    .diagram circle {
        fill: transparent;
    }
    .text {
        dominant-baseline: middle;
        text-anchor: middle;
        font-size: 28px;
        font-weight: bold;
    }
    .center {
        display: table;
        margin: 0 auto;
        text-align: center;
    }
    .month {
        margin: 0 0 10px;
        font-size: 24px;
    }
    .diagram-description {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        list-style: none;
        padding: 0;
        margin: 0 0 10px;
    }
    .diagram-description li {
        font-size: 20px;
        margin-top: 10px;
        flex-basis: 300px;
    }
    .diagram-description span {
        color: #424242;
    }
    .diagram-description li::before {
        content: '';
        display: inline-block;
        width: 15px;
        height: 15px;
        background-color: currentColor;
        border: 1px solid black;
        margin-right: 10px;
    }
    .diagram-price::after {
        content: '₽';
    }
</style>