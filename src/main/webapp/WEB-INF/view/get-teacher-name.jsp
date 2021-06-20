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
        <link rel="stylesheet" href="/stylesheet.css" />
    </head>
    <body>
            Teacher Name
            <table class="content-table">
                <thead>
                    <tr>
                        <td>
                        <form:form action="showListOfStudentsBasedOnTeacherName" modelAttribute="objects" method="GET">
                            <jsp:useBean id="objects" scope="request" type="ca.amir.controller.MainController.TeacherSelectForm"/>

                            <select name="teacherId">
                                <c:forEach items="${objects.teachers}" var="teacher">
                                    <option value="${teacher.teacherId}">${teacher.teacherName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input type="submit"/>
                            <form:button/>
                        </form:form>
                        <td>
                    </tr>
                </tbody>
            </table>

    </body>
</html>
