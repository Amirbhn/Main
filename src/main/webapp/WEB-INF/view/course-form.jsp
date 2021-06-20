<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Save Course</title>
        <link rel="stylesheet" href="/stylesheet.css" />
    </head>

    <body>

        <h3>Save Course</h3>

        <form:form action="saveCourse" modelAttribute="course" method="POST">
        <form:hidden path="courseId"/>
            <table class="content-table">
                <thead>
                    <tr>
                        <td><label>Course name:</label></td>
                        <td><form:input path="courseName"/></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                         <td><label></label></td>
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