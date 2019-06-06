// $('#checkBtn').click(function () {
//     var url = 'showPerInfoByLikeName';
//     var json={"userName":"王仕衡"};
//     var post={data:JSON.stringify(json)};//JSON.stringify(json)把json转化成字符串
//     $.ajax({
//         url: url,
//         type: 'POST',
//         dataType: "json",
//         contentType: "application/json;charset=uft-8",
//         data: post.data,
//         success: function (data) {
//             $(".content").html(data);
//         }
//     })})

function  checkBoxs() {
    var inputTextName=document.getElementById("inputTextName").value;
    var inputTextTLName=document.getElementById("inputTextTLName").value;
    var url="/admin/showPerInfoByLikeNameOrTLName"+"?likeName="+inputTextName+"&likeTLName="+inputTextTLName;
    $('#content').load(url);
}

