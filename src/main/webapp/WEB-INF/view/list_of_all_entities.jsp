<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>List Of All Entities</title>
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

            <input type="button" value="Add Course"
                   onclick="window.location.href='showFormForAddCourse'; return false;"
                   class="add-button"
            />
            <jsp:useBean id="objects" scope="request" type="ca.amir.controller.MainController.AllEntityForm"/>

    <%-------------------------------------------------Course Table---------------------------------------------------%>
            <table class="content-table">
               <thead>
                    <tr>
                        <th>Course Name</th>
                        <th>Action</th>
                    </tr>
               </thead>
               <tbody>
                    <c:forEach var="tempCourse" items="${objects.theCourses}">

                    <c:url var="updateCourseLink" value="/main/showFormForUpdateCourse">
                        <c:param name="courseId" value="${tempCourse.courseId}"/>
                    </c:url>

                    <c:url var="deleteCourseLink" value="/main/deleteCourse">
                        <c:param name="courseId" value="${tempCourse.courseId}"/>
                    </c:url>

                    <tr>
                        <td>${tempCourse.courseName}</td>
                        <td>
                            <a href="${updateCourseLink}">Update</a>
                            |
                            <a href="${deleteCourseLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this Course?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
               </tbody>
            </table>

            <br><br/>

            <%-------------------------------------------- table for Student---------------------------------------------%>

            <input type="button" value="Add Student"
                   onclick="window.location.href='showFormForAddStudent'; return false;"
                   class="add-button"
            />
            <table class="content-table">
               <thead>
                    <tr>
                        <th>Student Name</th>
                        <th>Student Family</th>
                        <th>Student Birthdate</th>
                        <th>Student Gender</th>
                        <th>Student Email</th>
                        <th>Action</th>
                    </tr>
               </thead>
                <tbody>
                <!-- loop over and print our Students -->
                    <c:forEach var="tempStudent" items="${objects.theStudents}">

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
                </tbody>
            </table>

            <br><br/>
    <%------------------------------------------------- Teacher Table -------------------------------------------------------%>
            <input type="button" value="Add Teacher"
                   onclick="window.location.href='showFormForAddTeacher'; return false;"
                   class="add-button"/>
            <table class="content-table">
                <thead>
                    <tr>
                        <th>Teacher Name</th>
                        <th>Teacher Email</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <!-- loop over and print our passengers -->
                <c:forEach var="tempTeacher" items="${objects.theTeachers}">


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
                </tbody>
            </table>
            <br><br/>


    <%-- -------------------------------------TeacherCourse Table------------------------------------------------------------%>
            <a href="showFormForAddTeacherCourse">Teacher Click Here To Select What Course he wants to Teach</a>

            <table class="content-table">
                <thead>
                    <tr>
                        <th>Teacher Name</th>
                        <th>Course Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- loop over and print our passengers -->
                    <c:forEach var="tempTeacherCourse" items="${objects.theTeacherCourses}">

                        <c:url var="updateTeacherCourseLink" value="/main/showFormForUpdateTeacherCourse">
                            <c:param name="teacherCourseId" value="${tempTeacherCourse.teacherCourseId}"/>
                        </c:url>

                        <c:url var="deleteTeacherCourseLink" value="/main/deleteTeacherCourse">
                            <c:param name="teacherCourseId" value="${tempTeacherCourse.teacherCourseId}"/>
                        </c:url>

                        <tr>
                            <td>${tempTeacherCourse.teacher.teacherName}</td>
                            <td>${tempTeacherCourse.course.courseName}</td>
                            <td>
                                <!-- display the update link -->
                                <a href="${updateTeacherCourseLink}">Update</a>
                                |
                                <a href="${deleteTeacherCourseLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this TeacherCourse?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br><br/>
    <%-------------------------------------------------StudentCourse Table-----------------------------------------------%>
            <a href="/main/showFormForAddStudentCourse">Student Click Here To Select What Course(s) They wants to Study</a>

            <table class="content-table">
               <thead>
                    <tr>
                        <th>Student Name</th>
                        <th>Course Name</th>
                        <th>Grade</th>
                        <th>Action</th>
                    </tr>
               </thead>
                <tbody>

                <!-- loop over and print our StudentCourseObjects -->
                <c:forEach var="tempStudentCourse" items="${objects.theStudentTeacherCourses}">

                    <c:url var="updateStudentCourseLink" value="/main/showFormForUpdateStudentCourse">
                        <c:param name="studentCourseId" value="${tempStudentCourse.studentTeacherCourseId}"/>
                    </c:url>

                    <c:url var="deleteStudentCourseLink" value="/main/deleteStudentCourse">
                        <c:param name="studentCourseId" value="${tempStudentCourse.studentTeacherCourseId}"/>
                    </c:url>

                    <tr>
                        <td>${tempStudentCourse.student.studentName}</td>
                        <td>${tempStudentCourse.teacherCourse.course.courseName}<sub> (<b>${tempStudentCourse.teacherCourse.teacher.teacherName}</b>)</sub></td>
                        <td>${tempStudentCourse.grade}</td>
                        <td>
                            <!-- display the update link -->
                            <a href="${updateStudentCourseLink}">Update</a>
                            |
                            <a href="${deleteStudentCourseLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this StudentCourse?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br><br/>
            <%------------------------------------------------- Link-----------------------------------------------%>
            <a href="/main/getTeacherId">Teachers Click Here To Enter their teacher id then enter grades</a>
    </body>

</html>