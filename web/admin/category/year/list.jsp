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
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link href="${path}/css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="${path}/js/jquery-3.3.1.js"></script>
    <script src="${path}/js/bootstrap.js"></script>
    <script src="${path}/js/my_jquery.js"></script>
</head>
<style>
    th, td {
        text-align: center;
    }
</style>
<body>
<div class="table-responsive">
    <table class="table table-bordered text-center table-hover">
        <tr>
            <th  colspan="3">${msg}</th>
        <th >
            <a href="${path}/AdminYearServlet?method=addYearUI">
                <button type="button" class="btn btn-primary" >添加</button>
            </a>
        </th>
        </tr>
        <tr class="text-center">
            <th>序号</th>
            <th>年代</th>
            <th>删除</th>
            <th>修改</th>
        </tr>
        <c:forEach items="${yearList}" var="year" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${year.name}</td>
                <td>
                    <%--<button Type="button" class="btn btn-danger deleteCategory" value="${category.id}" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">删除</button>--%>
                    <button type="button" class="btn btn-danger deleteCategory" value="${year.id}" >删除</button>
                </td>
                <td>
                    <a href="${path}/AdminYearServlet?method=editYearUI&id=${year.id}">
                        <button type="button" class="btn btn-primary" >修改</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%--弹出的确认删除模态框--%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="exampleModalLabel">确认框</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label class="control-label">确定要删除该年代？</label>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="confirm">确认</button>
            </div>
        </div>
    </div>
</div>

</body>
<script>
//点击时弹出模态框
$(function () {
 choose("${path}/AdminYearServlet?method=deleteYear");
});

</script>
</html>
