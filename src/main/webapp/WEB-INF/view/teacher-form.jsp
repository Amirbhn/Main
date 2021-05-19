<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Teacher</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-passenger-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Teacher Management</h2>
    </div>
</div>

<div id="container">
    <h3>Save Teacher</h3>

    <!--
        By clicking on submit button on the form method with @PostMapping("/saveCourse") in controller will be called
        Moreover, these fields will be saved as and object. This object will be added to Model object HashMap
        attribute by "course" key,

            @PostMapping("/saveCourse")
            public String saveCourse(@ModelAttribute("course") Course theCourse)

        so saveCourse method will receive it as an argument and will cast it to Course object
    -->
    <form:form action="saveTeacher" modelAttribute="teacher" method="POST">

        <!-- need to associate this data with student id -->
        <form:hidden path="teacherId"/>

        <table>
            <tbody>
            <tr>
                <td><label>Teacher name:</label></td>
                <td><form:input path="teacherName"/></td>
            </tr>


            <tr>
                <td><label>Teacher Email:</label></td>
                <td><form:input path="teacherEmail"/></td>
            </tr>


            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>

            </tbody>
        </table>


    </form:form>

    <div style="clear; both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/main/allEntities">Back to List</a>
    </p>

</div>

</body>

</html>
