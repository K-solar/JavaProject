<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath"  value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>

<link href="${cpath }/resources/css/style.css" rel="stylesheet">

<head>
	<title>Home</title>
	
	
	
</head>
<body>
	<h1>Hello world!</h1>
	
	<ul class="menu">
		<li><a href="${cpath }">home</a></li>
		<li><a href="${cpath }/ex01">ex01</a></li>
		<li><a href="${cpath }/ex02">ex02</a></li>
		<li><a href="${cpath }/quiz">quiz</a></li>
	</ul>
	
	<hr>