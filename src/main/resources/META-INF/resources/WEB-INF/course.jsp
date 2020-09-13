<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Запись на  Курсы</title>
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
	</head>

	<body>
		<div id="reg">
            <h4>Запись на  Курсы</h4>
			<table>
				<thead>
					<th>Название Курса</th>
					<th>Дата</th>
					<th>Оплата</th>
				</thead>
				<c:forEach items="${allCourses}" var="course">
					<tr>
						<td>${course.coursename}</td>
						<td>${course.coursedate}</td>
						<td>${course.courseformbay}</td>


												<td>
                        							<form action="${pageContext.request.contextPath}/course" method="post">
                        								<input type="hidden" name="courseId" value="${course.id}"/>
                        								<input type="hidden" name="action" value="reg"/>
                        								<button type="submit">Записаться</button>
                        							</form>
                        						</td>

					</tr>
				</c:forEach>
			</table>

			<a href="/">Главная</a>

		</div>
	</body>
</html>