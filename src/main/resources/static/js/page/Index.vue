<template>
    <div>
        <main>
            <Header/>
            <features/>
            <price-list/>
        </main>
        <Footer/>
        <router-view></router-view>
    </div>
</template>

<script>
    import Header from "../component/index/Header.vue";
    import Features from "../component/index/features/Features.vue";
    import PriceList from "../component/index/price-list/PriceList.vue";
    import Footer from "../component/index/Footer.vue";
    export default {
        name: "App",
        components: {Footer, PriceList, Features, Header}
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