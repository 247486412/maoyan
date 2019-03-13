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
            <th colspan="5">${msg}</th>
            <th>
                <a class="add" href="${path}/AdminPictureServlet?method=addPictureUI&id=${pictureList[0].movie_id}">
                    <button type="button" class="btn btn-primary">上传</button>
                </a>
            </th>
            <th>
                <button id="deleteAll" type="button" class="btn btn-danger" value="${pictureList[0].movie_id}">全部清除
                </button>
            </th>
        </tr>
        <tr class="text-center">
            <th>序号</th>
            <th>图片</th>
            <th>图片名</th>
            <th>描述</th>
            <th>大小</th>
            <th>删除</th>
            <th>下载</th>
        </tr>
        <c:forEach items="${pictureList}" var="picture" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td><img width="60px" height="60px" src="${path}/${picture.path}"></td>
                    <td>${picture.name}</td>
                    <td>${picture.describe}</td>
                    <td>${picture.size}</td>
                    <td>
                        <button type="button" class="btn btn-danger deleteCategory" value="${picture.id}">删除
                        </button>
                    </td>

                    <td>
                        <a href="${path}/AdminPictureServlet?method=download&id=${picture.id}">
                            <button type="button" class="btn btn-primary">下载</button>
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
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="exampleModalLabel">确认框</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label id="confirmDelete" class="control-label">确定要删除该图片？</label>
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
      $("#confirmDelete").text("确定删除该图片");
      var id = $(this).val();
      $("#exampleModal").modal('show');
      $("#confirm").click(function () {
        location.href = "${path}/AdminPictureServlet?method=deletePicture&id="+id+"&movieId=${pictureList[0].movie_id}";
      });
    });

    $("#deleteAll").click(function () {
      $("#confirmDelete").text("确定全部清除");
      var id = $(this).val();
      $("#exampleModal").modal('show');
      $("#confirm").click(function () {
        location.href = "${path}/AdminPictureServlet?method=deleteAllPicture&id=" + id;
      });
    });
  });
</script>
</html>
