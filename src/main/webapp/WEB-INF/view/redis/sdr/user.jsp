<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/6/15
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="col-sm-12">
    <h2 class="page-header">Welcome ${name}</h2>
</div>
<div class="col-sm-12">
    ${loggedUser}
    <c:choose>
        <c:when test="${loggedUser eq name}">
            <div id="updateform" class="box">
                <form method="post" action="!${name}">
                    <c:choose>
                        <c:when test="${!empty replyTo}">
                            replyTo <i>${replyTo}</i>:
                        </c:when>
                        <c:otherwise>
                            <b><i>${name}</i></b>,
                        </c:otherwise>
                    </c:choose>
                    <textarea name="content" rows="3" cols="60"><c:if test="${!empty replyTo}">@${replyTo} </c:if></textarea><br />
                    <input type="hidden" name="replyTo" value="${replyTo}"/>
                    <input type="hidden" name="replyPid" value="${replyPid}"/>
                    <input type="submit" value="Update"/>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <c:if test="${loggedIn}">
                <div class="box">
                    <c:choose>
                        <c:when test="${follows}"><a href="<c:url value="/!${name}/stopfollowing"/>">follow.stop</a></c:when>
                        <c:otherwise><a href="<c:url value="/!${name}/follow"/>">follow</a></c:otherwise>
                    </c:choose>
                    <c:if test="${!no_mentions}"> | <a href="<c:url value="/!${name}/mentions"/>">Mentions</a></c:if>
                </div>

                <c:if test="${!empty also_followed}">
                    <div class="box">
                        follow.also: <c:forEach var="f" items="${also_followed}"><a href="<c:url value="/!${f}"/>">${f}</a> </c:forEach>
                    </div>
                </c:if>
            </c:if>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
