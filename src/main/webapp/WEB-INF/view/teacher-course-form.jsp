<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Save Teacher Course</title>
</head>
<body>

<form:form action="showFormForAddTeacherCourse" modelAttribute="objects">

    <table>
        <tr>
            <td>
                Select a teacher:
            </td>
            <td>
                <select name="teacherId">
                    <c:forEach items="${objects.teachers}" var="teacher">
                        <option value="${teacher.teacherId}">${teacher.teacherName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                Select a course:
            </td>
            <td>
                <select name="courseId">
                    <c:forEach items="${objects.courses}" var="course">
                        <option value="${course.courseID}">${course.courseName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <form:button name="submit" value="1">Register!</form:button>
            </td>
        </tr>
    </table>

    <br/>

</form:form>
</body>
</html>