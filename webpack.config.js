const path = require("path");

const REACT_PATH = path.resolve(__dirname, "src/main/react");

const config = {
    entry: path.join(REACT_PATH, "index.tsx"),
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
        path: path.resolve(__dirname, "build/resources/assets"),
    },
};

module.exports = config;