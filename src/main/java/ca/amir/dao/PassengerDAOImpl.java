package ca.amir.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import ca.amir.entity.Passenger;

// @Repository will handle translation to JDBC exceptions
@Repository
public class PassengerDAOImpl implements PassengerDAO {
    // need to inject the session factory
    // SessionFactory is a bean defined in spring-hibernate-crud.xml
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Passenger> getPassengers() {

        // By using @Transactional annotation Spring will automatically call
        // session.beginTransaction() at the beginning and session.getTransaction().commit() at the end

        // get the current hibernate session
        Session currentSession = sessionFactory.openSession();

        // create a query
        Query<Passenger> theQuery = currentSession.createQuery("from Passenger order by lastName", Passenger.class);

        // execute query and get result list
        List<Passenger> passengers = theQuery.getResultList();

        // return the results
        return passengers;
    }

    @Override
    public void savePassenger(Passenger thePassenger) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // save/update the passenger ... finally LOL
        currentSession.saveOrUpdate(thePassenger);

    }

    @Override
    public Passenger getPassenger(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // now retrieve/read from database using the primary key
        Passenger thePassenger = currentSession.get(Passenger.class, theId);

        return thePassenger;
    }

    @Override
    public Passenger getPassengerByFamily(String theFamily) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // now retrieve/read from database using the family
        Query theQuery = currentSession.createQuery("select p from Passenger p where p.lastName=:passengerFamily");
        theQuery.setParameter("passengerFamily", theFamily);
        Passenger passenger = (Passenger) theQuery.uniqueResult();
        return passenger;

    }

    @Override
    public ArrayList<Passenger> getListOfPassengersBasedOnTheDestinationCity(String theCity) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("select passenger from Passenger passenger where passenger.toCity=:passengerDestination");
        theQuery.setParameter("passengerDestination", theCity);
        ArrayList<Passenger> listOfPassengersBasedOnTheDestinationCity = (ArrayList<Passenger>) theQuery.getResultList();
        return listOfPassengersBasedOnTheDestinationCity;
    }

    @Override
    public ArrayList<Passenger> getListOfPassengersBasedOnTheDepartureDate(String theDepartureDate) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("select passenger from Passenger passenger where passenger.departureDate=:passengerDepartureDate");
        theQuery.setParameter("passengerDepartureDate", theDepartureDate);
        ArrayList<Passenger> listOfPassengersBasedOnTheDepartureDate = (ArrayList<Passenger>) theQuery.getResultList();
        return listOfPassengersBasedOnTheDepartureDate;
    }

    @Override
    public ArrayList<Passenger> getListOfPassengersBasedOnTheDepartureDateAndDestinationCity(String theDepartureDate, String theDestinationCity) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("select passenger from Passenger passenger where passenger.departureDate=:passengerDepartureDate and passenger.toCity=:passengerDestinationCity");
        theQuery.setParameter("passengerDepartureDate", theDepartureDate);
        theQuery.setParameter("passengerDestinationCity", theDestinationCity);
        ArrayList<Passenger> getListOfPassengersBasedOnTheDepartureDateAndDestinationCity = (ArrayList<Passenger>) theQuery.getResultList();
        return getListOfPassengersBasedOnTheDepartureDateAndDestinationCity;
    }

    @Override
    public void deletePassenger(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Passenger where id=:passengerId");
        theQuery.setParameter("passengerId", theId);

        theQuery.executeUpdate();
    }
}