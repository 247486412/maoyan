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
    <script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
</head>
<style>
    .dropdown {
        margin: 0px 15px 10px 0px;
    }

    .dropdown-toggle {
        width: 100px;
    }
</style>
<body>
<form id="toForm" class="form-inline" method="post"
      action="${pageContext.request.contextPath}/AdminMovieServlet?method=editMovie">
    <input type="hidden" name="movieId" value="${id}">
    <div class="form-group " style="margin-left: 10px">
        <label for="exampleInputName1" class="h4">请输入影片名字:</label>
        <input type="text" class="form-control" id="exampleInputName1" name="movieName" placeholder="请输入影片名">

        <strong id="msg" class="text-danger h4 " style="font-size: 20px;font-weight: bold ">${msg}</strong>
        <br>
        <label for="exampleInputName2" class="h4">请输入影片时长:</label>
        <input type="text" class="form-control" id="exampleInputName2" name="duration" placeholder="请输入影片多少分钟">


        <p class="h4 text-info bg-primary" style="margin-top: 8px; height: 30px; line-height: 30px">请选择影片类型、年代、区域、状态</p>
        <div >
            <div class="dropdown pull-left">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    <span class="showText">影片类型</span>
                    <span class="caret"></span>
                </button>
                <input type="hidden" name="typeName" value="">
                <ul class="dropdown-menu dropdownMenu" aria-labelledby="dropdownMenu1">
                    <c:forEach items="${typeList}" var="type">
                        <li><a href="javascript:void(0)" values="${type.id}">${type.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="dropdown pull-left ">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    <span class="showText">影片年代</span>
                    <span class="caret"></span>
                </button>
                <input type="hidden" name="yearName" value="">
                <ul class="dropdown-menu dropdownMenu" aria-labelledby="dropdownMenu2">
                    <c:forEach items="${yearList}" var="year">
                        <li><a href="javascript:void(0)" values="${year.id}">${year.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="dropdown pull-left " >
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu3" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    <span class="showText">所属地区</span>
                    <span class="caret"></span>
                </button>
                <input type="hidden" name="areaName" value="">
                <ul class="dropdown-menu dropdownMenu" aria-labelledby="dropdownMenu3">
                    <c:forEach items="${areaList}" var="area">
                        <li><a href="javascript:void(0)" values="${area.id}">${area.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="dropdown pull-left " style="margin-right: 0px">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu4" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    <span class="showText">影片状态</span>
                    <span class="caret"></span>
                </button>
                <input type="hidden" name="status" value="">
                <ul id="flag" class="dropdown-menu" aria-labelledby="dropdownMenu4">
                        <li><a href="javascript:void(0)">正在热映</a></li>
                        <li><a href="javascript:void(0)">即将上映</a></li>
                        <li><a href="javascript:void(0)">最受期待</a></li>
                        <li><a href="javascript:void(0)">热播电影</a></li>
                </ul>
            </div>
            <div class="clearfix"></div>


            <%--button默认会是submit需要给type--%>


        </div>
        <div class="center-block text-center" style="margin-top: 20px">
        <a href="${pageContext.request.contextPath}/AdminMovieServlet?method=findMovie">
            <button type="button" class="btn btn-default btn-lg" id="goBack">返回</button>
        </a>
        <button type="submit" class="btn btn-success btn-lg">确定</button>
    </div>
    </div>
</form>
</body>
<script>
  $(function () {
    $("body").on("submit", $("#toForm"), function () {
      var inputText = $("input");
      var flag = true;
      inputText.each(function () {
        var value = $(this).val();
        if (value == null || value.trim().length === 0) {
          flag = false;
          $("#msg").text("值不能为空");
        }
      });
      return flag;
    });

    $(".dropdownMenu").children("li").click(function () {
      var value = $(this).children("a").text();
      var values = $(this).children("a").attr("values");
      $(this).parent("ul").prev().val(values);
      $(this).parent("ul").siblings("button").children(".showText").text(value);
    });
    $("#flag").children("li").click(function () {
      var index = $("#flag").children("li").index(this)+1;
      var value = $(this).children("a").text();
      $("#flag").prev().val(index);
      $("#flag").siblings("button").children(".showText").text(value);
    });

  })
</script>
</html>
