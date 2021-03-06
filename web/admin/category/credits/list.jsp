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
</head>
<style>
    th{
        text-align: center;
    }
    td{
        vertical-align: middle!important;
    }
</style>
<body>
<div class="table-responsive">
    <table class="table table-bordered text-center table-hover " style="table-layout: fixed;">
        <tr>
            <th colspan="6">${msg}</th>
            <th>
                <button id="deleteAll" type="button" class="btn btn-danger" value="${creditsMap["id"]["id"]}">全部清除
                </button>
            </th>
        </tr>
        <tr class="text-center">
            <th>序号</th>
            <th>演职人员类型</th>
            <th colspan="2">名字</th>
            <th>删除</th>
            <th>修改</th>
            <th>添加</th>
        </tr>
        <c:forEach items="${creditsMap}" var="credits" begin="1" varStatus="status">
            <c:forEach items="${credits.value}" var="c">
                <tr>
                    <td>${status.count}</td>
                    <td>${c.key}</td>
                    <td colspan="2">${c.value}</td>
                    <td>
                        <button type="button" class="btn btn-danger deleteCategory" value="${credits.key}">删除
                        </button>
                    </td>
                    <td>
                        <a href="${path}/AdminCreditsServlet?method=editCreditsUI&id=${creditsMap["id"]["id"]}&type=${credits.key}">
                            <button type="button" class="btn btn-primary">修改</button>
                        </a>
                    </td>
                    <td>
                        <a class="add" href="${path}/AdminCreditsServlet?method=addCreditsUI&id=${creditsMap["id"]["id"]}&type=${credits.key}">
                            <button type="button" class="btn btn-primary">添加</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</div>

<%--弹出的确认删除模态框--%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="exampleModalLabel">确认框</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label id="confirmDelete" class="control-label">确定要删除该演职人员？</label>
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
  $(function () {

    $(".deleteCategory").click(function () {
      $("#confirmDelete").text("确定删除该演职人员");
      var field = $(this).val();
      $("#exampleModal").modal('show');
      $("#confirm").click(function () {
        location.href = "${path}/AdminCreditsServlet?method=deleteCredits&fieldName=" + field+"&id=${creditsMap["id"]["id"]}";
      });
    });

    $("#deleteAll").click(function () {
      $("#confirmDelete").text("确定全部清除");
      var id = $(this).val();
      $("#exampleModal").modal('show');
      $("#confirm").click(function () {
        location.href = "${path}/AdminCreditsServlet?method=deleteAll&id=" + id;
      });
    });
  });
</script>
</html>
