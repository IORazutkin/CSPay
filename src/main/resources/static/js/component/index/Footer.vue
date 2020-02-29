<template>
    <footer class="page-footer">
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

<style lang="less" scoped>
    @import '~styles/varibles';

    .page-footer {
        background-color: @primary;
        font-size: 20px;
        color: @secondary;
        text-shadow: 0 0 3px black;

        .container {
            padding-top: 30px;
            padding-bottom: 30px;
            position: relative;
        }

        .copyright {
            strong::before {
                content: '©';
            }
            @media (max-width: 630px) {
                margin-top: 20px;
            }
            @media (min-width: 630px) {
                position: absolute;
                right: 0;
            }
        }
        @media (min-width: 630px) {
            section {
                display: inline-block;
            }
        }
    }
    .support a {
        color: @secondary;
    }
</style>