package ca.amir.dao;

import java.util.List;

import ca.amir.entity.Passenger;
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
    @Transactional
    public void saveCourse(Course theCourse) {
        // save/update the passenger ... finally LOL // did not work for Update so i changed it to .merge();
        //
        em.merge(theCourse);
    }

    @Override
    public Course getCourseById(int courseId) {
        // now retrieve/read from database using the primary key
        Course theCourse = em.find(Course.class, courseId);
        return theCourse;
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
}
