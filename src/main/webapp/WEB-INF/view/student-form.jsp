<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

    <head>
        <title>Save Student</title>
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
