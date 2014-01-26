package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.pages.blocks.LoginBlock;

/**
 * @author Aliaksei Boole
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
