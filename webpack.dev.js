const path = require("path");
const config = require("./webpack.config");
const merge = require("webpack-merge");

module.exports = merge(
    config({
        devMode: true,
        outputPath: path.resolve(__dirname, "build/webpack/static")
    }),
    {
        mode: "development",
        devtool: 'inline-source-map',
    }
);