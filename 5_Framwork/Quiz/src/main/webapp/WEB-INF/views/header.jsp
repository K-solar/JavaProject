<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz</title>

<link href="${cpath }/resources/css/style.css" rel="stylesheet">

</head>
<body>
	
	<c:set var="login" value="${empty user ? 'login' : 'logout' }"/>
	<c:set var="signUp" value="${empty user ? 'signUp' : 'myPage' }"/>
	<c:set var="user" value="${user }" />
	
	<header>
		<h1>Quiz</h1>
		
		<ul class="menu">
			<li><a href="${cpath }">home</a></li>
			<li><a href="${cpath }/acc/${login}">${login}</a></li>
			<li><a href="${cpath }/acc/${signUp}">${signUp}</a></li>
			
		</ul>
		
		<hr>
		
		<h4>현재 로그인 계정 : ${user.nick }</h4>
		
	</header>
	