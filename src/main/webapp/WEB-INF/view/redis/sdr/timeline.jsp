<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/6/15
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <title>Timeline</title>
</head>
<body>

    <div class="span-7 last" id="rightcol">
        <h1 class="page-header">Users</h1>
        <div class="span-7 box">
            <c:forEach var="u" items="${users}">
                <a href="!${u}">${u}</a>
            </c:forEach>
        </div>
    </div>

    <h1 class="page-header">Posts</h1>
    <c:forEach var="p" items="${posts}">
        <hr/>
        <div class="post">
            <p>
                <a class="user" href="<c:url value="/retwis/!${p.name}"/>"><b>${p.name}</b></a> ${p.content}
                <br/>
                <!-- link to post -->
                <a href="<c:url value="/retwis/status?pid=${p.pid}"/>"></a>
                <!-- reply connection -->
                <c:if test="${!empty p.replyPid}">
                    <a href="<c:url value="/retwis/status?pid=${p.replyPid}"/>">${p.replyTo}</a>
                </c:if>
                &nbsp;&nbsp;&nbsp;
                <c:if test="${loggedIn}">
                    <a href="<c:url value="/retwis/!${loggedUser}?replyto=${p.name}&replypid=${p.pid}"/>"></a>
                </c:if>
            </p>
        </div>
    </c:forEach>
</body>
</html>
