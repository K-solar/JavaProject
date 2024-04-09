<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>
		<h4>해당 게시글</h4>
		
			
		<table>
			<tr>
				<th colspan="1">제목</th>
				<td colspan="3">${select.title }</td>
				<th colspan="1">글 번호</th>
				<td colspan="1">${select.idx }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${select.nick }</td>
				<th>조회수</th>
				<td>${select.v_count + 1} </td>
				<th>작성일</th>
				<td>${select.w_date }</td>
			</tr>
			<tr>
				<th colspan="1">내용</th>
				<td colspan="5">${select.contents }</td>
			</tr>	
		</table>

</main>	
	
</body>
</html>