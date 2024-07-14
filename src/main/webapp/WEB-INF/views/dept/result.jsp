<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h4>부서 정보 추가 완료</h4>
<hr>
<c:forEach items="${deptAll}" var="dept">
	${ dept.deptno} / ${dept.dname } / ${dept.loc } 
	<br>
</c:forEach>
</body>
</html>