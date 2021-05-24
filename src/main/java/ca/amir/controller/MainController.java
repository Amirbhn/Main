
package ca.amir.controller;

import ca.amir.entity.*;
import ca.amir.service.CourseService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/allEntities")
    @Transactional
    public String listOfAllEntities(Model theModel) {
        // get customers from the dao
        List<Course> theCourses = courseService.getAllCourses();
        List<Student> theStudents = courseService.getAllStudents();
        List<Teacher> theTeachers = courseService.getAllTeachers();
        List<TeacherCourse> theTeacherCourses = courseService.getAllTeacherCourses();
        List<StudentTeacherCourse> theStudentTeacherCourses = courseService.getAllStudentTeacherCourses();

        // add the customers to the model
        theModel.addAttribute("objects", new AllEntityForm(
            theCourses,
            theStudents,
            theTeachers,
            theTeacherCourses,
            theStudentTeacherCourses
        ));
        return "list_of_all_entities";
    }

    @Value
    public static class AllEntityForm {
        List<Course> theCourses;
        List<Student> theStudents;
        List<Teacher> theTeachers;
        List<TeacherCourse> theTeacherCourses;
        List<StudentTeacherCourse> theStudentTeacherCourses;
    }

    @GetMapping("/showFormForAddCourse")
    public String showFormForAddCourse(Model theModel) {
        // create model attribute to bind form data
        Course theCourse = new Course();
        theModel.addAttribute("course", theCourse);
        return "course-form";
    }

    @GetMapping("/showFormForAddStudent")
    public String showFormForAddStudent(Model theModel) {
        // create model attribute to bind form data
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "student-form";
    }

    @GetMapping("/showFormForAddTeacher")
    public String showFormForAddTeacher(Model theModel) {
        // create model attribute to bind form data
        Teacher theTeacher = new Teacher();
        theModel.addAttribute("teacher", theTeacher);
        return "teacher-form";
    }

    @RequestMapping(value = "/showFormForAddTeacherCourse", method = {RequestMethod.GET, RequestMethod.POST})
    public String showFormForAddTeacherCourse(
        Model theModel,
        @RequestParam(value = "teacherId", required = false) Integer teacherId,
        @RequestParam(value = "courseId", required = false) Integer courseId,
        @RequestParam(value = "submit", required = false) String submit
    ) {
        if ("1".equals(submit)) {
            Course course = courseService.getCourseById(courseId);
            Teacher teacher = courseService.getTeacherById(teacherId);
            TeacherCourse teacherCourse = new TeacherCourse();
            teacherCourse.setCourse(course);
            teacherCourse.setTeacher(teacher);
            courseService.saveTeacherCourse(teacherCourse);
        }

        List<Course> courses = courseService.getAllCourses();
        List<Teacher> teachers = courseService.getAllTeachers();
        Map<String, Object> objects = new HashMap<>();
        objects.put("teachers", teachers);
        objects.put("courses", courses);
        theModel.addAttribute("objects", objects);
        return "/teacher-course-form";
    }

    @RequestMapping(value = "/showFormForAddStudentCourse", method = {RequestMethod.GET, RequestMethod.POST})
    public String showFormForAddStudentCourse(
        Model model,
        @RequestParam(value = "studentId", required = false) Integer studentId,
        @RequestParam(value = "teacherCourseIdSelected", required = false) Integer[] teacherCourseIdSelected,
        @RequestParam(value = "submit", required = false) String submit) {
        if ("1".equals(submit)) {
            for (Integer teacherCourseId : teacherCourseIdSelected) {
                List<StudentTeacherCourse> studentTeacherCourses = courseService.getAllStudentTeacherCourses();

                boolean hasDuplicate = studentTeacherCourses
                    .stream()
                    .anyMatch(studentTeacherCourse ->
                        studentTeacherCourse.getStudent().getStudentId() == studentId &&
                            teacherCourseId == studentTeacherCourse.getStudentTeacherCourseId());
                if (hasDuplicate) {
                    return "this-course-has-already-been-added";
                }

                StudentTeacherCourse newStudentTeacherCourse = new StudentTeacherCourse();
                TeacherCourse course = courseService.getTeacherCourseById(teacherCourseId);
                Student student = courseService.getStudentById(studentId);
                newStudentTeacherCourse.setStudent(student);
                newStudentTeacherCourse.setTeacherCourse(course);
                courseService.saveStudentTeacherCourse(newStudentTeacherCourse);
            }
        }

        List<Student> students = courseService.getAllStudents();
        List<TeacherCourse> teacherCourses = courseService.getAllTeacherCourses();
        model.addAttribute("objects", new StudentCourseForm(students, teacherCourses));

        return "student-course-form";
    }

    @Value
    public static class StudentCourseForm {
        List<Student> students;
        List<TeacherCourse> teacherCourses;
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {
        // save the Course using our service
        courseService.saveCourse(theCourse);
        return "redirect:/main/allEntities";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student theStudent) {
        // save the Student using our service
        courseService.saveStudent(theStudent);
        return "redirect:/main/allEntities";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher theTeacher) {
        // save the Student using our service
        courseService.saveTeacher(theTeacher);
        return "redirect:/main/allEntities";
    }

    @PostMapping("/saveTeacherCourse")
    public String saveTeacherCourse(@ModelAttribute("teacherCourse") TeacherCourse theTeacherCourse) {
        // save the Student using our service
        courseService.saveTeacherCourse(theTeacherCourse);
        return "redirect:/main/allEntities";
    }

    @GetMapping("/showFormForUpdateCourse")
    public String showFormForUpdateCourse(@RequestParam("courseId") int theCourseId, Model theModel) {
        // get the passenger from our service
        Course theCourse = courseService.getCourseById(theCourseId);
        // set passenger as a model attribute to pre-populate the form
        theModel.addAttribute("course", theCourse);
        // send over to our form
        return "course-form";
    }

    @GetMapping("/showFormForUpdateStudent")
    public String showFormForUpdateStudent(@RequestParam("studentId") int theStudentId, Model theModel) {
        // get the passenger from our service
        Student theStudent = courseService.getStudentById(theStudentId);
        // set Student as a model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);
        // send over to our form
        return "student-form";
    }

    @GetMapping("/showFormForUpdateTeacher")
    public String showFormForUpdateTeacher(@RequestParam("teacherId") int theTeacherId, Model theModel) {
        // get the Teacher from our service
        Teacher theTeacher = courseService.getTeacherById(theTeacherId);
        // set Teacher as a model attribute to pre-populate the form
        theModel.addAttribute("teacher", theTeacher);
        // send over to our form
        return "teacher-form";
    }

    @GetMapping("/showFormForUpdateTeacherCourse")
    public String showFormForUpdateTeacherCourse(@RequestParam("teacherCourseId") int theTeacherCourseId, Model theModel) {
        // get the Teacher from our service
        TeacherCourse theTeacherCourse = courseService.getTeacherCourseById(theTeacherCourseId);
        // set Teacher as a model attribute to pre-populate the form
        theModel.addAttribute("teacherCourse", theTeacherCourse);
        // send over to our form
        return "teacher-course-form";
    }

    @RequestMapping("/showListOfStudentsBasedOnTeacherName")
    public String showListOfStudentsBasedOnTeacherId(
        @RequestParam(value = "teacherId") Integer teacherId,
        @RequestParam(value = "studentTeacherCourseId", required = false) Integer studentTeacherCourseId,
        @RequestParam(value = "grade", required = false) Double grade,
        Model model) {

        if (studentTeacherCourseId != null) {
            StudentTeacherCourse studentTeacherCourse = courseService.getStudentTeacherCourseById(studentTeacherCourseId);
            studentTeacherCourse.setGrade(grade);
            courseService.saveStudentTeacherCourse(studentTeacherCourse);
        }

        Teacher theTeacher = courseService.getTeacherById(teacherId);

        // get all courses that this teacher offers
        List<TeacherCourse> teacherCourses =
            courseService
                .getAllTeacherCourses()
                .stream()
                .filter(tc -> tc.getTeacher().getTeacherId() == teacherId)
                .toList();

        // create a function to check if any TeacherCourse is in the offered courses list
        Function<TeacherCourse, Boolean> doesTheTeacherOffer = tc -> teacherCourses
            .stream()
            .anyMatch(offeredTc -> offeredTc.getTeacherCourseId() == tc.getTeacherCourseId());

        // retrieve all student registrations to the offered courses
        List<StudentTeacherCourse> studentTeacherCourses = courseService
            .getAllStudentTeacherCourses()
            .stream()
            .filter(stc -> doesTheTeacherOffer.apply(stc.getTeacherCourse()))
            .toList();

        model.addAttribute("objects", new TeacherStudentForm(theTeacher, studentTeacherCourses));

        return "teacher-student-form";
    }

    @Value
    public static class TeacherStudentForm {
        Teacher theTeacher;
        List<StudentTeacherCourse> studentTeacherCourses;
    }

/*    @GetMapping("/getTeacherId")
    public String getTeacherId(HttpServletRequest request, Model model) {
        int selectedTeacherId = parseInt(request.getParameter("teacherId"));
        model.addAttribute("teacherId", selectedTeacherId);
        return "get-teacher-id";
    }*/

    @GetMapping("/getTeacherId")
    public String getTeacherId(Model model) {
        List<Teacher> teachers = courseService.getAllTeachers();
        model.addAttribute("objects", new TeacherSelectForm(teachers));
        return "get-teacher-name";
    }

    @Value
    public static class TeacherSelectForm {
        List<Teacher> teachers;
    }

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") int theCourseId) {
        // delete the passengers
        courseService.deleteCourse(theCourseId);
        return "redirect:/main/allEntities";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int theStudentId) {
        // delete the Students
        courseService.deleteStudent(theStudentId);
        return "redirect:/main/allEntities";
    }

    @GetMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("teacherId") int theTeacherId) {
        // delete the Teacher
        courseService.deleteTeacher(theTeacherId);
        return "redirect:/main/allEntities";
    }

    @GetMapping("/deleteTeacherCourse")
    public String deleteTeacherCourse(@RequestParam("teacherCourseId") int theTeacherCourseId) {
        // delete the TeacherCourse
        courseService.deleteTeacherCourse(theTeacherCourseId);
        return "redirect:/main/allEntities";
    }

}

/*    @GetMapping("/showFormForAddCourse")
    public String showFormForAddCourse(Model theModel) {
        // create model attribute to bind form data
        Course theCourse = new Course();
        theModel.addAttribute("course", theCourse);
        return "course-form";
    }*/