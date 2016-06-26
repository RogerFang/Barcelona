<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/25
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <meta name="decorator" content="default">
    <title>JqueryValidate</title>
    <script>
        $().ready(function () {
            // validate form when it is submitted
            $("#xxxform").validate();

            // validate form on keyup and submit
            $("#testform").validate({
                rules:{
                    username:{
                        required:true,
                        minlength:2
                    },
                    password:{
                        required:true,
                        minlength:5,
                    },
                    confirm_password:{
                        required:true,
                        minlength:5,
                        equalTo:"#password"
                    },
                    school:"required",
                    email:{
                        required:true,
                        email:true
                    }
                }
            });
        });
    </script>
</head>
<body>
    <h1 class="page-header">
        Jquery Validate
    </h1>
    <form id="testform" class="form-horizontal">
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
            <label for="confirm_password" class="col-sm-2 control-label">确认密码:</label>
            <div class="col-sm-3">
                <input type="password" id="confirm_password" name="confirm_password" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="school" class="col-sm-2 control-label">学校:</label>
            <div class="col-sm-3">
                <input type="text" id="school" name="school" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">邮箱:</label>
            <div class="col-sm-3">
                <input type="text" id="email" name="email" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-3">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="rememberMe">remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-3">
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="button" class="btn btn-danger" onclick="history.back();">返回</button>
            </div>
        </div>
    </form>
</body>
</html>
