<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>文档资料</title>
<%@ include file="/common/header.jsp"%>
<script src="<%=basePath%>/source/frame/uploadify/jquery.uploadify.min.js"></script>
<link rel="stylesheet"  href="<%=basePath%>/source/frame/uploadify/uploadify.css">


<script type="text/javascript">



$(function(){
	initUploadify();
});



function initUploadify() {
	$("#uploadify").uploadify({
		method : 'POST',
		queueID : 'queue',
		width : 80,
		height : 20,
		buttonText : '选择文件',
		fileSizeLimit : '50MB',
		//fileTypeExts : '*.xls',
		swf : '<%=basePath%>/source/frame/uploadify/uploadify.swf',
		uploader : 'http://192.168.1.102:8080/staticfile/file/upload',
		fileObjName : 'file',
		multi : true,
		uploadLimit:2,
		auto : false,
		onUploadError: function(file, errorCode, errorMsg, errorString) {
            alert('The file ' + file.name + ' could not be uploaded: ' + errorString);
        },
		onUploadSuccess : function(file, data, response) {
			alert(data);
		},
		
	});
}

function upload() {
	var id='<%=session.getId()%>';
	$('#uploadify').uploadify('settings', 'formData', {
		sessionid : id
	});
	$('#uploadify').uploadify('upload', '*');
}

function test(){
	jq.ajax('http://192.168.1.102:8080/staticfile/file/upload', {
		sessionid:'<%=session.getId()%>'
	}, function(data){
		eui.alert(data);
	},{
		dataType:'text'
	});
	
	
}


</script>




</head>

<body>
	
	
	
	
		
		<div style="float:left; width:200px;height:200px;">
			<div style="width:80px;margin: 20px auto;">
				<input type="file" name="file" id="uploadify" />
			</div>
			<div id="queue"></div>
		</div>
		
			<a class="easyui-linkbutton" onclick="upload()">上传</a>
		
		
	
		
		
	<label>id:</label><input type="text" name="sessionid" id="sessionid" >
	<a class="easyui-linkbutton" onclick="test()">测试</a>
		
		
		
		

	
	
</body>
</html>
