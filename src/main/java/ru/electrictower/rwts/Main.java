package ru.electrictower.rwts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.beans.Order;
import ru.electrictower.rwts.beans.impl.PropCustomer;
import ru.electrictower.rwts.beans.impl.PropOrder;
import ru.electrictower.rwts.flows.FlowExecutionException;
import ru.electrictower.rwts.flows.UserFlow;
import ru.electrictower.rwts.flows.UserFlowFactory;

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
                Customer customer = new PropCustomer();
                Order order = new PropOrder();

                driver.get("http://poezd.rw.by/wps/portal/home/rp");

                UserFlow searchAndBuyFlow = UserFlowFactory.createSearchAndBuyFlow(customer, order, driver);
                searchAndBuyFlow.play();
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
}
