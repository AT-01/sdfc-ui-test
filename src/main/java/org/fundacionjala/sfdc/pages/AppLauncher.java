package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * The class is in charge to manage the AppLauncher window.
 */
public class AppLauncher extends AbstractBasePage {
    @FindBy(css = "[title=\"Sales\"]")
    @CacheLookup
    private WebElement salesLink;

    /**
     * Method that click on Sales link.
     *
     * @return {@link TabBar}
     */
    public TabBar clickSalesLink() {
        CommonActions.clickElement(salesLink);
        return new TabBar();
    }
}
