package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Order;
import ru.electrictower.rwts.pages.blocks.WagonTypeBlock;

import java.util.List;

/**
 * User: aliaksei.bul
 * Date: 29.10.13
 * Time: 20:33
 */
public class WagonSelectPage extends AbstractPage
{

    private List<WagonTypeBlock> wagonTypeBlocks;

    public WagonSelectPage(WebDriver driver)
    {
        super(driver);
    }

    public void selectWagon(Order order)
    {
        for (WagonTypeBlock wagonTypeBlock : wagonTypeBlocks)
        {
            if (wagonTypeBlock.isGoodCost(order))
            {
                wagonTypeBlock.clickSelect();
                break;
            }
        }
    }
}
