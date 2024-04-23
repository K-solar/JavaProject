<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
	<c:set var="user" value="${row }"/>
	
	<form method="POST">
		
	
		<p><input name="userpw" type="password" value="${user.userpw }" required></p>
		<p><input name="nick" value="${user.nick }" required></p>
		<p><input name="email" type="email" value="${user.email }" required></p>
		
		<p><input name="idx" type="hidden" value="${user.idx }"></p>
		
		<button>수정 완료</button>
		
	</form>
	
	
	<c:if test="${num eq 1}">
		<script>
			alert('수정 성공');
			location.href = '${cpath}/account/accinfo';
		</script>
	</c:if>
	
	<c:if test="${num eq 0}">
		<script>
			alert('수정 실패!');
			history.go(-1);
		</script>
	</c:if>
	
</body>
</html>