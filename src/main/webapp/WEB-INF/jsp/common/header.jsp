<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">学生首页</a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="text-success">${user }</span></a></li>
					<!-- <li><a href="#"><span class="badge pull-right">"+count+"</span>在线人数</a></li>
					<li><a href="#"><span class="badge pull-right">"+totalCount+"</span>总访问量</a></li> -->
					<li><a href="${contextPath }/user/logout">安全退出</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>