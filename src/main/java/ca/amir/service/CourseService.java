package ca.amir.service;
import java.util.List;
import ca.amir.entity.*;

public interface CourseService {
    Course getCourseById(int theCourseId);
    void deleteCourse(int theCourseId);
    List<Course> getAllCourses();
    void saveCourse(Course theCourse);
    // Student
    Student getStudentById(int theStudentId);
    void deleteStudent(int theStudentId);
    List<Student> getAllStudents();
    void saveStudent(Student theStudent);

    //Teacher
    Teacher getTeacherById(int theTeacherId);
    void deleteTeacher(int theTeacherId);
    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher theTeacher);

    //TeacherCourse
    TeacherCourse getTeacherCourseById(int theTeacherCourseId);
    void deleteTeacherCourse(int theTeacherCourseId);
    List<TeacherCourse> getAllTeacherCourses();
    void saveTeacherCourse(TeacherCourse theTeacherCourse);

    //StudentTeacherCourse
    StudentTeacherCourse getStudentTeacherCourseById(int StudentTeacherCourseId);
    void deleteStudentTeacherCourse(int StudentTeacherCourseId);
    List<StudentTeacherCourse> getAllStudentTeacherCourses();
    void saveStudentTeacherCourse(StudentTeacherCourse StudentTeacherCourse);

    List <StudentTeacherCourse> getStudentTeacherCourseBasedOnStudentId(int theStudentId);
    List<StudentTeacherCourse> getStudentTeacherCourseBasedOnTeacherId(int theTeacherId);
    List<StudentTeacherCourse> getStudentTeacherCourseBasedOnCourseId(int theCourseId);
}
