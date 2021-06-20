<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Save Teacher</title>
        <link rel="stylesheet" href="/stylesheet.css" />
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
