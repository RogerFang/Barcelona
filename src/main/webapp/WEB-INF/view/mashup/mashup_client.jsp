<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/26
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <meta name="decorator" content="default">
    <title>Mashup Client</title>
    <script>
        // 当保存该页面到本地时，相对于它来说，remoteURL服务器地址就是跨域地址
        var remoteURL = "http://${pageContext.request.serverName}:${pageContext.request.serverPort}${ctx}";

        // 使用Jquery ajax jsonp方式跨域访问内容
        function fetchMashupContent() {
            $.ajax({
                url:remoteURL+"/mashup/jsonp",
                dataType:"jsonp"
            }).done(function (data) {
                $('#mashupContent').html(data.content);
                $('#mashupContent').show();
            });
            /*$.getJSON(remoteURL+"/mashup/jsonp?callback=?", function(data) {
                $('#mashupContent').html(data.content);
                $('#mashupContent').show();
            });*/
        }
    </script>
</head>
<body>
    <h1 class="page-header">
        基于JQuery的Jsonp实现完成Mashup
    </h1>
    <div class="col-sm-12">
        <button type="button" class="btn btn-danger" onclick="history.back();">返回</button>
    </div>
    <div class="col-sm-12">
        <ul class="list-group col-sm-8">
            <li class="list-group-item">1、Ajax直接请求普通文件存在跨域无权限访问</li>
            <li class="list-group-item">2、有"src"这个属性的标签都拥有跨域的能力，比如&lt;script&gt;、&lt;img&gt;、&lt;iframe&gt;</li>
            <li class="list-group-item">3、web客户端通过与调用脚本一模一样的方式，来调用跨域服务器上动态生成的js格式文件</li>
            <li class="list-group-item">4、JSONP，该协议的一个要点就是允许用户传递一个callback参数给服务端，然后服务端返回数据时会将这个callback参数作为函数名来包裹住JSON数据，这样客户端就可以随意定制自己的函数来自动处理返回数据了</li>
        </ul>
    </div>
    <div class="col-sm-12">
        <input type="button" class="btn btn-primary" value="获取内容" onclick="fetchMashupContent();">
        <h2>演示:将该页面另存为本地文件,然后再点开访问,用来模拟跨域访问</h2>
        <div class="panel">
            <div class="panel-heading">
                跨域页面内容:
            </div>
            <div id="mashupContent" style="display:none" class="alert alert-success">
            </div>
        </div>
    </div>
</body>
</html>
