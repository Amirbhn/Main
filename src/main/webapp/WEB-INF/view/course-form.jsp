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

<div id="wrapper">
    <div id="header">
        <h2>Course Management</h2>
    </div>
</div>

<div id="container">
    <h3>Save Course</h3>

    <!--
        By clicking on submit button on the form method with @PostMapping("/saveCourse") in controller will be called
        Moreover, these fields will be saved as and object. This object will be added to Model object HashMap
        attribute by "course" key,

            @PostMapping("/saveCourse")
            public String saveCourse(@ModelAttribute("course") Course theCourse)

        so saveCourse method will receive it as an argument and will cast it to Course object
    -->
    <form:form action="saveCourse" modelAttribute="course" method="POST">

        <!-- need to associate this data with passenger id -->
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

    <div style="clear; both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/main/allEntities">Back to List</a>
    </p>

</div>

</body>

</html>