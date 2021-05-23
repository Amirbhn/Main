package ca.amir.dao;
import ca.amir.entity.Course;
import java.util.List;
import ca.amir.entity.*;


public interface CourseDAO {
    //Course
    Course getCourseById(int theCourseId);
    void deleteCourse(int theCourseId);
    List<Course> getAllCourses();
    void saveCourse(Course theCourse);

    //Student
    Student getStudentById(int theStudentId);
    void deleteStudent(int theStudentId);
    List<Student> getAllStudents();
    void saveStudent(Student theStudent);

    // Teacher
    Teacher getTeacherById(int theTeacherId);
    void deleteTeacher(int theSTeacherId);
    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher theTeacher);

    //TeacherCourse
    TeacherCourse getTeacherCourseById(int theTeacherCourseId);
    void deleteTeacherCourse(int theSTeacherCourseId);
    List<TeacherCourse> getAllTeacherCourses();
    void saveTeacherCourse(TeacherCourse theTeacherCourse);

    //StudentCourse
    StudentCourse getStudentCourseById(int theStudentCourseId);
    void deleteStudentCourse(int theStudentCourseId);
    List<StudentCourse> getAllStudentCourses();
    void saveStudentCourse(StudentCourse theStudentCourse);

    //TeacherStudent
    TeacherStudent getTeacherStudentById(int theTeacherStudentId);
    void deleteTeacherStudent(int theTeacherStudentId);
    List<TeacherStudent> getAllTeacherStudents();
    void saveTeacherStudent(TeacherStudent theTeacherStudent);






}
