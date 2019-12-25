const config = require("./webpack.config");
const merge = require("webpack-merge");

module.exports = merge(
    config({ devMode: true}),
    {
        mode: "development",
        devtool: 'inline-source-map',
    }
);