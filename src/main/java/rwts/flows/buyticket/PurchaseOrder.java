package rwts.flows.buyticket;

import org.openqa.selenium.WebDriver;
import rwts.flows.FlowUnitExecutionException;
import rwts.pages.*;

/**
 * @author Serj Sintsov
 * @since  11/5/13 8:58 PM
 */
public class PurchaseOrder extends BaseFlowUnit
{
    private VerifyPage verifyPage;
    private PayPage payPage;
    private CodePage codePage;

    public PurchaseOrder(WebDriver driver)
    {
        verifyPage = new VerifyPage(driver);
        payPage = new PayPage(driver);
        codePage = new CodePage(driver);
    }

    @Override
    public void doExecute() throws FlowUnitExecutionException
    {
        verifyPage.clickNext();
        payPage.clickNext();
        codePage.sendSmsWithPayCode();
    }

    @Override
    public boolean isMandatory() { return true; }
}
