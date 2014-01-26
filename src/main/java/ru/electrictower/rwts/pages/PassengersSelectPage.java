package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.electrictower.rwts.beans.Passenger;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.electrictower.rwts.beans.Trip;

/**
 * @author Aliaksei Boole
 */
public class PassengersSelectPage extends AbstractPage
{

    @FindBy(xpath = "//input[contains(@id,'lastname')]")
    private TextInput lastNameInput;

    @FindBy(xpath = "//input[contains(@id,'name')]")
    private TextInput firstNameInput;

    @FindBy(xpath = "//input[contains(@id,'patronymic')]")
    private TextInput patronymicInput;

    @FindBy(xpath = "//input[contains(@id,'docNum')]")
    private TextInput docNumInput;

    @FindBy(xpath = "//select[contains(@id,'selectPass')]")
    private Select selectPassenger;

    @FindBy(xpath = "//input[contains(@id,'pass:conf')]")
    private CheckBox agreeWithRulesCheckBox;

    @FindBy(xpath = "//input[contains(@id,'nextBtn')]")
    private Button nextButton;

    public PassengersSelectPage(WebDriver driver)
    {
        super(driver);
    }

    public void selectPassenger(Passenger passenger)
    {
	    //select passanger from drop down menu.
        //todo
        selectPassenger.selectByIndex(4);
        agreeWithRulesCheckBox.set(true);
        nextButton.click();
    }


}
