<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2016/5/25
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<html>
<head>
    <%--1--%>
    <link href="${ctx}/static/style/fileupload.css" rel="stylesheet">
    <script src="${ctx}/static/js/fileupload.js" type="text/javascript"></script>

    <title>INDEX</title>
    <script>
        $(function () {
            // 上传文件样式设置
            $('input[type=file]').bootstrapFileInput();
            $('.file-inputs').bootstrapFileInput();
        });

        function upload() {
            if ($("#uploadFile").val()!=""){
                $("#uploadForm").ajaxSubmit({
                    async: false,
                    success:function(data){
                        alert(data.msg);
                    }
                });
            }
        }
    </script>
</head>
<body>
    <div class="row">
        <div class="col-sm-6">
            <div class="panel panel-info">
                <div class="panel-heading text-center">
                    <h3>校验</h3>
                </div>
                <div class="panel-body">
                    <ol class="list-group">
                        <li class="list-group-item">前端校验：<a href="${ctx}/jquery" class="btn btn-link">JQuery validate</a></li>
                        <li class="list-group-item">后端校验：<a href="${ctx}/login" class="btn btn-link">Hibernate validator</a></li>
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
                    <ol class="list-group">
                        <li class="list-group-item"><a href="${ctx}/mashup" class="btn btn-link">Demo 跨域资源获取</a></li>
                    </ol>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-info">
                <div class="panel-heading text-center">
                    <h3>文件上传和下载</h3>
                </div>
                <div class="panel-body">
                    <ol class="list-group">
                        <li class="list-group-item">文件下载：<a href="${ctx}/file/download" class="btn btn-link">download file</a></li>
                        <li class="list-group-item">
                            <div class="row">
                                <span class="col-sm-3">文件上传：</span>
                                <form id="uploadForm" action="${ctx}/file/upload" method="post" enctype="multipart/form-data">
                                    <div class="col-sm-6 fileupload fileupload-new" data-provides="fileupload">
                                        <span class="btn btn-primary btn-file">
                                            <span class="fileupload-new">Select file</span>
                                            <span class="fileupload-exists">Change</span>
                                            <input type="file" name="multipartFile"/>
                                        </span>
                                        <span class="fileupload-preview"></span>
                                        <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
                                    </div>
                                    <button class="col-sm-2 btn btn-primary" type="button" onclick="upload();">上传</button>
                                </form>
                            </div>
                        </li>
                    </ol>
                </div>
            </div>
        </div>


    </div>

    <div class="row">
        <div class="col-sm-6">
            <div class="panel panel-info">
                <div class="panel-heading text-center">
                    <h3>jedis实现pub/sub</h3>
                </div>
                <div class="panel-body">
                    <ol class="list-group">
                        <li class="list-group-item">参见jedis目录下的Demo代码</li>
                    </ol>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="panel panel-info">
                <div class="panel-heading text-center">
                    <h3>spring-data-redis实现pub/sub</h3>
                </div>
                <div class="panel-body">
                    <ol class="list-group">
                        <li class="list-group-item"><a href="${ctx}/redis/pub" class="btn btn-link">发布消息</a></li>
                        <li class="list-group-item"><a href="${ctx}/redis/sub" class="btn btn-link">订阅消息</a></li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
