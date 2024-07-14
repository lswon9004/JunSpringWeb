<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<select id="ename">
	<option value=''>선택하세요</option>
	<c:forEach var="searchType" items="${deptno}">
		<option value="${searchType}">${searchType}</option>
	</c:forEach>
</select>

<div id="deptno">
	<select id='sd'></select>
</div>
<div id="emp">
<table border="1">
<tr><th>empno</th><th>ename</th><th>job</th><th>mgr</th><th>hiredate</th><th>sal</th><th>comm</th><th>deptno</th></tr>
<tr id="ts"></tr>
</table>
</div> 
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$("#deptno").hide();
$("#emp").hide();
$("#ename").on("change", function() {
	 
	let dept = $('#ename').val();
	 	 if (dept==''){
		 alert("부서를 선택하세요")
		 return false;
	 }
	  $.getJSON("/emp/ename", {'deptno':dept} ,function(data) {
		  $("#sd").empty();
		  $("#emp").hide();
		  $("#sd").append("<option value=''>선택하세요</option>");
		$.each(data, function(index, value){
				$("#sd").append("<option>"+value+"</option>")
			})

			$("#deptno").show();
	}).fail(function(){
		$("result").html("<span>통신에 실패했음</span>")
	});  
});

$("#sd").on("change",function(){
	let emp = $("#sd").val()
	
	 if (emp==''){
	 alert("이름을 선택하세요")
	 return false;
}
	$.getJSON("/emp/emp", {'ename':emp} ,function(data) {
		  $("#ts").empty();
		  
		  $.each(data, function(index, value){
			  if(!value.comm){			  
				  value.comm = '없음';
			  }
			  let hdate = new Date(value.hiredate);
			  
				$("#ts").append("<td>"+value.empno+"</td>")
				$("#ts").append("<td>"+value.ename+"</td>")
				$("#ts").append("<td>"+value.job+"</td>")
				$("#ts").append("<td>"+value.mgr+"</td>")
				$("#ts").append("<td>"+hdate.toLocaleDateString("ko-KR")+"</td>")
				$("#ts").append("<td>"+value.sal+"</td>")
				$("#ts").append("<td>"+value.comm+"</td>")				
				$("#ts").append("<td>"+value.deptno+"</td>")
			})
			$("#emp").show();
	}).fail(function(){
		$("result").html("<span>통신에 실패했음</span>")
	});
}) 
</script>
</body>
</html>