<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="row" value="${row }"/>

<main>
	<form method="POST">
		<p><input name="title" value="${row.title }" required></p>
		<p><input name="nick"  value="${row.nick }" required></p>
		<p><textarea name="contents" cols="25px" rows="10px" required></textarea></p>
		<p><input name="idx" type="hidden" value="${row.idx }"></p>
		
		<button>수정</button>		
	</form>

</main>

</body>
</html>

</body>
</html>