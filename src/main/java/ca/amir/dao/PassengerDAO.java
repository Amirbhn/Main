package ca.amir.dao;

import ca.amir.entity.Passenger;

import java.util.List;

public interface PassengerDAO {
	 List<Passenger> getPassengers();
	 void savePassenger(Passenger thePassenger);
	 List<Passenger> getListOfPassengersBasedOnTheDestinationCity(String theCity);
	 Passenger getPassenger(int theId);
	 void deletePassenger(int theId);
	 Passenger getPassengerByFamily(String theFamily);
	 List<Passenger> getListOfPassengersBasedOnTheDepartureDate(String theDepartureDate);
	 List<Passenger> getListOfPassengersBasedOnTheDepartureDateAndDestinationCity(String theDepartureDate, String theDestinationCity);
	
}