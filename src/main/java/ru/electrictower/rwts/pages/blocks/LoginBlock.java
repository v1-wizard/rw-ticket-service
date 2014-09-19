package ru.electrictower.rwts.pages.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.electrictower.rwts.beans.Customer;

/**
 * @author Aliaksei Boole
 */
@Name("Login Form on home page")
@Block(@FindBy(xpath = "//form[@id='login']"))
public class LoginBlock extends HtmlElement
{
    @FindBy(xpath = ".//input[@id='login']")
    private TextInput loginInput;

    @FindBy(xpath = ".//input[@id='password']")
    private TextInput passwordInput;

    @FindBy(xpath = ".//input[@class='commandExButton']")
    private Button loginButton;

    @FindBy(xpath = ".//input[@id='rememberUser1']")
    private CheckBox rememberCheckBox;

    public void login(Customer customer, boolean isRemember){
        loginInput.sendKeys(customer.getLogin());
        passwordInput.sendKeys(customer.getPassword());
        rememberCheckBox.set(isRemember);
        loginButton.click();
    }

}
