package ru.electrictower.rwts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;

/**
 * @author Aliaksei Boole
 */
public class RulesPage  extends AbstractPage
{

    @FindBy(xpath = "//input[@type='checkbox']")
    private CheckBox confirmationCheckBox;

    @FindBy(xpath = "//input[contains(@id,'nextBtn')]")
    private Button nextButton;

    public RulesPage(WebDriver driver)
    {
        super(driver);
    }

    public void confirmWithRules()
    {
        confirmationCheckBox.select();
        nextButton.click();
    }

}
