<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Добавление Курса</title>
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
	</head>
	
	<body>
		<div id="reg">
			<table>
				<thead>
					<th>Название Курса</th>
					<th>Дата</th>
					<th>Оплата</th>
				</thead>
			</table>
			
			<div>
				<form:form action="" method="post" modelAttribute="newCourse" enctype="application/x-www-form-urlencoded">
					<table>
					<thead>
					<th>Название Курса</th>
					<th>Дата</th>
					<th>Оплата</th>
					</thead>
					<tr>
					<td><form:input type="text" path="coursename" value="Курс"></form:input></td>
					<td><form:input type="date" path="coursedate" value="add"></form:input></td>
					<td><form:input type="text" path="courseformbay" value="Наличные"></form:input></td>
					<td><input  type="hidden"  name="action" value="add"/></td>
					<td><button type="submit">Добавить</button></td>
					</tr>
					</table>
					</form:form>
					
					<a href="/">Главная</a>
					
					</div>
					</body>
					</html>					