package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

/**
 * @author Aliaksei Boole
 */
public class PayPage extends AbstractPage
{

    @FindBy(xpath = "//input[@class='commandExButton']")
    private Button nextButton;

    public PayPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickNext()
    {
        nextButton.click();
    }

}
