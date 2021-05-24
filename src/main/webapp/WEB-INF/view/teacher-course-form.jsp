<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Save Teacher Course</title>
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
        <table class="content-table">
            <form:form action="showFormForAddTeacherCourse" modelAttribute="objects">
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
                        <c:forEach items="${objects.courses}" var="courseTeacher">
                            <option value="${courseTeacher.courseId}">${courseTeacher.courseName}</option>
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
        <p>
            <a href="${pageContext.request.contextPath}/main/allEntities">Back to List</a>
        </p>
    </form:form>
    </body>
</html>