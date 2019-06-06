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

function  checkPerByName() {

    var textName=$('#textByName').val();
    var textTMByName=$('#textTMByName').val();
    var textByTLName=$('#textByTLName').val();
    var url="/admin/showPerInfoByLikeNameH"+"?userName="+textName+"&textTMByName="+textTMByName+"&textByTLName="+textByTLName;
    $('#content').load(url);
}
