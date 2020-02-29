<template>
    <li class="features__item">
        <h2 class="title">{{ title }}</h2>
        <p class="description">{{ description }}</p>
    </li>
</template>

<script>
    export default {
        name: "FeatureItem",
        props: ['title', 'description']
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';

    .features__item {
        position: relative;
        margin: 5px;
        padding: 20px;
        flex: 1 0 310px;
        height: 160px;
        background-color: @main-background-color;
        border-radius: 10px;
        border: 1px solid @main-border-color;

        &:hover {
            background-color: @primary-opacity;
            border-color: @primary;
            .title, .description {
                color: @primary;
            }
            .title::before {
                filter: none;
            }
        }
    }
    .title {
        font-size: 24px;
        margin: 8px 0 25px 70px;

        &::before {
            content: '';
            position: absolute;
            left: 20px; top: 20px;
            width: 50px; height: 70px;
            background-size: 50px;
            background-repeat: no-repeat;
            background-position: top;
            filter: grayscale(1) brightness(80%);
        }
    }
    .description {
        margin: 0;
        font-size: 20px;
    }
    .features__item-1 .title::before {
        background-image: url(http://localhost:8000/images/speed.png);
    }
    .features__item-2 .title::before {
        background-image: url(http://localhost:8000/images/control.png);
    }
    .features__item-3 .title::before {
        background-image: url(http://localhost:8000/images/safe.png);
    }
    .features__item-4 .title::before {
        background-image: url(http://localhost:8000/images/call.png);
    }
</style>