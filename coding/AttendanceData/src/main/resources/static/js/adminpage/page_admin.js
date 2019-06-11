//首次加载页面进来显示的内容
$(function() {
		 	var dqPage = $("#dqPage").text();//得到当前页数
		 	dqPage = parseInt(dqPage);//得到的文本转成int
            var pageCount = $("#pageCount").text();//得到总页数
            pageCount = parseInt(pageCount);
            
            var i = 1;
            i = parseInt(i);
            var item="";
            var href = "javascript:void(0);";
            //总页数小于五页，则加载所有页
            if(pageCount<=5){
            	item+="<a href='"+href+i+"' ><</a>"
            	for(i;i<=pageCount;i++){
            		if(i==dqPage){
            			item+="<span class='thisclass' onclick='clikPage("+i+");'>"+i+"</span>";
            		}else{
            			item+="<a href='"+href+"' onclick='clikPage("+i+");' >"+i+"</a>";
            		}
            		
            	}
            	 item+="<a href='"+href+i+"' > > </a>"
            	 $('#scott').append(item);
            	
            	return;
            }else if(pageCount > 5){
            	
            	item+="<a href='"+href+i+"' ><</a>"
            	//总页数大于五页，则加载五页
            	if(dqPage<5){
            		for(i;i<=5;i++){
            			if(dqPage==i){
            				item+="<span class='thisclass' onclick='clikPage("+i+");'>"+i+"</span>";
            			}else{
            				item+="<a href='"+href+"' onclick='clikPage("+i+");'>"+i+"</a>";
            			}
            		};
            		//最后一页追加“...”代表省略的页
            		if(dqPage <= pageCount-2){
            			item += "<span> . . . </span>";
            		}
            		
            		item+="<a href='"+href+i+"' > > </a>"
            		$('#scott').append(item);
            		
            		return;
            	}else if(dqPage>=5){
            		//当前页大于5页
            		for (i; i <= 2; i++) {//1,2页码始终显示
                        item += "<a href='"+href+"'  onclick='clikPage("+i+");'>"+i+"</a>";
                    }
            		item += "<span> . . . </span>";//2页码后面用...代替部分未显示的页码
            		//当前页+1等于总页码
            		if(dqPage+1 == pageCount){
            			 for(i = dqPage-1; i <= pageCount; i++){
            			 	//“...”后面跟三个页码当前页居中显示
                            if (i == dqPage) {
                                item += "<span class='thisclass'>"+i+"</span>"; 
                            }else{
                                item += "<a href='"+href+"' onclick='clikPage("+i+");'>"+i+"</a>";
                            }
                        }
            		}else if (dqPage == pageCount) {
            			//当前页数等于总页数则是最后一页页码显示在最后
                        for(i = dqPage-2; i <= pageCount; i++){
                        	//...后面跟三个页码当前页居中显示
                            if (i == dqPage) {
                                item += "<span class='thisclass'>"+i+"</span>"; 
                            }else{
                                item += "<a href='"+href+"' onclick='clikPage("+i+");'>"+i+"</a>";
                            }
                        }
                        $('#scott').append(item);
                        return;
                    }else{//当前页小于总页数，则最后一页后面跟...
                        for(i = dqPage-1; i <= dqPage+1; i++){//dqPage+1页后面...
                            if (i == dqPage) {
                                item += "<span class='thisclass'>"+i+"</span>"; 
                            }else{
                                item += "<a href='"+href+"' onclick='clikPage("+i+");'>"+i+"</a>";
                            }
                        }
                        item += "<span> . . . </span>";
                        item+="<a href='"+href+i+"' > > </a>"
                         $('#scott').append(item);
                    	 return;
                    }
            	}
            }
		 });

//点击后要变更内容ajax
function clikPage(index) {
	var pageClickIndex=index;
    var pageCount = $("#pageCount").text();//得到总页数
    pageCount = parseInt(pageCount);

    var json={"pageClickIndex":pageClickIndex};
    var post={data:JSON.stringify(json)};//JSON.stringify(json)把json转化成字符串
	//发送请求
	$.ajax({
        url:"http://192.168.71.211:8888/admin/pageIndex",
        dataType: "json",
        contentType: "application/json;charset=uft-8",
        type:"POST",//提交的方式
        data: post.data,
        success: function success(ppf) {
            var i = 0;
            i = parseInt(i);
            if(ppf.performanceInfoList!=null){
                $("#table_per tbody").html("");
                var temp="";
                for(i;i<ppf.performanceInfoList.length;i++){
                    var performanceInfo=ppf.performanceInfoList[i];
                    temp+="<tr class='row1' style='text-align: center;' id='per_info_tr'>";
                    var name=ppf.performanceInfoList[i].pfe_user_name;

                    temp+="<td>"+performanceInfo.pfe_user_name+"</td>"
                    temp+="<td>"+performanceInfo.pfe_tm_name+"</td>"
                    temp+="<td>"+performanceInfo.pfe_rating+"</td>"
                    temp+="<td>"+performanceInfo.pfe_totalScore+"</td>"
                    temp+="<td style='text-align: left;'>"+performanceInfo.pfe_tmComment+"</td>"
                    temp+="<td>"+performanceInfo.pfe_tmScore+"</td>"
                    temp+="<td>"+performanceInfo.pfe_tlScore+"</td>"

                    temp+=" <td>"+performanceInfo.pfe_fullAtt+"</td>"
                    temp+="  <td>"+performanceInfo.pfe_lecturer+"</td>"
                    temp+="  <td>"+performanceInfo.pfe_noLeakage+"</td>"
                    temp+=" <td>"+performanceInfo.pfe_overValidBug+"</td>"
                    temp+=" <td >"+performanceInfo.pfe_bugRanking+"</td>"
                    temp+="  <td>"+performanceInfo.pfe_contribution+"</td>"
                    temp+=" <td>"+performanceInfo.pfe_praise+"</td>"

                    temp+="  <td >"+performanceInfo.pfe_tardiness+"</td>"
                    temp+=" <td >"+performanceInfo.pfe_lessValidBug+"</td>"
                    temp+=" <td >"+performanceInfo.pfe_leakage+"</td>"
                    temp+=" <td >"+performanceInfo.pfe_complaint+"</td>"
                    temp+="  <td >"+performanceInfo.pfe_InfoSafety+"</td>"

                    temp+=" <td >"+performanceInfo.pfe_bugRankingNum+"</td>"
                    temp+=" <td >"+performanceInfo.pfe_workingDay+"</td>"
                    temp+="  <td>"+performanceInfo.pfe_bugPerDay+"</td>"
                    temp+="  <td>"+performanceInfo.pfe_LatenessNum+"</td>"
                    temp+=" <td>"+performanceInfo.pfe_missing+"</td>"
                    temp+="  <td>"+performanceInfo.pfe_quarter+"</td>"
                    temp+=" <td style='text-align: left;'>"+performanceInfo.pfe_tlComment+"</td>"
                    temp+="</tr>"
                }
                $("#table_per tbody").append(temp);
                $("#scott").html("");
                pageDiv(pageClickIndex);

            }
        },
		error:function error(XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
                alert("网络异常！尝试刷新网页解决问题！")
         }
	});
}

//变更页码
function  pageDiv(dqPage) {
    dqPage = parseInt(dqPage);//得到的文本转成int
    var pageCount = $("#pageCount").text();//得到总页数
    pageCount = parseInt(pageCount);
    var i = 1;
    i = parseInt(i);
    var item="";
    var href = "javascript:void(0);";
    //总页数小于五页，则加载所有页
    if(pageCount<=5){
        item+="<a href='"+href+i+"' ><</a>"
        for(i;i<=pageCount;i++){
            if(i==dqPage){
                item+="<span class='thisclass' onclick='clikPage("+i+");'>"+i+"</span>";
            }else{
                item+="<a href='"+href+"' onclick='clikPage("+i+");' >"+i+"</a>";
            }
        }
        item+="<a href='"+href+i+"' > > </a>"
        $('#scott').append(item);

        return;
    }else if(pageCount > 5){

        item+="<a href='"+href+i+"' ><</a>"
        //总页数大于五页，则加载五页
        if(dqPage<5){
            for(i;i<=5;i++){
                if(dqPage==i){
                    item+="<span class='thisclass' onclick='clikPage("+i+");'>"+i+"</span>";
                }else{
                    item+="<a href='"+href+"' onclick='clikPage("+i+");'>"+i+"</a>";
                }
            };
            //最后一页追加“...”代表省略的页
            if(dqPage <= pageCount-2){
                item += "<span> . . . </span>";
            }

            item+="<a href='"+href+i+"' > > </a>"
            $('#scott').append(item);

            return;
        }else if(dqPage>=5){
            //当前页大于5页
            for (i; i <= 2; i++) {//1,2页码始终显示
                item += "<a href='"+href+"'  onclick='clikPage("+i+");'>"+i+"</a>";
            }
            item += "<span> . . . </span>";//2页码后面用...代替部分未显示的页码
            //当前页+1等于总页码
            if(dqPage+1 == pageCount){
                for(i = dqPage-1; i < pageCount; i++){
                    //“...”后面跟三个页码当前页居中显示
                    if (i == dqPage) {
                        item += "<span class='thisclass'>"+i+"</span>";
                    }else{
                        item += "<a href='"+href+"' onclick='clikPage("+i+");'>"+i+"</a>";
                    }
                }
                item+="<a href='"+href+i+"' > > </a>"
                $('#scott').append(item);
                return;
            }else if (dqPage == pageCount) {
                //当前页数等于总页数则是最后一页页码显示在最后
                for(i = dqPage-2; i <= pageCount; i++){
                    //...后面跟三个页码当前页居中显示
                    if (i == dqPage) {
                        item += "<span class='thisclass'>"+i+"</span>";
                    }else{
                        item += "<a href='"+href+"' onclick='clikPage("+i+");'>"+i+"</a>";
                    }
                }
                $('#scott').append(item);
                return;
            }else{//当前页小于总页数，则最后一页后面跟...
                for(i = dqPage-1; i <= dqPage+1; i++){//dqPage+1页后面...
                    if (i == dqPage) {
                        item += "<span class='thisclass'>"+i+"</span>";
                    }else{
                        item += "<a href='"+href+"' onclick='clikPage("+i+");'>"+i+"</a>";
                    }
                }
                item += "<span> . . . </span>";
                item+="<a href='"+href+i+"' > > </a>"
                $('#scott').append(item);
                return;
            }
        }
    }

}


