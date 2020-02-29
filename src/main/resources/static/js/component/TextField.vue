<template>
    <div>
        <input class="text-field"
               :type="type" placeholder=" " :value="value" :name="name"
               @input="$emit('input', $event.target.value)" :minlength="min"
               :maxlength="max" :pattern="pattern" :required="required">
        <div class="text-field__label-container">
            <label class="text-field__label">{{label}}</label>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TextField",
        props: {
            type: String,
            label: String,
            value: String,
            name: String,
            min: String,
            max: String,
            pattern: String,
            required: {
                default: true
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';

    .text-field {
        flex-basis: 100%;
        box-sizing: border-box;
        height: 40px;
        border: none;
        border-bottom: 1px solid @main-border-color;
        background-color: @main-background-color;
        outline: none;
        padding-left: 10px;
        font: inherit;
        color: inherit;
        font-size: 16px;

        &+.text-field__label-container {
            position: relative;
            width: 100%;
            color: rgba(0, 0, 0, 0.4);
            font-size: 20px;
            pointer-events: none;
            &::after {
                content: '';
                position: absolute;
                bottom: 0; left: 0;
                width: 100%; height: 3px;
                background-color: @main-border-color;
                transform: scaleX(0);
                transition: all 150ms linear;
            }
        }
        &:focus {
            background-color: white;
            box-shadow: inset 0 -1px 1px black;
            color: @primary;
            & + .text-field__label-container .text-field__label {
                color: #c85000;
            }
            & + .text-field__label-container::after {
                transform: scaleX(1);
                background-color: @primary;
            }
        }
        &:focus, &:not(:placeholder-shown) {
            & + .text-field__label-container .text-field__label {
                transform: translate(-5px, -20px);
                font-size: 16px;
            }
        }
    }
    .text-field__label {
        line-height: 40px;
        position: absolute;
        transition: all 100ms linear;
        margin-left: 10px;
        top: -41px; left: 0;
        font-weight: bold;
    }
</style>