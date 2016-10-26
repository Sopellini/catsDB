<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dodaj zabawkę</title>
	</head>
	<body>
		<a href="listOfCats">Powrót do listy kotów</a><br />
		<form:form method="POST" modelAttribute="toyDTO">
			<table border="1">
				<tbody>
					<tr>
						<th>Nazwa</th>
						<td>
							<form:input type="text" path="name" />
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="name"/></c:if>
						</td>

					</tr>
					<tr>
						<th>Opis</th>
						<td>
							<form:input type="text" path="description" id="description" />
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="description"/></c:if>
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