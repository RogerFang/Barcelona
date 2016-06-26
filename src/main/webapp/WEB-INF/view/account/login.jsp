<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/24
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default">
    <title>Login</title>
</head>
<body>
    <div>
        <h1 class="page-header">
            普通表单标签 &nbsp;&lt;form&gt;&nbsp;
        </h1>
        ${errorMsg}
        <form id="loginform" class="form-horizontal" action="${ctx}/login" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">姓名:</label>
                <div class="col-sm-3">
                    <input type="text" id="username" name="username" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码:</label>
                <div class="col-sm-3">
                    <input type="password" id="password" name="password" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-3">
                    <button type="submit" class="btn btn-primary">Common Form Submit</button>
                </div>
            </div>
        </form>

        <br>
        <br>
        <br>
        <br>

        <h1 class="page-header">
            spring表单标签 &nbsp;&lt;form:form&gt;&nbsp;&nbsp;&nbsp; hibernate-validator返回验证信息
        </h1>
        <form:form method="post" commandName="user" action="${ctx}/login" class="form-horizontal">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">姓名:</label>
                <div class="col-sm-3">
                    <form:input path="username" class="form-control"/>
                    <form:errors path="username" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码:</label>
                <div class="col-sm-3">
                    <form:password path="password" class="form-control"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-3">
                    <button type="submit" class="btn btn-primary">Spring Form Submit</button>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
