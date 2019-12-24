const path = require("path");
const HtmlWebpackPlugin = require('html-webpack-plugin');

const REACT_PATH = path.resolve(__dirname, "src/main/react");
const OUTPUT_PATH = path.resolve(__dirname, "build/resources/static");

const config = {
    entry: path.join(REACT_PATH, "index.tsx"),
    devtool: 'inline-source-map',
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: "ts-loader",
                exclude: /node_modules/,
            },
        ],
    },
    resolve: {
        extensions: [".tsx", ".ts", ".js"],
    },
    output: {
        filename: "js/bundle.js",
        path: OUTPUT_PATH,
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: path.join(REACT_PATH, "public/index.html"),
            filename: path.join(OUTPUT_PATH, "index.html")
        })
    ]
};

module.exports = config;