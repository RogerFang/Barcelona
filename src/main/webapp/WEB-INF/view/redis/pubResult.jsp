<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/6/14
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <title>PubResult</title>
</head>
<body>
    <div class="col-sm-12">
        <a href="${ctx}/redis/sub" class="btn btn-link">Go to Subscribe Result</a>
    </div>

    <div class="col-sm-12">
        发送成功 !<br/>
        <form id="pub" name="pub" action="${ctx}/redis/pub" method="get">
            <input type="submit" value="继续发送" class="btn btn-primary">
        </form>
    </div>
</body>
</html>
