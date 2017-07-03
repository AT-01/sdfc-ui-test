package org.fundacionjala.sfdc.pages.contracts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.base.DetailBase;

import static org.fundacionjala.sfdc.pages.contracts.ContractFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.COMPANY_SIGNED_BY;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.COMPANY_SIGNED_DATE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CONTRACT_START_DATE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CONTRACT_TERM_MONTHS;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CUSTOMER_SIGNED_BY;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CUSTOMER_SIGNED_DATE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.CUSTOMER_SIGNED_TITLE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.OWNER_EXPIRATION_NOTICE;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.PRICE_BOOK;
import static org.fundacionjala.sfdc.pages.contracts.ContractFields.STATUS;

/**
 * This class represents of the contract detail.
 */
public class ContractDetail extends DetailBase {

    @FindBy(xpath = "//span[contains(.,'Details')]")
    @CacheLookup
    private WebElement detailsLink;

    @FindBy(xpath = "//span[text()='Contract Number']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement contractNumberLabel;

    @FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement accountNameLabel;

    @FindBy(xpath = "//span[text()='Customer Signed By']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement customerSignedByLabel;

    @FindBy(xpath = "//span[text()='Customer Signed Title']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement customerSignedTitleLabel;

    @FindBy(xpath = "//span[text()='Customer Signed Date']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement customerSignedDateLabel;

    @FindBy(xpath = "//span[text()='Price Book']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement priceBookLabel;

    @FindBy(xpath = "//span[text()='Status']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement statusLabel;

    @FindBy(xpath = "//span[text()='Contract Start Date']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement contractStartDateLabel;

    @FindBy(xpath = "//span[text()='Contract End Date']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement contractEndDateLabel;

    @FindBy(xpath = "//span[text()='Contract Term (months)']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement contractTermMonthsLabel;

    @FindBy(xpath = "//span[text()='Owner Expiration Notice']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement ownerExpirationNoticeLabel;

    @FindBy(xpath = "//span[text()='Company Signed By']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement companySignedByLabel;

    @FindBy(xpath = "//span[text()='Company Signed Date']/parent::div/following-sibling::div/span")
    @CacheLookup
    private WebElement companySignedDateLabel;

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new ContractForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractHome clickDeleteButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(deleteBtn);
        CommonActions.clickElement(confirmDeleteButton);
        return new ContractHome();
    }

    /**
     * This method gets the account name.
     *
     * @return a string with account name text.
     */
    public String getAccountName() {
        return accountNameLabel.getText();
    }

    /**
     * This method gets the customer signed by.
     *
     * @return a string with the customer signed by text.
     */
    public String getCustomerSignedBy() {
        return customerSignedByLabel.getText();
    }

    /**
     * This method gets the customer signed title.
     *
     * @return a string with customer signed title text.
     */
    public String getCustomerSignedTitle() {
        return customerSignedTitleLabel.getText();
    }

    /**
     * This method gets the customer signed date.
     *
     * @return a string with customer signed date text.
     */
    public String getCustomerSignedDate() {
        return customerSignedDateLabel.getText();
    }

    /**
     * This method gets the price book.
     *
     * @return a string with price book text.
     */
    public String getPriceBook() {
        return priceBookLabel.getText();
    }

    /**
     * This method gets the STATUS.
     *
     * @return a string with STATUS text.
     */
    public String getStatus() {
        return statusLabel.getText();
    }

    /**
     * This method gets the contract start date.
     *
     * @return a string with contract start date text.
     */
    public String getContractStartDate() {
        return contractStartDateLabel.getText();
    }

    /**
     * This method gets the contract end date.
     *
     * @return a string with contract end date text.
     */
    public String getContractEndDate() {
        return contractEndDateLabel.getText();
    }

    /**
     * This method gets the contract term months.
     *
     * @return a string with contract term months text.
     */
    public String getContractTermMonths() {
        return contractTermMonthsLabel.getText();
    }

    /**
     * This method gets the owner expiration notice.
     *
     * @return a string with owner expiration notice text.
     */
    public String getOwnerExpirationNotice() {
        return ownerExpirationNoticeLabel.getText();
    }

    /**
     * This method gets the company signed by.
     *
     * @return a string with company signed by text.
     */
    public String getCompanySignedBy() {
        return companySignedByLabel.getText();
    }

    /**
     * This method gets the company signed date.
     *
     * @return a string with company signed date text.
     */
    public String getCompanySignedDate() {
        return companySignedDateLabel.getText();
    }

    /**
     * This method gets the contract number.
     *
     * @return a string with contract number text.
     */
    public String getContractNumber() {
        return contractNumberLabel.getText();
    }

    /**
     * This method that verifies if the contract is displayed.
     *
     * @param contractNumber string with contract number.
     * @return true if the contract with the number sent is displayed.
     */
    public boolean isContractDisplayed(final String contractNumber) {
        //span[contains(.,'Contract "00000120" was deleted.')]
        System.out.println();
        try {
            driver.findElement(By.linkText(contractNumber)).getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }


    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of contract edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();

        strategyMap.put(ACCOUNT_NAME.toString(), this::getAccountName);
        strategyMap.put(CUSTOMER_SIGNED_BY.toString(), this::getCustomerSignedBy);
        strategyMap.put(CUSTOMER_SIGNED_TITLE.toString(), this::getCustomerSignedTitle);
        strategyMap.put(CUSTOMER_SIGNED_DATE.toString(), this::getCustomerSignedDate);
        strategyMap.put(PRICE_BOOK.toString(), this::getPriceBook);
        strategyMap.put(STATUS.toString(), this::getStatus);
        strategyMap.put(CONTRACT_START_DATE.toString(), this::getContractStartDate);
        strategyMap.put(CONTRACT_TERM_MONTHS.toString(), this::getContractTermMonths);
        strategyMap.put(OWNER_EXPIRATION_NOTICE.toString(), this::getOwnerExpirationNotice);
        strategyMap.put(COMPANY_SIGNED_BY.toString(), this::getCompanySignedBy);
        strategyMap.put(COMPANY_SIGNED_DATE.toString(), this::getCompanySignedDate);
        return strategyMap;
    }

    /**
     * This method Navigate.
     */

    public void goToLinkDetail() {

        CommonActions.sleep(3000);
        CommonActions.clickElement(detailsLink);
    }
}
