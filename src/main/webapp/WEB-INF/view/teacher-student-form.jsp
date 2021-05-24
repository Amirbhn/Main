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
</head>
<body>
<jsp:useBean id="objects" scope="request" type="ca.amir.controller.MainController.TeacherStudentForm"/>

Teacher name is : ${objects.theTeacher.teacherName}
<br><br>
Teacher email is : ${objects.theTeacher.teacherEmail}
<br><br>
Teacher ID is : ${objects.theTeacher.teacherId}
<br><br>

    <table>
        <tr>
            <td>course name</td>
            <td>student name</td>
            <td>grade</td>
            <td>submit</td>
        </tr>
<form:form action="showListOfStudentsBasedOnTeacherName?teacherId=${objects.theTeacher.teacherId}" method="post" modelAttribute="objects">
        <c:forEach items="${objects.studentTeacherCourses}" var="studentTeacherCourse">
            <tr>
                <td>${studentTeacherCourse.teacherCourse.course.courseName}<sub> (<b>${studentTeacherCourse.teacherCourse.teacher.teacherName}</b>)</sub></td>
                <td>${studentTeacherCourse.student.studentName} ${studentTeacherCourse.student.studentFamily}</td>
                <td><input type="number" name="grade" placeholder="Please Enter the grade" value="${studentTeacherCourse.grade}"/></td>
                <td>
                    <input type="hidden" name="studentTeacherCourseId" value="${studentTeacherCourse.studentTeacherCourseId}">
                    <input type="submit" value="submit"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</form:form>


</body>
</html>
