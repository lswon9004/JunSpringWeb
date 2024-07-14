<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>[${query}]지역의 명소입니다.(${result.total}개)</h1>
<ul>
<c:forEach items="${result.items}" var="item" varStatus="assd">
	<li>${assd.index+1} <a href="${item.link}">${item.title}</a><br>
	주소 : ${item.roadAddress }<br> </li>
</c:forEach>
</ul>
</body>
</html>