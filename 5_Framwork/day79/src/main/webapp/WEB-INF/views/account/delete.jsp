<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${num eq 1}">
		<script>
			alert('탈퇴 성공');
			location.href = '${cpath}/account/logout';
		</script>
	</c:if>
	
	<c:if test="${num eq 0}">
		<script>
			alert('탈퇴 실패!');
			history.go(-1);
		</script>
	</c:if>

</body>
</html>