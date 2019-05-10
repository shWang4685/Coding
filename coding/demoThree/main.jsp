<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>

<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
	<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


</head>
<body>
<!-- 添加模态框 -->
<!-- Modal -->
<div class="modal fade" id="insert_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加员工</h4>
      </div>
      <div class="modal-body">
       <!-- 添加一个表单 -->
       <form class="form-horizontal">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="insert_name" name="name" placeholder="请输入账号">
      <span class="help-block"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="insert_password" name="password" placeholder="请输入密码">
      <span class="help-block"></span>
    </div>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="person_save_btn">添加</button>
      </div>
    </div>
  </div>
</div>


<!-- 修改模态框 -->
<!-- Modal -->
<div class="modal fade" id="update_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改员工</h4>
      </div>
      <div class="modal-body">
       <!-- 添加一个表单 -->
       <form class="form-horizontal">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
    <div class="col-sm-10">
      <p class="form-control-static" id="update_name"></p>
      <span class="help-block"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="update_password" name="password" placeholder="请输入密码">
      <span class="help-block"></span>
    </div>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="person_update_btn">修改</button>
      </div>
    </div>
  </div>
</div>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h1>员工管理系统</h1>
			</div>
		</div>
		
		<div class="row">
		<div class="col-md-4 col-md-offset-8">
		<button class="btn btn-danger" id="person_delete_all">删除</button>
		<button class="btn btn-primary" id="person_insert">添加</button>
		</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="table">
					<thead>
						<tr>
						<td><input type="checkbox" id="check_all"/></td>
							<td>ID</td>
							<td>姓名</td>
							<td>密码</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6" id="page_info"></div>

			<div class="col-md-6" id="page_nav"></div>
		</div>
	</div>
	
	<script type="text/javascript">
	
	//定义全局变量
	var total,pageNum;

	$(function() {
		to_page(1);
	});
	
	function to_page(pn){
		$.ajax({
			url : "personSelect",
			data : "pn=" + pn,
			type : "post",
			success : function(msg) {
				//解析并显示员工数据
				build_person_table(msg);
				//解析并显示分页信息
				build_person_info(msg);
				//解析并显示分页条信息
				build_person_nav(msg);
			},
			error : function() {
			}
		});
	}
	
	function to_delete(id){
		$.ajax({
			url:"personDeleteById",
			data:"id="+id,
			type:"post",
			success:function(msg){
				if(msg.code==100){
					to_page(pageNum);
				}else{
					alert("删除失败");
				}
			},
			error:function(){
			}
		});
	}
	

	//解析并显示员工数据
	function build_person_table(msg) {
		//清空table
		$("#table tbody").empty();

		var list = msg.map.pageInfo.list;
		$.each(list, function(index, person) {
			var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
			var id = $("<td></td>").append(person.id);
			var name = $("<td></td>").append(person.name);
			var password = $("<td></td>").append(person.password);
			//删除
			var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append("<span></span>").addClass("glyphicon glyphicon-trash").append("删除");
			deleteBtn.click(function(){
				to_delete(person.id);
			});
			//修改
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append("<span></span>").addClass("glyphicon glyphicon-pencil").append("修改");
			//给修改按钮添加一个自定义属性,用来存取ID
			editBtn.attr("edit_id",person.id);
			
			var tr = $("<tr></tr>");
			tr.append(checkBoxTd).append(id).append(name).append(password).append(deleteBtn).append(editBtn).appendTo("#table tbody");
		});
	}
	
	//解析并显示分页信息
	function build_person_info(msg) {
		//清空page_info
		$("#page_info").empty();
		
		$("#page_info").append("当前第" + msg.map.pageInfo.pageNum+"页,一共有"+msg.map.pageInfo.pages+"页,一共有"+msg.map.pageInfo.total+"条数据");
	
	    total = msg.map.pageInfo.total;
	    pageNum = msg.map.pageInfo.pageNum;
	}
	
	//解析并显示分页条信息
	function build_person_nav(msg) {
		//清空nav
		$("#page_nav").empty();
		//nav
		var nav = $("<nav></nav>");
		
		//ul
		var ul = $("<ul></ul>").addClass("pagination");
		
		//首页
		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
		//上一页
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
		//判断是否为首页
		if(msg.map.pageInfo.hasPreviousPage==false){
			//禁用li
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		}else{
			firstPageLi.click(function(){
				to_page(1);
			});
			prePageLi.click(function(){
				to_page(msg.map.pageInfo.pageNum-1);
			});
		}
		
		ul.append(firstPageLi);
		ul.append(prePageLi);
		//页码
		$.each(msg.map.pageInfo.navigatepageNums,function(index,item){
			var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
			if(msg.map.pageInfo.pageNum==item){
				numLi.addClass("active");
			}
			numLi.click(function(){
				to_page(item);
			});
			ul.append(numLi);
		});
		
		//下一页
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
		//末页
		var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
		
		//判断是否为末页
		if(msg.map.pageInfo.hasNextPage==false){
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		}else{
			nextPageLi.click(function(){
				to_page(msg.map.pageInfo.pageNum+1);
			});
			lastPageLi.click(function(){
				to_page(msg.map.pageInfo.pages);
			});
		}
		
		ul.append(nextPageLi);
		ul.append(lastPageLi);
		//
		nav.append(ul).appendTo("#page_nav");
	}
	
	$("#person_insert").click(function(){
		//每次打开模态框都清空数据
		reset_form($("#insert_modal form"));
		
		//通过JS调用模态框
		$("#insert_modal").modal({
			backdrop:"static"
		});
	});
	
	function reset_form(ele){
		//清除input输入内容
		$(ele)[0].reset();
		//清除父容器DIV样式
		$(ele).find("*").removeClass("has-success has-error");
		//清除span内容
		$(ele).find(".help-block").text("");
	}
	
	
	
	
    $("#insert_name").change(function(){
    	var name = this.value;
    	
    	$.ajax({
    		url:"personSelectByName",
    		data:"name=" + name,
    		type:"post",
    		success:function(msg){
    			if(msg.code==100){
    				show_validate_msg("#insert_name","success",msg.map.msg);
    				//通过attr赋值自定义属性
    				$("#person_save_btn").attr("ajax-va","success");
    			}else{
    				show_validate_msg("#insert_name","error",msg.map.msg);
    				//
    				$("#person_save_btn").attr("ajax-va","error");
    			}
    		},
    		error:function(){
    			
    		}
    	});
    });
    
    function show_validate_msg(ele,status,msg){
    	if("success"==status){
    		//让父容器变色
    		$(ele).parent().addClass("has-success");
    		//给sapn赋值错误信息
    		$(ele).next("span").text(msg);
    	}else if("error"==status){
    		//让父容器变色
    		$(ele).parent().addClass("has-error");
    		//给sapn赋值错误信息
    		$(ele).next("span").text(msg);
    	}
    }
	
	$("#person_save_btn").click(function(){
		//前端正则表达式验证
		//if(!validate_add_form()){
		//	return false;
		//}
		//验证用户名是否已经被占用
		//if($(this).attr("ajax-va")=="error"){
		//	return false;
		//}
		
		//发起ajax进行添加操作
		$.ajax({
			url:"personInsert",
			data:$("#insert_modal form").serialize(),
			type:"post",
			success:function(msg){
				if(msg.code==100){
					//关闭模态框
					$("#insert_modal").modal("hide");
					
					//加强程序健壮性 
					//PageHelper如果页码大于总页码,总是会显示最后一页
					to_page(total);
				}else{
					//显示失败信息
					//有哪个字段错误,就显示哪个字段
					if(undefined!=msg.map.map.name){
						//显示账号错误信息
						show_validate_msg("#insert_name","error",msg.map.map.name);
					}
					if(undefined!=msg.map.map.password){
						show_validate_msg("#insert_password","error",msg.map.map.password);
					}
				}

			},
			error:function(){
			}
		});
	});
	
	
	function validate_add_form(){
		//验证用户名
		var name = $("#insert_name").val();
		var reg_name= /(^[a-zA-Z0-9_-]{6,19}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if(!reg_name.test(name)){
			show_validate_msg("#insert_name","error","用户名必须是2-5位中文或6-19位英文和数字的组合");
			return false;
		}else{
			show_validate_msg("#insert_name","success","");
		}

		
		//验证密码
		var password = $("#insert_password").val();
		var reg_password = /(^[a-zA-Z0-9_-]{6,19}$)/;
		if(!reg_password.test(password)){
			show_validate_msg("#insert_password","error","密码必须是6-19位英文和数字的组合");
			return false;
		}else{
			show_validate_msg("#insert_password","success","");
		}
		return true;
	}

      //先有点击事件,再有的按钮
      //老版本JQuery使用live绑定事件
      //新版本JQuery使用on绑定事件
	  $(document).on("click",".edit_btn",function(){
		var id = ($(this).attr("edit_id"));
		$.ajax({
			url:"personSelectById",
			data:"id="+id,
			type:"post",
			success:function(msg){
				$("#update_name").text(msg.map.person.name);
				$("#update_password").val(msg.map.person.password);
				
				$("#person_update_btn").attr("edit_id",id);
				
				//打开修改模态框,把返回值赋值给模态框控件
				$("#update_modal").modal({
					backdrop:"static"
				});
			},
			error:function(){
				
			}
		});
	  });

      $("#person_update_btn").click(function(){
  		//验证密码
  		var password = $("#update_password").val();
  		var reg_password = /(^[a-zA-Z0-9_-]{6,19}$)/;
  		if(!reg_password.test(password)){
  			show_validate_msg("#update_password","error","密码必须是6-19位英文和数字的组合");
  			return false;
  		}else{
  			show_validate_msg("#update_password","success","");
  		}
    	 
  		var id = $(this).attr("edit_id");
  		var password = $("#update_password").val();

  		
    	 //发送ajax请求修改员工数据
    	 $.ajax({
    		 url:"personUpdateById",
 			data:"id="+id+"&password="+password,
    		 type:"post",
    		 success:function(msg){
    			 //关闭模态框
    			 $("#update_modal").modal("hide");
    			 //回到当前页
    			 to_page(pageNum);
    		 },
    		 error:function(){
    			 
    		 }
    	 });
      });
      
      //完成全选全不选功能
      $("#check_all").click(function(){
    	  //使用prop获取dom原生属性的值
    	  $(".check_item").prop("checked",$(this).prop("checked"));
      });
      
      
      //列表checkbox选满以后,全选按钮要变为选中状态,未选满全选按钮为未选中状态
      $(document).on("click",".check_item",function(){
    	  var flag = $(".check_item:checked").length==$(".check_item").length;
    	  $("#check_all").prop("checked",flag);
      });
      
      
      
      
      $("#person_delete_all").click(function(){
    	  var ids = "";
    	  var names = "";
    	  
    	  //循环遍历选中的checkbox把ID拿出来
    	  $.each($(".check_item:checked"),function(index,item){
    		 ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
    		 names += $(this).parents("tr").find("td:eq(2)").text() + ",";
    	  });
    	  
    	  //去掉ids后面多余的那个杠
    	  ids = ids.substring(0,ids.length-1);
    	  names = names.substring(0,names.length-1);
    	  
    	  if(confirm("你确定要批量删除"+names+"吗?")){
    		  $.ajax({
        		  url:"deletePersonByCheckbox",
        		  data:"ids="+ids,
        		  type:"post",
        		  success:function(msg){
        			  to_page(pageNum);
        		  },
        		  error:function(){
        			  
        		  }
        	  });
    	  }
    	  
    	  
      });
      
      
      
</script>
</body>



</html>


