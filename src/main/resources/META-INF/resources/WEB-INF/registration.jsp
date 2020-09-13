<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>Регистрация 1</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css"  href="${contextPath}/resources/css/style.css">
</head>

<body>
<div id="container">
    <form:form action="" method="post" modelAttribute="userForm" enctype="application/x-www-form-urlencoded">

	<div id="reg">
		<dl>
			<dd><span class="pole">Логин</span>
			<form:input type="text" path="username" name="login" placeholder="Введите логин"
			autofocus="true"></form:input>
			<span class="not_correct">
            <form:errors path="username"></form:errors>
            ${usernameError}
            </span>
		</dl>
		<dl>
			<dd><span class="pole">Пароль</span>
			<form:input type="password" path="password" placeholder="Введите пароль"></form:input>
			<span class="not_correct">
			<form:errors path="password"></form:errors>
			</span>
			</dd>

			<dd><span class="pole">Повторите</span>
			<form:input type="password" path="passwordConfirm" placeholder="Повторите пароль"></form:input>
			<span class="not_correct">
			<form:errors path="password"></form:errors>
            </span>
			</dd>
		</dl>
		<dl>
		<span class="not_correct">${passwordError}</span>
		</dl>

	</div>
	<div id="footer">
        <dl>
        <input type="submit" value="Отправить" class="btn"/>
        </dl> <dl>
        <input type="button" value="На главную страницу" class="btn" onclick="javascript:window.location='/'"/>
        </dl>
	</div>
	</form:form>
</div>
</body>
</html>