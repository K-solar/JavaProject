<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
	
	<c:if test="${not empty id }">
		<script>
		alert('찾고자하는 ID는 ${id}입니다.');
		location.href='/day69/account/login';
		</script>	
	</c:if>
	
	<c:if test="${not empty pw }">
		<script> 
		alert('새 PW는 ${pw}입니다.');
		location.href='/day69/account/login';
		</script>	
	</c:if>
	
	
		
	
	
</body>
</html>