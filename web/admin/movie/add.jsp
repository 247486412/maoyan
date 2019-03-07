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
</head>
<body>
<form id="toForm" class="form-inline" method="post"
      action="${pageContext.request.contextPath}/AdminCategoryServlet?method=addCategory">
    <div class="form-group ">
        <label for="exampleInputName2" class="h4">类别名:</label>
        <input type="text" class="form-control" id="exampleInputName2" name="categoryName" placeholder="请输入类别名">
        <%--button默认会是submit需要给type--%>
        <button type="button" class="btn btn-default addCategory">添加多个</button>
        <a href="${pageContext.request.contextPath}/AdminCategoryServlet?method=findAllCategory"><button type="button" class="btn btn-default" id="goBack">返回</button></a>
        <button type="submit" class="btn btn-success">确定</button> <strong class="text-danger h4 " style="font-size: 20px;font-weight: bold ">${msg}</strong>
    </div>
</form>
</body>
<script>
  $(function () {
    $(".addCategory").click(function () {
      var input = $("<br><div class=\"form-group\">\n" +
          "            <label for=\"exampleInputName2\" class=\"h4\">类别名:</label>\n" +
          "            <input Type=\"text\" class=\"form-control\" id=\"exampleInputName2\"  name=\"categoryName\" placeholder=\"请输入类别名\">\n" +
          "        <button Type=\"button\" class=\"btn btn-default deleteCategory\">删除</button></div> ");
      input.appendTo($("#toForm"));
    });
    $("#toForm").on("click",".deleteCategory",function () {
      $(this).parent().prev("br").remove();
      $(this).parent().remove();
    });
  });
</script>
</html>
