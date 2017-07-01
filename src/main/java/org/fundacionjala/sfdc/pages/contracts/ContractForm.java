package org.fundacionjala.sfdc.pages.contracts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;

/**
 * This class represents a form to create or edit a contract.
 */
public class ContractForm extends FormBase {


    @FindBy(id = "ctrc7")
    @CacheLookup
    private WebElement accountNameTextField;

    @FindBy(id = "ctrc7_lkwgt")
    @CacheLookup
    private WebElement accountNameLoopIconBtn;

    @FindBy(id = "ctrc16")
    @CacheLookup
    private WebElement customerSignedByTextField;

    @FindBy(id = "ctrc16_lkwgt")
    @CacheLookup
    private WebElement customerSignedByLoopBtn;

    @FindBy(id = "CustomerSignedTitle")
    @CacheLookup
    private WebElement customerSignedTitle;

    @FindBy(id = "ctrc6")
    @CacheLookup
    private WebElement customerSignedDateTextField;

    @FindBy(css = "span.dateFormat a[tabindex='4']")
    @CacheLookup
    private WebElement customerSignedDateTodayLink;

    @FindBy(id = "ctrc17")
    @CacheLookup
    private WebElement priceBookMultiSelect;

    @FindBy(id = "ctrc15")
    @CacheLookup
    private WebElement statusMultiselect;

    @FindBy(id = "ctrc5")
    @CacheLookup
    private WebElement contractStartDateTextBox;

    @FindBy(css = "span.dateFormat a[tabindex='7']")
    @CacheLookup
    private WebElement contractStartDateTodayLink;

    @FindBy(id = "ctrc40")
    @CacheLookup
    private WebElement contractTermMonthsTextBox;

    @FindBy(id = "ctrc13")
    @CacheLookup
    private WebElement ownerExpirationNoticeMultiSelect;

    @FindBy(id = "CompanySigned")
    @CacheLookup
    private WebElement companySignedByTextBox;

    @FindBy(id = "CompanySigned_lkwgt")
    @CacheLookup
    private WebElement companySignedByLoopIcon;

    @FindBy(id = "CompanySignedDate")
    @CacheLookup
    private WebElement companySignedDateTextBox;

    @FindBy(css = "span.dateFormat a[tabindex='11']")
    @CacheLookup
    private WebElement todayCompanySignedDateLink;

    private ContractBuilder contractBuilder;

    private Map<String, String> valuesMap;

    /**
     * Contractor by default.
     */
    public ContractForm() {
        super();
    }

    /**
     * Constructor that initialize the builder and hash map.
     *
     * @param contractBuilder {@link ContractBuilder}
     */
    public ContractForm(final ContractBuilder contractBuilder) {
        valuesMap = new HashMap<>();
        this.contractBuilder = contractBuilder;
    }

    /**
     * This method save a new contract on "ContractFields" form.
     *
     * @return {@link ContractDetail}
     */
    public ContractDetail saveContract() {
        valuesMap = contractBuilder.getStrategyMap();
        fillTheForm(valuesMap);
        return clickSaveButton();
    }

    /**
     * This method obtains values the Map set.
     *
     * @return A map with values set on "product" form.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * This method sets a customer signed by.
     *
     * @param customerSignedBy is the new name of a customer signed by.
     * @return a contract form.
     */
    public ContractForm setCustomerSignedBy(final String customerSignedBy) {
        customerSignedByTextField.clear();
        customerSignedByTextField.sendKeys(customerSignedBy);
        return this;
    }

    /**
     * This method sets a account name.
     *
     * @param accountName is a string name.
     * @return a contract form.
     */
    public ContractForm setAccountName(final String accountName) {
        accountNameTextField.clear();
        accountNameTextField.sendKeys(accountName);
        return this;
    }

    /**
     * This method sets a customer signed title.
     *
     * @param customerSignedTitle is a string name.
     * @return a contract form.
     */
    public ContractForm setCustomerSignedTitle(final String customerSignedTitle) {
        customerSignedByTextField.clear();
        customerSignedByTextField.sendKeys(customerSignedTitle);
        return this;
    }

    /**
     * This method  sets the customer signed date.
     *
     * @param customerSignedDate a string to set.
     * @return a contract form..
     */
    public ContractForm setCustomerSignedDate(final String customerSignedDate) {
        customerSignedDateTextField.clear();
        customerSignedDateTextField.sendKeys(customerSignedDate);
        return this;
    }

    /**
     * This method sets the customer signed date by default.
     *
     * @return a contract form.
     */
    public ContractForm setCustomerSignedDateWithCurrentDate() {
        customerSignedDateTextField.clear();
        customerSignedDateTodayLink.click();
        return this;
    }

    /**
     * This method sets the price book.
     *
     * @param type is a string type.
     * @return a contract form.
     */
    public ContractForm choosePriceBookType(final String type) {
        Select selectBox = new Select(priceBookMultiSelect);
        selectBox.selectByVisibleText(type);
        return this;
    }

    /**
     * This method chooses the STATUS.
     *
     * @param status is a string type.
     * @return a contract form.
     */
    public ContractForm chooseStatus(final String status) {
        Select selectBox = new Select(statusMultiselect);
        selectBox.selectByVisibleText(status);
        return this;
    }

    /**
     * This method  sets the contract start date.
     *
     * @param contractStartDate a string to set.
     * @return a contract form..
     */
    public ContractForm setContractStartDate(final String contractStartDate) {
        contractStartDateTextBox.clear();
        contractStartDateTextBox.sendKeys(contractStartDate);
        return this;
    }

    /**
     * This method sets the contract start date by default.
     *
     * @return a contract form.
     */
    public ContractForm setContractStartDateWithCurrentDate() {
        contractStartDateTextBox.clear();
        contractStartDateTodayLink.click();
        return this;
    }

    /**
     * This method sets the contract term in months.
     *
     * @param contractTermMonths a string to set.
     * @return a contract form.
     */
    public ContractForm setContractTermMonths(final String contractTermMonths) {
        contractTermMonthsTextBox.clear();
        contractTermMonthsTextBox.sendKeys(contractTermMonths);
        return this;
    }

    /**
     * This method chooses the owner expiration notice.
     *
     * @param ownerExpirationNotice is a string type.
     * @return a contract form.
     */
    public ContractForm chooseOwnerExpirationNotice(final String ownerExpirationNotice) {
        Select selectBox = new Select(ownerExpirationNoticeMultiSelect);
        selectBox.selectByVisibleText(ownerExpirationNotice);
        return this;
    }

    /**
     * This method sets the company signed by field.
     *
     * @param companySignedBy is a string.
     * @return a opportunity form.
     */
    public ContractForm setCompanySignedBy(final String companySignedBy) {
        companySignedByTextBox.clear();
        companySignedByTextBox.sendKeys(companySignedBy);
        return this;
    }

    /**
     * This method  sets the company signed date.
     *
     * @param companySignedDate a string to set.
     * @return a contract form..
     */
    public ContractForm setCompanySignedDate(final String companySignedDate) {
        companySignedDateTextBox.clear();
        companySignedDateTextBox.sendKeys(companySignedDate);
        return this;
    }

    /**
     * This method sets the the company signed date by default.
     *
     * @return a contract form.
     */
    public ContractForm setCompanySignedDateWithCurrentDate() {
        companySignedDateTextBox.clear();
        todayCompanySignedDateLink.click();
        return this;
    }

    /**
     * This method makes click on account name.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickAccountNameLoopIcon() {
        CommonActions.clickElement(accountNameLoopIconBtn);
        return new LookUpWindow();
    }

    /**
     * This method makes click on customer signed by loop icon.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickCustomerSignedByLoopIcon() {
        CommonActions.clickElement(customerSignedByLoopBtn);
        return new LookUpWindow();
    }

    /**
     * This method makes click on company signed by loop icon.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickCompanySignedByLoopIcon() {
        CommonActions.clickElement(companySignedByLoopIcon);
        return new LookUpWindow();
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate is the map that contains all the values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method that to permit set values to create a new ContractHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the contract create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(ContractFields.ACCOUNT_NAME.toString(),
                () -> setAccountName(values.get(ContractFields.ACCOUNT_NAME.toString())));
        strategyMap.put(ContractFields.CUSTOMER_SIGNED_BY.toString(),
                () -> setCustomerSignedBy(values.get(ContractFields.CUSTOMER_SIGNED_BY.toString())));
        strategyMap.put(ContractFields.CUSTOMER_SIGNED_TITLE.toString(),
                () -> setCustomerSignedTitle(values.get(ContractFields.CUSTOMER_SIGNED_TITLE.toString())));
        strategyMap.put(ContractFields.CUSTOMER_SIGNED_DATE.toString(),
                () -> setCustomerSignedDate(values.get(ContractFields.CUSTOMER_SIGNED_DATE.toString())));
        strategyMap.put(ContractFields.PRICE_BOOK.toString(),
                () -> choosePriceBookType(values.get(ContractFields.PRICE_BOOK.toString())));
        strategyMap.put(ContractFields.STATUS.toString(),
                () -> chooseStatus(values.get(ContractFields.STATUS.toString())));
        strategyMap.put(ContractFields.CONTRACT_START_DATE.toString(),
                () -> setContractStartDate(values.get(ContractFields.CONTRACT_START_DATE.toString())));
        strategyMap.put(ContractFields.CONTRACT_TERM_MONTHS.toString(),
                () -> setContractTermMonths(values.get(ContractFields.CONTRACT_TERM_MONTHS.toString())));
        strategyMap.put(ContractFields.OWNER_EXPIRATION_NOTICE.toString(),
                () -> setAccountName(values.get(ContractFields.OWNER_EXPIRATION_NOTICE.toString())));
        strategyMap.put(ContractFields.COMPANY_SIGNED_BY.toString(),
                () -> setCompanySignedBy(values.get(ContractFields.COMPANY_SIGNED_BY.toString())));
        strategyMap.put(ContractFields.COMPANY_SIGNED_DATE.toString(),
                () -> setCompanySignedDate(values.get(ContractFields.COMPANY_SIGNED_DATE.toString())));

        return strategyMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new ContractDetail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new ContractDetail();
    }

    /**
     * This class handle the builder pattern.
     */
    public static class ContractBuilder {

        private Map<String, String> strategyMap;

        /**
         * Constructor of the ContractBuilder class.
         *
         * @param accountName        Account name is a required field to create a contract.
         * @param status             Status is a required field to create a contract.
         * @param contractStartDate  ContractFields Start Date is a required field to create a contract.
         * @param contractTermMonths ContractFields Term in months is a required field to create a contract.
         */
        public ContractBuilder(
                final String accountName, final String status, final String contractStartDate,
                final String contractTermMonths) {
            strategyMap = new HashMap<>();
            strategyMap.put(ContractFields.ACCOUNT_NAME.toString(), accountName);
            strategyMap.put(ContractFields.STATUS.toString(), status);
            strategyMap.put(ContractFields.CONTRACT_START_DATE.toString(), contractStartDate);
            strategyMap.put(ContractFields.CONTRACT_TERM_MONTHS.toString(), contractTermMonths);
            //this.OWNER_EXPIRATION_NOTICE = "--None--";
        }

        /**
         * Sets the account name field in the form.
         *
         * @param accountName Is the new account name.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setAccountName(final String accountName) {
            strategyMap.put(ContractFields.ACCOUNT_NAME.toString(), accountName);
            return this;
        }

        /**
         * Sets the customer signed by field in the form.
         *
         * @param customerSignedBy Is the new customer signed by value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedBy(final String customerSignedBy) {
            strategyMap.put(ContractFields.CUSTOMER_SIGNED_BY.toString(), customerSignedBy);
            return this;
        }

        /**
         * Sets the customer signed title field in the form.
         *
         * @param customerSignedTitle Is the new customer signed title value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedTitle(final String customerSignedTitle) {
            strategyMap.put(ContractFields.CUSTOMER_SIGNED_TITLE.toString(), customerSignedTitle);
            return this;
        }

        /**
         * Sets the customer signed date field in the form.
         *
         * @param customerSignedDate Is the new customer signed date value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedDate(final String customerSignedDate) {
            strategyMap.put(ContractFields.CUSTOMER_SIGNED_DATE.toString(), customerSignedDate);
            return this;
        }

        /**
         * Sets the price book field in the form.
         *
         * @param priceBook Is the new price book value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setPriceBook(final String priceBook) {
            strategyMap.put(ContractFields.PRICE_BOOK.toString(), priceBook);
            return this;
        }

        /**
         * Sets the status field in the form.
         *
         * @param status Is the new status value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setStatus(final String status) {
            strategyMap.put(ContractFields.STATUS.toString(), status);
            return this;
        }

        /**
         * Sets the contract start date field in the form.
         *
         * @param contractStartDate Is the new contract start date value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setContractStartDate(final String contractStartDate) {
            strategyMap.put(ContractFields.CONTRACT_START_DATE.toString(), contractStartDate);
            return this;
        }

        /**
         * Sets the contract term months field in the form.
         *
         * @param contractTermMonths Is the new contract term months value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setContractTermMonths(final String contractTermMonths) {
            strategyMap.put(ContractFields.CONTRACT_TERM_MONTHS.toString(), contractTermMonths);
            return this;
        }

        /**
         * Sets the owner expiration notice field in the form.
         *
         * @param ownerExpirationNotice Is the new owner expiration notice value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setOwnerExpirationNotice(final String ownerExpirationNotice) {
            strategyMap.put(ContractFields.OWNER_EXPIRATION_NOTICE.toString(), ownerExpirationNotice);
            return this;
        }

        /**
         * Sets the company signed by field in the form.
         *
         * @param companySignedBy Is the new contract term months value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCompanySignedBy(final String companySignedBy) {
            strategyMap.put(ContractFields.COMPANY_SIGNED_BY.toString(), companySignedBy);
            return this;
        }

        /**
         * This method set the company signed date.
         *
         * @param companySignedDate String with the new company signed date.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCompanySignedDate(final String companySignedDate) {
            strategyMap.put(ContractFields.COMPANY_SIGNED_DATE.toString(), companySignedDate);
            return this;
        }

        /**
         * This method set the strategyMap contract.
         *
         * @return A map with values set on "contract" form.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        /**
         * Builds the builder pattern design.
         * @return {@link ContractForm}
         */
        public ContractForm build() {
            return new ContractForm(this);
        }

    }
}
