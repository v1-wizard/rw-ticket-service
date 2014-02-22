package ru.electrictower.rwts.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.electrictower.rwts.beans.Trip;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * @author Aliaksei Boole
 */
public class RouteChoosePage extends AbstractPage
{

    @FindBy(xpath = "//input[contains(@id,'textDepStat')]")
    private TextInput departureStationField;

    @FindBy(xpath = "//input[contains(@id,'textArrStat')]")
    private TextInput destinationStationField;

    @FindBy(xpath = "//input[contains(@id,'dob')]")
    private TextInput travelDateField;

    @FindBy(xpath = "//select[contains(@id,'countAdults')]")
    private Select numberAdultPassengerSelect;

    @FindBy(xpath = "//input[contains(@id,'buttonSearch')]")
    private Button searchButton;

    @FindBy(xpath = "//span[contains(@id,':form1:messages2')]")
    private TextBlock noWayText;

    public RouteChoosePage(WebDriver driver)
    {
        super(driver);
    }


    public boolean searchPossibleRoute(Trip trip)
    {
        departureStationField.clear();
        departureStationField.sendKeys(trip.getDepartureStation());
        destinationStationField.clear();
        destinationStationField.sendKeys(trip.getDestinationStation());
        travelDateField.clear();
        travelDateField.sendKeys(trip.getTravelDate());
        searchButton.click();
        return isSearchResults();
    }

    private boolean isSearchResults()
    {
        try{
        return !noWayText.isDisplayed();
        } catch(NoSuchElementException e){
             return true;
        }
    }


}
