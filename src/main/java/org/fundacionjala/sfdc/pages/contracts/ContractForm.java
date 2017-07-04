package org.fundacionjala.sfdc.pages.contracts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;


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
 * This class represents a form to create or edit a contract.
 */
public class ContractForm extends FormBase {


    @FindBy(xpath = "//span[text()='Account Name']/"
            + "parent::label/following-sibling::div/div/div/div/input")

    private WebElement accountNameTextField;

    @FindBy(xpath = ("//span[text()='Customer Signed By']/parent::label/following-sibling::div/div/div/div/input"))
    private WebElement customerSignedByTextFieldSearch;

    @FindBy(xpath = "//span[text()='Customer Signed Title']/parent::label/following-sibling::input")
    private WebElement customerSignedTitleField;

    @FindBy(xpath = "//span[text()='Customer Signed Date']/parent::label/following-sibling::div/input")
    private WebElement customerSignedDate;

    @FindBy(xpath = "//span[text()='Price Book']/parent::label/following-sibling::div/descendant::input")
    private WebElement priceBookMultiSelect;

    @FindBy(xpath = "//span[text()='Status']/"
            + "parent::span/following-sibling::div/descendant::a")
    private WebElement statusMultiselect;

    @FindBy(xpath = "//span[text()='Contract Start"
            + " Date']/parent::label/following-sibling::div/child::input")
    private WebElement contractStartDateTextBox;

    @FindBy(xpath = "//span[text()='Contract Term (months)']/parent::label/following-sibling::input")

    private WebElement contractTermMonthsTextBox;

    @FindBy(xpath = "//a[contains(@aria-required,'false')]")
    @CacheLookup
    private WebElement ownerExpirationNoticeMultiSelect;

    @FindBy(xpath = "//span[text()='Company Signed By']/parent::label/following-sibling::div/descendant::input")
    private WebElement companySignedByTextBox;

    @FindBy(xpath = "//span[text()='Company Signed Date']/parent::label/following-sibling::div/input")
    @CacheLookup
    private WebElement companySignedDateField;

    @FindBy(xpath = "//span[text()='Company Signed By']/parent::label/following-sibling::div/descendant::a/div/div")
    private WebElement generalDropdown1;

//    protected List<WebElement> generalDropdown1;

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

        CommonActions.clickElement(customerSignedByTextFieldSearch);
        CommonActions.selectAnElement(generalAcountDropdown, customerSignedBy).click();
        return this;
    }

    /**
     * This method sets a account name.
     *
     * @param accountName is a string name.
     * @return a contract form.
     */
    public ContractForm setAccountName(final String accountName) {
        CommonActions.clickElement(accountNameTextField);
        CommonActions.selectAnElement(generalAcountDropdown, accountName).click();
        return this;
    }

     /**
     * This method sets a customer signed title.
     *
     * @param customerSignedTitle is a string name.
     * @return a contract form.
     */
    public ContractForm setCustomerSignedTitle(final String customerSignedTitle) {
        customerSignedTitleField.clear();
        customerSignedTitleField.sendKeys(customerSignedTitle);
        return this;
    }

    /**
     * This method  sets the contract start date.
     *
     * @param contractStartDate a string to set.
     * @return a contract form..
     */
    public ContractForm setContractCustomerSignedDateDate(final String contractStartDate) {

        customerSignedDate.clear();
        customerSignedDate.sendKeys(contractStartDate);
        return this;
    }
    /**
     * This method sets the price book.
     *
     * @param type is a string type.
     * @return a contract form.
     */
    public ContractForm choosePriceBookType(final String type) {
        CommonActions.clickElement(priceBookMultiSelect);
        CommonActions.selectAnElement(generalAcountDropdown, type).click();
        return this;
    }

    /**
     * This method chooses the STATUS.
     *
     * @param status is a string type.
     * @return a contract form.
     */
    public ContractForm chooseStatus(final String status) {

        CommonActions.clickElement(statusMultiselect);
        CommonActions.selectAnElement(generalDropdown, status).click();
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
        CommonActions.clickElement(ownerExpirationNoticeMultiSelect);
        CommonActions.selectAnElement(generalDropdown, ownerExpirationNotice).click();
        return this;
    }

    /**
     * This method sets the company signed by field.
     *
     * @param companySignedBy is a string.
     * @return a opportunity form.
     */
    public ContractForm setCompanySignedBy(final String companySignedBy) {
        CommonActions.clickElement(companySignedByTextBox);
        CommonActions.clickElement(generalDropdown1);
//        CommonActions.selectAnElement(generalDropdown1, companySignedBy);
        return this;
    }

    /**
     * This method  sets the contract company date.
     *
     * @param contractCompanyDate string to set.
     * @return a contract form..
     */
    public ContractForm setContractCompanyDate(final String contractCompanyDate) {
        companySignedDateField.clear();
        companySignedDateField.sendKeys(contractCompanyDate);
        return this;
    }

    /**
     * This method makes click on account name.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickAccountNameLoopIcon() {
        //  CommonActions.clickElement(accountNameLoopIconBtn);
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

        strategyMap.put(STATUS.toString(), () -> chooseStatus(values.get(STATUS.toString())));
        strategyMap.put(CONTRACT_START_DATE.toString(), () ->
                setContractStartDate(values.get(CONTRACT_START_DATE.toString())));
        strategyMap.put(ACCOUNT_NAME.toString(), () -> setAccountName(values.get(ACCOUNT_NAME.toString())));
        strategyMap.put(CONTRACT_TERM_MONTHS.toString(), () ->
                setContractTermMonths(values.get(CONTRACT_TERM_MONTHS.toString())));
        strategyMap.put(CUSTOMER_SIGNED_BY.toString(), () ->
                setCustomerSignedBy(values.get(CUSTOMER_SIGNED_BY.toString())));
        strategyMap.put(OWNER_EXPIRATION_NOTICE.toString(), () ->
                chooseOwnerExpirationNotice(values.get(OWNER_EXPIRATION_NOTICE.toString())));
        strategyMap.put(CUSTOMER_SIGNED_TITLE.toString(), () ->
                setCustomerSignedTitle(values.get(CUSTOMER_SIGNED_TITLE.toString())));
        strategyMap.put(COMPANY_SIGNED_BY.toString(), () ->
                setCompanySignedBy(values.get(COMPANY_SIGNED_BY.toString())));
        strategyMap.put(CUSTOMER_SIGNED_DATE.toString(), () ->
                setContractCustomerSignedDateDate(values.get(CUSTOMER_SIGNED_DATE.toString())));
        strategyMap.put(COMPANY_SIGNED_DATE.toString(), () ->
                setContractCompanyDate(values.get(COMPANY_SIGNED_DATE.toString())));
        strategyMap.put(PRICE_BOOK.toString(), () -> choosePriceBookType(values.get(PRICE_BOOK.toString())));





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
            strategyMap.put(ACCOUNT_NAME.toString(), accountName);
            strategyMap.put(STATUS.toString(), status);
            strategyMap.put(CONTRACT_START_DATE.toString(), contractStartDate);
            strategyMap.put(CONTRACT_TERM_MONTHS.toString(), contractTermMonths);
            //this.OWNER_EXPIRATION_NOTICE = "--None--";
        }

        /**
         * Sets the account name field in the form.
         *
         * @param accountName Is the new account name.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setAccountName(final String accountName) {
            strategyMap.put(ACCOUNT_NAME.toString(), accountName);
            return this;
        }

        /**
         * Sets the customer signed by field in the form.
         *
         * @param customerSignedBy Is the new customer signed by value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedBy(final String customerSignedBy) {
            strategyMap.put(CUSTOMER_SIGNED_BY.toString(), customerSignedBy);
            return this;
        }

        /**
         * Sets the customer signed title field in the form.
         *
         * @param customerSignedTitle Is the new customer signed title value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedTitle(final String customerSignedTitle) {
            strategyMap.put(CUSTOMER_SIGNED_TITLE.toString(), customerSignedTitle);
            return this;
        }

        /**
         * Sets the customer signed date field in the form.
         *
         * @param customerSignedDate Is the new customer signed date value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCustomerSignedDate(final String customerSignedDate) {
            strategyMap.put(CUSTOMER_SIGNED_DATE.toString(), customerSignedDate);
            return this;
        }

        /**
         * Sets the price book field in the form.
         *
         * @param priceBook Is the new price book value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setPriceBook(final String priceBook) {
            strategyMap.put(PRICE_BOOK.toString(), priceBook);
            return this;
        }

        /**
         * Sets the status field in the form.
         *
         * @param status Is the new status value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setStatus(final String status) {
            strategyMap.put(STATUS.toString(), status);
            return this;
        }

        /**
         * Sets the contract start date field in the form.
         *
         * @param contractStartDate Is the new contract start date value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setContractStartDate(final String contractStartDate) {
            strategyMap.put(CONTRACT_START_DATE.toString(), contractStartDate);
            return this;
        }

        /**
         * Sets the contract term months field in the form.
         *
         * @param contractTermMonths Is the new contract term months value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setContractTermMonths(final String contractTermMonths) {
            strategyMap.put(CONTRACT_TERM_MONTHS.toString(), contractTermMonths);
            return this;
        }

        /**
         * Sets the owner expiration notice field in the form.
         *
         * @param ownerExpirationNotice Is the new owner expiration notice value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setOwnerExpirationNotice(final String ownerExpirationNotice) {
            strategyMap.put(OWNER_EXPIRATION_NOTICE.toString(), ownerExpirationNotice);
            return this;
        }

        /**
         * Sets the company signed by field in the form.
         *
         * @param companySignedBy Is the new contract term months value.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCompanySignedBy(final String companySignedBy) {
            strategyMap.put(COMPANY_SIGNED_BY.toString(), companySignedBy);
            return this;
        }

        /**
         * This method set the company signed date.
         *
         * @param companySignedDate String with the new company signed date.
         * @return {@link ContractBuilder}
         */
        public ContractBuilder setCompanySignedDate(final String companySignedDate) {
            strategyMap.put(COMPANY_SIGNED_DATE.toString(), companySignedDate);
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
         *
         * @return {@link ContractForm}
         */
        public ContractForm build() {
            return new ContractForm(this);
        }

    }
}
