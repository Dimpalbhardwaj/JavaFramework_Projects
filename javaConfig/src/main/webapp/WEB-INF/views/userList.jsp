<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div align="center">
		<h1>Users List</h1>
		<h2>
			<a href="userForm">New User</a>
		</h2>

		<table border="1">
		<tr>
			<th>Sr.No</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Designation</th>
			<th>Location</th>
			<th>Actions</th>
		</tr>
			<c:forEach var="user" items="${userList}" >
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.designation}</td>
					<td>${user.location}</td>
					<td><a href="/edit?id=${user.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="/delete?id=${user.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>