<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<form method="POST">
		<p><input name="userid" placeholder="ID" required></p>
		<p><input name="userpw" type="password" placeholder="PW" required></p>
		<p><input name="userpw" type="password" placeholder="PW확인" required></p>
		<p><input name="nick" placeholder="닉네임" required></p>
		<p><input name="email" type="email" placeholder="이메일" required></p>
		
		<button>가입</button>
	</form>

	<p></p>

	<script>
		let userpw = document.getElementsByName("userpw");
		let msg = '';

		userpw[1].onblur = () => {
			

			if (userpw[0].value == userpw[1].value) {
				msg = '패스워드가 일치합니다.^^';
			}
			else {
				msg = '패스워드가 일치하지 않습니다!!';
				userpw[0].value = userpw[1].value = '';
				userpw[0].focus();
			}

			document.querySelectorAll('p')[5].innerHTML = msg;

		}

		// 아이디 중복 검사
		let userid = document.getElementsByName("userid")[0];
		
		userid.onblur = () => {
			let url = 'checkId?userid=' + userid.value;
			let msg = '사용 불가능한 ID 입니다.';
			
			fetch(url, {method : 'GET'})
			.then(response => response.json())
			.then(data => {
				if (data == 1) {msg = '사용 가능한 ID입니다.'};
				alert('결과 : ' + msg);
			});
		}

	</script>


</body>
</html>