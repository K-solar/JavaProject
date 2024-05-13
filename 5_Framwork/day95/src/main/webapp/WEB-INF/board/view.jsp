<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>

	<table class="viewboard">
		<tr>
			<th colspan="6">제목</th>
			
		</tr>
		<tr>
			<td colspan="6">${row.title }</td>
		</tr>
		<tr>
			<th colspan="1">게시글 번호</th>
			<td colspan="2">${row.idx }</td>
			<th colspan="1">작성자</th>
			<td colspan="2">${row.nick }</td>
		</tr>
		<tr>
			<th colspan="1">조회수</th>
			<td colspan="2">${row.v_count }</td>
			<th colspan="1">작성일</th>
			<td colspan="2">${row.w_date }</td>
		</tr>
		<tr>
			<th colspan="6">내용</th>
		</tr>
		<tr>
			<td colspan="6" width="15px" height="15px">${row.contents }</td>
		</tr>
	
	</table>
	
	<br>
	
	<a href="/board/update?idx=${row.idx }">
		<button>글 수정</button>
	</a>
	<a href="/board/delete?idx=${row.idx }">
		<button type="button">글 삭제</button>
	</a>
	
</main>


</body>
</html>