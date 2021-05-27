<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Save Course</title>
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