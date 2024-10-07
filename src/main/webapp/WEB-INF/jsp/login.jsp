<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>登陆界面</title>
	<link rel="stylesheet" type="text/css" href="${contextPath }/dist/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath }/css/loginView.css" />
</head>
<body>

	<div class="container">
		<button type="button" class="btn btn-default btn-lg">
			<span class="glyphicon glyphicon-user"> </span>User
		</button>
	</div>
	<!--登陆begin-->
	<div id="login" class="container">
		<form action="${contextPath }/user/login" class="form-horizontal" role="form" method="post">
			<fieldset>
				<legend>用户登陆入口</legend>
				<div class="form-group has-feedback">
					<label for="firstname" class="col-md-2 control-label">用户名</label>
					<div class="col-md-5">
						<span class="glyphicon glyphicon-user form-control-feedback">
						</span> <input type="text"  name="username"
							class="form-control" id="firstname" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group has-feedback">
					<label for="lastname" class="col-md-2 control-label">密码</label>
					<div class="col-md-5">
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<input type="password" name="password" class="form-control"
							id="lastname" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox" name="cookie">请记住我
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-info" type="submit" class="btn btn-default">登录</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<!--登陆end-->

	<script type="text/javascript" src="${contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${contextPath }/dist/js/bootstrap.min.js"></script>
</body>
</html>