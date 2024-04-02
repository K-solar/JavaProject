<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
	<p>ID: <input name="userid" placeholder="ID" required></p>
	<p>PW: <input name="userpw" type="password" placeholder="PW" required></p>
	<p>닉네임: <input name="nick" placeholder="닉네임" required></p>
	<p>이메일: <input name="email" type="email" placeholder="이메일" required></p>
	
	<button>회원 가입</button>
</form>

</body>
</html>