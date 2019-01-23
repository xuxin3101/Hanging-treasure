var app={
    logout:function () {
        localStorage.clear();
        location.href="index.html"
      },
      checklogin:function () {
        var username=localStorage.getItem("gjbusername")
        if(username==""|| username==undefined){
            ShowFailure("对不起，未登录不允许访问本页面")
            location.href="index.html"
        }
        },
    getusername:function () {
        return localStorage.getItem("gjbusername");
      }
}