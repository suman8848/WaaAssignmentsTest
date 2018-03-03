<%--
  Created by IntelliJ IDEA.
  User: sumankhatiwada
  Date: 3/2/18
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h2>Hello world</h2>

<label> <spring:message code = "label.firstName"/></label> <br/>
<label> <spring:message code = "label.lastName"/></label>
<p>Please Select One</p>
<select id="locales">
    <option>Cars</option>
    <option>Books</option>

</select>
</body>
</html>
