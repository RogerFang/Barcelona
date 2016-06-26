<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/6/15
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <title>SigIn&SignUp</title>
</head>
<body>
<div class="span-11 box">
    <h2>登录SignIn</h2>

    <form action="${ctx}/retwis/signIn" method="post">
        <c:if test="${errorpass}">
            <div class="error">
                密码错误
            </div>
        </c:if>

        <table>
            <tr>
                <td>Username</td>
                <td><input  name="name" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="pass" /></td>
            </tr>
        </table>
        <input type="submit" value="登录" />

    </form>
</div>

<div class="span-11 box last">
    <h2>注册SignUp</h2>

    <c:if test="${errorduplicateuser}">
        <div class="error">
            已有该用户
        </div>
    </c:if>

    <c:if test="${errormatch}">
        <div class="error">
            errormatch
        </div>
    </c:if>

    <form action="${ctx}/retwis/signUp" method="post">
        <table>
            <tr>
                <td>Username</td>
                <td><input  name="name" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input  type="password" name="pass" /></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input  type="password" name="pass2" /></td>
            </tr>
        </table>
        <input type="submit" value="注册">
    </form>
</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
