<template>
    <footer>
        <div class="container">
            <section class="support">
                <strong>Служба поддержки: <a href="#">+7 (917) 235-25-25</a></strong>
            </section>
            <section class="copyright">
                <strong>IORazutkin</strong>
            </section>
        </div>
    </footer>
</template>

<script>
    export default {
        name: "Footer"
    }
</script>

<style scoped>
    footer {
        background-color: #c85000;
        font-size: 20px;
        color: #f0f0f0;
        text-shadow: 0 0 3px black;
    }
    .container {
        padding-top: 30px;
        padding-bottom: 30px;
        position: relative;
    }
    @media (max-width: 630px) {
        .copyright {
            margin-top: 20px;
        }
    }
    @media (min-width: 630px) {
        section {
            display: inline-block;
        }
        .copyright {
            position: absolute;
            right: 0;
        }
    }
    .copyright strong::before {
        content: '©';
    }
    .support a {
        color: #f0f0f0;
    }
</style>