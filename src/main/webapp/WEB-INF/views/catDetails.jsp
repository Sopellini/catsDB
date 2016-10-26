<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
td {
	display: inline
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Szczegóły kota</title>
</head>
<body>
	<a href="listOfCats">Powrót do listy kotów</a>
	<br />
	<table border="1">
		<tbody>
			<tr>
				<th>Imię</th>
				<td>${cat.name}</td>
			</tr>
			<tr>
				<th>Data urodzenia</th>
				<td>${cat.dateOfBirth}</td>
			</tr>
			<tr>
				<th>Waga</th>
				<td>${cat.weight}</td>
			</tr>
			<tr>
				<th>Imię opiekuna</th>
				<td>${cat.nameOfOwner}</td>
			</tr>
			<tr>
				<th>Zabawki</th>
				<c:forEach items="${toysList}" var="toy" varStatus="status">
					<td><a href="<c:url value="toyDetails-${toy.id}" />">${toy.name}</a></td>
				</c:forEach>

			</tr>
		</tbody>
	</table>
	<br />
	<a href="<c:url value="addToy"/>">Dodaj zabawkę kotu</a>
	<hr />
</body>
</html>