<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

    <head>
        <title>Save Student</title>
        <link rel="stylesheet" href="/stylesheet.css" />
    </head>
    <body>
        <table class="content-table">
            <form:form action="saveStudent" modelAttribute="student" method="POST">
            <form:hidden path="studentId"/>
               <thead>
                   <tr>
                       <td>Student name</td>
                       <td>Student Family</td>
                       <td>Student Birthdate</td>
                       <td>Student Gender</td>
                       <td>Student Email</td>
                       <td>Add</td>
                   </tr>
               </thead>
                <tbody>
                    <tr>
                        <td><form:input path="studentName"/></td>
                        <td><form:input path="studentFamily"/></td>
                        <td><form:input path="studentBirthdate"/></td>
                        <td><form:input path="studentGender"/></td>
                        <td><form:input path="studentEmail"/></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        <p>
            <a href="${pageContext.request.contextPath}/main/allEntities">Back to List</a>
        </p>
    </body>
</html>
