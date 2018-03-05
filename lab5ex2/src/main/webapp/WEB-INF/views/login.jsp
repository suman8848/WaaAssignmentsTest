<%--
  Created by IntelliJ IDEA.
  User: sumankhatiwada
  Date: 3/4/18
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form action="login" method="post" modelAttribute="user" >
    <c:if test="${param.error != null }">
        <p>Invalid username and password.</p>
        <p>${param.error}</p>
    </c:if>
    Username: <form:input type="text" path="username"/>
    <br />
    Password: <form:password path="password"/>
    <br />
    <input type="submit" value="Login" />
</form:form>
</body>
</html>
