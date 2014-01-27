package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.electrictower.rwts.beans.Passenger;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.electrictower.rwts.beans.Trip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aliaksei Boole
 */
public class PassengersSelectPage extends AbstractPage
{

    @FindBy(xpath = "//input[contains(@id,'lastname')]")
    private TextInput lastNameInput;

    @FindBy(xpath = "//input[contains(@id,':name')]")
    private TextInput firstNameInput;

    @FindBy(xpath = "//input[contains(@id,'patronymic')]")
    private TextInput patronymicInput;

    @FindBy(xpath = "//input[contains(@id,'docNum')]")
    private TextInput docNumInput;

    @FindBy(xpath = "//select[contains(@id,'selectPass')]")
    private Select selectPassenger;

    @FindBy(xpath = "//select[contains(@id,'selectType')]")
    private Select selectDocumentId;

    @FindBy(xpath = "//input[contains(@id,'pass:conf')]")
    private CheckBox agreeWithRulesCheckBox;

    @FindBy(xpath = "//input[contains(@id,'nextBtn')]")
    private Button nextButton;

    private final static int FIRST_NAME_INDEX = 0;
    private final static int LAST_NAME_INDEX  = 2;
    private final static int PATRONYMIC_INDEX = 1;
    private final static int DOCUMENT_ID      = 4;
    private final static int SIZE_WITH_INFO   = 6;

    public PassengersSelectPage(WebDriver driver)
    {
        super(driver);
    }

    public void selectPassenger(Passenger passenger)
    {
        int passengerIndexInSelect = getPassengerIndexInSelect(passenger);
        if (passengerIndexInSelect == -1)
        {
            fillPassengersInfo(passenger);
        }
        else
        {
            selectPassenger.selectByIndex(passengerIndexInSelect);
        }
        agreeWithRulesCheckBox.set(true);
        nextButton.click();
    }

    private int getPassengerIndexInSelect(Passenger passenger)
    {
        List<String[]> passengersInfoFromSelect = getPassengersInfoFromSelect();
        for (String[] passengerInfo : passengersInfoFromSelect)
        {
            if (
                    passengerInfo.length == SIZE_WITH_INFO &&
                            passenger.getFirstName().equalsIgnoreCase(passengerInfo[FIRST_NAME_INDEX]) &&
                            passenger.getLastName().equalsIgnoreCase(passengerInfo[LAST_NAME_INDEX]) &&
                            passenger.getPatronymic().equalsIgnoreCase(passengerInfo[PATRONYMIC_INDEX]) &&
                            passenger.getDocumentId().equalsIgnoreCase(passengerInfo[DOCUMENT_ID])
                    )
            {
                return passengersInfoFromSelect.indexOf(passengerInfo);
            }
        }
        return -1;
    }

    private List<String[]> getPassengersInfoFromSelect()
    {
        List<WebElement> options = selectPassenger.getOptions();
        List<String[]> passengerInfoFromSelect = new ArrayList<String[]>(10);
        for (WebElement option : options)
        {
            passengerInfoFromSelect.add(option.getAttribute("value").split(";"));
        }
        return passengerInfoFromSelect;
    }

    private void fillPassengersInfo(Passenger passenger)
    {
        firstNameInput.sendKeys(passenger.getFirstName());
        lastNameInput.sendKeys(passenger.getLastName());
        patronymicInput.sendKeys(passenger.getPatronymic());
        docNumInput.sendKeys(passenger.getDocumentId());
        selectDocumentId.selectByIndex(passenger.getDocumentTypeId());
    }


}
