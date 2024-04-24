<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>
	<form method="POST">
		<p><input name="title" placeholder="제목" required></p>
		<p><input name="nick" placeholder="작성자" required></p>
		<p><textarea name="contents" placeholder="바르고 고운말 사용!"></textarea></p>
		
		<button>글 작성</button>
	</form>
</main>

</body>
</html>