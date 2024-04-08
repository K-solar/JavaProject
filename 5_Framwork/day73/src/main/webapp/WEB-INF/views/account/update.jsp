<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>
	
	<h4>회원 수정</h4>
	
	<form method="POST">
		<p>ID : <input name="userid" placeholder="ID" required></p>		
		<p>PW : <input name="userpw" type="password" placeholder="PW" required></p>		
		<p>닉네임 : <input name="nick" placeholder="닉네임" required></p>		
		<p>이메일 : <input name="email" type="email" placeholder="이메일" required></p>		
		
		<p><input name="idx" type="hidden" value="idx"></p>
		

		<button>등록</button>
	</form>
	
	<c:if test="${row eq 1 }">
		<script>
			alert('수정 성공!');
			location.href = '${cpath}/account/view';	
		</script>
	</c:if>
	<c:if test="${row eq 0 }">
		<script>
			alert('수정 실패!');
			location.href = '${cpath}/account/view';	
		</script>
	</c:if>
	
</main>



</body>
</html>