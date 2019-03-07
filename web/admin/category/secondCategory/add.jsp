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
    <script src="${path}/js/bootstrap.js" type="text/javascript"></script>
    <script src="${path}/js/my_jquery.js"></script>
</head>
<body>
<form id="toForm" class="form-inline" method="post"
      action="${pageContext.request.contextPath}/AdminCategoryServlet?method=addSecondCategory">
    <div class="form-group ">
        <label for="exampleInputName2" class="h4">类别名:</label>
        <input type="text" class="form-control inputText" id="exampleInputName2" name="name" placeholder="请输入类别名">

        <button type="button" class="btn btn-default addCategory">添加多个</button>
        <span class="h4">所属类别:</span>
        <select name="belongCategory" class="btn btn-default " id="selectBox">
            <c:forEach items="${categoryList}" var="category">
            <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <%--button默认会是submit需要给type--%>
        <a href="${pageContext.request.contextPath}/AdminCategoryServlet?method=findAllSecondCategory"><button type="button" class="btn btn-default" id="goBack">返回</button></a>
        <button type="submit" class="btn btn-success">确定</button> <strong id="msg" class="text-danger h4 " style="font-size: 20px;font-weight: bold "></strong>
    </div>
</form>
</body>
<script>
  addDelete("类别名");
  mySubmit($("#toForm"));
</script>
</html>
