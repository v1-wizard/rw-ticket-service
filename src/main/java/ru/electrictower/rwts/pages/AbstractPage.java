package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * @author Aliaksei Boole
 */
abstract class AbstractPage {
    @FindBy(xpath = "//td[@class='status']//a")
    private Link logOutLink;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    public boolean isLogin() {
        return logOutLink.isDisplayed();
    }
}
