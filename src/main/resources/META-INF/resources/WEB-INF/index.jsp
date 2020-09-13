<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
  <title>Главная</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<sec:authorize access="!isAuthenticated()">
<div id="container">
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<div id="container2">
</sec:authorize>
<div id="reg">
    <c:if test="${not empty pageContext.request.userPrincipal}">
        <h3>${pageContext.request.userPrincipal.name}</h3>
        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
             Роль: Администратор.<Br>
        </c:if>
        <c:if test="${pageContext.request.isUserInRole('USER')}">
             Роль: Пользователь.<Br>
        </c:if>
    </c:if>
  <sec:authorize access="!isAuthenticated()">
    <h4><a href="/login">Войти</a></h4>
    <h4><a href="/registration">Зарегистрироваться</a></h4>
  </sec:authorize>

    <sec:authorize access="isAuthenticated()">
      <h4><a href="/registration0">Задать\изменить ФИО</a></h4>
      <h4><a href="/userCourse">Мои курсы</a></h4>
      <h4><a href="/course">Запись на курсы</a></h4>
      <Br>
    <c:if test="${not empty pageContext.request.userPrincipal}">
        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
        <h4><a href="/admin">Управление пользователями</a></h4>
        <h4><a href="/courseDell">Редактирование списка курсов</a></h4>
        </c:if>
    </c:if>
      <Br>
      <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>


</div>
</div>
</body>
</html>