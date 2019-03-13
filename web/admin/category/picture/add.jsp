<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/3
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="${path}/js/my_jquery.js" type="text/javascript"></script>
</head>
<body>
<form id="toForm" class="form-inline" enctype="multipart/form-data" method="post"
      action="${pageContext.request.contextPath}/AdminPictureServlet?method=addPicture&id=${id}">
    <div class="form-group ">
        <label class="h4">请选择图片:</label>
        <input type="file" class="form-control  fileName" name="fileName" style="display: none" onchange="$(this).next().next().val($(this).val())">
        <button type="button" class="btn btn-primary upload" onclick="$(this).prev().click();">选择图片</button>
        <input type="text" class="form-control "  name="pictureName" placeholder="图片描述">
        <button type="button" class="btn btn-default addCategory">添加多张</button>
        <a href="${pageContext.request.contextPath}/AdminPictureServlet?method=findPicture&id=${id}"><button type="button" class="btn btn-default">返回</button></a>
        <button type="submit" class="btn btn-success">确定</button>
        <strong id="msg" class="text-danger h4 " style="font-size: 20px;font-weight: bold ">${msg}</strong>
    </div>
</form>
</body>
<script>
      $("body").on("submit", $("#toForm"), function () {
        var fileType = $(".fileName");
        var flag = true;
        fileType.each(function () {
          var value = $(this).val();
          var fileName =  value.substring(value.lastIndexOf(".")).toUpperCase();
          if (value == null || value.trim().length === 0) {
            flag = false;
            $("#msg").text("值不能为空");
          }else if(fileName==".PNG"||fileName==".BMP"||fileName==".JPEG"||fileName==".GIF"||fileName==".PSD"||fileName==".TIFF"||fileName==".TAG"||fileName==".TAG"||fileName==".EPS"||fileName==".JPG"){
            flag = true;
          }else {
            flag = false;
            $("#msg").text("文件格式错误");
          }
          console.log(fileName);
        });
        return flag;
      });


    $(".addCategory").click(function () {
      var fileElement = $("<br><div class=\"form-group \"><label class=\"h4\">请选择图片:</label>\n" +
          "        <input type=\"file\" class=\"form-control  fileName\" name=\"fileName\" style=\"display: none\" onchange=\"$(this).next().next().val($(this).val())\">\n" +
          "        <button type=\"button\" class=\"btn btn-primary upload\" onclick=\"$(this).prev().click();\">选择图片</button>\n" +
          "        <input type=\"text\" class=\"form-control \"  name=\"name\" placeholder=\"图片描述\"><button Type=\"button\" class=\"btn btn-default deleteCategory\">删除</button></div>");
      fileElement.appendTo($("#toForm"));
    });
    $("#toForm").on("click", ".deleteCategory", function () {
      $(this).parent().prev("br").remove();
      $(this).parent().remove();
    });
</script>
</html>
