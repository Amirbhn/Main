<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Of All Entities</title>
    <!-- reference our style sheet -->
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/static/css/style.css"/>
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
<%-------------------------------------------------Course Table---------------------------------------------------%>
        <table>
            <tr>
                <th>Course Name</th>
                <th>Action</th>
            </tr>
            <!-- loop over and print our passengers -->
            <c:forEach var="tempCourse" items="${allCourses}">

                <c:url var="updateCourseLink" value="/main/showFormForUpdateCourse">
                    <c:param name="courseId" value="${tempCourse.courseId}"/>
                </c:url>

                <c:url var="deleteCourseLink" value="/main/deleteCourse">
                    <c:param name="courseId" value="${tempCourse.courseId}"/>
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

        <br><br/>

        <%-------------------------------------------- table for Student---------------------------------------------%>

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

                <c:url var="updateStudentLink" value="/main/showFormForUpdateStudent">
                    <c:param name="studentId" value="${tempStudent.studentId}"/>
                </c:url>


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

        <br><br/>
<%------------------------------------------------- Teacher Table -------------------------------------------------------%>
        <input type="button" value="Add Teacher"
               onclick="window.location.href='showFormForAddTeacher'; return false;"
               class="add-button"
        />
        <table>
            <tr>
                <th>Teacher Name</th>
                <th>Teacher Email</th>
                <th>Action</th>
            </tr>
            <!-- loop over and print our passengers -->
            <c:forEach var="tempTeacher" items="${allTeachers}">


                <c:url var="updateTeacherLink" value="/main/showFormForUpdateTeacher">
                    <c:param name="teacherId" value="${tempTeacher.teacherId}"/>
                </c:url>


                <c:url var="deleteTeacherLink" value="/main/deleteTeacher">
                    <c:param name="teacherId" value="${tempTeacher.teacherId}"/>
                </c:url>

                <tr>
                    <td>${tempTeacher.teacherName}</td>
                    <td>${tempTeacher.teacherEmail}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateTeacherLink}">Update</a>
                        |
                        <a href="${deleteTeacherLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this Teacher?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <br><br/>


<%-- -------------------------------------TeacherCourse Table------------------------------------------------------------%>
        <a href="showFormForAddTeacherCourse">Teacher Click Here To Select What Course he wants to Teach</a>

        <table>
            <tr>
                <th>Teacher Name</th>
                <th>Course Name</th>
                <th>Action</th>
            </tr>
            <!-- loop over and print our passengers -->
            <c:forEach var="tempTeacherCourse" items="${allTeacherCourses}">

                <c:url var="updateTeacherCourseLink" value="/main/showFormForUpdateTeacherCourse">
                    <c:param name="teacherCourseId" value="${tempTeacherCourse.teacherCourseId}"/>
                </c:url>

                <c:url var="deleteTeacherCourseLink" value="/main/deleteTeacherCourse">
                    <c:param name="teacherCourseId" value="${tempTeacherCourse.teacherCourseId}"/>
                </c:url>

                <tr>
                    <td>${tempTeacherCourse.course.courseName}</td>
                    <td>${tempTeacherCourse.teacher.teacherName}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateTeacherCourseLink}">Update</a>
                        |
                        <a href="${deleteTeacherCourseLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this TeacherCourse?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <br><br/>
<%-------------------------------------------------StudentCourse Table-----------------------------------------------%>
        <a href="/main/showFormForAddStudentCourse">Student Click Here To Select What Course(s) They wants to Study</a>

        <table>
            <tr>
                <th>Student Name</th>
                <th>Course Name</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our StudentCourseObjects -->
            <c:forEach var="tempStudentCourse" items="${allStudentCourses}">

                <c:url var="updateStudentCourseLink" value="/main/showFormForUpdateStudentCourse">
                    <c:param name="studentCourseId" value="${tempStudentCourse.studentCourseId}"/>
                </c:url>

                <c:url var="deleteStudentCourseLink" value="/main/deleteStudentCourse">
                    <c:param name="studentCourseId" value="${tempStudentCourse.studentCourseId}"/>
                </c:url>

                <tr>
                    <td>${tempStudentCourse.student.studentName}</td>
                    <td>${tempStudentCourse.course.courseName}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateStudentCourseLink}">Update</a>
                        |
                        <a href="${deleteStudentCourseLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this StudentCourse?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <br><br/>

    </div>
</div>
</body>

</html>