<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>登录</title>
<%@ include file="/common/header.jsp"%>

<script type="text/javascript">
$(function(){
	
});



function login(){
	var uname=$('#username').val();
	var pword=$('#password').val();
	var chodb=$('#chodb').val();
	jq.ajax('<%=basePath%>/login', {
		username: uname,
		password: pword,
		chodb: chodb
	}, function(data){
		if(data.msg=='success'){
			window.location = "index";
		}else{
			eui.alert(data.msg);
		}
	});
}

function clean(){
	$('#username').val('');
	$('#password').val('');
}

</script>

</head>

<body class="easyui-layout">
	<div data-options="region:'center',border:false" style="background:#1362AD;">
		<div style="position:absolute;width:1000px;height:500px;top:50%;left:50%;margin-top:-250px;margin-left:-500px;background: url('source/imgs/login/login_bg.png');">
			
			<div style="position:relative; width: 320px; height: 150px;margin-top:205px;margin-left:330px;">
				<table style="width:300px; color:#ffffff;font-size: 16px;">
					<tr style="height: 40px;">
						<td style="text-align:right; width:30%;">用户：</td>
						<td style="text-align:left; width: 70%">
							<input type="text" id="username" value="admin"
								style="width:150px; background-color:#3e95c2; border:solid 1px #7dbad7;">
						</td>
					</tr>
					<tr style="height: 40px;">
						<td style="text-align:right; width:30%;">密码：</td>
						<td style="text-align:left; width: 70%;">
							<input type="password" id="password" value="admin"
								style="width:150px; background-color:#3e95c2; border:solid 1px #7dbad7;">
						</td>
					</tr>
					<tr style="height: 40px;">
						<td style="text-align:right; width:30%;">数据库：</td>
						<td style="text-align:left; width: 70%;">
							<select id="chodb"
								style="width:155px; background-color:#3e95c2; border:solid 1px #7dbad7;">
								<option value="A">常规数据库</option>
								<option value="B">基因组数据库</option>
								<option value="C">实验数据库（待开发）</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			
			<div style="position:relative; width: 100%; height: 50px;">
				<a href="javascript:void(0)" style="text-decoration:none; width:60px;height: 50px;font-size: 28px;color: #fff;font-weight:bold; margin-left: 400px;"  onclick="login()">登录</a>
				<a href="javascript:void(0)" style="text-decoration:none; width:60px;height: 50px;font-size: 28px;color: #fff;font-weight:bold; margin-left: 50px;"  onclick="clean()">重置</a>
			</div>
		</div>	
	</div>
</body>
</html>
