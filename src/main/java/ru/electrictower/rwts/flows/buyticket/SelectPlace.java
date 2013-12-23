package ru.electrictower.rwts.flows.buyticket;

import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Order;
import ru.electrictower.rwts.flows.FlowUnitExecutionException;
import ru.electrictower.rwts.pages.PassengersSelectPage;
import ru.electrictower.rwts.pages.WagonSelectPage;

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
