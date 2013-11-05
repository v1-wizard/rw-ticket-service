package rwts.pages;

import org.openqa.selenium.WebDriver;
import rwts.beans.Customer;
import rwts.pages.blocks.LoginBlock;

/**
 * User: aliaksei.bul
 * Date: 28.10.13
 * Time: 17:39
 */
public class HomePage extends AbstractPage
{
    private LoginBlock loginBlock;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void login(Customer customer, boolean isSelected)
    {
        loginBlock.login(customer, isSelected);
    }


}
