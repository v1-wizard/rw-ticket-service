package rwts.flows;

import com.google.common.collect.Lists;
import org.openqa.selenium.WebDriver;
import rwts.beans.Customer;
import rwts.beans.Order;
import rwts.flows.buyticket.GoToTrainSearch;
import rwts.flows.buyticket.PurchaseOrder;
import rwts.flows.buyticket.SearchTrain;
import rwts.flows.buyticket.SelectPlace;

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
