<template>
    <header class="clearfix">
        <button class="header-menu" @click="$emit('menu')">
            &#9776;
        </button>
        <div class="logo">
            CSPay
        </div>
        <div class="logout">
            <a href="/logout"></a>
        </div>
        <div class="address">
            {{this.address}}
        </div>
    </header>
</template>

<script>
    export default {
        name: "Header",
        data() {
            return {
                city: '',
                street: '',
                house: '',
                apartment: ''
            }
        },
        computed: {
            address() {
                return this.city + ', ' + this.street +
                        ' '+ this.house + ', кв. ' +
                        this.apartment;
            }
        },
        created() {
            this.$http.get('/users').then(result => {
                let user = result.data,
                    apartment = user.apartment,
                    house = apartment.house;

                this.city = house.city;
                this.street = house.street;
                this.house = house.house;

                this.apartment = apartment.number;
            });
        }
    }
</script>

<style lang="less" scoped>
    @import '~styles/varibles';

    header {
        background: @header-gradient no-repeat;
        height: 60px; width: 100%;
        position: fixed;
        top: 0; left: 0;
        z-index: 1;
    }
    .header-menu {
        outline: none;
        display: block;
        float: left;
        font-size: 40px;
        color: white;
        text-shadow: 0 0 5px black;
        width: 60px; height: 60px;
        line-height: 60px;
        text-align: center;
        margin-right: -10px;
        border: none;
        background-color: transparent;

        &:hover {
            background-color: rgba(0, 0, 0, 0.1);
        }
        &:active {
            background-color: rgba(0, 0, 0, 0.2);
        }
    }
    .logo {
        float: left;
        color: @secondary;
        font-size: 30px;
        line-height: 60px;
        margin-left: 20px;
        text-shadow: 0 0 5px black;
    }
    .address, .logout {
        float: right;
    }
    .address {
        color: @secondary;
        font-size: 18px;
        line-height: 60px;
        margin-right: 20px;
        text-shadow: 0 0 5px black;
    }
    .logout {
        margin-right: 20px;

        a {
            display: inline-block;
            width: 40px; height: 40px;
            border-radius: 50%;
            margin-top: 10px;
            background: url(http://localhost:8000/images/logout.png) no-repeat center;
            background-size: 24px;
        }
        a:hover {
            background-color: rgba(0, 0, 0, 0.1);
        }
        a:active {
            filter: opacity(0.8);
        }
    }
    @media handheld, (min-width: 700px) {
        .header-menu {
            display: none;
        }
        .address {
            font-size: 20px;
        }
    }
</style>