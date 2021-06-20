<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Save Student Course</title>
        <link rel="stylesheet" href="/stylesheet.css" />
    </head>
    <body>

         <form:form action="showFormForAddStudentCourse" modelAttribute="objects" method="post">
         <jsp:useBean id="objects" scope="request" type="ca.amir.controller.MainController.StudentCourseForm"/>

        <table class="content-table">
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
                    <c:forEach items="${objects.teacherCourses}" var="courseTeacher">
                        <input id="course-${courseTeacher.teacherCourseId}" name="teacherCourseIdSelected" type="checkbox"
                               value="${courseTeacher.teacherCourseId}"/>
                        <label for="course-${courseTeacher.teacherCourseId}">${courseTeacher.course.courseName}
                            <sub>(<b>${courseTeacher.teacher.teacherName}</b>)</sub></label>
                    </c:forEach>
                </td>
            </tr>
            <br>
            <tr>

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