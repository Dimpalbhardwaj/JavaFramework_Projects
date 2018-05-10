<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.default.sahakara" /></title>
</head>
<body>
	<h2>${msg}</h2>
		<form:form action="save.do" modelAttribute="society" method="post">
		<table>
			<tr>
				<td><spring:message code="emaga.login.username" /></td>
				<td><form:input path="userName"/> </td>
			</tr>
			<tr>
				<td><spring:message code="emaga.login.password" /></td>
				<td><form:password path="password" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<button type="submit">
						<spring:message code="emaga.login.submit" />
					</button>
				</td>
			</tr>
	</table>
	</form:form>
</body>
</html>