package ru.electrictower.rwts.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;

/**
 * @author Aliaksei Boole
 */
public class PayPage extends AbstractPage
{

    @FindBy(xpath = "//input[@class='commandExButton']")
    private Button   nextButton;
    @FindBy(xpath = "//input[contains(@id,':confirm:registrationNeeded')]")
    private CheckBox electronicRegistration;


    public PayPage(WebDriver driver)
    {
        super(driver);
    }

    public void next()
    {
        try
        {
            electronicRegistration.select();
        }
        catch (NoSuchElementException e)
        {
            System.out.println("No Electronic Registration.");
        }
        nextButton.click();
    }

}
