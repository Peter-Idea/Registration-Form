<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>Заполнить ФИО</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css"  href="${contextPath}/resources/css/style.css">
</head>

<body>
<div id="container">
    <form:form action="" method="post" modelAttribute="userForm" enctype="application/x-www-form-urlencoded">

	<div id="reg">
		<dl>
    		<dd><span class="pole">Логин:${pageContext.request.userPrincipal.name}</span>
    	</dl>

    	<dl>
        	<dd><span class="pole">Фамилия</span>
        	<form:input  type="text" path="lastname" placeholder="${userForm.lastname}"
        	autofocus="true"></form:input >
			<span class="not_correct">
			<form:errors path="lastname"></form:errors>
            </span>
        </dl>

		<dl>
			<dd><span class="pole">Имя</span>
			<form:input  type="text" path="firstname"  placeholder="${userForm.firstname}"
			autofocus="true"></form:input >
			<span class="not_correct">
			<form:errors path="firstname"></form:errors>
            </span>
		</dl>

		<dl>
			<dd><span class="pole">Отчество</span>
			<form:input  type="text" path="middlename"  placeholder="${userForm.middlename}"
			autofocus="true"></form:input >
			<span class="not_correct">
            <form:errors path="middlename"></form:errors>
            </span>
		</dl>

		<dl>
			<dd><span class="pole">E-mail</span>
			<form:input  type="text" path="email"  placeholder="${userForm.email}"
			autofocus="true"></form:input >
			<span class="not_correct">
            <form:errors path="email"></form:errors>
            </span>
		</dl>

        <dl>
        	<dd><span class="pole">tell</span>
        	<form:input  type="text" path="phone"  placeholder="${userForm.phone}"
        	autofocus="true"></form:input >
			<span class="not_correct">
            <form:errors path="phone"></form:errors>
            </span>
        </dl>
	</div>

	<div id="footer">
        <dl>
        <input  type="submit" value="Отправить" class="btn"/>
        </dl> <dl>
        <input  type="button" value="На главную страницу" class="btn" onclick="javascript:window.location='/'"/>
        </dl>
	</div>

		</form:form>
</div>
</body>
</html>