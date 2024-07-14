<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 성공</title>
</head>
<body>
로그인 성공
<a href="/">index</a>
<h1>${user.userid }님이 로그인하셨습니다.</h1>
<a href="/checklogin">로그인 체크</a>
<a href="logout">로그아웃</a>

</body>
</html>