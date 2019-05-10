$(function(){
	$("#publish").click(function(){
	//通过类名获得输入框中的值	
	var inputTitle = $(".inputTitle").val();
	var inputContent = $(".inputContent").val();
	
	//发起ajax请求，把发表的文章内容传到后台
	//后台响应这个路径要加前缀/article/publishArticle
	$.ajax({
		  url:"publishArticle",
		  data:{inputTitle:inputTitle,inputContent:inputContent},
		  type:"post",
		  success:function(msg){
			 console.log(msg);
			 //成功
			 if (msg.code = "100") {
				//此处拼接内容
				 url = "showJustArticle.html?id="+msg.map.article.id+
				       "&title="+msg.map.article.title+"&content="+msg.map.article.content+
				       "&userId="+msg.map.article.userId
		         window.location.href = encodeURI(url);
			 } else {
				  alert("发表失败！");
		     }
		  },
		  error:function(){
		  }
 	 });
	
    });
});