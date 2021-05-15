package ca.amir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.amir.entity.Passenger;
import ca.amir.service.PassengerService;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/list")
    public String listPassengers(Model theModel) {

        // get customers from the dao
        List<Passenger> thePassengers = passengerService.getPassengers();

        // add the customers to the model
        theModel.addAttribute("passengers", thePassengers);
        return "list-passengers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Passenger thePassenger = new Passenger();
        theModel.addAttribute("passenger", thePassenger);
        return "passenger-form";
    }

    @PostMapping("/savePassenger")
    public String savePassenger(@ModelAttribute("passenger") Passenger thePassenger) {
        // save the Passenger using our service
        passengerService.savePassenger(thePassenger);
        return "redirect:/passenger/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("passengerId") int theId, Model theModel) {
        // get the passenger from our service
        Passenger thePassenger = passengerService.getPassenger(theId);
        // set passenger as a model attribute to pre-populate the form
        theModel.addAttribute("passenger", thePassenger);
        // send over to our form
        return "passenger-form";
    }

    @GetMapping("/delete")
    public String deletePassenger(@RequestParam("passengerId") int theId) {
        // delete the passengers
        passengerService.deletePassenger(theId);
        return "redirect:/passenger/list";
    }
}