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
    <table class="table table-bordered text-center table-hover" style="table-layout: fixed;">
        <tr>
            <th  colspan="12"></th>
        <th >
            <a href="${path}/AdminMovieServlet?method=addMovieUI">
                <button type="button" class="btn btn-primary" >添加</button>
            </a>
        </th>
        </tr>
        <tr class="text-center">
            <th>影片名</th>
            <th>封面图</th>
            <th>图集</th>
            <th>类型</th>
            <th>年代</th>
            <th>所属地区</th>
            <th>状态</th>
            <th>评分</th>
            <th>时长</th>
            <th>添加时间</th>
            <th>演职人员</th>
            <th>删除</th>
            <th>修改</th>
        </tr>
        <c:forEach items="${page.pageData}" var="movie" varStatus="status">
            <tr>
                <td>${movie.name}</td>
                <td><img width="60px" height="60px" src="${path}/${movie.picture.path}"></td>
                <td><a href="${path}/AdminPictureServlet?method=findPicture&id=${movie.id}" class="btn btn-info btn-sm">查看详情</a></td>
                <td>${movie.type.name}</td>
                <td>${movie.year.name}</td>
                <td>${movie.area.name}</td>
                <td>
                    <c:if test="${movie.flag == 1 }">
                        <span>正在热映</span>
                    </c:if>

                    <c:if test="${movie.flag == 2 }">
                        <span>即将上映</span>
                    </c:if>
                    <c:if test="${movie.flag == 3 }">
                        <span>最受期待</span>
                    </c:if>
                    <c:if test="${movie.flag == 4 }">
                        <span>热播电影</span>
                    </c:if>
                </td>
                <td>${movie.score}</td>
                <td>${movie.duration}分钟</td>
                <td>${movie.create_time}</td>
                <td>
                <a href="${path}/AdminCreditsServlet?method=findCredits&id=${movie.credits_id}" class="btn btn-info btn-sm">查看详情</a>
                </td>
                <td>
                    <button type="button" class="btn btn-danger deleteCategory" value="${movie.id}" >删除</button>
                </td>
                <td>
                    <a href="${path}/AdminMovieServlet?method=editMovieUI&id=${movie.id}">
                        <button type="button" class="btn btn-primary" >修改</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="container">
    共${page.totalPage}页/第${page.currentPage}页
    <%--显示的页码，使用forEach遍历显示的页面 --%>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <c:if test="${page.currentPage != page.firstPage}">
                    <a href="${pageContext.request.contextPath}${page.url}&currentPage=1">首页</a>
                </c:if>
            </li>
            <li class="previous ">
                <a href="${pageContext.request.contextPath}${page.url}&currentPage=${page.prePage}">上一页</a>
            </li>
            <c:forEach begin="${page.startButton}" end="${page.lastButton}" var="pagenum">
                <c:if test="${page.totalPage >= pagenum }">
                    <li>
                        <a class="pageButton"
                           href="${pageContext.request.contextPath}${page.url}&currentPage=${pagenum}">${pagenum}</a>
                    </li>
                </c:if>
            </c:forEach>
            <li >
                <a href="${pageContext.request.contextPath}${page.url}&currentPage=${page.nextPage}">下一页</a>
            </li>
            <li>
                <c:if test="${page.currentPage != page.totalPage}">
                    <a href="${pageContext.request.contextPath}${page.url}&currentPage=${page.totalPage}">末页</a>
                </c:if>
            </li>
            <li><input type="text" id="pagenum" name="pagenum" size="1" style="border-radius: 3px;outline: none;box-shadow: none;border: 1px solid #ddd;height: 34px;width: 40px;"/></li>
            <li class="next"><input class="btn btn-primary " type="button" value="前往" onclick="jump()" style=" margin-bottom: 2px;"/></li>
        </ul>
    </nav>
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
                        <label class="control-label">确定要删除该影片？</label>
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
    var id = $(this).val();
    $("#exampleModal").modal('show');
    $("#confirm").click(function () {
      location.href="${path}/AdminMovieServlet?method=deleteMovie&id="+id;
    });
  });
    });



  var pageButton = document.getElementsByClassName("pageButton");
  for (var i = 0; i < pageButton.length; i++) {
    if (pageButton[i].innerText ==${page.currentPage}) {
      pageButton[i].style.color = "red";
    }
  }

  function jump() {
    var totalpage = ${page.totalPage};
    var pagenum = document.getElementById("pagenum").value;
    //判断输入的是一个数字
    var reg = /^[1-9][0-9]{0,2}$/;
    if (!reg.test(pagenum)) {
      //不是一个有效数字
      document.getElementById("msg").innerText = "请输入1到999之间的数字";
      return;
    }
    //判断输入的数字不能大于总页数
    if (parseInt(pagenum) > parseInt(totalpage)) {
      //超过了总页数
      document.getElementById("msg").innerText = "不能超过总页数";
      return;
    }
    //转向分页显示的Servlet
    window.location.href = "${pageContext.request.contextPath}${page.url}&currentPage=" + pagenum;
  }
</script>
</html>
