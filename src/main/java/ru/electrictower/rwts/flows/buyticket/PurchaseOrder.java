package ru.electrictower.rwts.flows.buyticket;

import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.flows.FlowUnitExecutionException;
import ru.electrictower.rwts.pages.*;

/**
 * @author Serj Sintsov
 * @since 11/5/13 8:58 PM
 */
public class PurchaseOrder extends BaseFlowUnit
{
    private VerifyPage verifyPage;
    private PayPage    payPage;
    private CodePage   codePage;

    private Customer customer;

    public PurchaseOrder(Customer customer, WebDriver driver)
    {
        verifyPage = new VerifyPage(driver);
        payPage = new PayPage(driver);
        codePage = new CodePage(driver);

        this.customer = customer;
    }

    @Override
    public void doExecute() throws FlowUnitExecutionException
    {
        verifyPage.clickNext();
        payPage.clickNext();
        codePage.sendSmsWithPayCode(customer);
        codePage.logOut();
    }

    @Override
    public boolean isMandatory()
    {
        return true;
    }
}
