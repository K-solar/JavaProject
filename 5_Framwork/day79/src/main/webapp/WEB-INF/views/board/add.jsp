<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>
	<form method="POST" class="writeboard">
		<p>제목 : <input name="title" placeholder="Title" required></p>
		<p>계정회원 번호 : <input name="user_idx" type="number" placeholder="UserIDX" required></p>
		<p>내용 : <textarea name="contents" rows="10px" cols="30px" placeholder="바르고 고운말 사용!"></textarea></p>
		
		<button>작성하기</button>
	</form>
	
	<c:if test="${result eq 1 }">
		<script>
			alert('작성 완료');
			location.href = '${cpath}/board/list';
		</script>
	</c:if>
		<c:if test="${result eq 0 }">
		<script>
			alert('작성 실패');
			history.go(-1);
		</script>
	</c:if>
	
	
</main>

</body>
</html>