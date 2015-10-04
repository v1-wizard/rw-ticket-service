package ru.electrictower.rwts;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
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
public class Main {
    static {
        LogFactory.getFactory()
                .setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }


    public static void main(String[] args) {
        Customer customer = PropCustomer.INSTANCE;
        Trip trip = PropTrip.INSTANCE;
        PassengersList passengersList = PropPassengersList.INSTANCE;

        WebDriver driver = getWebDriver();

        try {
            NotNullValidator.checkCustomer(customer);
            NotNullValidator.checkPassengerList(passengersList);
            NotNullValidator.checkTrip(trip);

            while (passengersList.hasNext()) {
                driver.get("http://poezd.rw.by");
                Passenger passenger = passengersList.getNext();
                NotNullValidator.checkPassenger(passenger);
                UserFlow searchAndBuyFlow = UserFlowFactory.createSearchAndBuyFlow(customer, trip, passenger, driver);
                searchAndBuyFlow.play();
            }

        } catch (FlowExecutionException e) {
            Sms.send(customer, "Rwts finish work with error!");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static WebDriver getWebDriver() {
        Capabilities caps = configWebDriver();
        return new PhantomJSDriver(caps);
    }

    private static Capabilities configWebDriver() {
        DesiredCapabilities dCaps = new DesiredCapabilities();
        dCaps.setCapability("takesScreenshot", true);
        dCaps.setCapability(
                PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent",
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/53 (KHTML, like Gecko) Chrome/15.0.87"
        );
        dCaps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "path_to_phantom_js"
        );
        return dCaps;
    }

}
