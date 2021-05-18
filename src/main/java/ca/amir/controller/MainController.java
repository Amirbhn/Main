
package ca.amir.controller;

import java.util.List;
import ca.amir.entity.*;
import ca.amir.service.CourseService;
import ca.amir.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.amir.entity.Course;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/allCourses")
    @Transactional
    public String listOfAllCourses(Model theModel) {

        // get customers from the dao
        List<Course> theCourses = courseService.getAllCourses();
        List<Student> theStudents = courseService.getAllStudents();
        List<Teacher> theTeachers = courseService.getAllTeachers();

        // add the customers to the model
        theModel.addAttribute("allCourses", theCourses);
        theModel.addAttribute("allStudents", theStudents);
        theModel.addAttribute("allTeachers", theTeachers);
        return "list_of_all_entities";
    }


/*    @GetMapping("/allStudents")
    @Transactional
    public String listOfAllStudents(Model theModel) {

        // get Students from the dao
        List<Student> theStudents = courseService.getAllStudents();
        List<Course> theCourses = courseService.getAllCourses();


        // add the customers to the model
        theModel.addAttribute("allCourses", theCourses);
        theModel.addAttribute("allStudents", theStudents);
        return "list_of_all_entities";
    }*/

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

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {
        // save the Course using our service
        courseService.saveCourse(theCourse);
        return "redirect:/main/allCourses";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student theStudent) {
        // save the Student using our service
        courseService.saveStudent(theStudent);
        return "redirect:/main/allCourses";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher theTeacher) {
        // save the Student using our service
        courseService.saveTeacher(theTeacher);
        return "redirect:/main/allCourses";
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

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") int theCourseId) {
        // delete the passengers
        courseService.deleteCourse(theCourseId);
        return "redirect:/main/allCourses";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int theStudentId) {
        // delete the Students
        courseService.deleteStudent(theStudentId);
        return "redirect:/main/allCourses";
    }

    @GetMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("teacherId") int theTeacherId) {
        // delete the Teacher
        courseService.deleteTeacher(theTeacherId);
        return "redirect:/main/allCourses";
    }
}

