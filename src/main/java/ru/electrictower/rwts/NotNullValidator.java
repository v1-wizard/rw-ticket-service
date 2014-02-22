package ru.electrictower.rwts;

import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.beans.Passenger;
import ru.electrictower.rwts.beans.PassengersList;
import ru.electrictower.rwts.beans.Trip;

import static org.apache.commons.lang.Validate.*;

/**
 * @author Aliaksei Boole
 */
public class NotNullValidator
{

    public static void checkCustomer(Customer customer)
    {
        notEmpty(customer.getLogin());
        notEmpty(customer.getPassword());
        notEmpty(customer.getPhone());
        notEmpty(customer.getSmsServiceId());
    }

    public static void checkPassengerList(PassengersList passengersList)
    {
        notEmpty(passengersList.getPassengers());
    }

    public static void checkPassenger(Passenger passenger)
    {
        notEmpty(passenger.getDocumentId());
        notEmpty(passenger.getLastName());
        notEmpty(passenger.getFirstName());
        notEmpty(passenger.getPatronymic());
    }

    public static void checkTrip(Trip trip)
    {
        notZero(trip.getCost());
        notEmpty(trip.getDepartureStation());
        notEmpty(trip.getDestinationStation());
        notEmpty(trip.getTime());
        notEmpty(trip.getTravelDate());
    }

    private static void notZero(int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("The validated integer is 0");
        }
    }
}
