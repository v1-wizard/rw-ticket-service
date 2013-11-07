package rwts.flows.buyticket;

import org.openqa.selenium.WebDriver;
import rwts.beans.Customer;
import rwts.flows.FlowUnitExecutionException;
import rwts.pages.HomePage;
import rwts.pages.RulesPage;

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
