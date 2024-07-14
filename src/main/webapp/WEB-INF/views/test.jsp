<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<img src="/mainImg/${bibles.filename }" alt="이미지">

<h2>${bibles.bible_text}</h2>
<hr>
<h2>${bibles.bibleinfo_box}</h2>
<br>
<%-- ${bibles.liList}
 --%>   
<c:forEach items="${bibles.liList}" var="bible">
	${bible }<br>
</c:forEach>
</body>
</html>