<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: amirb
  Date: 5/22/2021
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Please enter Students Grades</title>
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
        <jsp:useBean id="objects" scope="request" type="ca.amir.controller.MainController.TeacherStudentForm"/>
            <table class="content-table">
                <thead>
                <tr>
                    <td>Teacher name</td>
                    <td>Teacher email</td>
                    <td>Teacher ID</td>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${objects.theTeacher.teacherName}</td>
                        <td>${objects.theTeacher.teacherEmail}</td>
                        <td>${objects.theTeacher.teacherId}</td>
                    </tr>
                </tbody>
            </table>
            <table class="content-table">
                <thead>
                    <tr>
                        <td>course name</td>
                        <td>student name</td>
                        <td>grade</td>
                        <td>submit</td>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${objects.studentTeacherCourses}" var="studentTeacherCourse">
                        <form:form action="showListOfStudentsBasedOnTeacherName?teacherId=${objects.theTeacher.teacherId}" method="post" modelAttribute="objects">
                        <tr>
                            <td>${studentTeacherCourse.teacherCourse.course.courseName}<sub> (<b>${studentTeacherCourse.teacherCourse.teacher.teacherName}</b>)</sub></td>
                            <td>${studentTeacherCourse.student.studentName} ${studentTeacherCourse.student.studentFamily}</td>
                            <td><input type="number" name="grade" placeholder="Please Enter the grade" value="${studentTeacherCourse.grade}"/></td>
                            <td>
                                <input type="hidden" name="studentTeacherCourseId" value="${studentTeacherCourse.studentTeacherCourseId}">
                                <input type="submit" value="submit"/>
                            </td>
                        </tr>
                        </form:form>
                    </c:forEach>
                </tbody>
            </table>
        <p>
            <a href="${pageContext.request.contextPath}/main/allEntities">Back to List</a>
        </p>
    </body>
</html>
