<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Редактирование списка курсов</title>
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
	</head>
	
	<body>
		<div id="container2">
		<h4>Редактирование списка курсов</a></h4>
			<div id="reg">
			<table >
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
							<form action="${pageContext.request.contextPath}/courseDell" method="post">
								<input type="hidden" name="courseId" value="${course.id}"/>
								<input type="hidden" name="action" value="delete"/>
								<button type="submit">Удалить</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
             <p><br></p>
			<div >
				<form action="${pageContext.request.contextPath}/courseDell" method="post" >
					<table>
					<thead>
					<th>Название Курса</th>
					<th>Дата</th>
					<th>Оплата</th>
					</thead>
					<tr>
					<td><input type="text" name="coursename" value="Курс"></input></td>
					<td><input type="date"  name="coursedate"  value="add"></input></td>

                    <td><select required size="1"  name="courseformbay">
						<option value="" label="Выберите форму оплаты">Выберите форму оплаты</option>
						<option value="Наличные" label="Наличные">Наличные</option>
						<option value="Карта" label="Карта">Карта</option>
					    </select>
					</td>
					</tr>
                    </table>

	                <div id="footer">
                    <dl>
			            <input type="submit"  name="action" value="Добавить" class="btn" ></input>
                    </dl>
                    <dl>
                        <input  type="button" value="На главную страницу" class="btn" onclick="javascript:window.location='/'"/>
                    </dl>
   	                </div>
		        </form>
			</div>
		</div>
	</body>
</html>