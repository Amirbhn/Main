<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Save Student Course</title>
        <style>
            .content-table {
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
            .content-table td {
                padding: 12px 15px;
            }

            .content-table tbody tr {
                border-bottom: 1px solid #dddddd;
            }

            .content-table tbody tr:nth-of-type(even) {
                background-color: #f3f3f3;
            }

            .content-table tbody tr:last-of-type {
                border-bottom: 2px solid #009879;
            }
        </style>
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