<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h4>A페이지입니다.</h4>
	<hr>
	<div><button id="mybtn">눌러보세요</button></div>
	<hr>
	<div id="result"></div>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
	$("#mybtn").on("click", function() {
		alert("클릭");
		
		$.getJSON("/jsondata", function(data) {
			 console.log(data);
			$.each(data, function(index, value){
				$("#result").append(value+"<br>")
			})
		}).fail(function(){
			$("result").html("<span>통신에 실패했음</span>")
		});
	});
	</script>
</body>
</html>