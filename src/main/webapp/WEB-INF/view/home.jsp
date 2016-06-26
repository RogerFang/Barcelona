<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/26
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Barcelona</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">WHO</a></li>
                <li><a href="#">WHAT</a></li>
                <li><a href="#">WHERE</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- First Container -->
<div class="container-fluid bg-1 text-center">
    <h3 class="margin">Who Am I?</h3>
    <img src="${ctx}/static/img/barcelona/team_logo3.jpg" class="img-responsive img-circle margin" style="display:inline" alt="Barcelona" width="350" height="350">
    <h3>FC Barcelona</h3>
</div>

<!-- Second Container -->
<div class="container-fluid bg-2 text-center">
    <%--<h3 class="margin">What Am I?</h3>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
    <a href="#" class="btn btn-default btn-lg">
        <span class="glyphicon glyphicon-search"></span> Search
    </a>--%>
    <div class="col-lg-offset-1 col-lg-10">
        <div class="row">
            <div class="col-sm-6">
                <div class="panel panel-info">
                    <div class="panel-heading text-center">
                        <h3>校验</h3>
                    </div>
                    <div class="panel-body">
                        <ol>
                            <li>前端校验：<a href="${ctx}/jquery" class="btn btn-link">JQuery validate</a></li>
                            <li>后端校验：<a href="${ctx}/login" class="btn btn-link">Hibernate validator</a></li>
                        </ol>
                    </div>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="panel panel-info">
                    <div class="panel-heading text-center">
                        <h3>Mashup多内容源整合</h3>
                    </div>
                    <div class="panel-body">
                        <ol>
                            <li><a href="${ctx}/mashup" class="btn btn-link">Demo</a></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Third Container (Grid) -->
<div class="container-fluid bg-3 text-center">
    <h3 class="margin">Where To Find Me?</h3><br>
    <div class="row">
        <div class="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <img src="${ctx}/static/img/barcelona/team_logo1.jpg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <img src="${ctx}/static/img/barcelona/team_player1.jpg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <img src="${ctx}/static/img/barcelona/team_cloth1.jpg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
    </div>
</div>

</body>
</html>