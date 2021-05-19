<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Save Teacher Course</title>
</head>
<body>

<form:form action="showFormForAddTeacherCourse" modelAttribute="teacher">

    <form:select path="teacherName">
        <form:options items="${teacher.teacherName}"/>
    </form:select>

</form:form>

<%-- Course Dropdown List     --%>

<form:form action="showFormForAddTeacherCourse" modelAttribute="teacherCourse">

    <form:select path="course">
        <form:options items="${course.courseName}"/>
    </form:select>


</form:form>
</body>
</html>