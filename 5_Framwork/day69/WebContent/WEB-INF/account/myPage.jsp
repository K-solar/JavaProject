<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<main class="home">


<form method="POST">
	<p>IDX : ${user.idx }</p>
	<p>ID : ${user.userid }</p>
	<p>PW <input name="userpw" type="password" placeholder="PW" required></p>
	<p>닉네임 <input name="nick" placeholder="닉네임" required></p>
	<p>이메일 <input name="email" type="email" placeholder="이메일" required></p>
	
	<input name="idx" type="hidden" value="${user.idx }">
	
	<button>수정</button>
</form>

</main>
</body>
</html>