<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


	<script>
		let row = ${row };
		
		if (row != 0) {
			alert('삭제 완료');
			location.href = '${cpath}';
		}
		else {
			alert('삭제 실패');
			history.go(-1);
		}
	</script>

</body>
</html>