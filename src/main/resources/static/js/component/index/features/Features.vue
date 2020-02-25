<template>
    <section>
        <div class="container">
            <h2 class="section-title">Почему мы?</h2>
            <ul>
                <li
                        is="AppFeatureItem" v-for="(feature, index) in features"
                        :class="'feature-item-' + (index + 1)" :key="index"
                        v-bind="feature"></li>
            </ul>
        </div>
    </section>
</template>

<script>
    import AppFeatureItem from "./FeatureItem.vue";
    export default {
        name: "AppFeatures",
        components: {AppFeatureItem},
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

<style scoped>
    section {
        border-bottom: 2px dashed #c85000;
    }
    .container {
        padding-top: 30px;
        padding-bottom: 50px;
    }
    ul {
        list-style: none;
        margin: 20px 0 0;
        padding: 0;
        display: flex;
        flex-wrap: wrap;
    }
</style>