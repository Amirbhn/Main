package ca.amir.service;

import ca.amir.entity.*;
import ca.amir.dao.CourseDAO;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<TeacherCourse> getAllTeacherCourses() {
        return courseDAO.getAllTeacherCourses();
    }

    @Override
    public List<StudentTeacherCourse> getAllStudentTeacherCourses() {
        return courseDAO.getAllStudentTeacherCourses();
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
    public void saveTeacherCourse(TeacherCourse theTeacherCourse) {
        courseDAO.saveTeacherCourse(theTeacherCourse);
    }

    @Override
    public void saveStudentTeacherCourse(StudentTeacherCourse theStudentTeacherCourse) {
        courseDAO.saveStudentTeacherCourse(theStudentTeacherCourse);
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
    public TeacherCourse getTeacherCourseById(int theTeacherCourseId) {
        return courseDAO.getTeacherCourseById(theTeacherCourseId);
    }

    @Override
    public StudentTeacherCourse getStudentTeacherCourseById(int theStudentTeacherCourseId) {
        return courseDAO.getStudentTeacherCourseById(theStudentTeacherCourseId);
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

    @Override
    public void deleteTeacherCourse(int theTeacherCourseId) {
        courseDAO.deleteTeacherCourse(theTeacherCourseId);
    }

    @Override
    public void deleteStudentTeacherCourse(int theStudentTeacherCourseId) {
        courseDAO.deleteStudentTeacherCourse(theStudentTeacherCourseId);
    }

    @Override
    public List<StudentTeacherCourse> getStudentTeacherCourseBasedOnStudentId(int theStudentId) {
        return courseDAO.getStudentTeacherCourseBasedOnStudentId(theStudentId);
    }

    @Override
    public List<StudentTeacherCourse> getStudentTeacherCourseBasedOnTeacherId(int theTeacherId) {
        return courseDAO.getStudentTeacherCourseBasedOnTeacherId(theTeacherId);
    }

    @Override
    public List<StudentTeacherCourse> getStudentTeacherCourseBasedOnCourseId(int theCourseId) {
        return courseDAO.getStudentTeacherCourseBasedOnCourseId(theCourseId);
    }

}
