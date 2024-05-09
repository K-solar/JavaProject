<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../home.jsp" %>


	<h3>Account</h3>
	
	<table>
		<tr>
			<th>계정번호</th>
			<th>ID</th>
			<th>닉네임</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<c:forEach var="row" items="${list }">
		<tr>
			<td>${row.idx }</td>
			<td>${row.userid }</td>
			<td>${row.nick }</td>
			<td>${row.email }</td>
			<td>${row.j_date }</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>