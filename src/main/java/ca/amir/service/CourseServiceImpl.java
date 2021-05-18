package ca.amir.service;
import ca.amir.entity.*;

import java.util.List;

import ca.amir.dao.PassengerDAO;
import ca.amir.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ca.amir.dao.CourseDAO;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    @Override
    public List<Student> getAllStudents() {
        return courseDAO.getAllStudents();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return courseDAO.getAllTeachers();
    }

    @Override
    public void saveCourse(Course theCourse) {
        courseDAO.saveCourse(theCourse);
    }

    @Override
    public void saveStudent(Student theStudent) {
        courseDAO.saveStudent(theStudent);
    }

    @Override
    public void saveTeacher(Teacher theTeacher) {
        courseDAO.saveTeacher(theTeacher);
    }

    @Override
    public Course getCourseById(int theCourseId) {
        return courseDAO.getCourseById(theCourseId);
    }

    @Override
    public Student getStudentById(int theStudentId) {
        return courseDAO.getStudentById(theStudentId);
    }

    @Override
    public Teacher getTeacherById(int theTeacherId) {
        return courseDAO.getTeacherById(theTeacherId);
    }

    @Override
    public void deleteCourse(int theCourseId) {
        courseDAO.deleteCourse(theCourseId);
    }

    @Override
    public void deleteStudent(int theStudentId) {
        courseDAO.deleteStudent(theStudentId);
    }

    @Override
    public void deleteTeacher(int theTeacherId) {
        courseDAO.deleteTeacher(theTeacherId);
    }


}
