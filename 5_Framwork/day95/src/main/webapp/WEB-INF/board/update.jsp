<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- Place the first <script> tag in your HTML's <head> -->
	<script src="https://cdn.tiny.cloud/1/bmpz83s4yqa4fgfuozripnlgp9hjdztmwwmpnqkfnjhs8r39/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
	
	<!-- Place the following <script> and <textarea> tags your HTML's <body> -->
	<script>
	  tinymce.init({
	    selector: 'textarea',
	    plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount linkchecker',
	    toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table | align lineheight | numlist bullist indent outdent | emoticons charmap | removeformat',
	  });
	</script>


<main>
	
	<form method="POST">
		<table>
			<tr>
				<td><input name="title" placeholder="제목" required></td>
			</tr>
			<tr>
				<td><input name="idx" type="hidden" placeholder="${row.idx }" required></td>
			</tr>
			<tr>
				<td><textarea name="contents" placeholder="바르고 고운말 사용!!!"></textarea></td>
			</tr>
		</table>
		
		<br>
		
		<button>글 수정</button>
	</form>

</main>

</body>
</html>