let path = require('path');
let VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
    entry: path.join(__dirname, 'src', 'main', 'resources', 'static', 'js', 'main.js'),
    devtool: 'source-map',
    devServer: {
        overlay: true,
        port: 8000,
        contentBase: './dist'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                loader: 'babel-loader'
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.(less|css)$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                    'less-loader',
                ],
            },
            {
                test: /\.png$/,
                loader: 'file-loader',
                options: {
                    name: '/images/[name].[ext]'
                }
            }
        ]
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    resolve: {
        alias: {
            styles: path.join(__dirname, 'src', 'main', 'resources', 'style')
        }
    }
};