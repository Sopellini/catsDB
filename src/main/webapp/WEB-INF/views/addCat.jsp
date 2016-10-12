<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dodaj kota</title>
	</head>
	<body>
		<a href="listOfCats">Powrót do listy kotów</a><br />
		<form:form method="POST" modelAttribute="catDTO">
			<table border="1">
				<tbody>
					<tr>
						<th>Imię</th>
						<td>
							<form:input type="text" path="name" />
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="name"/></c:if>
						</td>

					</tr>
					<tr>
						<th>Data urodzenia (RRRR-MM-DD)</th>
						<td>
							<form:input type="text" path="dateOfBirth" id="dateOfBirth" />
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="dateOfBirth"/></c:if>
						</td>
					</tr>
					<tr>
						<th>Waga</th>
						<td>
							<form:input type="text" path="weight" id="weight" />
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="weight"/></c:if>
						</td>
					</tr>
					<tr>
						<th>Imię opiekuna</th>
						<td>
							<form:input type="text" path="nameOfOwner" id="nameOfOwner" />
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="nameOfOwner"/></c:if>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit" value="Dodaj!" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<br />
		<hr />
</body>
</html>