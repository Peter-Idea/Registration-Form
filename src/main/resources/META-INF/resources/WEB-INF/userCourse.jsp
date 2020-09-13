<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Список моих Курсов</title>
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
	</head>

	<body>
		<div id="reg">
		    <h4>Список моих Курсов</h4>
		    <c:if test="${not empty pageContext.request.userPrincipal}">
                <h3>${pageContext.request.userPrincipal.name}</h3>
                <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                     Роль: Администратор.<Br>
                </c:if>
                <c:if test="${pageContext.request.isUserInRole('USER')}">
                     Роль: Пользователь.<Br>
                </c:if>
            </c:if>

			<table>
				<thead>
					<th>Название Курса</th>
					<th>Дата</th>
					<th>Оплата</th>
				</thead>
				<c:forEach items="${usersCourses}" var="course">
					<tr>
						<td>${course.coursename}</td>
						<td>${course.coursedate}</td>
						<td>${course.courseformbay}</td>
					</tr>
				</c:forEach>
			</table>

			<a href="/">Главная</a>

		</div>
	</body>
</html>