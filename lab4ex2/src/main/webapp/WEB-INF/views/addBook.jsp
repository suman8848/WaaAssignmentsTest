<%--
  Created by IntelliJ IDEA.
  User: sumankhatiwada
  Date: 3/1/18
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Book</title>
</head>
<body>
<form:form modelAttribute="book" action="addbooks" method="post">
    <%--<form:errors path = "*" cssClass="errorblock" element = "div"></form:errors>--%>
    <table>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title"/></td>
            <td><form:errors path="title" cssClass="error"></form:errors> </td>
        </tr>
        <tr>
            <td><form:label path="ISBN">ISBN</form:label></td>
            <td><form:input path="ISBN"/></td>
            <td><form:errors path="ISBN" cssClass="error"></form:errors> </td>
        </tr>
        <tr>
            <td><form:label path="author">Author</form:label></td>
            <td><form:input path="author"/></td>
            <td><form:errors path="author" cssClass="error"></form:errors> </td>
                <%--<td>Author:</td>--%>
                <%--<td><input type="text" name="author"/></td>--%>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price"/></td>
            <td><form:errors path="price" cssClass="error"></form:errors> </td>
                <%--<td>Price:</td>--%>
                <%--<td><input type="text" name="price"/></td>--%>
        </tr>
    </table>
    <input type="submit"/>

</form:form>
<%--<form:form modelAttribute="book" action="books" method="post">--%>

    <%--<table>--%>
            <%--<tr>--%>
            <%--<td><form:label path="title">Title</form:label></td>--%>
            <%--<td><form:input path="title"/></td>--%>
            <%--<td><form:errors path="title" cssClass="error"></form:errors> </td>--%>
            <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>ISBN:</td>--%>
            <%--<td><input type="text" name="ISBN" /> </td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>Author:</td>--%>
            <%--<td><input type="text" name="author" /> </td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>Price:</td>--%>
            <%--<td><input type="text" name="price" /> </td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <%--<input type="submit"/>--%>

<%--</form:form>--%>
</body>
</html>