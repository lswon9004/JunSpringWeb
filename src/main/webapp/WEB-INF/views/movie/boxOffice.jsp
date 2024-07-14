<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>bocOffice</title>
</head>
<body>
<h3>${boxOfficeList.boxOfficeResult.showRange} 일별 박스 오피스</h3>
<hr>
<table border="1">
<tr><th>순위</th><th>이름</th><th>오픈일</th><th>누적관객수</th></tr>
<c:forEach items="${boxOfficeList.boxOfficeResult.dailyBoxOfficeList}" var="movie">
	<tr>
	<td>${movie.rank}</td>
	<td><a href="/boxOffice/movienifo/${movie.movieCd}">${movie.movieNm}</a></td>
	<td>${movie.openDt}</td>
	<td>${movie.audiAcc}</td>
	</tr>
</c:forEach>

</table>
</body>
</html>