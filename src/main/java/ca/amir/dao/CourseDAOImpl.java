package ca.amir.dao;
import ca.amir.entity.*;

import java.util.List;

import ca.amir.entity.Student;
import org.springframework.stereotype.Repository;
import ca.amir.entity.Course;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

// @Repository will handle translation to JDBC exceptions
@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {

    private final EntityManager em;

    public CourseDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Course> getAllCourses() {

        // create a query
        TypedQuery<Course> theQuery = em.createQuery("select c from Course c order by c.courseName", Course.class);

        // execute query and get result list
        List<Course> courses = theQuery.getResultList();

        // return the results
        return courses;
    }

    @Override
    public List<Student> getAllStudents() {

        // create a query
        TypedQuery<Student> theQuery = em.createQuery("select s from Student s order by s.studentName", Student.class);

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        // return the results
        return students;
    }

    @Override
    public List<Teacher> getAllTeachers()
    {

        // create a query
        TypedQuery<Teacher> theQuery = em.createQuery("select t from Teacher t order by t.teacherName", Teacher.class);

        // execute query and get result list
        List<Teacher> teachers = theQuery.getResultList();

        // return the results
        return teachers;
    }

    @Override
    public List<TeacherCourse> getAllTeacherCourses() {

        // create a query
        TypedQuery<TeacherCourse> theQuery = em.createQuery("select tc from TeacherCourse tc order by tc.teacherCourseId", TeacherCourse.class);

        // execute query and get result list
        List<TeacherCourse> teacherCourse = theQuery.getResultList();

        // return the results
        return teacherCourse;
    }

    @Override
    public List<StudentTeacherCourse> getAllStudentTeacherCourses() {

        // create a query
        TypedQuery<StudentTeacherCourse> theQuery = em.createQuery("select stc from StudentTeacherCourse stc order by stc.studentTeacherCourseId", StudentTeacherCourse.class);

        // execute query and get result list
        List<StudentTeacherCourse> studentCourse = theQuery.getResultList();

        // return the results
        return studentCourse;
    }

    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        // save/update the passenger ... finally LOL // did not work for Update so i changed it to .merge();
        //
        em.merge(theCourse);
    }

    @Override
    @Transactional
    public void saveStudent(Student theStudent) {
        // save/update the passenger ... finally LOL // did not work for Update so i changed it to .merge();
        //
        em.merge(theStudent);
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher theTeacher) {
        // save/update the passenger ... finally LOL // did not work for Update so i changed it to .merge();
        //
        em.merge(theTeacher);
    }

    @Override
    @Transactional
    public void saveTeacherCourse(TeacherCourse theTeacherCourse) {
        // save/update the passenger ... finally LOL // did not work for Update so i changed it to .merge();
        //
        em.merge(theTeacherCourse);
    }

    @Override
    @Transactional
    public void saveStudentTeacherCourse(StudentTeacherCourse theStudentTeacherCourse) {
        // save/update the passenger ... finally LOL // did not work for Update so i changed it to .merge();
        //
        em.merge(theStudentTeacherCourse);
    }

    @Override
    public Course getCourseById(int courseId) {
        // now retrieve/read from database using the primary key
        Course theCourse = em.find(Course.class, courseId);
        return theCourse;
    }

    @Override
    public Student getStudentById(int studentId) {
        // now retrieve/read from database using the primary key
        Student theStudent = em.find(Student.class, studentId);
        return theStudent;
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        // now retrieve/read from database using the primary key
        Teacher theTeacher = em.find(Teacher.class, teacherId);
        return theTeacher;
    }

    @Override
    public TeacherCourse getTeacherCourseById(int teacherCourseId) {
        // now retrieve/read from database using the primary key
        TeacherCourse theTeacherCourse = em.find(TeacherCourse.class, teacherCourseId);
        return theTeacherCourse;
    }

    @Override
    public StudentTeacherCourse getStudentTeacherCourseById(int studentCourseId) {
        // now retrieve/read from database using the primary key
        StudentTeacherCourse theStudentTeacherCourse = em.find(StudentTeacherCourse.class, studentCourseId);
        return theStudentTeacherCourse;
    }

    @Override
    public  void deleteCourse(int theCourseId){
        // delete object with primary key
        em.createQuery("delete from Course c where c.courseId = :courseId")
                .setParameter("courseId", theCourseId)
                .executeUpdate();
    }

    @Override
    public  void deleteStudent(int theStudentId){
        // delete object with primary key
        em.createQuery("delete from Student s where s.studentId = :studentId")
                .setParameter("studentId", theStudentId)
                .executeUpdate();
    }

    @Override
    public  void deleteTeacher(int theTeacherId){
        // delete object with primary key
        em.createQuery("delete from Teacher t where t.teacherId = :teacherId")
                .setParameter("teacherId", theTeacherId)
                .executeUpdate();
    }

    @Override
    public  void deleteTeacherCourse(int theTeacherCourseId){
        // delete object with primary key
        em.createQuery("delete from TeacherCourse tc where tc.teacherCourseId = :teacherCourseId")
                .setParameter("teacherCourseId", theTeacherCourseId)
                .executeUpdate();
    }

    @Override
    public  void deleteStudentTeacherCourse(int theStudentTeacherCourseId){
        // delete object with primary key
        em.createQuery("delete from StudentTeacherCourse stc where stc.studentTeacherCourseId = :studentTeacherCourseId")
                .setParameter("studentTeacherCourseId", theStudentTeacherCourseId)
                .executeUpdate();
    }

    @Override
    public List<StudentTeacherCourse> getStudentTeacherCourseBasedOnStudentId(int theStudentId) {
        return em.createQuery("select stc from StudentTeacherCourse stc where stc.student.studentId = :studentId"
                ,StudentTeacherCourse.class)
                .setParameter("studentId",theStudentId)
                .getResultList();

    }

    @Override
    public List<StudentTeacherCourse> getStudentTeacherCourseBasedOnTeacherId(int theTeacherId) {
        return em.createQuery("select stc from StudentTeacherCourse stc where stc.teacherCourse.teacher.teacherId= :teacherId"
                ,StudentTeacherCourse.class)
                .setParameter("teacherId",theTeacherId)
                .getResultList();
    }

    @Override
    public List<StudentTeacherCourse> getStudentTeacherCourseBasedOnCourseId(int theCourseId) {
        return em.createQuery("select stc from StudentTeacherCourse stc where stc.teacherCourse.course.courseId= :courseId"
                ,StudentTeacherCourse.class)
                .setParameter("courseId",theCourseId)
                .getResultList();
    }

}
