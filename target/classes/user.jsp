<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
</head>
<body>
	<h3>User:-</h3>
	<a href="?action=add">Add User</a>
	<table>
		<tbody>
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>User City</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${requestScope.userList}" var="user">
				<tr>
					<td><c:out value="${user.userId}"></c:out></td>
					<td><c:out value="${user.userName}"></c:out></td>
					<td><c:out value="${user.userCity}"></c:out></td>
					<td> <a href="?action=edit&userId=${user.userId}"> Edit </a> </td>
					<td> <a href="?action=delete&userId=${user.userId}"> Delete </a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>