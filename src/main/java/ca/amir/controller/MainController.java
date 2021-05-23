
package ca.amir.controller;

import java.util.*;

import ca.amir.entity.*;
import ca.amir.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.amir.entity.Course;

import javax.transaction.Transactional;

import static java.lang.Integer.parseInt;

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
        List<StudentCourse> theStudentCourses = courseService.getAllStudentCourses();

        // add the customers to the model
        theModel.addAttribute("allCourses", theCourses);
        theModel.addAttribute("allStudents", theStudents);
        theModel.addAttribute("allTeachers", theTeachers);
        theModel.addAttribute("allTeacherCourses", theTeacherCourses);
        theModel.addAttribute("allStudentCourses", theStudentCourses);
        return "list_of_all_entities";
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

    @RequestMapping(value = "/showFormForAddStudentCourse", method = {RequestMethod.GET, RequestMethod.POST} )
    public String showFormForAddStudentCourse(Model theModel,
                                              @RequestParam(value = "studentId", required = false) Integer studentId,
                                              @RequestParam(value = "courseIdSelected", required = false) Integer[] courseIdSelected,
                                              @RequestParam(value = "submit", required = false) String submit) {
        if ("1".equals(submit)) {
            for (Integer courseId : courseIdSelected) {
                List<StudentCourse> studentCourse = courseService.getAllStudentCourses();
                for (StudentCourse studentCourse1 : studentCourse) {
                    if (studentCourse1.getStudent().getStudentId() == studentId && studentCourse1.getCourse().getCourseId() == courseId) {
                        return "this-course-has-already- been-added";
                    }
                }
                StudentCourse newStudentCourse = new StudentCourse();
                Course course = courseService.getCourseById(courseId);
                Student student = courseService.getStudentById(studentId);
                newStudentCourse.setStudent(student);
                newStudentCourse.setCourse(course);
                courseService.saveStudentCourse(newStudentCourse);
            }
        }

        List<Student> students = courseService.getAllStudents();
        List<Course> courses = courseService.getAllCourses();

        Map<String, Object> objects = new HashMap<>();
        objects.put("students", students);
        objects.put("courses", courses);

        theModel.addAttribute("objects", objects);
        return "student-course-form";
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

    @RequestMapping(value = "/showFormForAddTeacherStudent",method = {RequestMethod.GET,RequestMethod.POST})
    public String showFormForAddTeacherStudent(
            Model model,
            @RequestParam("theTeacher") String teacherName ){
        return "teacher-student-form";
    }

    @GetMapping("/showListOfStudentsBasedOnTeacherName")
    public String showListOfStudentsBasedOnTeacherId(
            @RequestParam("teacherName") String teacherName,
            Model model) {

        List<TeacherCourse> teacherCourses = courseService.getAllTeacherCourses();
        List<StudentCourse> studentCourses = courseService.getAllStudentCourses();
        List <Student>students = new ArrayList<>();
        Teacher theTeacher = new Teacher();

        int courseIdAssociatedWithTeacher = 0;

        for (TeacherCourse teacherCourse : teacherCourses) {
            if (teacherCourse.getTeacher().getTeacherName().equals(teacherName)) {
                courseIdAssociatedWithTeacher = teacherCourse.getCourse().getCourseId();
            theTeacher = teacherCourse.getTeacher();}}
        for (StudentCourse studentCourse :studentCourses){
            if(studentCourse.getCourse().getCourseId()==courseIdAssociatedWithTeacher){
                students.add(studentCourse.getStudent());
            }
            model.addAttribute("theTeacher",theTeacher);
            model.addAttribute("students",students);
        }
        return "teacher-student-form";
    }

/*    @GetMapping("/getTeacherId")
    public String getTeacherId(HttpServletRequest request, Model model) {
        int selectedTeacherId = parseInt(request.getParameter("teacherId"));
        model.addAttribute("teacherId", selectedTeacherId);
        return "get-teacher-id";
    }*/

    @GetMapping("/getTeacherId")
    public String getTeacherId() {
        return "get-teacher-name";
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