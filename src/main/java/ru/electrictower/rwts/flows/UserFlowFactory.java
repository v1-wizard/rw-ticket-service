package ru.electrictower.rwts.flows;

import com.google.common.collect.Lists;
import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.beans.Passenger;
import ru.electrictower.rwts.beans.PassengersList;
import ru.electrictower.rwts.beans.Trip;
import ru.electrictower.rwts.flows.buyticket.GoToTrainSearch;
import ru.electrictower.rwts.flows.buyticket.PurchaseOrder;
import ru.electrictower.rwts.flows.buyticket.SearchTrain;
import ru.electrictower.rwts.flows.buyticket.SelectPlace;

/**
 * @author Serj Sintsov
 */
public class UserFlowFactory
{
    public static UserFlow createSearchAndBuyFlow(Customer customer, Trip trip, Passenger passenger,
                                                  WebDriver webDriver)
    {
        UserFlow searchAndBuyFlow = new UserFlow();

        searchAndBuyFlow.setActions(Lists.<FlowUnit>newArrayList(
                new GoToTrainSearch(customer, webDriver),
                new SearchTrain(trip, webDriver),
                new SelectPlace(trip, passenger, webDriver),
                new PurchaseOrder(customer, webDriver)
        ));

        return searchAndBuyFlow;
    }
}
