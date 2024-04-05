<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main class="quizresult">
	<h4>로그인 결과</h4>
	
	<div class="result">
		<p>${msg }</p>
	</div>
	
	<br>
	<a href="${cpath }/quiz"><button>돌아가기</button></a>

</main>




</body>
</html>