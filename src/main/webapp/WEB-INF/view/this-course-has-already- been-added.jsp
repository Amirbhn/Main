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
