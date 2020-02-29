<template>
    <transition>
        <div v-if="isShow" class="alert" :class="{success: isSuccess}">
            <p>{{text}}</p>
        </div>
    </transition>
</template>

<script>
    export default {
        name: "Alert",
        props: ['isShow', 'isSuccess', 'text'],
        updated() {
            if (this.isShow) {
                setTimeout(() => this.$emit('close'), 2000);
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';
    @import '~styles/animations';

    .scale(v, Y);

    .alert {
        padding: 15px;
        border: 1px solid @error-alert;
        border-left-width: 5px;
        border-radius: 10px;

        background-color: fade(@error-alert, 5%);
        color: @error-alert;
        position: relative;

        &.success {
             border-color: @success-alert;
             color: @success-alert;
             background-color: fade(@success-alert, 5%);
        }
        p {
            margin: 0;
        }
    }
</style>