package ca.amir.dao;

import ca.amir.entity.Passenger;

import java.util.ArrayList;
import java.util.List;

public interface PassengerDAO {
	 List<Passenger> getPassengers();
	 void savePassenger(Passenger thePassenger);
	 ArrayList<Passenger> getListOfPassengersBasedOnTheDestinationCity(String theCity);
	 Passenger getPassenger(int theId);
	 void deletePassenger(int theId);
	 Passenger getPassengerByFamily(String theFamily);
	 ArrayList<Passenger> getListOfPassengersBasedOnTheDepartureDate(String theDepartureDate);
	 ArrayList<Passenger>  getListOfPassengersBasedOnTheDepartureDateAndDestinationCity(String theDepartureDate, String theDestinationCity);
	
}