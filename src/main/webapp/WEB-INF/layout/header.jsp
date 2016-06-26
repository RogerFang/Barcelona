<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/25
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<div id="header">
    <div id="title">
        <h1><a href="${ctx}">Barcelona</a>
        <shiro:guest>
            <a class="btn pull-right" href="${ctx}/login">Login</a>
        </shiro:guest>
        <shiro:user>
            <div class="btn-group pull-right">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-user"><shiro:principal/></i>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <shiro:hasRole name="admin">
                        <li><a href="${ctx}/admin/user">Users Manage</a></li>
                    </shiro:hasRole>
                    <li><a href="${ctx}/logout">Logout</a></li>
                </ul>
            </div>
        </shiro:user>
        </h1>
        <legend></legend>
    </div>
</div>