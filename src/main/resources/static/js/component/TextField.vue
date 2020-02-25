<template>
    <div>
        <input :type="type" placeholder=" " :value="value" :name="name"
               @input="$emit('input', $event.target.value)" :minlength="min"
               :maxlength="max" :pattern="pattern" required>
        <div>
            <label>{{label}}</label>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TextField",
        props: ['type', 'label', 'value', 'name', 'min', 'max', 'pattern']
    }
</script>

<style scoped>
    input {
        flex-basis: 100%;
        box-sizing: border-box;
        height: 40px;
        border: none;
        border-bottom: 1px solid rgba(0, 0, 0, 0.3);
        background-color: rgba(0, 0, 0, 0.05);
        outline: none;
        padding-left: 10px;
        font: inherit;
        color: inherit;
        font-size: 16px;
    }
    input + div {
        position: relative;
        width: 100%;
        color: rgba(0, 0, 0, 0.4);
        font-size: 20px;
        pointer-events: none;
    }
    input + div label {
        line-height: 40px;
        position: absolute;
        transition: all 100ms linear;
        margin-left: 10px;
        top: -41px;
        left: 0;
        font-weight: bold;
    }
    input + div::after {
        content: '';
        position: absolute;
        bottom: 0;
        left: 0;
        width: 100%;
        height: 3px;
        background-color: rgba(0, 0, 0, 0.3);
        transform: scaleX(0);
        transition: all 150ms linear;
    }
    input:focus {
        background-color: white;
        box-shadow: inset 0 -1px 1px black;
        color: #c85000;
    }
    input:focus + div label {
        color: #c85000;
    }
    input:focus + div::after {
        transform: scaleX(1);
        background-color: #c85000;
    }
    input:focus + div label,
    input:not(:placeholder-shown) + div label {
        transform: translate(-5px, -20px);
        font-size: 16px;
    }
</style>