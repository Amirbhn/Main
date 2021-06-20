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
    <link rel="stylesheet" href="/stylesheet.css" />
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
