package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.electrictower.rwts.beans.Customer;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Aliaksei Boole
 */
public class CodePage extends AbstractPage
{
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td/div[9]/h3/span[2]")
    TextBlock codeText;
    @FindBy(xpath = "//a[contains(text(),'Выход из системы')]")
    Link      logOutLink;

    WebDriver driver;

    public CodePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void logOut()
    {
        logOutLink.click();
    }

    public void sendSmsWithPayCode(Customer customer)
    {
        String code = codeText.getText();
        try
        {
            sendGetForSms(customer, code);
        }
        catch (Exception e)
        {
            System.out.println("Sms didn't send");
        }
    }

    private void sendGetForSms(Customer customer, String code) throws Exception
    {
        String url = String.format(
                "http://sms.ru/sms/send?api_id=%s&to=%s&text=%s",
                customer.getSmsServiceId(),
                customer.getPhone(),
                code
        );

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
    }
}
