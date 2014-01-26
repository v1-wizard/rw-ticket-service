package ru.electrictower.rwts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.electrictower.rwts.testdata.TestTrainSelectPage;

import java.text.ParseException;

import static org.mockito.Mockito.*;

/**
 * @author Aliaksei Boole
 */
public class TimeCompareTests extends Assert
{
    WebDriver           mockWebDriver       = mock(FirefoxDriver.class);
    TestTrainSelectPage testTrainSelectPage = new TestTrainSelectPage(mockWebDriver);

    @Test
    public void certainTimeTest() throws ParseException
    {
        assertFalse(testTrainSelectPage.compareTravelTimes("16:30", "18:00"));
        assertTrue(testTrainSelectPage.compareTravelTimes("18:10", "18:10"));
    }

    @Test
    public void periodTimeTest() throws ParseException
    {
        assertFalse(testTrainSelectPage.compareTravelTimes("19:31", "14:00 - 18:20"));
        assertFalse(testTrainSelectPage.compareTravelTimes("15:00", "16:00 - 12:00"));

        assertTrue(testTrainSelectPage.compareTravelTimes("17:00", "14:22 - 17:00"));
        assertTrue(testTrainSelectPage.compareTravelTimes("14:22", "14:22 - 17:00"));
        assertTrue(testTrainSelectPage.compareTravelTimes("15:32", "14:22 - 17:00"));
    }

}
