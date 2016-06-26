<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/25
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <title><sitemesh:title/></title>
    <link href="${ctx}/static/style/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/style/validate.css" rel="stylesheet" type="text/css"/>

    <script src="${ctx}/static/js/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/jquery.form.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/messages_bs_zh.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/jquery-ui.js" type="text/javascript"></script>
    <sitemesh:head/>
</head>
<body>
    <div class="container">
        <%@ include file="/WEB-INF/layout/header.jsp"%>
        <div id="content">
            <sitemesh:body/>
        </div>
        <%@ include file="/WEB-INF/layout/footer.jsp"%>
    </div>

    <script src="${ctx}/static/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
