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

Teacher name is : ${theTeacher.teacherName}
<br><br>
Teacher email is : ${theTeacher.teacherEmail}
<br><br>
Teacher ID is : ${theTeacher.teacherId}
<br><br>
<input type="hidden" name="selectedTeacherId" value="${theTeacher.teacherId}">

<table>

    <tr>
        <td>teacher name</td>
        <td>student name</td>
        <td> grade</td>
        <td> submit</td>
    </tr>


<c:forEach items="${students}" var="student">
        <form:form  action="showFormForAddTeacherStudent" method="post">
            <input type="hidden" name="selectedStudentId" value="${student.studentId}">

            <tr>
                <td>${theTeacher.teacherName}</td>
                <td>${student.studentName} ${student.studentFamily}</td>
                <td><input type="text" name="givenGrade" placeholder="Please Enter the grade"/>
                <td><input type="submit" value="submit" /></td>
                </td>
            </tr>

        </form:form>
</c:forEach>

</table>

</body>
</html>
