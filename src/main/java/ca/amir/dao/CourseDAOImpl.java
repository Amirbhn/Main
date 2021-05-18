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
    public List<Teacher> getAllTeachers() {

        // create a query
        TypedQuery<Teacher> theQuery = em.createQuery("from Teacher order by teacherName", Teacher.class);

        // execute query and get result list
        List<Teacher> teachers = theQuery.getResultList();

        // return the results
        return teachers;
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
        /*TypedQuery<Course> theQuery = em.createQuery("delete from Course c where c.courseID=:courseId and e.completedDate IS NULL", Course.class);
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
        /*TypedQuery<Course> theQuery = em.createQuery("delete from Course c where c.courseID=:courseId and e.completedDate IS NULL", Course.class);
        theQuery.setParameter("courseId", theCourseId);
        theQuery.executeUpdate();*/
    }
}
