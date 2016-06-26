<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/6/14
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <title>pub</title>
</head>
<body>
<h1 class="page-header">发布消息</h1>
<form  class="form-horizontal" action="${ctx}/redis/pub" method="post">
    <div class="form-group">
        <label for="message" class="col-sm-2 control-label">消息:</label>
        <div class="col-sm-3">
            <input type="text" id="message" name="message" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-3">
            <button type="submit" class="btn btn-primary">发送</button>
            <button type="button" class="btn btn-danger" onclick="history.back();">返回</button>
        </div>
    </div>
</form>
</body>
</html>
