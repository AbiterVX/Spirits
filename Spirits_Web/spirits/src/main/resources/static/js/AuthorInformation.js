function f_getAuthorUserName(user_id) {
    var author_id="";
    var data='{"user_id":"'+user_id+'"}';
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/MySpace/getUserName",
        data:data,
        processData :false,
        contentType:"application/json",
        async:false,
        success:function (jsondata) {
            author_id=jsondata["user_name"];
        },
        error: function (err) {
            alert("getAuthorUserName Wrong!");
        }
    });
    return author_id;
}
function f_getAuthorImage(user_id) {
    var image_name='image/'+user_id+'.txt';
    var author_image="";
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/downloadFile",
        data:image_name,
        processData :false,
        contentType:"application/json",
        async:false,
        success:function (jsondata) {
            author_image=jsondata['data'];
            if(author_image==""){
                author_image="../imgIndex/users.png";
            }
        },
        error: function (err) {
            alert(err);
        }
    })
    return author_image;
}