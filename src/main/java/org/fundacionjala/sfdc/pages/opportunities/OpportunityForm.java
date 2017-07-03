package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;

import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.AMOUNT;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.CURRENT_CLOSE_DATE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.DELIVERY_INSTALL_STATUS;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.LEAD_SOURCE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.NEXT_STEP;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.OPPORTUNITY_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.ORDER_NUMBER;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.PRIVATE_FLAG;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.STAGE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.TYPE;


/**
 * This class represent to a form to create or edit a opportunity.
 */
public class OpportunityForm extends FormBase {

    @FindBy(xpath = "//span[text()='Private']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement activeFlagPrivateCheckBox;

    @FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement opportunityNameTextField;

    @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div/div")
    @CacheLookup
    private WebElement accountNameTextField;


    @FindBy(css = "li[role='presentation']")
    @CacheLookup
    private List<WebElement> accountNameList;


    @FindBy(xpath = "//span[@title='New Account']")
    @CacheLookup
    private WebElement accountNameCreate;

    @FindBy(xpath = ".//*[@id='opp4_lkwgt']/img")
    @CacheLookup
    private WebElement accountNameLookupIconBtn;

    @FindBy(xpath = "//span[text()='Type']/parent::span/following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement selectTypeCheckBox;

    @FindBy(xpath = "//span[text()='Lead Source']/parent::span/following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement selectLeadSourceCheckBox;

    @FindBy(xpath = "//span[text()='Amount']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement amountTextField;

    @FindBy(xpath = "//span[text()='Close Date']/parent::label/following-sibling::div/child::input")
    @CacheLookup
    private WebElement closeDateField;

    @FindBy(xpath = "//input[@id='opp9']/following::a")
    @CacheLookup
    private WebElement todayLink;

    @FindBy(xpath = "//span[text()='Next Step']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement nextStepTextField;


    @FindBy(xpath = "//span[text()='Stage']/parent::label/following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement selectStageField;

    @FindBy(css = ".uiMenuItem.uiRadioMenuItem>a")

    private List<WebElement> radiobuttonElement;


    @FindBy(xpath = "//span[text()='Probability (%)']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement probabilityTextBox;

    @FindBy(id = "//span[text()='Primary Campaign Source']/parent::label/following-sibling::div/div")
    @CacheLookup
    private WebElement primaryCampaignSourceTextBox;

    @FindBy(xpath = "//img[@alt='Primary Campaign Source Lookup (New Window)']")
    private WebElement primaryCampaignSourceLookupIconBtn;

    @FindBy(xpath = "//span[text()='Order Number']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement orderNumberTextField;

    @FindBy(xpath = "//span[text()='Delivery/Installation Status']/parent::span/following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement multiSelectDeliveryInstallationStatus;

    @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement descriptionTextArea;

    private OpportunityBuilder opportunityBuilder;
    private Map<String, String> valuesMap;

    /**
     * Constructor that call the parent constructor.
     */
    public OpportunityForm() {
        super();
    }

    /**
     * Constructor that initialize the values.
     *
     * @param opportunityBuilder the builder class.
     */
    private OpportunityForm(final OpportunityBuilder opportunityBuilder) {
        valuesMap = new HashMap<>();
        this.opportunityBuilder = opportunityBuilder;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public OpportunityDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        CommonActions.sleep(3000);
        return new OpportunityDetail();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public OpportunityDetail clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new OpportunityDetail();
    }

    /**
     * This method checks in.
     *
     * @param flag Boolean with flag.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm checkPrivateFlag(final boolean flag) {
        if (!CommonActions.isSelected(activeFlagPrivateCheckBox) && flag) {
            CommonActions.clickElement(activeFlagPrivateCheckBox);
        }
        return this;
    }

    /**
     * This method sets a opportunity name.
     *
     * @param opportunityName is a boolean.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setOpportunityName(final String opportunityName) {
        CommonActions.sendKeys(opportunityNameTextField, opportunityName);
        return this;
    }

    /**
     * This method sets a account name.
     *
     * @param accountName is a string name.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setAccountName(final String accountName) {
        CommonActions.clickElement(accountNameTextField);
        List<WebElement> myElements = driver.findElements(
                By.xpath("//div[contains(@class,'primaryLabel slds-truncate slds-lookup__result-text')]"));
        CommonActions.selectAnElement(myElements, accountName).click();

        return this;
    }

    /**
     * This method sets a type.
     *
     * @param type is a string type.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseTypeDdl(final String type) {


        CommonActions.clickElement(selectTypeCheckBox);
        CommonActions.selectAnElement(generalDropdown, type).click();
        return this;
    }

    /**
     * This method chooses leadSource.
     *
     * @param leadSource is a string type.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseLeadSourceDdl(final String leadSource) {

        CommonActions.clickElement(selectLeadSourceCheckBox);
        CommonActions.selectAnElement(generalDropdown, leadSource).click();
        return this;
    }

    /**
     * Thid method  sets amount.
     *
     * @param amount a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setAmount(final String amount) {
        CommonActions.sendKeys(amountTextField, amount);
        return this;
    }

    /**
     * This method  sets a close date.
     *
     * @param closeDate a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setCloseDate(final String closeDate) {
        CommonActions.sendKeys(closeDateField, closeDate);
        return this;
    }

    /**
     * This method sets a close date by default.
     *
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setCurrentCloseDate() {
        closeDateField.clear();
        todayLink.click();
        return this;
    }

    /**
     * This method sets next step.
     *
     * @param nextStep is a string.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setNextStep(final String nextStep) {
        nextStepTextField.clear();
        nextStepTextField.sendKeys(nextStep);
        return this;
    }

    /**
     * This method selects a stage.
     *
     * @param stage is a string to select.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseStageDdl(final String stage) {
        CommonActions.clickElement(selectStageField);
        CommonActions.selectAnElement(generalDropdown, stage).click();
        return this;
    }

    /**
     * This method sets a probability to opportunity.
     *
     * @param probability a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setProbability(final String probability) {
        CommonActions.sendKeys(nextStepTextField, probability);
        return this;
    }

    /**
     * This method sets a probability to opportunity.
     *
     * @param primaryCampaignSource is a string value to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setPrimaryCampaignSource(final String primaryCampaignSource) {
        CommonActions.sendKeys(primaryCampaignSourceTextBox, primaryCampaignSource);
        return this;
    }

    /**
     * This method is to add information.
     *
     * @param orderNumber is a string to add.
     * @return {@link OpportunityForm}
     */
    public OpportunityForm setOrderNumber(final String orderNumber) {
        orderNumberTextField.clear();
        orderNumberTextField.sendKeys(orderNumber);
        return this;
    }


    /**
     * This method chooses install status.
     *
     * @param deleveryInstallationStatus a string to choose.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseDeliveryInstallationStatusDdl(final String deleveryInstallationStatus) {
        CommonActions.clickElement(multiSelectDeliveryInstallationStatus);
        CommonActions.selectAnElement(generalDropdown, deleveryInstallationStatus).click();
        return this;
    }

    /**
     * This method sets a description.
     *
     * @param description a string to sets.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setDescription(final String description) {
        CommonActions.sendKeys(descriptionTextArea, description);
        return this;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate Map with the Json or builder map values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method that to permit set values to create a new ContractHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(OPPORTUNITY_NAME.toString(), () -> setOpportunityName(values.get(OPPORTUNITY_NAME.toString())));
        strategyMap.put(TYPE.toString(), () -> chooseTypeDdl(values.get(TYPE.toString())));
        strategyMap.put(LEAD_SOURCE.toString(), () -> chooseLeadSourceDdl(values.get(LEAD_SOURCE.toString())));
        strategyMap.put(AMOUNT.toString(), () -> setAmount(values.get(AMOUNT.toString())));
        strategyMap.put(NEXT_STEP.toString(), () -> setNextStep(values.get(NEXT_STEP.toString())));
        strategyMap.put(STAGE.toString(), () -> chooseStageDdl(values.get(STAGE.toString())));
        strategyMap.put(ORDER_NUMBER.toString(), () -> setOrderNumber(values.get(ORDER_NUMBER.toString())));
        strategyMap.put(DELIVERY_INSTALL_STATUS.toString(),
                () -> chooseDeliveryInstallationStatusDdl(values.get(DELIVERY_INSTALL_STATUS.toString())));
        strategyMap.put(ACCOUNT_NAME.toString(), () -> setAccountName(values.get(ACCOUNT_NAME.toString())));
        strategyMap.put(CURRENT_CLOSE_DATE.toString(), () -> setCloseDate(values.get(CURRENT_CLOSE_DATE.toString())));
        strategyMap.put(PRIVATE_FLAG.toString(),
                () -> checkPrivateFlag(Boolean.parseBoolean(values.get(PRIVATE_FLAG.toString()))));

        return strategyMap;
    }

    /**
     * This method fill the form in opportunity form.
     *
     * @return {@link OpportunityDetail}.
     */
    public OpportunityDetail saveOpportunity() {
        valuesMap = opportunityBuilder.getStrategyMap();
        fillTheForm(valuesMap);
        return clickSaveButton();
    }

    /**
     * This method gets a map with values builded.
     *
     * @return a map.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * Inner class that manage the values to be built.
     */
    public static class OpportunityBuilder {

        private Map<String, String> strategyMap;

        /**
         * This method gets a opportunity form.
         *
         * @return {@link OpportunityForm}.
         */
        public OpportunityForm build() {
            return new OpportunityForm(this);
        }

        /**
         * This method construct builds the steps required.
         *
         * @param opportunityName  a string value to set.
         * @param currentCloseDate a string value to set.
         * @param stage            a string value to set.
         */
        public OpportunityBuilder(final String opportunityName, final String currentCloseDate,
                                  final String stage) {
            strategyMap = new HashMap<>();
            strategyMap.put(OPPORTUNITY_NAME.toString(), opportunityName);
            strategyMap.put(CURRENT_CLOSE_DATE.toString(), currentCloseDate);
            strategyMap.put(STAGE.toString(), stage);
        }

        /**
         * This method sets account name in opportunity.
         *
         * @param accountName a string value to set
         * @return {@link OpportunityBuilder}
         */
        public OpportunityBuilder setAccountName(final String accountName) {
            strategyMap.put(ACCOUNT_NAME.toString(), accountName);
            return this;
        }

        /**
         * This method sets amount in opportunity.
         *
         * @param type a string value to set.
         * @return {@link OpportunityBuilder}
         */
        public OpportunityBuilder setType(final String type) {
            strategyMap.put(TYPE.toString(), type);
            return this;
        }

        /**
         * This method sets amount in opportunity.
         *
         * @param amount a string value to set.
         * @return {@link OpportunityBuilder}
         */
        public OpportunityBuilder setAmount(final String amount) {
            strategyMap.put(AMOUNT.toString(), amount);
            return this;
        }

        /**
         * This method set the strategyMap product.
         *
         * @return a map with values set on "opportunity" form.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }
}
