var userName=false;
var realName=false;
var jobNum=false;
var pwd=false;
var confirmPwd=false;
var emailInput=false;
var tmSelect=false;
var tlSelect=false;

function userName_onfocus(){
	var textObj = document.getElementById("username");
	var tipObj=document.getElementById("username_tips");
	
	var reg=/^[a-zA-Z0-9]{3,12}$/;
	if(!reg.test(textObj)){
		userName=false;
		tipObj.innerHTML="用户名格式有误!"
		
		//return false;
	}else{
		userName=true;
		tipObj.innerHTML="用户名可以使用!"
		//return userName;
	}
}

//用户名验证
function userName_onblur(){
	var textObj = document.getElementById("username");
	var tipObj=document.getElementById("username_tips");
	var reg=/^[a-zA-Z0-9]{3,12}$/;
	tipObj.style.color="#f00";
	if(textObj.value==""){
		userName=false;
		tipObj.innerHTML="用户名不能为空！"
	}else if(reg.test(textObj.value)){
		userName=true;
		tipObj.innerHTML=""
	}else{
		userName=false;
		tipObj.innerHTML="用户名不能含有非法字符，长度在3-10之间"
	}
}
//真实姓名验证
function realName_onblur(){
	var textObj = document.getElementById("realName");
	var tipObj = document.getElementById("name_tips");
	var reg = /^[\u4e00-\u9fa5]+$/;
	tipObj.style.color="#f00";
	if(textObj.value==""){
		realName=false;
		tipObj.innerHTML="真实姓名不能为空！"
		
	}else if(reg.test(textObj.value)){
		tipObj.innerHTML=""
		realName=true;
	}else{
		tipObj.innerHTML="请输入汉字！"
		realName=false;
	}
	
}
//工号验证
function jobNum_onblur(){
	var textObj = document.getElementById("jobNum");
	var tipObj = document.getElementById("jobNum_tips");
	var reg = /^[pP][0-9]{4,12}$/;
	tipObj.style.color="#f00";
	if(textObj.value==""){
		tipObj.innerHTML="员工编号不能为空！"
		jobNum= false;
	}else if(reg.test(textObj.value)){
		tipObj.innerHTML=""
		jobNum=true;
	}else{
		tipObj.innerHTML="格式输入不正确！"
		jobNum=false;
	}
	
}

//秘密输入框
function pwd_onblur(){
	var textObj = document.getElementById("pwd");
	var tipObj = document.getElementById("pwd_tips");
	var reg=/^[a-zA-Z0-9]{4,10}$/;    
	tipObj.style.color="#f00";
	if(textObj.value==""){
		tipObj.innerHTML="密码不能为空！"
		pwd=false;
	}else if(reg.test(textObj.value)){
		tipObj.innerHTML=""
		pwd=true;
	}else{
		tipObj.innerHTML="密码不能含有非法字符，长度在4-10之间"
		pwd=false;
	}
	
	
}

//确认秘密输入框
function confirmPwd_onblur(){
	var pwdText = document.getElementById("pwd");
	var confirmPwdText = document.getElementById("confirmPwd");
	var tipObj = document.getElementById("confirmPwd_tips");
	tipObj.style.color="#f00";
	
	if(confirmPwdText.value==""){
		tipObj.innerHTML="确认密码不能为空！"
		confirmPwd=false;
	}else if(pwdText.value==confirmPwdText.value){
		tipObj.innerHTML=""
		confirmPwd=true;
	}else{
		tipObj.innerHTML="两次秘密输入不相同"
		confirmPwd=false;
	}
}

function emailCheck(){
	var tipObj = document.getElementById("email_tips");
	var emailInputs=document.getElementById("email_id");
	tipObj.style.color="#f00";
    var reg=/^[0-9A-Za-z][\.-_0-9A-Za-z]*@[0-9A-Za-z]+(?:\.[0-9A-Za-z]+)+$/;
    if(emailInputs.value==""){
		tipObj.innerHTML="邮箱不能为空";
        emailInput= false;
	}else if(!reg.test(emailInputs.value)) {
		//alert("邮箱格式不正确!");
		 //var reg=/^([a-zA-Z0-9])
	    tipObj.innerHTML="格式不正确";
        emailInput= false;
    }else{
    	tipObj.innerHTML="";
        emailInput= true;
	}
			
}

window.onload = function(){
	//配置select数据
	selectOnLoding();
}
//设置select中下拉框的数据
function selectOnLoding() {
	var TMDatas = TMInfo;
	var TLDatats= TLInfo;
	
	for (var i = 0; i < TMDatas.length; i++){
		var tmName=TMDatas[i];
		var op=document.createElement("option"); 
		op.innerText=tmName.TMName;
		op.setAttribute("value",tmName.TMName); 
		TMSelect.appendChild(op);
	}
	for(var i = 0; i < TLDatats.length; i++){
		var tlName=TLDatats[i];
		var op=document.createElement("option"); 
		op.innerText=tlName.TLName;
		op.setAttribute("value",tlName.TLName); 
		TLSelect.appendChild(op);
	}
}

//聚焦TM下拉框
function selectTM(){
	
		var tipObj = document.getElementById("TMSelect_tips");			
		tipObj.innerHTML="TM注册请选填自己的姓名";
		tipObj.style.color="#999999"
		
}
//失焦TM下拉框	
function onblur_TMselect(){
	var tipObj = document.getElementById("TMSelect_tips");			
	var  obj=document.getElementById('TMSelect');
	var  index=obj.selectedIndex; 
	var  val = obj.options[index].value;
	if(val=='no'){
		tipObj.style.color="#f00";
		tipObj.innerHTML="选择不能为空";
		tmSelect=false;
	}else{
		tipObj.innerHTML="";
		tmSelect=true;
	}
}

function onblur_TLselect(){
	var tipObj = document.getElementById("TLSelect_tips");			
	var  obj=document.getElementById('TLSelect');
	var  index=obj.selectedIndex; 
	var  val = obj.options[index].value;
	if(val=='no'){
		tipObj.style.color="#f00";
		tipObj.innerHTML="选择不能为空";
		tlSelect=false;
		
	}else{
		tipObj.innerHTML="";
		tlSelect=true;
	}
}
function actionRegitst(){
	
	if(userName==false){
		var tipObj=document.getElementById("username_tips");
		tipObj.style.color="#f00";
		tipObj.innerHTML="*";
	}
	if(realName==false){
		var tipObj = document.getElementById("name_tips");
		tipObj.style.color="#f00";
        tipObj.innerHTML="*";
	}
	if(jobNum==false){
		var tipObj = document.getElementById("jobNum_tips");
		tipObj.style.color="#f00";
        tipObj.innerHTML="*";
	}
	if(pwd==false){
		var tipObj = document.getElementById("pwd_tips");
		tipObj.style.color="#f00";
        tipObj.innerHTML="*";
	}
	if(confirmPwd==false){
		var tipObj = document.getElementById("confirmPwd_tips");
		tipObj.style.color="#f00";
        tipObj.innerHTML="*";
	}
	if(emailInput==false){
		var tipObj = document.getElementById("email_tips");
		tipObj.style.color="#f00";
        tipObj.innerHTML="*";
	}
	if(tmSelect==false){
		var tipObj = document.getElementById("TMSelect_tips");
		tipObj.style.color="#f00";
        tipObj.innerHTML="*";
	}
	if(tlSelect==false){
		var tipObj = document.getElementById("TLSelect_tips");
		tipObj.style.color="#f00";
        tipObj.innerHTML="*";
	}
    if(userName==true&&realName==true&&jobNum==true&&pwd==true&&confirmPwd==true&&emailInput==true&&tmSelect==true&&tlSelect==true){
        var email=$("#email_id").val();//邮箱
        var username=$("#username").val();//用户账户
        var realname=$("#realName").val();//真实姓名
        var jobnum=$("#jobNum").val();//工号
        var password=$("#pwd").val();//密码
		//TM姓名
		var tmobj=document.getElementById( 'TMSelect' );
        var  index1=tmobj.selectedIndex;
        alert("index1:"+index1)
        var  TMSelect = tmobj.options[index1].value;
        //tl姓名
        var tlobj=document.getElementById( 'TLSelect' );
        var  index2=tlobj.selectedIndex;
        var  TLSelect = tlobj.options[index2].value;

        var json={"RigistUserInfo":[{"jobnum":jobnum,"username":username,"password":password,"realname":realname,"TMSelect":TMSelect,"TLSelect":TLSelect,"email":email}]};
        var post={data:JSON.stringify(json)};//JSON.stringify(json)把json转化成字符串
        var urlConfig="http://"+ip[0].ipconfig;
        $.ajax({
            url:urlConfig+"/registAction",
            dataType: "json",
            contentType: "application/json;charset=uft-8",
            type:"POST",//提交的方式
            data: post.data,
            success: function success(msg) {
				if(msg.code==102){
					if(msg.mapStr["regitsName"]==1){
                        var tipObj=document.getElementById("username_tips");
                        tipObj.style.color="#f00";
                        tipObj.innerHTML="用户名已存在";
					}
					if(msg.mapStr["regitsJobNum"]==1){
                        var tipObj = document.getElementById("jobNum_tips");
                        tipObj.style.color="#f00";
                        tipObj.innerHTML="工号已存在！";
					}
                    if(msg.mapStr["regitsEmail"]==1){
                        var tipObj = document.getElementById("email_tips");
                        tipObj.style.color="#f00";
                        tipObj.innerHTML="邮箱已被注册！";
                    }
				}else if(msg.code==101){
					alert("注册提交，已经发送激活码链接到您的邮箱，请您前往邮箱激活！")
                    window.location.href=urlConfig+"/login";
                }else{
                    alert(msg.code);
                    alert("sss")
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
}
