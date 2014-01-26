package ru.electrictower.rwts.testdata;

import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.pages.TrainSelectPage;

import java.text.ParseException;

/**
 * @author Aliaksei Boole
 */
public class TestTrainSelectPage extends TrainSelectPage
{
    public TestTrainSelectPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean compareTravelTimes(String actualTime, String expectedTime) throws ParseException
    {
        return super.compareTravelTimes(actualTime, expectedTime);
    }


}
