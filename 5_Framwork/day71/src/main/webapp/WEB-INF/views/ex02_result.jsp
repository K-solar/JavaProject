<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main>
	<h4>ex02 결과</h4>
	
	<ul>
		<li>이름 : ${param.name }</li>
		<li>나이 : ${param.age }</li>
		<li>결과 : ${adult }</li>
	</ul>
	
</main>

</body>
</html>