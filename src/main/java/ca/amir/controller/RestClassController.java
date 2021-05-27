package ca.amir.controller;

import ca.amir.entity.StudentTeacherCourse;
import ca.amir.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class RestClassController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/allStudentTeacherCourseObjects")
    public List<StudentTeacherCourse> showListOfAllStudentTeacherCourseObjects() {
        return courseService.getAllStudentTeacherCourses();
    }

    @GetMapping("/StudentTeacherCourseObjects/student/{studentId}")
    public List<StudentTeacherCourse> showStudentTeacherCourseObjectsBasedOnStudentId(@PathVariable int studentId) {
        return courseService.getStudentTeacherCourseBasedOnStudentId(studentId);
    }

    @GetMapping("/StudentTeacherCourseObjects/teacher/{teacherId}")
    public List<StudentTeacherCourse> showStudentTeacherCourseObjectsBasedOnTeacherId(@PathVariable int teacherId) {
        return courseService.getStudentTeacherCourseBasedOnTeacherId(teacherId);
    }

    @GetMapping("/StudentTeacherCourseObjects/course/{courseId}")
    public List<StudentTeacherCourse> showStudentTeacherCourseObjectsBasedOnCourseId(@PathVariable int courseId) {
        return courseService.getStudentTeacherCourseBasedOnCourseId(courseId);
    }
}
