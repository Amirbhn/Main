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
    <style>
        .content-table{
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 0.9em;
            min-width: 400px;
            border-radius: 5px 5px 0 0;
            overflow: hidden;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        }
        .content-table thead tr {
            background-color: #009879;
            color: #ffffff;
            text-align: left;
            font-weight: bold;
        }
        .content-table th,
        .content-table td{
            padding: 12px 15px;
        }
        .content-table tbody tr{
            border-bottom: 1px solid #dddddd;
        }

        .content-table tbody tr:nth-of-type(even){
            background-color: #f3f3f3;
        }

        .content-table tbody tr:last-of-type{
            border-bottom: 2px solid #009879;
        }
    </style>
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
