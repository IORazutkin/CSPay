<template>
    <div>
        <Header @menu="openMenu = true"/>
        <main>
            <transition mode="out-in">
                <router-view></router-view>
            </transition>
        </main>
        <Menu :class="{'nav-open': openMenu}" @change="change"/>
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
        data() {
            return {
                openMenu: false
            }
        },
        watch: {
            openMenu() {
                if (this.openMenu) {
                    setTimeout(() =>
                        document.addEventListener(
                            'click', this.outsideClick
                        ), 200);
                } else {
                    document.removeEventListener('click', this.outsideClick);
                }
            }
        },
        methods: {
            change(target) {
                this.$router.replace(target);
            },
            outsideClick() {
                this.openMenu = false;
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';
    @import '~styles/animations';

    .opacity(v);

    main {
        display: flex;
        margin: 80px 20px 20px 130px;
        justify-content: center;

        @media handheld, (max-width: 700px) {
            margin-left: 20px;
        }
    }
    section {
        flex: 0 1 1000px;
        border-radius: 10px;
        border: 1px solid @main-border-color;
        padding: 10px;
        background-color: @main-background-color;
        box-shadow: 0 0 5px black;
        position: relative;
    }
</style>