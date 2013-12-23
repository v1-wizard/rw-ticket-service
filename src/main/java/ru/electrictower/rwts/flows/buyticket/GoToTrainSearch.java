package ru.electrictower.rwts.flows.buyticket;

import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.flows.FlowUnitExecutionException;
import ru.electrictower.rwts.pages.HomePage;
import ru.electrictower.rwts.pages.RulesPage;

/**
 * @author Serj Sintsov
 * @since  11/5/13 8:58 PM
 */
public class GoToTrainSearch extends BaseFlowUnit
{
    private HomePage homePage;
    private RulesPage rulesPage;

    private Customer customer;

    public GoToTrainSearch(Customer customer, WebDriver driver)
    {
        homePage = new HomePage(driver);
        rulesPage = new RulesPage(driver);

        this.customer = customer;
    }

    @Override
    public void doExecute() throws FlowUnitExecutionException
    {
        homePage.login(customer, true);

        if (!homePage.isLogin())
            throw new FlowUnitExecutionException("Cannot login customer [%s]", customer);

        rulesPage.confirmWithRules();
    }

    @Override
    public boolean isMandatory() { return true; }
}
