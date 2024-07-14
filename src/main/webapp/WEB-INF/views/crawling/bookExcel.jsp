<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>[${d_titl}]의 검색결과입니다.(${re.total}개)</h1>
<c:forEach items="${re.items}" var="item" varStatus="index">
	<p>${index.index+1 } : ${item.title }/${item.link }/${item.author }/${item.discount } </p>
</c:forEach>
</body>
</html>