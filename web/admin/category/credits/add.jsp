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
<form id="toForm" class="form-inline" method="post"
      action="${pageContext.request.contextPath}/AdminCreditsServlet?method=addCredits">
    <div class="form-group ">
        <c:forEach items="${creditsMap}" var="credits" begin="0" end="0">
        <label for="exampleInputName2" class="h4">${credits.key}名字:</label>
        <input type="text" class="form-control inputText" id="exampleInputName2"  name="name" placeholder="请输入${credits.key}名字">
        <%--button默认会是submit需要给type--%>
        <input type="hidden" name="id" value="${id}">
        <input type="hidden" name="type" value="${type}">
        <input type="hidden" name="creditsName" value="${credits.value}">
        <button type="button" class="btn btn-default addCategory">添加多个</button>
        <a href="${pageContext.request.contextPath}/AdminCreditsServlet?method=findCredits"><button type="button" class="btn btn-default" id="goBack">返回</button></a>
        <button type="submit" class="btn btn-success">确定</button> <strong id="msg" class="text-danger h4 " style="font-size: 20px;font-weight: bold ">${msg}</strong>
        </c:forEach>
    </div>
</form>
</body>
<script>
<c:forEach items="${creditsMap}" var="credits" begin="0" end="1">
  addDelete("${credits.key}名字");
</c:forEach>
  mySubmit($("#toForm"));
</script>
</html>
