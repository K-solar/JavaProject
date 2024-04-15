<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>
	<h4>계정 정보</h4>
	<hr>
	
	<table>
		<tr>
			<th>회원번호</th>
			<th>ID</th>
			<th>닉네임</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<c:forEach var="row" items="${acclist }">
		<tr>
			<td>${row.idx }</td>
			<td>${row.userid }</td>
			<td>${row.nick }</td>
			<td>${row.email }</td>
			<td>${row.j_date }</td>
		</tr>
		</c:forEach>

	</table>

</main>

</body>
</html>