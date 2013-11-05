package rwts.pages.blocks;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import rwts.beans.Order;

import java.util.List;

/**
 * User: aliaksei.bul
 * Date: 29.10.13
 * Time: 20:24
 */
@Name("Wagon block")
@Block(@FindBy(how = How.XPATH, using = "//table[@class='fields']"))
public class WagonTypeBlock extends HtmlElement
{
    @Name("Cost Text")
    @FindBy(xpath = "//p/span[contains(@style,'font-weight:bold')]")
    private List<TextBlock> cost;

    @Name("Select Button")
    @FindBy(xpath = "//input[contains(@id,'button1')]")
    private List<Button> selectButton;

    private int blockNumber;

    public boolean isGoodCost(Order order)
    {   
	    //todo Need refactor this shit!
        blockNumber = Integer
                .valueOf(this.getName().substring(this.getName().length() - 2, this.getName().length() - 1));
        int costActual = Integer.valueOf(cost.get(blockNumber).getText().replace(" ", ""));
        return costActual <= order.getCost();
    }

    public void clickSelect()
    {   
		//todo Need refactor this shit!
        blockNumber = Integer
                .valueOf(this.getName().substring(this.getName().length() - 2, this.getName().length() - 1));
        selectButton.get(blockNumber).click();
    }
}
