package ca.amir.service;
import java.util.List;
import ca.amir.entity.Passenger;

public interface PassengerService {
    public List<Passenger> getPassengers();
    public void savePassenger(Passenger thePassenger);
    public List<Passenger> getListOfPassengersBasedOnTheDestinationCity(String theCity);
    public Passenger getPassenger(int theId);
    public void deletePassenger(int theId);
    public Passenger getPassengerByFamily(String theFamily);
    public List<Passenger> getListOfPassengersBasedOnTheDepartureDate(String theDepartureDate);
    public List<Passenger> getListOfPassengersBasedOnTheDepartureDateAndDestinationCity(String theDepartureDate, String theDestinationCity);


}
