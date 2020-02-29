<template>
    <section>
        <h2 class="block-title">Статистика расходов</h2>
        <div class="diagram-container">
            <button :disabled="currentMonth === 0" class="left-arrow" @click="currentMonth -= 1">&lt;</button>
            <Diagram class="services-diagram" :r="100" :stroke-width="30"
                     :data="serviceData[currentMonth]"/>
            <button :disabled="currentMonth === serviceData.length - 1"
                    class="right-arrow" @click="currentMonth += 1">&gt;</button>
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
                serviceData: [],
                currentMonth: 0
            }
        },
        created() {
            this.$http.get('/receipts/stats').then(result => {
                for (let item of result.data) {
                    let res = {};
                    res.dataDate = item.formationDate;
                    res.data = [];

                    for (let s of item.receiptServices) {
                        let service = {};
                        service.title = s.service.title;
                        service.price = s.value * s.service.price;

                        res.data.push(service);
                    }

                    this.serviceData.push(res);
                }

                this.currentMonth = this.serviceData.length - 1;
            });
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
        width: 40px; height: 100%;
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