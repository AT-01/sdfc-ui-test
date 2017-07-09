package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.cases.CasesHome;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;
import org.fundacionjala.sfdc.pages.leads.LeadHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Class to manage the Tab menu Bar.
 */
public class AppLauncher extends AbstractBasePage {

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Campaigns']")
    @CacheLookup
    private WebElement campaignsTab;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Leads']")
    @CacheLookup
    private WebElement leadTab;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Chatter']")
    @CacheLookup
    private WebElement chatterTab;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Contacts']")
    @CacheLookup
    private WebElement contactsTab;

    @FindBy(linkText = "Products")
    @CacheLookup
    private WebElement productsTab;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Accounts']")
    @CacheLookup
    private WebElement accountTab;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Opportunities']")
    @CacheLookup
    private WebElement opportunitiesTab;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/span[text()='Contracts']")
    private WebElement contractsTab;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Cases']")
    @CacheLookup
    private WebElement caseTab;


    /**
     * This Method makes click on Campaigns tab.
     *
     * @return {@link CampaignsHome}
     */

    public CampaignsHome clickCampaigns() {
        CommonActions.clickElement(campaignsTab);
        waitModal();
        return new CampaignsHome();
    }

    /**
     * This method makes click on Contacts tab.
     *
     * @return {@link ContactHome}
     */
    public ContactHome clickOnContactsHome() {
        CommonActions.clickElement(contactsTab);
        return new ContactHome();
    }

    /**
     * This method makes click on Products tab.
     *
     * @return {@link ProductHome}
     */
    public ProductHome clickOnProductsHome() {
        CommonActions.clickElement(productsTab);
        return new ProductHome();
    }

    /**
     * This method makes click on Opportunities tab.
     *
     * @return {@link OpportunityHome}
     */
    public OpportunityHome clickOnOpportunitiesHome() {
        CommonActions.clickElement(opportunitiesTab);
        return new OpportunityHome();
    }

    /**
     * This method makes click on Accounts tab.
     *
     * @return {@link AccountHome}
     */
    public AccountHome clickOnAccountsHome() {
        CommonActions.clickElement(accountTab);
        waitModal();
        return new AccountHome();
    }

    /**
     * This method wait modal.
     *
     */
    private void waitModal() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".modal-header"))));
    }

    /**
     * This method makes click on Leads tab.
     *
     * @return {@link LeadHome}
     */
    public LeadHome clickLead() {
        CommonActions.clickElement(leadTab);
        return new LeadHome();
    }

    /**
     * This method makes click on Chatter tab.
     *
     * @return {@link ChatterAbstractPage}
     */
    public ChatterAbstractPage clickOnChatterTab() {
        CommonActions.clickElement(chatterTab);
        return new ChatterAbstractPage();
    }

    /**
     * This method makes click on Contracts tab.
     *
     * @return {@link ContractHome}
     */
    public ContractHome clickOnContractHome() {
        CommonActions.clickElement(contractsTab);
        return new ContractHome();
    }

    /**
     * This method makes click on Cases tab.
     *
     * @return CasesHome class.
     */
    public CasesHome clickOnCasesHome() {
        CommonActions.clickElement(caseTab);
        return new CasesHome();
    }

}
