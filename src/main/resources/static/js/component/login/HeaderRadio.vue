<template>
    <div>
        <input type="radio" :name="name" :id="id" :checked="checked" @change="radioChange">
        <label :for="id">{{label}}</label>
    </div>
</template>

<script>
    export default {
        name: "ModalWindowHeaderRadio",
        props: ['id', 'name', 'label', 'checked'],
        methods: {
            radioChange() {
                this.$emit('change')
            }
        }
    }
</script>

<style scoped>
    input {
        display: none;
    }
    div {
        flex-basis: 50%;
        text-align: center;
        height: 100%;
        line-height: 60px;
        font-weight: bold;
    }
    label {
        display: inline-block;
        width: 100%;
        height: 100%;
    }
    input:checked + label {
        background-color: rgba(200, 80, 0, 0.1);
        color: #c85000;
    }
</style>