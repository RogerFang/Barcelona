<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/25
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <meta name="decorator" content="default">
    <title>adminUserList</title>
</head>
<body>

    <table class="table table-hover">
        <thead>
            <tr>
                <td>#</td>
                <td>id</td>
                <td>username</td>
                <td>管理</td>
            </tr>
        </thead>
        <c:forEach items="${users}" var="item" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${item.id}</td>
                <td><a href="${ctx}/admin/user/update/${item.id}">${item.username}</a></td>
                <td><a class="btn btn-link" href="${ctx}/admin/user/delete/${item.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addUserModel">Add a User</button>
    <div class="modal fade" id="addUserModel" role="dialog" tabindex="-1" aria-hidden="true" aria-labelledby="addUserModelLabel" draggable="true">
        <div class="modal-dialog">
            <form action="${ctx}/admin/user/add" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel2">增加用户</h4>
                    </div>
                    <div class="modal-body" role="form">
                            <div class="form-group">
                                <label for="username" class="control-label">姓名:</label>
                                <div class="">
                                    <input type="text" id="username" name="username" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label">密码:</label>
                                <div class="">
                                    <input type="password" id="password" name="password" class="form-control">
                                </div>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


    <script>
        $(function () {
            // 这是jquery ui的特性, 需要引入jquery.ui.js
            $("#addUserModel").draggable({
                handle: ".modal-header"
            });
        });
    </script>
</body>
</html>
