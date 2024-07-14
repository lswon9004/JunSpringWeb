<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		부서번호 : <input name="deptno" value="${deptno+10}" readonly="readonly"><br>
		부서명 : <input name="dname"><br>
		근무지 : <input name="loc"><br>
		<button>전송</button>
	</form>
</body>
</html>