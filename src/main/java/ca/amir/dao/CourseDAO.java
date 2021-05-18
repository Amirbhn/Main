package ca.amir.dao;
import ca.amir.entity.Course;
import java.util.List;

public interface CourseDAO {

    List<Course> getAllCourses();
    void saveCourse(Course theCourse);
    Course getCourseById(int theCourseId);
    void deleteCourse(int theCourseId);
}
