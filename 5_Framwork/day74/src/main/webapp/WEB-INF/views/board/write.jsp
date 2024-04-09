<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>

	<form method="POST">
		<table>
			<thead>
				<tr>
					<th>제목</th>
					<td><input name="title" placeholder="제목 입력란" required></td>
				</tr>
				<tr>
					<th>작성자 회원번호</th>
					<td><input name="user_idx" type="number" placeholder="회원번호" required></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td><textarea name="contents"  cols="70px" rows="30px"
						placeholder="바르고 고운말을 사용합시다." required></textarea></td>
				</tr>
			</tbody>
		</table>
		
		<button>작성 완료</button>
	
	</form>
	
	<c:if test="${row eq 1 }">
		<script>
			alert('작성 완료');
			location.href = '${cpath}';	
		</script>
	</c:if>
	<c:if test="${row eq 0 }">
		<script>
			alert('작성 실패!');
			history.go(-1);	
		</script>
	</c:if>
	
	
</main>

</body>
</html>