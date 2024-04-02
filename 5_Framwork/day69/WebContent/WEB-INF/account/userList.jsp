<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<main class="home">
<%@ include file="../sideMenu.jsp" %>

<article>
	<table id="account" class="board">
		<thead>
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>닉네임</td>
			<td>이메일</td>
			<td>가입일</td>
		</tr>
		</thead>
		
		<tbody>
			<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.idx }</td>
				<td>${row.userid }</td>
				<td>${row.nick }</td>
				<td>${row.email }</td>
				<td>${row.j_date }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<ul class="page">
		<c:if test="${pg.prev }">
			<li><a href="${cpath }/board.jsp?page=${pg.begin - 1}">이전</a></li>	
		</c:if>
		
		
		<c:forEach var="i" begin="${pg.begin }" end="${pg.end }">
			<li><a href="${cpath }/board.jsp?page=${i }">
				${i }
			</a></li>
		</c:forEach>
		
		<c:if test="${pg.next }">
			<li><a href="${cpath }/board.jsp?page=${pg.end + 1} ">다음</a></li>
		</c:if>
	</ul>
	
</article>
</main>
</body>
</html>