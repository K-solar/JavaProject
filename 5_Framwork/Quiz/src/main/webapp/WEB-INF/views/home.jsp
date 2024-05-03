<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<main>
	<table>
		<thead>
			<tr>
				<th>계정번호</th>
				<th>ID</th>
				<th>PW</th>
				<th>닉네임</th>
				<th>가입일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.idx }</td>
				<td>${row.userid }</td>
				<td>${row.userpw }</td>
				<td>${row.nick }</td>
				<td>${row.j_date }</td>
			</tr>
			</c:forEach>
		</tbody>
		
	
	</table>

</main>



</body>
</html>
