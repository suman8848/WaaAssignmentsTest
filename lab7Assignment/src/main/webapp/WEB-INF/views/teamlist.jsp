<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Books currently in the shop</title>
</head>
<body>
<h1>Team List</h1>
<table>
    <c:forEach var="team" items="${teams}">
        <tr>
            <td>${team.name}</td>
            <td>${team.city}</td>
            <td>${team.mascot}</td>
            <td><a href="/teams/${team.teamKey}">edit</a></td>
        </tr>
    </c:forEach>
</table>

<a href="/addteams"> Add Team</a>
</body>
</html>