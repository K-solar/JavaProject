<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<link href="${cpath }/resources/css/style.css" rel="stylesheet">
</head>
<body>
	<header>
		<h1>Test</h1>
		
		<ul class="menu">
			<li><a href="${cpath }">ex01</a></li>
			<li><a href="${cpath }/ex02">ex02</a></li>
			<li><a href="${cpath }/board/list">게시판</a></li>
			<li><a href="${cpath }/account/accinfo">계정</a></li>
		</ul>
		
		<hr>
	</header>