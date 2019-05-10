		function $(id){
			return document.getElementById(id);
		}
		function actionCheck() {
            var userName=$("#inputName").val();
            var passwrod=$("#inputPass").val();
            var json={"CompanyUser":[{"user_account":userName, "user_password":passwrod}]};
            var post={data:JSON.stringify(json)};//JSON.stringify(json)把json转化成字符串
            $.ajax({
                url:"http://192.168.71.211:8888/logindemo",
                dataType: "json",
                contentType: "application/json;charset=uft-8",
                type:"POST",//提交的方式
                data: post.data,
                success: function success(msg) {
                    if(msg.code==100){
                       // alert("登录成功");
                        document.write("<form action='/getAllEmp' method=post name=form1 style='display:none'>");
                        document.write("</form>");
                        document.form1.submit();
                        //window.location.href='http://localhost:8888/getCheck';
                    }else{
                        alert(msg.map.errMsg);
                       // alert(msg.map.errMsg);
                       // alert("账号或密码不正确");
                    }
                },
                error: function error(XMLHttpRequest, textStatus, errorThrown) {
                    console.log('XMLHttpRequest:');
                    console.log(XMLHttpRequest);
                    alert("网络异常！尝试刷新网页解决问题！")
                }
            });
        }



		