package ca.amir.controller;

import ca.amir.entity.Passenger;
import ca.amir.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PassengerRestController {

    @Autowired
    private PassengerService passengerService;

    //Test to be Sure Restful API is working
    @GetMapping("/hi")
    public String testApi() {
        return "Hi from API";
    }

    // Show list of all passengers:
    @GetMapping("/passengers")
    public List<Passenger> showListOfAllPassengers() {
        return passengerService.getPassengers();
    }

    // Show just one passenger by id:
    @GetMapping("/passenger/{passengerId}")
    public Passenger showPassengerById(@PathVariable int passengerId) {
        // jackson will return an empty body, and user does not know what was the problem
        Passenger thePassenger = passengerService.getPassenger(passengerId);
        return thePassenger;
    }

    // Find a passenger by family
    @GetMapping("/passengers/find/{passengerFamily}")
    public Passenger findThePassengerByFamily(@PathVariable String passengerFamily) {
        // jackson will return an empty body, and user does not know what was the problem
        Passenger thePassenger = passengerService.getPassengerByFamily(passengerFamily);
        return thePassenger;
    }

    // Show list of passengers based on the destination city
    @GetMapping("/passengers/city/{passengerDestination}")
    public List<Passenger> showListOfPassengersBasedOnTheDestinationCity(@PathVariable String passengerDestination) {
        List<Passenger> ListOfPassengersBasedOnTheDestinationCity =
                passengerService.getListOfPassengersBasedOnTheDestinationCity(passengerDestination);
        return ListOfPassengersBasedOnTheDestinationCity;
    }

    // Show list of passengers sorted by family
    @GetMapping("/passengers/sorted/family")
    public List<Passenger> showListOfPassengersSortedByFamily() {
        List<Passenger> allPassengers = passengerService.getPassengers();
        Collections.sort(allPassengers);
        return allPassengers;
    }

    // Show list of all passengers by departure date
    @GetMapping("/passengers/departuredate/{passengerDepartureDate}")
    public List<Passenger> getAllPassengersByDepartureDate(@PathVariable String passengerDepartureDate) {
        List<Passenger> ListOfPassengersBasedOnTheDepartureDate =
                passengerService.getListOfPassengersBasedOnTheDepartureDate(passengerDepartureDate);
        return ListOfPassengersBasedOnTheDepartureDate;
    }

    // Show list of all passengers by departure date and destination city
    @GetMapping("/passengers/find/date/{passengerDepartureDate}/city/{passengerDestinationCity}")
    public List<Passenger> showAllPassengersByDepartureDateAndDestinationCity(@PathVariable String passengerDepartureDate) {
        List<Passenger> ListOfPassengersBasedOnTheDepartureDate =
                passengerService.getListOfPassengersBasedOnTheDepartureDate(passengerDepartureDate);
        return ListOfPassengersBasedOnTheDepartureDate;
    }

    // ADD: add mapping for POST /passengers
    // @RequestBody bind JSON object to POJO object and
    // we do not need to manually convert JSON to POJO
    @PostMapping("/passengers")
    public Passenger addPassenger(@RequestBody Passenger thePassenger) {
        // Also just in case user passed an id in JSON ... set id to 0
        // id zero force to save new item ... instead of update
        // it is because of saveOrUpdate from session object method used in our DAO class
        thePassenger.setId(0);
        passengerService.savePassenger(thePassenger);
        return thePassenger;
    }

    // UPDATE: add mapping for PUT /passengers
    @PutMapping("/passengers")
    public Passenger updatePassenger(@RequestBody Passenger thePassenger) {
        passengerService.savePassenger(thePassenger);
        return thePassenger;
    }

    // DELETE: add mapping for DELETE /passengers/{passengerId}
    @DeleteMapping("/passengers/{passengerId}")
    public String deleteCustomer(@PathVariable int passengerId) {
        Passenger thePassenger = passengerService.getPassenger(passengerId);

        passengerService.deletePassenger(passengerId);
        return "Deleted passenger id - " + passengerId;
    }


}
