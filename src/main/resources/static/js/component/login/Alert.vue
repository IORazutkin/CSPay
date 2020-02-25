<template>
    <transition>
        <div v-if="isShow" class="alert" :class="{success: isSuccess}">
            <p>{{text}}</p>
            <input type="button" @click="$emit('close')" value="×">
        </div>
    </transition>
</template>

<script>
    export default {
        name: "Alert",
        props: ['isShow', 'isSuccess', 'text']
    }
</script>

<style scoped>
    .v-enter-active, .v-leave-active {
        transition: 200ms linear;
    }
    .v-enter, .v-leave-to {
        transform: scaleY(0);
    }
    .v-enter-to, .v-leave {
        transform: scaleY(1);
    }
    .alert {
        padding: 15px;
        border: 1px solid red;
        border-left-width: 5px;
        border-radius: 10px;

        background-color: rgba(255, 0, 0, 0.1);
        color: red;
        position: relative;
    }
    .alert.success {
        border-color: green;
        color: green;
        background-color: rgba(0, 255, 0, 0.1);
    }
    .alert p {
        margin: 0;
    }
    .alert input {
        font-size: 20px;
        border: 1px solid red;
        color: red;
        border-radius: 50%;
        position: absolute;
        right: 15px;
        top: 50%;
        width: 26px;
        height: 26px;
        margin-top: -13px;
        display: none;
    }
    .alert.success input {
        border-color: green;
        color: green;
    }
    .alert:hover input {
        display: block;
    }
</style>