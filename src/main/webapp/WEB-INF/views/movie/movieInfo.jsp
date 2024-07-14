<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
	<td>${movieInfo.movieInfoResult.movieInfo.movieCd}</td>
	<td>${movieInfo.movieInfoResult.movieInfo.movieNm}</td>
	<td>${movieInfo.movieInfoResult.movieInfo.movieNmEn}</td>	
	<td>${movieInfo.movieInfoResult.movieInfo.movieNmOg}</td>
	<td>${movieInfo.movieInfoResult.movieInfo.prdtYear}</td>
	<td>${movieInfo.movieInfoResult.movieInfo.openDt}</td>
	<td>${movieInfo.movieInfoResult.movieInfo.showTm}</td>
	<td>${movieInfo.movieInfoResult.movieInfo.prdtStatNm}</td>
	<td>${movieInfo.movieInfoResult.movieInfo.typeNm}</td>
	</tr>
</table>
</body>
</html>