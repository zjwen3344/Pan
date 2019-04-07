
function PostFIle( FomData ) {
    $.ajax({
        url:"/Upload"
        ,type:"Post"
        ,data:FomData
        ,async:false
        ,processData: false
        ,contentType: false
        ,mimeType:"multipart/form-data"
        ,success:function (ok) {
            //这里有一个问题，就是没有判断返回值就抛出上传成功
            alert("上传成功!")
        }
    });
}
