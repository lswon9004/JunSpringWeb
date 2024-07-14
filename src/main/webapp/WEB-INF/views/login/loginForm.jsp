<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<title>로그인 화면</title>
</head>
<body>
<h3>로그인 화면 입니다.</h3>
<form:form action="/login" method="post" modelAttribute="loginDto">
	<form:errors element="div"/>
	<label for="userid">id : </label>
	<input name="userid" id="userid">
	<form:errors path="userid" delimiter=" "/> <br>
	<label for="password">pw : </label>
	<input name="password" id="password" type="password">
	<form:errors path="password" delimiter=" "/><br>
	<input type="submit" value="로그인">
</form:form>
   
</body>
</html>