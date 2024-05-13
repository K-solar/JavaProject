<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
</head>
<body>
	
	<script>
		let row = ${row};
		
		if (row != 0) {
			alert('${msg}');
			location.href = '/board';	
		}
		else {
			alert('${msg}');
			history.go(-1);
		}
		
		
	</script>
	
</body>
</html>