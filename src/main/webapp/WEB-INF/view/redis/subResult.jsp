<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/6/14
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <title>SubResult</title>
</head>
<body>
<div class="col-sm-12">
    <a href="${ctx}/redis/pub" class="btn btn-link">Go to Publish</a>
</div>

<div class="col-sm-12">
    <ul class="list-group col-sm-8">
        <li class="list-group-item">1、直接使用message.toString()获取消息, 对于其他的Serializer会出现乱码 >>>>>  ��tHello </li>
        <li class="list-group-item">2、String itemValue = (String)redisTemplate.getValueSerializer().deserialize(body);</li>
    </ul>
</div>

<h1 class="page-header">订阅消息</h1>
<div class="col-sm-12">
    <c:forEach items="${messageList}" var="li">
        ${li} <br/>
    </c:forEach>
</div>
</body>
</html>
