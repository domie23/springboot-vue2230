const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyuanjiankangyz/",
            name: "xiaoyuanjiankangyz",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyuanjiankangyz/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园健康驿站管理系统"
        } 
    }
}
export default base
