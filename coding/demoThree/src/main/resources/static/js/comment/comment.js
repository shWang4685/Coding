$(function() {
	$("#comment").click(function() {
		//获得主评论的内容
		var inputComment = $(".inputComment").val();
		// 定义了全局变量的save数组，所以可以直接这样子取得刚才发表的文章信息
		//主评论评论的文章id
		var idArticle = save[0];
		//主评论用户的id
		//var userIdArticle = save[3];userIdArticle : userIdArticle,int userIdArticle,
		
		// 发起ajax请求，把发表的文章内容传到后台
		$.ajax({
			url : "commentArticle",
			data : {
				idArticle : idArticle,
				
				inputComment : inputComment
			},
			type : "post",
			success : function(msg) {
				console.log(msg);
				// 成功
				if (msg.code = "100") {
					//主评论的用户名
					var commentUserName = msg.map.commentUserName;
					//主评论的内容
					var commentContent = msg.map.comment.content;
			        //主评论的时间
					var commentTime = formateDate(msg.map.comment.publishTime);
			        //拼接上述,创建一个新的div
					var commentBox = document.createElement('div');
			        commentBox.className = 'comment-box clearfix';
			        commentBox.setAttribute('user', 'self');
			        commentBox.innerHTML =
			            '<img class="myhead" src="" alt="TODO:这里显示的是用户头像"/>' +
			                '<div class="comment-content">' +
			                '<p class="comment-text"><span class="user">' + commentUserName +'：</span>' + commentContent + '</p>' +
			                '<p class="comment-time">' +
			                commentTime +
			                '<a href="javascript:;" class="comment-praise" total="0" my="0" style="">赞</a>' +
			                '<a href="javascript:void(0);" onclick="commentReply()" class="comment-operate">回复</a>' +
			                '</p>' +
			                '</div>'
			        //要拼接到的位置
			        var commentList = document.getElementsByClassName('comment-list')[0];
			        commentList.appendChild(commentBox);
			        //清空评论内容输入框
			        commentContent.value = '';
				} else {
					alert("发表失败！");
				}
			},
			error : function() {
			}
		});

	});
	
	//格式化日期
	function formateDate(date) {
		var date = new Date(date);
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		var h = date.getHours();
		var mi = date.getMinutes();
		m = m > 9 ? m : '0' + m;
		return y + '-' + m + '-' + d + ' ' + h + ':' + mi;
	}
	
	
	
	// 次评论的回复:会不会出现多个class相同导致打开很多回复页面？
	// TODO:先完成这一步先：别人点击文章链接，然后显示全部文章和主次评论？
	function commentReply() {
		alert("666");
	}
	
});
