<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>学生表单</title>
		<link rel="stylesheet" type="text/css" href="${contextPath }/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${contextPath }/css/update.css"/>
		<link rel="stylesheet" type="text/css" href="${contextPath }/css/bootstrap-datetimepicker.min.css"/>
	</head>
	<body>
		<!-- 引入公共的头部开始 -->
		<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
		<!-- 引入公共的头部结束 -->
		
		<div class="container">
			<div id="update">
				<form action="${contextPath }/student/save" method="post"  class="form-horizontal" role="form">
					<fieldset>
						<legend>学生信息</legend>
						<input type="hidden" value="${student.id }" name="id">
						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">学生姓名</label>
							<div class="col-md-7">
								<input type="text" name="sname" value="${student.sname }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">学生年龄</label>
							<div class="col-md-7">
								<input type="number" name="sage" value="${student.sage }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">性别</label>
							<c:choose>
								<c:when test="${empty student.id }">
									<div class="col-md-1">
										<input type="radio" value="M" class="form-control" name="sgender">
									</div>
									<label class="pull-left control-label">男</label>
									
									<div class="col-md-1">
										<input type="radio" value="F" class="form-control" name="sgender">
									</div>
									<label class="pull-left control-label">女</label>
								</c:when>
								<c:otherwise>
									<input type="hidden" name="sgender" value="${student.sgender }">
									<label class="pull-left control-label">${student.sgender eq 'F' ? '女' : '男' }</label>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<div>
								<!-- /*<form class="form-horizontal">*/ -->
								<div class="form-group has-feedback">
									<label for="lastname" class="col-md-3 control-label">出生日期</label>
									<div class="col-md-7">
										<input id="datetimepicker" name="birthday" class="form-control" value="${student.birthday }"> <span
											class="glyphicon glyphicon-time form-control-feedback">
										</span>
									</div>
								</div>
								<!-- /*</form>*/ -->
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-success">保存</button>
								<button type="reset" class="btn btn-warning">重置</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	
		<script type="text/javascript" src="${contextPath }/js/jquery.min.js"></script>
		<script type="text/javascript" src="${contextPath }/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${contextPath }/js/moment.js"></script>
		<script type="text/javascript" src="${contextPath }/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="${contextPath }/js/update.js"></script>
	</body>
</html>