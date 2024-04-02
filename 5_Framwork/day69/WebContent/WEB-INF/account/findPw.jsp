<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<form method="POST">
		<p>회원가입 당시 ID를 입력해주세요.
			<input name="userid" placeholder="ID" required></p>
		
		<p>회원가입 당시 이메일을 입력해주세요.
			<input name="email" type="email" placeholder="이메일" required></p>
	
		<button>전송</button>
	</form>

</body>
</html>