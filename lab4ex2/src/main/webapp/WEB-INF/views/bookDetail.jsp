<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Book</title>
</head>
<body>
<form:form modelAttribute="book" action="../books/${book.id}" method="post">
    <table>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title"/></td>
            <%--<td><input type="text" name="title" value="${book.title}" /> </td>--%>
        </tr>
        <tr>
            <td><form:label path="ISBN">Title</form:label></td>
            <td><form:input path="ISBN"/></td>
            <%--<td>ISBN:</td>--%>
            <%--<td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>--%>
        </tr>
        <tr>
            <td><form:label path="author">Author</form:label></td>
            <td><form:input path="author"/></td>
            <%--<td>Author:</td>--%>
            <%--<td><input type="text" name="author" value="${book.author}" /> </td>--%>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price"/></td>
            <%--<td>Price:</td>--%>
            <%--<td><input type="text" name="price" value="${book.price}" /> </td>--%>
        </tr>
    </table>
    <input type="submit" value="update"/>
</form:form>
<form:form action="delete?bookId=${book.id}" method="post" modelAttribute="book">
    <form:button type="submit">Delete</form:button>
</form:form>
</body>
</html>