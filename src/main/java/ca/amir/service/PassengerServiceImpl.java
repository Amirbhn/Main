package ca.amir.service;

import java.util.List;

import ca.amir.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.amir.dao.PassengerDAO;

@Service
public class PassengerServiceImpl implements PassengerService {
    // 1- Dependency Injection for passengerDAO
    @Autowired
    private PassengerDAO passengerDAO;

    @Override
    @Transactional
    public List<Passenger> getPassengers() {
        // 2- Delegate the call to passengerDAO
        return passengerDAO.getPassengers();
    }

    @Override
    @Transactional
    public void savePassenger(Passenger thePassenger) {
        passengerDAO.savePassenger(thePassenger);
    }

    @Override
    @Transactional
    public List<Passenger> getListOfPassengersBasedOnTheDestinationCity(String theCity){
        return passengerDAO.getListOfPassengersBasedOnTheDestinationCity(theCity);
    }

    @Override
    @Transactional
    public List<Passenger> getListOfPassengersBasedOnTheDepartureDate(String theDepartureDate){
        return passengerDAO.getListOfPassengersBasedOnTheDepartureDate(theDepartureDate);
    }

    @Override
    @Transactional
    public List<Passenger> getListOfPassengersBasedOnTheDepartureDateAndDestinationCity(String theDepartureDate, String theDestinationCity){
        return passengerDAO.getListOfPassengersBasedOnTheDepartureDateAndDestinationCity(theDepartureDate,theDestinationCity);
    }

    @Override
    @Transactional
    public Passenger getPassengerByFamily(String theFamily) {return passengerDAO.getPassengerByFamily(theFamily);}

    @Override
    @Transactional
    public Passenger getPassenger(int theId) {
        return passengerDAO.getPassenger(theId);
    }

    @Override
    @Transactional
    public void deletePassenger(int theId) {
        passengerDAO.deletePassenger(theId);
    }

}