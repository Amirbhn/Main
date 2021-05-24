<%--
  Created by IntelliJ IDEA.
  User: amirb
  Date: 5/22/2021
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Teacher Name</title>
</head>
<body>
Teacher Name

<form:form action="showListOfStudentsBasedOnTeacherName" modelAttribute="objects" method="GET">
    <jsp:useBean id="objects" scope="request" type="ca.amir.controller.MainController.TeacherSelectForm"/>

    <select name="teacherId">
        <c:forEach items="${objects.teachers}" var="teacher">
            <option value="${teacher.teacherId}">${teacher.teacherName}</option>
        </c:forEach>
    </select>

    <input type="submit"/>
    <form:button/>
</form:form>


</body>
</html>
