package ru.electrictower.rwts.flows.buyticket;

import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Trip;
import ru.electrictower.rwts.flows.FlowUnitExecutionException;
import ru.electrictower.rwts.pages.RouteChoosePage;
import ru.electrictower.rwts.pages.TrainSelectPage;

import java.text.ParseException;

/**
 * @author Serj Sintsov
 * @since 11/5/13 8:58 PM
 */
public class SearchTrain extends BaseFlowUnit
{
    private final static int MAX_ATTEMPTS_COUNT = 1000;

    private TrainSelectPage trainSelectPage;
    private RouteChoosePage routeChoosePage;
    private Trip            trip;

    public SearchTrain(Trip trip, WebDriver driver)
    {
        routeChoosePage = new RouteChoosePage(driver);
        trainSelectPage = new TrainSelectPage(driver);
        this.trip = trip;
    }

    @Override
    public void doExecute() throws FlowUnitExecutionException
    {
        int attempt = 0;

        while (attempt < MAX_ATTEMPTS_COUNT)
        {
            tryToChooseRoute();

            try
            {
                if (trainSelectPage.selectTrain(trip))
                {
                    trainSelectPage.selectGoodTrain();
                    trainSelectPage.clickNext();
                    break;
                }
                else
                {
                    trainSelectPage.backToRouteChoosePage();
                    System.out.println("No ticket");
                }
            }
            catch (ParseException e)
            {
                throw new FlowUnitExecutionException("Can't parse trip time", e);
            }
        }

        if (attempt == MAX_ATTEMPTS_COUNT)
        {
            throw new FlowUnitExecutionException("Cannot find appropriate train or tickets");
        }
    }

    private int tryToChooseRoute()
    {
        int attempt = 0;

        while (attempt < MAX_ATTEMPTS_COUNT && !routeChoosePage.searchPossibleRoute(trip))
        {
            attempt++;
            sleep(1000);
        }

        return attempt;
    }

    private void sleep(long ms)
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

    @Override
    public boolean isMandatory()
    {
        return true;
    }
}
