import router from './router/router';
import Vue from 'vue/dist/vue.common';
import '../../style/style.less';
import VueResource from 'vue-resource';

Vue.use(VueResource);

let vm = new Vue({
    el: '#app',
    router
});