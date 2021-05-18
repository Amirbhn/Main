package ca.amir.service;
import java.util.List;
import ca.amir.entity.Course;


public interface CourseService {
    List<Course> getAllCourses();
    void saveCourse(Course theCourse);
    Course getCourseById(int theCourseId);
    void deleteCourse(int theCourseId);
}
