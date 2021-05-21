<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Save Teacher Course</title>
</head>
<body>

<form:form action="showFormForAddStudentCourse" modelAttribute="objects" method="post">

    <table>
        <tr>
            <td>
                Select a student:
            </td>
            <td>
                <select name="studentId">
                    <c:forEach items="${objects.students}" var="student">
                        <option value="${student.studentId}">${student.studentName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                select course(s)
            </td>
            <td>
                <c:forEach items="${objects.teacherCourses}" var="teacherCourse" >
                    <input name="courseIdSelected" type="checkbox" value
                           value="<option "${teacherCourse.course.courseId}">${teacherCourse.course.courseName}

                </c:forEach>
            </td>
        </tr>
        <br>
        <tr>
<%
    String[] coursesIds = request.getParameterValues("courseIdSelected");
%>

            <td colspan="2">
                <form:button name="submit" value="1">Add Course(s)!</form:button>
            </td>
        </tr>

    </table>

    <br/> <br/>


    <p>
        <a href="${pageContext.request.contextPath}/main/allEntities">Back to List</a>
    </p>

</form:form>
</body>
</html>