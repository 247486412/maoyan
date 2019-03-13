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
<style>
    .form-group div{
        clear: both;
        float: right;
        margin-left: 10px;
    }
</style>
<body>
<form id="toForm" class="form-inline" method="post"
      action="${pageContext.request.contextPath}/AdminMovieServlet?method=addCredits">
    <div class="form-group pull-left">
        <div>
        <label for="exampleInputName1" class="h4">主演：</label>
        <input type="text" class="form-control inputText" id="exampleInputName1"  name="actor" placeholder="请输入演员名字">
        </div>
        <div>
        <label for="exampleInputName2" class="h4">导演：</label>
        <input type="text" class="form-control inputText" id="exampleInputName2"  name="director" placeholder="请输入导演名字">
        </div>
        <div>
        <label for="exampleInputName3" class="h4">副导演：</label>
        <input type="text" class="form-control inputText" id="exampleInputName3"  name="assistant_director" placeholder="请输入副导演名字">
        </div>
        <div>
        <label for="exampleInputName4" class="h4">执行导演：</label>
        <input type="text" class="form-control inputText" id="exampleInputName4"  name="executive_director" placeholder="请输入执行导演名字">
        </div>
        <div>
        <label for="exampleInputName5" class="h4">制片人：</label>
        <input type="text" class="form-control inputText" id="exampleInputName5"  name="producer" placeholder="请输入制片人名字">
        </div>
        <div>
        <label for="exampleInputName6" class="h4">编剧：</label>
        <input type="text" class="form-control inputText" id="exampleInputName6"  name="scriptwriter" placeholder="请输入编剧名字">
        </div>
        <div>
        <label for="exampleInputName7" class="h4">摄影师：</label>
        <input type="text" class="form-control inputText" id="exampleInputName7"  name="cameraman" placeholder="请输入摄影师名字">
        </div>
        <div>
        <label for="exampleInputName8" class="h4">艺术指导：</label>
        <input type="text" class="form-control inputText" id="exampleInputName8"  name="art_director" placeholder="请输入艺术指导名字">
        </div>
        <div>
        <label for="exampleInputName9" class="h4">原作者：</label>
        <input type="text" class="form-control inputText" id="exampleInputName9"  name="original_author" placeholder="请输入原作者名字">
        </div>
        <%--button默认会是submit需要给type--%>
        <div class="center-block text-center" style="width: 100%;" >
        <button type="submit" class="btn btn-success btn-lg ">确认提交</button>
        </div>
        <div class="center-block text-center" style="width: 100%;">
            <strong id="msg" class="text-danger h5 " style="font-size: 20px;font-weight: bold;margin: 8px 0px 0px 8px;">${msg}</strong>
        </div>
    </div>
</form>

</body>
</html>
