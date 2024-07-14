<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>부서 정보</title>
</head>
<body>
<h3>모든 부서의 정보를 출력합니다.</h3>

<c:forEach items="${ename}" var="emp">
	${emp.empno} / ${emp.ename } / ${emp.job} / ${emp.mgr}/<fmt:formatDate value="${emp.hiredate}" pattern="yyyy/MM/dd"/>/ ${emp.sal}/ ${emp.comm}/ ${emp.deptno}
	<br>
</c:forEach>

</body>
</html>