<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h4>학생 정보 입력창</h4>
	<hr>


	<form method="POST">
		<p><input name="name" placeholder="이름" value="${stu.name }" required></p>
		<p><input name="kor" type="number" placeholder="국어점수" value="${stu.kor }" required></p>
		<p><input name="eng" type="number" placeholder="영어점수" value="${stu.eng }" required></p>
		<p><input name="mat" type="number" placeholder="수학점수" value="${stu.mat }" required></p>
			
		<button>수정</button>
	</form>

</body>
</html>