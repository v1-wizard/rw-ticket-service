package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Trip;
import ru.electrictower.rwts.pages.blocks.WagonTypeBlock;

import java.util.List;

/**
 * @author Aliaksei Boole
 */
public class WagonSelectPage extends AbstractPage
{

    private List<WagonTypeBlock> wagonTypeBlocks;

    public WagonSelectPage(WebDriver driver)
    {
        super(driver);
    }

    public void selectWagon(Trip trip)
    {
        for (WagonTypeBlock wagonTypeBlock : wagonTypeBlocks)
        {
            if (wagonTypeBlock.isGoodCost(trip))
            {
                wagonTypeBlock.clickSelect();
                break;
            }
        }
    }
}
