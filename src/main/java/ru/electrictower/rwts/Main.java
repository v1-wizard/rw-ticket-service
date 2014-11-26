package ru.electrictower.rwts;

import org.apache.commons.logging.LogFactory;
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

import java.util.concurrent.TimeUnit;

/**
 * @author Aliaksei Boole
 */
public class Main
{
    static
    {
        LogFactory.getFactory()
                .setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }


    public static void main(String[] args)
    {
        Customer customer = PropCustomer.INSTANCE;
        Trip trip = PropTrip.INSTANCE;
        PassengersList passengersList = PropPassengersList.INSTANCE;

        WebDriver driver = getWebDriver();

        try
        {
            NotNullValidator.checkCustomer(customer);
            NotNullValidator.checkPassengerList(passengersList);
            NotNullValidator.checkTrip(trip);

            while (passengersList.hasNext())
            {
                driver.get("http://poezd.rw.by");
                Passenger passenger = passengersList.getNext();
                NotNullValidator.checkPassenger(passenger);
                UserFlow searchAndBuyFlow = UserFlowFactory.createSearchAndBuyFlow(customer, trip, passenger, driver);
                searchAndBuyFlow.play();
            }
        }
        catch (FlowExecutionException e)
        {
            Sms.send(customer, "Rwts finish work with error!");
            e.printStackTrace();
        }
        finally
        {
            driver.close();
        }
    }

    private static WebDriver getWebDriver()
    {
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return firefoxDriver;
    }

}
