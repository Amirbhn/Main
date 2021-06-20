<%--
  Created by IntelliJ IDEA.
  User: amirb
  Date: 5/22/2021
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Error</title>
        <link rel="stylesheet" href="/stylesheet.css" />
    </head>
    <body>
        <table class="content-table">
            <thead>
            <tr>
                <td>
                This Course Has Already  been Added !
                </td>
            </tr>
            </thead>
        </table>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/main/showFormForAddStudentCourse">Back to List</a>
    </body>
</html>
