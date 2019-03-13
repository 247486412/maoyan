<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>菜单</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css"/>
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="12"></td>
    </tr>
</table>
<table width="100%" border="0">
    <tr>
        <td>
            <div class="dtree">

                <a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>

                <script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
                <script type="text/javascript">

                  /**
                   * 树形菜单组件使用方法
                   * 需要导入DTree.js,DTree.css,DTree下的img
                   * 树形菜单外层标签的class名需为dtree
                   * 在页面中实现如下语句
                   * d = new dTree('d');创建一个DTree对象，调用对象的add方法创建节点
                   * 参数1为：当前节点的id
                   * 参数2为：父节点的id,-1为根节点
                   * 参数3为：节点的描述(titel)
                   * 参数4为：点击后跳转的路径
                   * 参数5为：提示信息
                   * 参数6为：需要发生变化的frame的name属性值
                   * 方法：d.openAll()为打开所有二级菜单，d.closeAll()为关闭所有二级菜单，document.write(d);输出创建的节点
                   */
                  d = new dTree('d');
                  d.add('01', -1, '系统菜单树');

                  d.add('0102', '01', '分类管理', '', '', 'mainFrame');
                  d.add('010201', '0102', '一级类别', '${pageContext.request.contextPath}/AdminCategoryServlet?method=findAllCategory', '', 'mainFrame');
                  d.add('010202', '0102', '二级类别', '${pageContext.request.contextPath}/AdminCategoryServlet?method=findAllSecondCategory', '', 'mainFrame');
                  d.add('0104', '01', '电影管理');
                  d.add('010401', '0104', '影片管理', '${pageContext.request.contextPath}/AdminMovieServlet?method=findMovie&currentPage=1', '', 'mainFrame');
                  d.add('010403', '0104', '类型管理', '${pageContext.request.contextPath}/AdminTypeServlet?method=findAllType', '', 'mainFrame');
                  d.add('010404', '0104', '年代管理', '${pageContext.request.contextPath}/AdminYearServlet?method=findAllYear', '', 'mainFrame');
                  d.add('010405', '0104', '区域管理', '${pageContext.request.contextPath}/AdminAreaServlet?method=findArea', '', 'mainFrame');
                  d.add('0105', '01', '影院管理');
                  d.add('010502', '0105', '品牌管理', '${pageContext.request.contextPath}/AdminOrderServlet?method=findAllOrder&status=1', '', 'mainFrame');
                  d.add('010503', '0105', '行政区管理', '${pageContext.request.contextPath}/AdminOrderServlet?method=findAllOrder&status=2', '', 'mainFrame');
                  d.add('010504', '0105', '特殊厅管理', '${pageContext.request.contextPath}/AdminOrderServlet?method=findAllOrder&status=3', '', 'mainFrame');
                  d.add('010505', '0105', '影院列表管理', '${pageContext.request.contextPath}/AdminOrderServlet?method=findAllOrder&status=4', '', 'mainFrame');
                  d.add('0106', '01', '电影票管理', '', '', '');
                  d.add('010601', '0106', '电影票管理', '', '', '');

                  document.write(d);

                </script>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
