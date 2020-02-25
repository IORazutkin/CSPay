<template>
    <li>
        <h2>{{ title }}</h2>
        <p>{{ description }}</p>
    </li>
</template>

<script>
    export default {
        name: "AppFeatureItem",
        props: ['title', 'description']
    }
</script>

<style scoped>
    li {
        position: relative;
        margin: 5px;
        flex: 1 0 310px;
        height: 160px;
        background-color: rgba(0, 0, 0, 0.05);
        border-radius: 10px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        padding: 20px;
    }
    li:hover {
        background-color: rgba(200, 80, 0, 0.1);
        border-color: #c85000;
    }
    li:hover h2 {
        color: #c85000;
    }
    li:hover h2::before {
        filter: none;
    }
    h2 {
        font-size: 24px;
        margin: 8px 0 25px 70px;
    }
    h2::before {
        content: '';
        position: absolute;
        left: 20px;
        top: 20px;
        width: 50px;
        height: 70px;
        background-size: 50px;
        background-repeat: no-repeat;
        background-position: top;
        filter: grayscale(1) brightness(80%);
    }
    p {
        margin: 0;
        font-size: 20px;
    }
    .feature-item-1 h2::before {
        background-image: url(http://localhost:8000/images/speed.png);
    }
    .feature-item-2 h2::before {
        background-image: url(http://localhost:8000/images/control.png);
    }
    .feature-item-3 h2::before {
        background-image: url(http://localhost:8000/images/safe.png);
    }
    .feature-item-4 h2::before {
        background-image: url(http://localhost:8000/images/call.png);
    }
</style>