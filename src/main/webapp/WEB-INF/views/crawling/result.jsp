<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>해외 축구 추천 뉴스</title>
</head>
<body>
<c:forEach items="${list}" var="news">
	<a href="${news.link}">${news.text}</a><br>
</c:forEach>
</body>
</html>