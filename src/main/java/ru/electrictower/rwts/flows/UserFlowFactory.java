package ru.electrictower.rwts.flows;

import com.google.common.collect.Lists;
import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.beans.Order;
import ru.electrictower.rwts.flows.buyticket.GoToTrainSearch;
import ru.electrictower.rwts.flows.buyticket.PurchaseOrder;
import ru.electrictower.rwts.flows.buyticket.SearchTrain;
import ru.electrictower.rwts.flows.buyticket.SelectPlace;

/**
 * @author Serj Sintsov
 */
public class UserFlowFactory
{
    public static UserFlow createSearchAndBuyFlow(Customer customer, Order order, WebDriver webDriver)
    {
        UserFlow searchAndBuyFlow = new UserFlow();

        searchAndBuyFlow.setActions(Lists.<FlowUnit>newArrayList(
            new GoToTrainSearch(customer, webDriver),
            new SearchTrain(order, webDriver),
            new SelectPlace(order, webDriver),
            new PurchaseOrder(webDriver)
        ));

        return searchAndBuyFlow;
    }
}
