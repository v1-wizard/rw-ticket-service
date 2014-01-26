package ru.electrictower.rwts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.beans.Passenger;
import ru.electrictower.rwts.beans.PassengersList;
import ru.electrictower.rwts.beans.Trip;
import ru.electrictower.rwts.beans.impl.PropCustomer;
import ru.electrictower.rwts.beans.impl.PropPassengersList;
import ru.electrictower.rwts.beans.impl.PropTrip;
import ru.electrictower.rwts.flows.FlowExecutionException;
import ru.electrictower.rwts.flows.UserFlow;
import ru.electrictower.rwts.flows.UserFlowFactory;

/**
 * @author Aliaksei Boole
 */
public class Main
{
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        try
        {
            Customer customer = PropCustomer.INSTANCE;
            Trip trip = PropTrip.INSTANCE;
            PassengersList passengersList = PropPassengersList.INSTANCE;

            while (passengersList.hasNext())
            {
                driver.get("http://poezd.rw.by/wps/portal/home/rp");
                Passenger passenger = passengersList.getNext();
                UserFlow searchAndBuyFlow = UserFlowFactory.createSearchAndBuyFlow(customer, trip, passenger, driver);
                searchAndBuyFlow.play();
            }
        }
        catch (FlowExecutionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.close();
        }
    }
}
