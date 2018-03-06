<%--
  Created by IntelliJ IDEA.
  User: sumankhatiwada
  Date: 3/5/18
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Book</title>
</head>
<body>
<%--@elvariable id="team" type=""--%>
<form:form modelAttribute="team" action="addteam" method="post">
    <%--<form:errors path = "*" cssClass="errorblock" element = "div"></form:errors>--%>
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
            <%--<td><form:errors path="name" cssClass="error"></form:errors> </td>--%>
        </tr>
        <tr>
            <td><form:label path="city">City</form:label></td>
            <td><form:input path="city"/></td>
            <%--<td><form:errors path="city" cssClass="error"></form:errors> </td>--%>
        </tr>
        <tr>
            <td><form:label path="mascot">Mascot</form:label></td>
            <td><form:input path="mascot"/></td>
            <td><form:errors path="mascot" cssClass="error"></form:errors> </td>
                <%--<td>Author:</td>--%>
                <%--<td><input type="text" name="author"/></td>--%>
        </tr>
        <tr>
            <td><form:label path="homeuniforms">Home Uniform</form:label></td>
            <td><form:input path="homeuniforms"/></td>
            <td><form:errors path="homeuniforms" cssClass="error"></form:errors> </td>
                <%--<td>Price:</td>--%>
                <%--<td><input type="text" name="price"/></td>--%>
        </tr>
    </table>
    <input type="submit"/>

</form:form>

</body>
</html>
