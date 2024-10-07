<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生列表</title>
	<link rel="stylesheet" type="text/css" href="${contextPath }/dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${contextPath }/css/update.css"/>
	<link rel="stylesheet" type="text/css" href="${contextPath }/css/bootstrap-datetimepicker.min.css"/>
</head>
<body>
	
	<!-- 引入公共的头部开始 -->
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
	<!-- 引入公共的头部结束 -->
	
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="#">学生信息</a></li>
			<li><a href="#">2013</a></li>
			<li class="active">十一月</li>
		</ol>
	</div>

	<div class="container">
		<div>
			<form action="${contextPath }/student/list" class="bs-example bs-example-form" role="form" method="post">
				<div class="row">
					<div class="col-md-3">
						<div class="input-group">
							<input type="text" name="likename" value="${name }"  placeholder="学生姓名进行模糊查询" class="form-control"> 
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit">查询</button>
							</span>
						</div>
					</div>
					<div class="col-md-4">
						<button class="btn btn-danger" type="button" onclick="delStu()">删除学生</button>
						<a href="${contextPath }/student/form" class="btn btn-info">添加学生</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="container">
		<div class="table-responsive">
			<table class="table table-hover">
				<caption>全部学生信息</caption>
				<thead>
					<tr class="active">
						<th><input type="checkbox" onclick="checkAll(this)" /></th>
						<th>学生姓名</th>
						<th>学生年龄</th>
						<th>学生性别</th>
						<th>出生日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${studentList }" var="student">
						<tr>
							<td><input type="checkbox" value="${student.id }" name="cks" /></td>
							<td>${student.sname }</td>
							<td>${student.sage }</td>
							<td>${student.sgender eq 'F' ? '女'  : '男'  }</td>
							<td><fmt:formatDate value="${student.birthday }" pattern="yyyy-MM-dd" /></td>
							<td><a href="${contextPath }/student/form?sid=${student.id }" class="btn btn-warning">修改</a></td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
	<div class="container">
		<div class="row text-center">
			<div class="col-md-12">
				<ul class="pagination">
					<li><a href="javascript:;">首页</a></li>
					<li><a href="javascript:void(0);">&laquo;</a></li>
					<li class="active"><a href="javascript:void(0);">1</a></li>
					<li><a href="javascript:void(0);">2</a></li>
					<li><a href="javascript:void(0);">3</a></li>
					<li><a href="javascript:void(0);">&raquo;</a></li>
					<li><a href="#" style="border: 1px solid #ddd;">尾页</a></li>
					<li><a style="border: 0px;margin-left: 0px;">当前页1/3总页</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${contextPath }/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${contextPath }/js/index.js"></script>
</body>
</html>