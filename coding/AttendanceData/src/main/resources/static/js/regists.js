    function actionRegitst() {
        var email=$("#inputEmail").val();
        var json={"RigistUserInfo":[{"emailInfo":email}]};
       //var json={"CompanyUser":[{"user_account":email, "user_password":email}]};
        var post={data:JSON.stringify(json)};//JSON.stringify(json)把json转化成字符串
        $.ajax({
            url:"http://192.168.71.211:8888/registAction",
            dataType: "json",
            contentType: "application/json;charset=uft-8",
            type:"POST",//提交的方式
            data: post.data,
            success: function success(msg) {
                if(msg.code==101){
                    alert("发个邮件");
                }else{
                    alert("有错误，校验返回的错误");
                    //alert(msg.map.errMsg);
                }
            },
            error: function error(XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
                alert("网络异常！尝试刷新网页解决问题！")
            }
        });
    }





		