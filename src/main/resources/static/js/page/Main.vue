<template>
    <div>
        <Header/>
        <Menu @change="change"/>
        <main>
            <transition mode="out-in">
                <router-view></router-view>
            </transition>
        </main>
    </div>
</template>

<script>
    import Header from "../component/main/Header.vue";
    import Menu from "../component/main/Menu.vue";
    import BlockPay from "../component/main/block-pay/BlockPay.vue";
    import BlockProfile from "../component/main/block-profile/BlockProfile.vue";
    import BlockStats from "../component/main/block-stats/BlockStats.vue";
    export default {
        name: "User",
        components: {BlockStats, BlockProfile, BlockPay, Menu, Header},
        methods: {
            change(target) {
                this.$router.replace(target);
            }
        }
    }
</script>

<style>
    .block-title {
        margin: 0;
        font-size: 26px;
        color: #c85000;
    }
</style>
<style scoped>
    .v-enter-active, .v-leave-active {
        transition: 200ms linear;
    }
    .v-enter, .v-leave-to {
        opacity: 0;
    }
    .v-enter-to, .v-leave- {
        opacity: 1;
    }
    main {
        margin: 80px 20px 20px 130px;
        display: flex;
        justify-content: center;
    }
    section {
        flex: 0 1 1000px;
        border-radius: 10px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        padding: 10px;
        background-color: rgba(0, 0, 0, 0.05);
        box-shadow: 0 0 5px black;
        position: relative;
    }
</style>