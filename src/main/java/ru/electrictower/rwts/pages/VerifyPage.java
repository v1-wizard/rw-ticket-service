package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

/**
 * User: aliaksei.bul
 * Date: 29.10.13
 * Time: 22:37
 */
public class VerifyPage extends AbstractPage
{
    @FindBy(xpath = "//input[contains(@id,':confirm:')]")
    private Button nextButton;

    public VerifyPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickNext()
    {
        nextButton.click();
    }


}
