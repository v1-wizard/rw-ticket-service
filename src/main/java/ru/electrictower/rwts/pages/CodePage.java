package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.electrictower.rwts.Sms;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.pages.blocks.UserBlock;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * @author Aliaksei Boole
 */
public class CodePage extends AbstractPage
{
    private UserBlock userBlock;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td/div[9]/h3/span[2]")
    private TextBlock codeText;
    @FindBy(xpath = "//a[contains(text(),'Выход из системы')]")
    private Link logOutLink;

    WebDriver driver;

    public CodePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void logOut()
    {
        userBlock.logOut();
    }

    public void sendSmsWithPayCode(Customer customer)
    {
        String code = codeText.getText();
        Sms.send(customer, "ЕРИП:" + code);
    }

}
