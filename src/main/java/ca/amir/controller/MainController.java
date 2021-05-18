
package ca.amir.controller;

import java.util.List;

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

        // add the customers to the model
        theModel.addAttribute("allCourses", theCourses);
        return "list_of_all_entities";
    }

    @GetMapping("/showFormForAddCourse")
    public String showFormForAddCourse(Model theModel) {
        // create model attribute to bind form data
        Course theCourse = new Course();
        theModel.addAttribute("course", theCourse);
        return "course-form";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {
        // save the Course using our service
        courseService.saveCourse(theCourse);
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

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") int theCourseId) {
        // delete the passengers
        courseService.deleteCourse(theCourseId);
        return "redirect:/main/allCourses";
    }
}

