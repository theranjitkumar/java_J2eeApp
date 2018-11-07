<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> user form </title>
</head>
<body>

	<form action="./user?action" method="POST">
		User Id: <input type="text" name="userId" value="${user.userId}"> <br> 
		User Name: <input type="text" name="userName" value="${user.userName}"> <br> 
		User City: <input type="text" name="userCity" value="${user.userCity}"> <br> 
		<input type="submit" value="submit"> <br>
	</form>

</body>
</html>