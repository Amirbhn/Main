package ca.amir.dao;
import ca.amir.entity.*;
import java.util.List;

import ca.amir.entity.Passenger;
import ca.amir.entity.Student;
import org.springframework.stereotype.Repository;
import ca.amir.entity.Course;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

// @Repository will handle translation to JDBC exceptions
@Repository
public class CourseDAOImpl implements CourseDAO {

    private final EntityManager em;



    public CourseDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Course> getAllCourses() {

        // create a query
        TypedQuery<Course> theQuery = em.createQuery("from Course order by courseName", Course.class);

        // execute query and get result list
        List<Course> courses = theQuery.getResultList();

        // return the results
        return courses;
    }

    @Override
    public List<Student> getAllStudents() {

        // create a query
        TypedQuery<Student> theQuery = em.createQuery("from Student order by studentName", Student.class);

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        // return the results
        return students;
    }

    @Override
    public List<Teacher> getAllTeachers()
    {

        // create a query
        TypedQuery<Teacher> theQuery = em.createQuery("from Teacher order by teacherName", Teacher.class);

        // execute query and get result list
        List<Teacher> teachers = theQuery.getResultList();

        // return the results
        return teachers;
    }

    @Override
    public List<TeacherCourse> getAllTeacherCourses() {

        // create a query
        TypedQuery<TeacherCourse> theQuery = em.createQuery("from TeacherCourse order by teacherCourseId", TeacherCourse.class);

        // execute query and get result list
        List<TeacherCourse> teacherCourse = theQuery.getResultList();

        // return the results
        return teacherCourse;
    }

    @Override
    public List<StudentCourse> getAllStudentCourses() {

        // create a query
        TypedQuery<StudentCourse> theQuery = em.createQuery("from StudentCourse order by studentCourseId", StudentCourse.class);

        // execute query and get result list
        List<StudentCourse> studentCourse = theQuery.getResultList();

        // return the results
        return studentCourse;
    }

    @Override
    public List<TeacherStudent> getAllTeacherStudents() {

        // create a query
        TypedQuery<TeacherStudent> theQuery = em.createQuery("from TeacherStudent order by teacherStudentId", TeacherStudent.class);

        // execute query and get result list
        List<TeacherStudent> teacherStudent = theQuery.getResultList();

        // return the results
        return teacherStudent;
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
    public void saveStudentCourse(StudentCourse theStudentCourse) {
        // save/update the passenger ... finally LOL // did not work for Update so i changed it to .merge();
        //
        em.merge(theStudentCourse);
    }

    @Override
    @Transactional
    public void saveTeacherStudent(TeacherStudent theTeacherStudent) {

        em.merge(theTeacherStudent);
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
    public StudentCourse getStudentCourseById(int studentCourseId) {
        // now retrieve/read from database using the primary key
        StudentCourse theStudentCourse = em.find(StudentCourse.class, studentCourseId);
        return theStudentCourse;
    }


    @Override
    public TeacherStudent getTeacherStudentById(int teacherStudentId) {
        // now retrieve/read from database using the primary key
        TeacherStudent theTeacherStudent = em.find(TeacherStudent.class, teacherStudentId);
        return theTeacherStudent;
    }


    @Override
    @Transactional
    public  void deleteCourse(int theCourseId){
        // delete object with primary key
        em.createNativeQuery("delete from Course where course_id=:courseId", Course.class)
                .setParameter("courseId", theCourseId)
                .executeUpdate();
        /*TypedQuery<Course> theQuery = em.createQuery("delete from Course c where c.courseID=:courseId and e.completedDate IS NULL", Course.class);
        theQuery.setParameter("courseId", theCourseId);
        theQuery.executeUpdate();*/
    }

    @Override
    @Transactional
    public  void deleteStudent(int theStudentId){
        // delete object with primary key
        em.createNativeQuery("delete from Student where student_id=:studentId", Student.class)
                .setParameter("studentId", theStudentId)
                .executeUpdate();
        /*TypedQuery<Course> theQuery = em.createQuery("delete from Course c where c.courseId=:courseId and e.completedDate IS NULL", Course.class);
        theQuery.setParameter("courseId", theCourseId);
        theQuery.executeUpdate();*/
    }

    @Override
    @Transactional
    public  void deleteTeacher(int theTeacherId){
        // delete object with primary key
        em.createNativeQuery("delete from Teacher where teacher_id=:teacherId", Teacher.class)
                .setParameter("teacherId", theTeacherId)
                .executeUpdate();
    }

    @Override
    @Transactional
    public  void deleteTeacherCourse(int theTeacherCourseId){
        // delete object with primary key
        em.createNativeQuery("delete from TeacherCourse where teacher_course_id=:teacherCourseId", TeacherCourse.class)
                .setParameter("teacherCourseId", theTeacherCourseId)
                .executeUpdate();
    }

    @Override
    @Transactional
    public  void deleteStudentCourse(int theStudentCourseId){
        // delete object with primary key
        em.createNativeQuery("delete from StudentCourse where student_course_id=:studentCourseId", StudentCourse.class)
                .setParameter("studentCourseId", theStudentCourseId)
                .executeUpdate();
    }

    @Override
    @Transactional
    public  void deleteTeacherStudent(int theTeacherStudentId){
        // delete object with primary key
        em.createNativeQuery("delete from TeacherStudent where teacher-student-id=:teacherStudentId", TeacherStudent.class)
                .setParameter("teacherStudentId", theTeacherStudentId)
                .executeUpdate();
    }


}
