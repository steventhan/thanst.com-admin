const path = require("path");
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');


const REACT_PATH = path.resolve(__dirname, "src/main/react");

module.exports = env => {
    const { devMode, outputPath } = env;
    return {
        entry: path.join(REACT_PATH, "index.tsx"),
        module: {
            rules: [
                {
                    test: /\.tsx?$/,
                    use: "ts-loader",
                    exclude: /node_modules/,
                },
                {
                    test: /\.scss$/,
                    use: [
                        MiniCssExtractPlugin.loader,
                        'css-loader',
                        'sass-loader',
                    ],
                },
                {
                    test: /\.html$/,
                    loader: 'html-loader'
                }
            ],
        },
        resolve: {
            extensions: [".tsx", ".ts", ".js"],
        },
        output: {
            filename: "js/[name].bundle.js",
            path: outputPath,
        },
        plugins: [
            new MiniCssExtractPlugin({
                filename: 'css/[name].css',
            }),
            new HtmlWebpackPlugin({
                template: path.join(REACT_PATH, "public/index.html"),
                filename: path.join(outputPath, "index.html")
            })
        ]
    };
};

