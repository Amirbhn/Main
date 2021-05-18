<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Of All Entities</title>
    <!-- reference our style sheet -->
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Entities Management</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add Course"
               onclick="window.location.href='showFormForAddCourse'; return false;"
               class="add-button"
        />
<%--table for Course--%>
        <table>
            <tr>
                <th>Course Name</th>
                <th>Action</th>
            </tr>
            <!-- loop over and print our passengers -->
            <c:forEach var="tempCourse" items="${allCourses}">

                <!--
                construct an "update" link with passenger id
                http://localhost:8080/00-Spring-Hibernate-CRUD-Final/passenger/showFormForUpdate?passengerId=5
                -->
                <c:url var="updateCourseLink" value="/main/showFormForUpdateCourse">
                    <c:param name="courseId" value="${tempCourse.courseID}"/>
                </c:url>

                <!--
                Construct an "delete" link with passenger id
                http://localhost:8080/00-Spring-Hibernate-CRUD-Final/customer/delete?customerId=5
                -->
                <c:url var="deleteCourseLink" value="/main/deleteCourse">
                    <c:param name="courseId" value="${tempCourse.courseID}"/>
                </c:url>

                <tr>
                    <td>${tempCourse.courseName}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateCourseLink}">Update</a>
                        |
                        <a href="${deleteCourseLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this Course?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
        <br><br/>


        <%---table for Student-------------------------------------------------------%>
<div id="container1">
    <div id="content1">
        <input type="button" value="Add Student"
               onclick="window.location.href='showFormForAddStudent'; return false;"
               class="add-button"
        />
        <table>
            <tr>
                <th>Student Name</th>
                <th>Student Family</th>
                <th>Student Birthdate</th>
                <th>Student Gender</th>
                <th>Student Email</th>
                <th>Action</th>
            </tr>
            <!-- loop over and print our Students -->
            <c:forEach var="tempStudent" items="${allStudents}">

                <!--
                construct an "update" link with Student id
                http://localhost:8080/00-Spring-Hibernate-CRUD-Final/Student/showFormForUpdate?passengerId=5
                -->
                <c:url var="updateStudentLink" value="/main/showFormForUpdateStudent">
                    <c:param name="studentId" value="${tempStudent.studentId}"/>
                </c:url>

                <!--
                Construct an "delete" link with Student id
                http://localhost:8080/00-Spring-Hibernate-CRUD-Final/customer/delete?customerId=5
                -->
                <c:url var="deleteStudentLink" value="/main/deleteStudent">
                    <c:param name="studentId" value="${tempStudent.studentId}"/>
                </c:url>

                <tr>
                    <td>${tempStudent.studentName}</td>
                    <td>${tempStudent.studentFamily}</td>
                    <td>${tempStudent.studentBirthdate}</td>
                    <td>${tempStudent.studentGender}</td>
                    <td>${tempStudent.studentEmail}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateStudentLink}">Update</a>
                        |
                        <a href="${deleteStudentLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>

</html>