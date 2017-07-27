<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<%@ include file="/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=basePath%>/source/frame/dtree/dtree.css">
<script
	src="<%=basePath%>/source/frame/dtree/dtree.js"></script>



<script type="text/javascript">


var d=null;
var nodes=[
	{"id":1,"pid":-1,"name":"常规数据库"},       
	{"id":11,"pid":1,"name":"个人首页","open":false},
	{"id":111,"pid":11,"name":"任务管理"},
	{"id":1111,"pid":111,"name":"待办任务","url":"http://localhost:8080"},
	{"id":112,"pid":11,"name":"外部链接","url":"http://localhost:8080/ssm"},
	
	{"id":12,"pid":1,"name":"数据库"},
	{"id":121,"pid":12,"name":"包壳材料数据库","url":"http://localhost:8080"},
	{"id":1211,"pid":121,"name":"基本信息","url":"http://localhost:8080","open":false},
	{"id":1212,"pid":121,"name":"加工工艺","url":"http://localhost:8080","open":false},
	{"id":1213,"pid":121,"name":"堆外信息","url":"http://localhost:8080","open":false},
	{"id":1214,"pid":121,"name":"堆内信息","url":"http://localhost:8080","open":false},
	{"id":122,"pid":12,"name":"芯块材料数据库","url":"http://localhost:8080"},
	{"id":123,"pid":12,"name":"结构材料数据库","url":"http://localhost:8080"},
	
	{"id":13,"pid":1,"name":"文档资料库","url":"wdzl"},
	
	{"id":14,"pid":1,"name":"APPs","url":"http://localhost:8080"},
	
	{"id":15,"pid":1,"name":"系统设置","open":false},
	{"id":151,"pid":15,"name":"菜单管理","url":"http://localhost:8080"},
	{"id":152,"pid":15,"name":"用户管理","url":"http://localhost:8080"},
	{"id":153,"pid":15,"name":"权限管理","url":"http://localhost:8080"},
	{"id":154,"pid":15,"name":"日志管理","url":"http://localhost:8080"},
	
	{"id":16,"pid":1,"name":"帮助","url":"http://localhost:8080"}
	];


$(function(){
	setUserInfo();
	setLeftMenu();
	
});

function addTab(node){
	var isExist = $('#tt').tabs('exists',node.name);
	if(!isExist){
		var content = '<div style="width:100%;height:100%;overflow:hidden;"><iframe scrolling="auto" frameborder="0"  src="'+node.url+'" style="border:0;width:100%;height:100%;"></iframe></div>';
		$('#tt').tabs('add',{
			title:node.name,
			content:content,
			closable:true
		});
	}
}

function setUserInfo(){
	var userid='<%=session.getAttribute("userid")%>';
	var role='<%=session.getAttribute("role")%>';
	$('#userid').text(userid);
	$('#role').text(role);
}

function setLeftMenu(){
	d = new dTree('d');
	for(var i=0;i<nodes.length;i++){
		var node=nodes[i];
		d.add (node.id,node.pid ,node.name,node.url,node.name,node.target,'','',node.open,addTab);
	}
	$('#dTree').html(d.toString());
}


function logout(){
	jq.ajax('<%=basePath%>/logout', {
	}, function(data){
		window.location='<%=basePath%>';
	});
}

</script>

<style type="text/css">
.topbg{
	width:100%;
	height:100%;
	padding:0px;
	overflow:hidden;
	background-color: #0A1321;
	background-image : url('source/imgs/top/main_header.png');
    background-size: 100% 100%;
    -ms-behavior: url(source/imgs/backgroundsize.min.htc);
    behavior: url(source/imgs/backgroundsize.min.htc);
    
}

</style>

</head>

<body class="easyui-layout">   
   <div data-options="region:'north',border:false" style="height:150px;">
		<div class="topbg">
			<div style="position: relative;top:45px;left:25%;">
				<span style="color: #fff;font-size:24px;font-weight:bold;">核燃料数据管理与分析平台</span>
				<div style="height: 15px;"></div>
				<span style="color: #fff;font-size:24px;font-weight:bold;">ATF Fdmap </span>
			</div>
			<div style="position: absolute;width:250px;bottom :0px;right:0px;">
				<table style="color:#fff;font-size:14px;">
					<tr style="height: 30px;">
						<td style="width:80px;">当前用户：</td>
						<td><span id="userid">456</span></td>
					</tr>
					<tr style="height: 30px;">
						<td style="width:80px;">当前角色：</td>
						<td><span id="role">456</span></td>
					</tr>
				</table>
				
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-lock'">修改密码</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-man'">用户信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="logout()">退出登录</a>
			</div>
		</div>
   </div>   
    <div data-options="region:'west',title:' '" style="width:200px;">
    	<div id="dTree" class="dtree" style="margin:15px 15px;"></div>
    </div>   
    <div data-options="region:'center',border:false">
    	<div id="tt" class="easyui-tabs" data-options="fit:true"></div>  
    </div>
     <div data-options="region:'south',border:false" style="height:30px;"></div>
</body>
</html>
