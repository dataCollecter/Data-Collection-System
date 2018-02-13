const path = require('path');

module.exports = {
	entry: path.resolve(__dirname,"./app.js"), //已多次提及的唯一入口文件
    output: {
        path:path.resolve(__dirname,"/build"),
        filename: "bundle.js"
    },
    devtool: 'none',
    devServer: {
        contentBase: "./", //本地服务器所加载的页面所在的目录
        historyApiFallback: true, //不跳转
        inline: true,
        hot: true,
        port: 9000,
        // proxy: {
        //   "/api": {
        //     target: "http://120.78.153.99:8080/DataCollectionSystem/",
        //     pathRewrite: {"^/api" : ""}
        //   }
        // }
    }
   
}