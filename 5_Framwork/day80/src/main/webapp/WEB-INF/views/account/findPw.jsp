<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<form method="POST">
		<p><input name="userid" placeholder="ID" required></p>
		<p><input name="email" type="email" placeholder="Email" required></p>
		
		<button>비번 찾기</button>
	</form>
	
	<c:if test="${msg ne null}">
		<script>
			alert('${msg}');
			history.go(-1);
		</script>
	</c:if>
	
	<c:if test="${newPw ne null }">
		<script>
			alert('새 비밀번호는 ${newPw} 입니다.');
			location.href = '${cpath}/account/login';
		</script>
	</c:if>
	
</body>
</html>