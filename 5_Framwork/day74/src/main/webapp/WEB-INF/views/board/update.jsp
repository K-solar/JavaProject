<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>
	
	<h4>해당 글 수정</h4>
	
	<form method="POST">
		<p>제목 : <input name="title" placeholder="제목" required></p>		
		<p>내용 : <input name="contents" placeholder="바르고 고운말 씁시다." required></p>		

		
		<p><input name="idx" type="hidden" value="${row.idx }"></p>
		

		<button>등록</button>
	</form>
	
	<c:if test="${updat eq 1 }">
		<script>
			alert('수정 성공!');
			location.href = '${cpath}';	
		</script>
	</c:if>
	<c:if test="${updat eq 0 }">
		<script>
			alert('수정 실패!');
			history.go(-1);	
		</script>
	</c:if>
	
</main>

</body>
</html>