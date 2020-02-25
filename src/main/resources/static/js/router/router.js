import VueRouter from 'vue-router/dist/vue-router';
import Vue from 'vue/dist/vue.common';
import Main from "../page/Main.vue";
import Login from "../page/Login.vue";
import Index from "../page/Index.vue";
import BlockPay from "../component/main/block-pay/BlockPay.vue";
import BlockStats from "../component/main/block-stats/BlockStats.vue";
import BlockProfile from "../component/main/block-profile/BlockProfile.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: '/', component: Index,
        children: [
            { path: 'login', component: Login },
            { path: 'registration', component: Login }
        ]
    },
    {
        path: '/', component: Main,
        children: [
            { path: 'pay', component: BlockPay },
            { path: 'stats', component: BlockStats },
            { path: 'profile', component: BlockProfile }
        ]
    }
];

export default new VueRouter({
    routes,
    mode: 'history'
});