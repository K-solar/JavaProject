<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="row" value="${row }" />

<main>
	<table>
		<tr>
			<th colspan="2">글 번호</th>
			<td colspan="2">${row.idx }</td>
			<th colspan="2">제목</th>
			<td colspan="2">${row.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="2">${row.nick }</td>
			<th>조회 수</th>
			<td>${row.v_count }</td>
			<th>작성일자</th>
			<td colspan="2">${row.w_date }</td>
		</tr>
		<tr>
			<th colspan="8">글 내용</th>
		</tr>
		<tr>
			<td colspan="8">${row.contents }</td>
		</tr>
		<tr>
			<th colspan="3">파일경로</th>
			<td colspan="5">${row.upload }</td>
		</tr>
		
		
		
	</table>
	
		<a href="${cpath }/board/update/${row.idx }">
			<button>수정</button>
		</a>
		
		<a href="${cpath }/board/delete/${row.idx }">
			<button>삭제</button>
		</a>
</main>


</body>
</html>