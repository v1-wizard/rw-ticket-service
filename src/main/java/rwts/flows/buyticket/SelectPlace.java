package rwts.flows.buyticket;

import org.openqa.selenium.WebDriver;
import rwts.beans.Order;
import rwts.flows.FlowUnitExecutionException;
import rwts.pages.PassengersSelectPage;
import rwts.pages.WagonSelectPage;

/**
 *
 * @author Serj Sintsov
 * @since  11/5/13 8:58 PM
 */
public class SelectPlace extends BaseFlowUnit
{
    private WagonSelectPage wagonSelectPage;
    private PassengersSelectPage passengersSelectPage;

    private Order order;

    public SelectPlace(Order order, WebDriver driver)
    {
        wagonSelectPage = new WagonSelectPage(driver);
        passengersSelectPage = new PassengersSelectPage(driver);

        this.order = order;
    }

    @Override
    public void doExecute() throws FlowUnitExecutionException
    {
        wagonSelectPage.selectWagon(order);
        passengersSelectPage.selectPassenger(order);
    }

    @Override
    public boolean isMandatory() { return true; }
}
