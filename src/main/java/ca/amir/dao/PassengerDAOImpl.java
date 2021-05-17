package ca.amir.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import ca.amir.entity.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

// @Repository will handle translation to JDBC exceptions
@Repository
public class PassengerDAOImpl implements PassengerDAO {
    // need to inject the session factory
    // SessionFactory is a bean defined in spring-hibernate-crud.xml

    private EntityManager em;

    @Override
    public List<Passenger> getPassengers() {
        // By using @Transactional annotation Spring will automatically call
        // session.beginTransaction() at the beginning and session.getTransaction().commit() at the end

        // create a query
        TypedQuery<Passenger> theQuery = em.createQuery("from Passenger order by lastName", Passenger.class);

        // execute query and get result list
        List<Passenger> passengers = theQuery.getResultList();

        // return the results
        return passengers;
    }

    @Override
    public void savePassenger(Passenger thePassenger) {
        // save/update the passenger ... finally LOL
        em.persist(thePassenger);
    }

    @Override
    public Passenger getPassenger(int theId) {
        // now retrieve/read from database using the primary key
        Passenger thePassenger = em.find(Passenger.class, theId);

        return thePassenger;
    }

    @Override
    public Passenger getPassengerByFamily(String theFamily) {
        // now retrieve/read from database using the family
        TypedQuery<Passenger> theQuery = em.createQuery("select p from Passenger p where p.lastName=:passengerFamily", Passenger.class);
        theQuery.setParameter("passengerFamily", theFamily);
        Passenger passenger = theQuery.getSingleResult();
        return passenger;

    }

    @Override
    public List<Passenger> getListOfPassengersBasedOnTheDestinationCity(String theCity) {
        TypedQuery<Passenger> theQuery = em.createQuery("select passenger from Passenger passenger where passenger.toCity=:passengerDestination", Passenger.class);
        theQuery.setParameter("passengerDestination", theCity);
        List<Passenger> listOfPassengersBasedOnTheDestinationCity = theQuery.getResultList();
        return listOfPassengersBasedOnTheDestinationCity;
    }

    @Override
    public List<Passenger> getListOfPassengersBasedOnTheDepartureDate(String theDepartureDate) {
        TypedQuery<Passenger> theQuery = em.createQuery("select passenger from Passenger passenger where passenger.departureDate=:passengerDepartureDate", Passenger.class);
        theQuery.setParameter("passengerDepartureDate", theDepartureDate);
        List<Passenger> listOfPassengersBasedOnTheDepartureDate = theQuery.getResultList();
        return listOfPassengersBasedOnTheDepartureDate;
    }

    @Override
    public List<Passenger> getListOfPassengersBasedOnTheDepartureDateAndDestinationCity(String theDepartureDate, String theDestinationCity) {
        TypedQuery<Passenger> theQuery = em.createQuery("select passenger from Passenger passenger where passenger.departureDate=:passengerDepartureDate and passenger.toCity=:passengerDestinationCity", Passenger.class);
        theQuery.setParameter("passengerDepartureDate", theDepartureDate);
        theQuery.setParameter("passengerDestinationCity", theDestinationCity);
        List<Passenger> getListOfPassengersBasedOnTheDepartureDateAndDestinationCity = theQuery.getResultList();
        return getListOfPassengersBasedOnTheDepartureDateAndDestinationCity;
    }

    @Override
    public void deletePassenger(int theId) {
        // delete object with primary key
        TypedQuery<Passenger> theQuery = em.createQuery("delete from Passenger where id=:passengerId", Passenger.class);
        theQuery.setParameter("passengerId", theId);
        theQuery.executeUpdate();
    }
}