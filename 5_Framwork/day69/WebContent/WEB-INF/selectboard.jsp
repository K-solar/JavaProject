<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<main class="home">
<%@ include file="sideMenu.jsp" %>

<article>
	<table class="boardlist">
		<tr>
			<th colspan="8">제목 :  ${boardlist.title }</th>
		</tr>
		<tr>
			<th>No</th>
			<td>${boardlist.idx }</td>
			<th>작성자</th>
			<td>${boardlist.nick }</td>
			<th>조회수</th>
			<td>${boardlist.v_count }</td>
			<th>작성일</th>
			<td>${boardlist.w_date }</td>
		</tr>
		<tr>
			<th colspan="8">내용</th>
		</tr>
		<tr>
			<td colspan="8" class="contentsbox">${boardlist.contents }</td>
		</tr>


	</table>
	
	<br>
	<a href="${cpath }/boardwrite" class="writePage"><button>글쓰기</button></a>
	
</article>
</main>

</body>
</html>