<template>
    <div>
        <div class="center">
            <h3 class="month">{{currentDate}}</h3>
            <svg :width="width"
                 :height="width">
                <circle class="back" :r="r"
                        :stroke-width="strokeWidth + 2">
                </circle>
                <g class="diagram">
                    <circle v-for="circle in diagram"
                            :stroke="circle.color"
                            :stroke-width="strokeWidth" :r="r"
                            :stroke-dasharray="circle.dashArray"
                            :stroke-dashoffset="circle.dashOffset">
                    </circle>
                    <text class="text" x="50%" y="50%">{{totalPrice}}₽</text>
                </g>
            </svg>
        </div>
        <table v-if="data" class="diagram-description">
            <tr v-for="(item, index) in data.data">
                <td :style="{color: colors[index]}" class="item-title"><span>{{item.title}}</span></td>
                <td class="diagram-price">{{item.price.toFixed(2)}}</td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        name: "Diagram",
        props: ['r', 'data', 'stroke-width'],
        data() {
            return {
                colors: [
                    '#00ee00', '#eeee00', '#ff6060', '#6060ff'
                ],
            }
        },
        computed: {
            width() {
                return 2 * (this.r + this.strokeWidth / 2) + 10;
            },
            currentDate() {
                let options = {
                    month: 'long',
                    year: 'numeric'
                };

                if (this.data)
                    return new Date(this.data.dataDate).toLocaleDateString("ru", options);
            },
            diagram() {
                if (this.data) {
                    let arr = [],
                        circleLength = Math.PI * this.r * 2,
                        offset = 0, index = 0;

                    for (let item of this.data.data) {
                        let s = {},
                            percent = item.price / this.totalPrice,
                            length = percent * circleLength;

                        s.color = this.colors[index++];
                        s.dashArray = [length,
                            circleLength * (1 - percent)
                        ];
                        s.dashOffset = offset;
                        offset -= length;
                        arr.push(s);
                    }

                    return arr;
                }
            },
            totalPrice() {
                if (this.data) {
                    return this.data.data.map(i => i.price)
                        .reduce((sum, current) => {
                            return sum + current;
                        }, 0).toFixed(2);
                }
            }
        }
    }
</script>

<style lang="less" scoped>
    circle {
        cx: 50%; cy: 50%;
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
        margin: 0 0 10px;
        width: 100%;

        tr {
            font-size: 24px;
        }
        span {
            color: #424242;
        }
        td {
            padding: 5px 0;
        }
        .item-title::before {
            content: '';
            display: inline-block;
            width: 15px; height: 15px;
            background-color: currentColor;
            border: 1px solid black;
            margin-right: 10px;
        }
    }
    .diagram-price {
        font-weight: bold;
        text-align: right;
        &::after {
            content: '₽';
        }
    }
</style>