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
</head>
<body>
<form id="toForm" class="form-inline" method="post"
      action="${pageContext.request.contextPath}/AdminAreaServlet?method=editArea">
    <div class="form-group ">
        <label for="exampleInputName2" class="h4">类别名:</label>
        <input type="hidden" name="id" value="${area.id}">
        <input type="text" class="form-control h5" id="exampleInputName2" name="name" value="${area.name}">
        <%--button默认会是submit需要给type--%>
        <button type="submit" class="btn btn-success">确定修改</button> <strong class="text-danger h4 " style="font-size: 20px;font-weight: bold ">${msg}</strong>
    </div>
</form>
</body>
</html>
