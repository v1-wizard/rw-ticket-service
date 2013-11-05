package rwts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import rwts.beans.Customer;
import rwts.beans.Order;
import rwts.beans.impl.CustomerImpl;
import rwts.beans.impl.OrderImpl;
import rwts.pages.*;

/**
 * User: aliaksei.bul
 * Date: 28.10.13
 * Time: 17:37
 */
public class Main
{


    public static void main(String[] args)
    {
        boolean get = false;
        while (!get)
        {
            WebDriver driver = new FirefoxDriver();
            try
            {
                boolean isTrainSelect;
                boolean isSearchResult;

                Customer customer = new CustomerImpl();
                Order order = new OrderImpl();

                HomePage homePage = new HomePage(driver);
                RulesPage rulesPage = new RulesPage(driver);
                RouteChoosePage routeChoosePage = new RouteChoosePage(driver);
                TrainSelectPage trainSelectPage = new TrainSelectPage(driver);
                WagonSelectPage wagonSelectPage = new WagonSelectPage(driver);
                PassengersSelectPage passengersSelectPage = new PassengersSelectPage(driver);
                VerifyPage verifyPage = new VerifyPage(driver);
                PayPage payPage = new PayPage(driver);
                CodePage codePage = new CodePage(driver);

                driver.get("http://poezd.rw.by/wps/portal/home/rp");
                homePage.login(customer, true);
                rulesPage.confirmWithRules();
                do
                {
                    do
                    {
                        isSearchResult = routeChoosePage.searchPossibleRoute(order);
                        if (!isSearchResult)
                        {
                            System.out.println("No train");
                            sleep(10000);
                        }
                    }
                    while (!isSearchResult);
                    isTrainSelect = trainSelectPage.selectTrain(order);
                    if (isTrainSelect)
                    {
                        trainSelectPage.selectGoodTrain();
                        trainSelectPage.clickNext();
                    }
                    else
                    {
                        trainSelectPage.backToRouteChoosePage();
                        System.out.println("No ticket");
                        sleep(10000);
                    }
                }
                while (!isTrainSelect);
				
                wagonSelectPage.selectWagon(order);
                passengersSelectPage.selectPassenger(order);
                verifyPage.clickNext();
                sleep(500);
                payPage.clickNext();
                sleep(500);
                codePage.sendSmsWithPayCode();
                get = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            finally
            {
                driver.close();
            }
        }
    }

    public static void sleep(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
