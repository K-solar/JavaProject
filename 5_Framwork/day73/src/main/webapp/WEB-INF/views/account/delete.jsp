<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
	<script>
		let row = ${row};
		if (row != 0) {
			alert('삭제 성공!');
			location.href = '${cpath}/account/view';	
		}
		else {
			alert('삭제 실패!');
			location.href = '${cpath}/account/view';	
		}
	
		
	</script>
	
</body>
</html>