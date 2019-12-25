const config = require("./webpack.config");
const merge = require("webpack-merge");

console.log("hello world from prod");
module.exports = merge(
    config({ devMode: false}),
    {
        mode: "production",
        devtool: 'inline-source-map',
    }
);