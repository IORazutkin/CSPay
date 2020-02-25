<template>
    <div>
        <main>
            <app-header/>
            <app-features/>
            <app-price-list/>
        </main>
        <Footer/>
        <router-view></router-view>
    </div>
</template>

<script>
    import AppHeader from "../component/index/Header.vue";
    import AppFeatures from "../component/index/features/Features.vue";
    import AppPriceList from "../component/index/price-list/PriceList.vue";
    import Footer from "../component/index/Footer.vue";
    export default {
        name: "App",
        components: {Footer, AppPriceList, AppFeatures, AppHeader}
    }
</script>

<style scoped>
    div {
        height: 100%;
        display: flex;
        flex-direction: column;
    }
    main {
        flex-grow: 1;
    }
</style>