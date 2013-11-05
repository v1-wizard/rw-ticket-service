package rwts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import rwts.beans.Customer;
import rwts.beans.Order;
import rwts.beans.impl.YaCustomer;
import rwts.beans.impl.YaOrder;
import rwts.flows.FlowExecutionException;
import rwts.flows.UserFlow;
import rwts.flows.UserFlowFactory;

/**
 * User: aliaksei.bul
 * Date: 28.10.13
 * Time: 17:37
 */
public class Main
{
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();

        while (true)
        {
            try
            {
                Customer customer = new YaCustomer();
                Order order = new YaOrder();

                driver.get("http://poezd.rw.by/wps/portal/home/rp");

                UserFlow searchAndBuyFlow = UserFlowFactory.createSearchAndBuyFlow(customer, order, driver);
                searchAndBuyFlow.play();
            } catch (FlowExecutionException e)
            {
                e.printStackTrace();
            }
            finally
            {
                driver.close();
            }
        }
    }
}
