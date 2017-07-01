package org.fundacionjala.sfdc.pages.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class manage the page objects.
 */
public class CasesHome extends HomeBase {

    @FindBy(css = ".displayArea div.emptyContentInner")
    @CacheLookup
    private WebElement casesList;


    @FindBy(xpath = "//span[text()='Delete']")
    @CacheLookup
    private WebElement confirmationDeleteButton;

    /**
     * {@inheritDoc}
     */
    @Override
    public CasesForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new CasesForm();
    }

    /**
     * Click in confirmationDelete.
     */
    public void clickConfirmationDelete() {
        CommonActions.clickElement(confirmationDeleteButton);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditViewLink() {
        return null;
    }

    /**
     * find if the subject case exist.
     *
     * @param subject String  subject text.
     * @return Boolean value.
     */
    public boolean existCase(final String subject) {
        List<WebElement> casesRows = casesList.findElements(By.cssSelector(".displayArea div.emptyContent"));
        return casesRows.stream().anyMatch(webElement -> webElement.getText().equals(subject));
    }

}
