package ca.amir.service;
import java.util.List;
import ca.amir.entity.Course;
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
    void deleteTeacher(int theSTeacherId);
    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher theTeacher);
}
