package ru.electrictower.rwts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.electrictower.rwts.beans.Trip;

import java.util.Iterator;
import java.util.List;


/**
 * @author Aliaksei Boole
 */
public class TrainSelectPage extends AbstractPage
{
    @FindBy(xpath = "//table[contains(@id,':form2:tableEx1')]")
    private Table resultsTable;

    @FindBy(xpath = "//span[contains(@id,'viewFragmentT:textSel1')]")
    private Link backToRouteChoosePageLink;

    @FindBy(xpath = "//input[contains(@id,':form2:button2')]")
    private Button nextButton;

    private int       goodChoiceRowNumber;
    private WebDriver driver;

    private final static int ROW_WITH_INFORMATION = 14;
    private final static int TIME_FIELD           = 5;
    private final static int COST_FIELD           = 8;

    public TrainSelectPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public boolean selectTrain(Trip trip)
    {
        boolean isGoodTime = false;
        int correction = 0;
        List<List<String>> rows = resultsTable.getRowsAsString();
        Iterator<List<String>> iterator = rows.iterator();
        while (iterator.hasNext())
        {
            List<String> row = iterator.next();
            if (row.size() < ROW_WITH_INFORMATION)
            {
                iterator.remove();
            }
        }
        for (List<String> row : rows)
        {
            correction = row.size() - ROW_WITH_INFORMATION;
            String timeString = row.get(TIME_FIELD + correction);
            if (!timeString.isEmpty())
            {
                isGoodTime = compareTravelTimes(timeString, trip.getTime());
                if (isGoodTime)
                {
                    String costsString = row.get(COST_FIELD + correction);
                    if (isGoodCost(costsString, trip))
                    {
                        goodChoiceRowNumber = rows.indexOf(row);
                        return true;
                    }

                    costsString = row.get(COST_FIELD + correction + 1);
                    if (isGoodCost(costsString, trip))
                    {
                        goodChoiceRowNumber = rows.indexOf(row);
                        return true;
                    }

                    costsString = row.get(COST_FIELD + correction + 2);
                    if (isGoodCost(costsString, trip))
                    {
                        goodChoiceRowNumber = rows.indexOf(row);
                        return true;
                    }

                    costsString = row.get(COST_FIELD + correction + 3);
                    if (isGoodCost(costsString, trip))
                    {
                        goodChoiceRowNumber = rows.indexOf(row);
                        return true;
                    }

                    costsString = row.get(COST_FIELD + correction + 4);
                    if (isGoodCost(costsString, trip))
                    {
                        goodChoiceRowNumber = rows.indexOf(row);
                        return true;
                    }

                    costsString = row.get(COST_FIELD + correction + 5);
                    if (isGoodCost(costsString, trip))
                    {
                        goodChoiceRowNumber = rows.indexOf(row);
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean compareTravelTimes(String actualTime, String expectedTime)
    {
        String actualHours = actualTime.split(":")[0];
        String expectedHours = expectedTime.split(":")[0];
        return Integer.valueOf(actualHours) >= Integer.valueOf(expectedHours);
    }

    private boolean isGoodCost(String costsString, Trip trip)
    {
        boolean isGoodCost = false;
        String[] actualCosts;
        if (!costsString.isEmpty())
        {
            actualCosts = costsString.replace(" ", "").replace("/", "\n").split("\n");
            for (int i = 1; i < actualCosts.length; i++)
            {
                isGoodCost = trip.getCost() >= Integer.valueOf(actualCosts[i]);
                if (isGoodCost)
                {
                    return isGoodCost;
                }
            }
        }
        return isGoodCost;
    }

    public void backToRouteChoosePage()
    {
        backToRouteChoosePageLink.click();
    }

    public void selectGoodTrain()
    {
        WebElement CheckBox = driver.findElements(By.xpath("//span/input[@id='rowSelect1']")).get(goodChoiceRowNumber);
        CheckBox.click();
    }

    public void clickNext()
    {
        nextButton.click();
    }
}
