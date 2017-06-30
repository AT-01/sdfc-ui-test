package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


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

    @FindBy(id = "Chatter_Tab")
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

    @FindBy(id = "Opportunity_Tab")
    @CacheLookup
    private WebElement opportunitiesTab;

    @FindBy(id = "Contract_Tab")
    @CacheLookup
    private WebElement contractsTab;

    @FindBy(id = "Case_Tab")
    @CacheLookup
    private WebElement caseTab;

    @FindBy(css = ".slds-icon-waffle")
    @CacheLookup
    private WebElement iconWaffle;


    /**
     * This Method makes click on Campaigns tab.
     *
     * @return {@link CampaignsHome}
     */

    public CampaignsHome clickCampaigns() {
//        CommonActions.sleep();
        CommonActions.clickElement(campaignsTab);
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
        return new AccountHome();
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
