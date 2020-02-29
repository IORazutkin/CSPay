<template>
    <div class="radio-container">
        <input class="radio" type="radio" :name="name" :id="id" :checked="checked" @change="radioChange">
        <label class="radio-label" :for="id">{{label}}</label>
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

<style lang="less" scoped>
    @import '~styles/varibles';

    .radio {
        display: none;
        &:checked + .radio-label {
             background-color: @primary-opacity;
             color: @primary;
        }
    }
    .radio-container {
        flex-basis: 50%;
        text-align: center;
        height: 100%;
        line-height: 60px;
        font-weight: bold;
    }
    .radio-label {
        display: inline-block;
        width: 100%; height: 100%;
    }
</style>