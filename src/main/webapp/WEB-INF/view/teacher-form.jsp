<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Save Teacher</title>
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
        <form:form action="saveTeacher" modelAttribute="teacher" method="POST">
            <form:hidden path="teacherId"/>
              <thead>
                  <tr>
                      <td>Teacher name</td>
                      <td>Teacher Email</td>
                      <td>Save</td>
                  </tr>
              </thead>
              <tbody>
                  <tr>
                      <td><form:input path="teacherName"/></td>
                      <td><form:input path="teacherEmail"/></td>
                      <td><input type="submit" value="Save" class="save"/></td>
                  </tr>
              </tbody>
        </form:form>
        <p>
            <a href="${pageContext.request.contextPath}/main/allEntities">Back to List</a>
        </p>

    </body>
</html>
