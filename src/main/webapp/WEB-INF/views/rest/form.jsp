<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>form</title>
</head>
<body>
	post form
	<form method="post">
		<input name="name"> <input type="submit">
	</form>

	put form
	<form method="post">
		<input type="hidden" name="_method" value="put"> 
		<input name="name"><input type="submit">
	</form>

	delete form
	<form method="post">
		<input type="hidden" name="_method" value="delete"> 
		<input name="name"><input type="submit">
	</form>
</body>
</html>