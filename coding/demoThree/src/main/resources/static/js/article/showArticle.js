$(document).ready(function() {
	
	$.ajax({
		url:"showArticle",
		data:
		{},
		type:"post",
		success:function(msg){
			console.log(msg);
			//100表示成功
			if (msg.code == 100) {
				alert("sadsadsa");
			} else {
			}
		 },
		 error:function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
		 }
		
		}); 
});