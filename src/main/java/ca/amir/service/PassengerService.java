package ca.amir.service;

import java.util.ArrayList;
import java.util.List;
import ca.amir.entity.Passenger;

public interface PassengerService {
    public List<Passenger> getPassengers();
    public void savePassenger(Passenger thePassenger);
    public ArrayList<Passenger> getListOfPassengersBasedOnTheDestinationCity(String theCity);
    public Passenger getPassenger(int theId);
    public void deletePassenger(int theId);
    public Passenger getPassengerByFamily(String theFamily);
    public ArrayList<Passenger> getListOfPassengersBasedOnTheDepartureDate(String theDepartureDate);
    public ArrayList<Passenger>  getListOfPassengersBasedOnTheDepartureDateAndDestinationCity(String theDepartureDate, String theDestinationCity);


}
