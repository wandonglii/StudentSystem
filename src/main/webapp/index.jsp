<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>欢迎引导页</title>
	</head>
	<body>
		<!-- 跳转至登录界面 -->
		<c:redirect url="/user/login.html"></c:redirect>
	</body>
</html>