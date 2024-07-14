<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>리포트 제출</title>
</head>
<body>
	<h3>@RequestParam 사용</h3>
	<form action="submitReport1" method="post"
		enctype="multipart/form-data">
		 학번: <input type="text" name="studentNumber" /> <br />
		 리포트파일: <input type="file" name="report" /> 
		<input type="submit" />
	</form>

	<h3>MultipartHttpServletRequest 사용</h3>
	<img style="width: 300px;" id="previewImage" src="https://dummyimage.com/300x100/ffffff/ff00ff.png&text=file upload">
	<form action="submitReport2" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 
		리포트파일: <input type="file" name="report" accept="image/*" id="inputImage"/><br /> 
		<input type="submit" />
	</form>

	<h3>커맨드 객체 사용</h3>
	<form action="submitReport3" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 
		리포트파일: <input type="file" name="report" <%--multiple="multiple"--%>/> <br /> 
		<input type="submit" />
	</form>
<script>
function readImage(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();
        
        reader.onload = (e) => {
            const previewImage = document.getElementById('previewImage');
            previewImage.src = e.target.result;
        }
        reader.readAsDataURL(input.files[0]);
    }
}
// 이벤트 리스너
document.getElementById('inputImage').addEventListener('change', (e) => {
    readImage(e.target);
})
</script>

</body>
</html>




