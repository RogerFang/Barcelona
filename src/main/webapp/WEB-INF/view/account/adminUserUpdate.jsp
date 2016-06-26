<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/26
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <meta name="decorator" content="default">
    <title>Update User</title>
</head>
<body>
    <form id="updateForm" action="${ctx}/admin/user/update" class="form-horizontal" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">姓名:</label>
            <div class="col-sm-3">
                <input type="text" id="username" name="username" class="form-control" value="${user.username}">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-3">
                <input type="password" id="password" name="password" class="form-control" placeholder="leave it blank if no change">
            </div>
        </div>
        <div class="form-group">
            <label for="confirm_password" class="col-sm-2 control-label">确认密码:</label>
            <div class="col-sm-3">
                <input type="password" id="confirm_password" name="confirm_password" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-3">
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="button" class="btn btn-danger" onclick="history.back()">Back</button>
            </div>
        </div>
    </form>
</body>
</html>
