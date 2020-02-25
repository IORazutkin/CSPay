<template>
    <section>
        <h2 class="block-title">Статистика расходов</h2>
        <div class="diagram-container">
            <button class="left-arrow">&lt;</button>
            <Diagram class="services-diagram" :r="90" :stroke-width="30"
                     :data="serviceData"/>
            <button class="right-arrow">&gt;</button>
        </div>
    </section>
</template>

<script>
    import Diagram from "./Diagram.vue";
    export default {
        name: "BlockStats",
        components: {Diagram},
        data() {
            return {
                serviceData: [
                    {
                        color: 'green',
                        title: 'Газ',
                        price: 150.32
                    },
                    {
                        color: 'yellow',
                        title: 'Электроэнергия',
                        price: 162.79
                    },
                    {
                        color: 'red',
                        title: 'Горячая вода',
                        price: 691.03
                    },
                    {
                        color: 'blue',
                        title: 'Холодная вода',
                        price: 318.91
                    }
                ]
            }
        }
    }
</script>

<style scoped>
    .services-diagram {
        margin: 10px 50px 0;
    }
    .diagram-container {
        position: relative;
    }
    .left-arrow, .right-arrow {
        position: absolute;
        top: 0;
        width: 40px;
        height: 100%;
        font-size: 24px;
        font-weight: bold;
    }
    .left-arrow {
        left: 0;
    }
    .right-arrow {
        right: 0;
    }
</style>