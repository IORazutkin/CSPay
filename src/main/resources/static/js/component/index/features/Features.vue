<template>
    <section class="features-section">
        <div class="container">
            <h2 class="section-title">Почему мы?</h2>
            <ul class="features">
                <li
                        is="FeatureItem" v-for="(feature, index) in features"
                        :class="'features__item-' + (index + 1)" :key="index"
                        v-bind="feature"></li>
            </ul>
        </div>
    </section>
</template>

<script>
    import FeatureItem from "./FeatureItem.vue";
    export default {
        name: "Features",
        components: {FeatureItem},
        data() {
            return {
                features: [
                    {
                        title: 'Быстрая оплата',
                        description: 'Оплата счетов за коммунальные услуги в одно касание.'
                    },
                    {
                        title: 'Контроль расходов',
                        description: 'Анализируйте свои рассходы за прошедший период.'
                    },
                    {
                        title: 'Надежность',
                        description: 'Все ваши переводы и личные данные надежно защищены.'
                    },
                    {
                        title: 'Всегда на связи',
                        description: 'Служба поддержки CSPay работает круглосуточно.'
                    }
                ]
            }
        }
    }
</script>

<style lang="less" scoped>
   @import '~styles/varibles';

    .features-section {
        border-bottom: 2px dashed @primary;
        .container {
            padding-top: 30px;
            padding-bottom: 50px;
        }
    }
    .features {
        list-style: none;
        margin: 20px 0 0;
        padding: 0;
        display: flex;
        flex-wrap: wrap;
    }
</style>