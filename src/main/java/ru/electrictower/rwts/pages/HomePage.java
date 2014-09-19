package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.electrictower.rwts.beans.Customer;
import ru.electrictower.rwts.pages.blocks.LoginBlock;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * @author Aliaksei Boole
 */
public class HomePage extends AbstractPage {
    private LoginBlock loginBlock;
    @FindBy(xpath = "//a[contains(@onclick,'/home/login_main/')]")
    private Link loginPageLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void login(Customer customer, boolean isSelected) {
        loginPageLink.click();
        if (loginPageLink.isDisplayed()) {
            loginPageLink.click();
        }
        loginBlock.login(customer, isSelected);
    }


}
