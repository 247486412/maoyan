<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--分页显示的开始 --%>
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
            <li><input type="text" id="pagenum" name="pagenum" size="1"/></li>
            <li class="next"><input class="btn btn-primary " type="button" value="前往" onclick="jump()"/></li>
        </ul>
    </nav>
    <script type="text/javascript">
      var pageButton = document.getElementsByClassName("pageButton");
      for (var i = 0; i < pageButton.length; i++) {
        console.log(pageButton[i]);
        if (pageButton[i].innerText ==${page.currentPage}) {
          pageButton[i].style.color = "red";
        }
      }

      function jump() {
        var totalpage = ${page.totalPage};
        var pagenum = document.getElementById("pagenum").value;
        //判断输入的是一个数字
        var reg = /^[1-9][0-9]{0,1}$/;
        if (!reg.test(pagenum)) {
          //不是一个有效数字
          document.getElementById("msg").innerText = "请输入1到99之间的数字";
          return;
        }
        //判断输入的数字不能大于总页数
        if (parseInt(pagenum) > parseInt(totalpage)) {
          //超过了总页数
          document.getElementById("msg").innerText = "不能超过总页数";
          return;
        }
        //转向分页显示的Servlet
        window.location.href = "${pageContext.request.contextPath}/${page.url}&currentPage=" + pagenum;
      }
    </script>
</div>
<%--分页显示的结束--%>
