package rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * User: aliaksei.bul
 * Date: 29.10.13
 * Time: 22:57
 */
public class CodePage extends AbstractPage
{
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td/div[9]/h3/span[2]")
    TextBlock codeText;
    WebDriver driver;

    public CodePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void sendSmsWithPayCode()
    {
        String code = codeText.getText();
        driver.get("http://sms.ru/sms/send?api_id=3d5f68d5-d371-57a4-ddec-cebcb6298329&to=375296034984&text=" + code);
    }
}
