package org.fundacionjala.sfdc.pages.campaigns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * This class is in charge to manage the elements of the page.
 */
public class CampaignForm extends FormBase {

    @FindBy(xpath = "//span[text()='Campaign Name']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement campaignNameField;

    @FindBy(xpath = "//span[text()='Active']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement activeCheckbox;

    @FindBy(css = "[aria-label=\"Type\"]")
    @CacheLookup
    private WebElement typeDropdownButton;

    @FindBy(css = "[aria-label=\"Status\"]")
    @CacheLookup
    private WebElement statusDropdown;

    @FindBy(xpath = "//span[text()='Start Date']/parent::label/following-sibling::div/child::input")
    @CacheLookup
    private WebElement startDateField;

    @FindBy(xpath = "//span[text()='End Date']/parent::label/following-sibling::div/child::input")
    @CacheLookup
    private WebElement endDateField;

    @FindBy(xpath = "//span[text()='Budgeted Cost in Campaign']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement budgetedCostField;

    @FindBy(xpath = "//span[text()='Actual Cost in Campaign']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement actualCostField;

    @FindBy(xpath = "//span[text()='Expected Response (%)']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement expectedResponseField;

    @FindBy(xpath = "//span[text()='Num Sent in Campaign']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement numSentInCampaignField;

    @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement descriptionField;

    @FindBy(css = "button[title='Save']")
    @CacheLookup
    private WebElement saveButton;

    @FindBy(className = "hotListElement")
    @CacheLookup
    private WebElement allCampaigns;

    @FindBy(xpath = "//span[text()='Expected Revenue in Campaign']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement revenueCampaignTextField;



    /**
     * set name of the campaign.
     *
     * @param text String whit the name.
     * @return return Campaign Form.
     */
    public CampaignForm setCampaignNameField(final String text) {
        CommonActions.sendKeys(campaignNameField, text);
        return this;
    }

    /**
     * set the check Box.
     *
     * @return Campaign Form.
     */
    public CampaignForm checkActiveCheckbox() {
        CommonActions.check(activeCheckbox);
        return this;
    }

    /**
     * set the Type drop down.
     *
     * @param item String whit the value.
     * @return Campaign Form.
     */
    public CampaignForm selectTypeDropdown(final String item) {
        CommonActions.clickElement(typeDropdownButton);
        CommonActions.selectAnElement(generalDropdown, item).click();
        return this;
    }

    /**
     * set the status drop down.
     *
     * @param item String whit the value.
     * @return Campaign Form.
     */
    public CampaignForm selectStatusDropdown(final String item) {
        CommonActions.clickElement(statusDropdown);
        CommonActions.selectAnElement(generalDropdown, item).click();
        return this;
    }

    /**
     * set the start date of the campaign.
     *
     * @param date String whit the date.
     * @return Campaign Form.
     */
    public CampaignForm setStartDateField(final String date) {
        CommonActions.sendKeys(startDateField, date);
        return this;
    }

    /**
     * set the end date of the campaign.
     *
     * @param endDate String whit the date.
     * @return Campaign Form.
     */
    private CampaignForm setEndDateField(final String endDate) {
        CommonActions.sendKeys(endDateField, endDate);
        CommonActions.clickElement(campaignNameField);
        return this;
    }

//    /**
//     * click on the look up icon.
//     *
//     * @return Campaign Form.
//     */
//    public LookUpWindow clickLookUpIcon() {
//        CommonActions.clickElement(lookUpIcon);
//        return new LookUpWindow();
//    }

    /**
     * click on save button.
     *
     * @return Campaign Form.
     */
    @Override
    public CampaignDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new CampaignDetail();
    }

    /**
     * click save/new button.
     *
     * @return abstract page.
     */
    @Override
    public AbstractBasePage clickSaveNewButton() {
        return null;
    }

    /**
     * find the campaign created.
     *
     * @param campaignUpdated String whit the name of the campaign.
     * @return Boolean
     */
    public boolean campaignUpdate(final String campaignUpdated) {
        List<WebElement> campaigns = allCampaigns.findElements(By.className("dataCell"));
        return campaigns.stream()
                .anyMatch(webElement -> webElement.getText().equals(campaignUpdated));
    }

    /**
     * Method that to permit set values to create a new OpportunityHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();
        strategyMap.put("campaignName", () -> setCampaignNameField(String.valueOf(values.get("campaignName"))));
        strategyMap.put("active", this::checkActiveCheckbox);
        strategyMap.put("typeDropDown", () -> selectTypeDropdown(String.valueOf(values.get("typeDropDown"))));
        strategyMap.put("statusDropDown", () -> selectStatusDropdown(String.valueOf(values.get("statusDropDown"))));
        strategyMap.put("startDate", () -> setStartDateField(String.valueOf(values.get("startDate"))));
        strategyMap.put("endDate", () -> setEndDateField(String.valueOf(values.get("endDate"))));
        strategyMap.put("revenue", () -> setRevenue(String.valueOf(values.get("revenue"))));
        strategyMap.put("budgetedCost", () -> setBudgetedCost(String.valueOf(values.get("budgetedCost"))));
        strategyMap.put("actualCost", () -> setActualCost(String.valueOf(values.get("actualCost"))));
        strategyMap.put("expectedResponse", () -> setExpectedResponse(String.valueOf(values.get("expectedResponse"))));
        strategyMap.put("numSentInCampaign", () -> setNumSentInCampaign(String.valueOf(values
                .get("numSentInCampaign"))));
        strategyMap.put("description", () -> setDescription(String.valueOf(values.get("description"))));
        return strategyMap;
    }

    /**
     * Set description to campaign.
     *
     * @param description String description to campaign
     */
    private void setDescription(String description) {
        CommonActions.clearTextField(descriptionField);
        CommonActions.sendKeys(descriptionField, description);
    }

    /**
     * Set num sent in campaign.
     *
     * @param numSentInCampaign String to num sent in campaign.
     */
    private void setNumSentInCampaign(String numSentInCampaign) {
        CommonActions.clearTextField(numSentInCampaignField);
        CommonActions.sendKeys(numSentInCampaignField, numSentInCampaign);
    }

    /**
     * Set the expected response.
     *
     * @param expectedResponse String with expected response.
     */
    private void setExpectedResponse(String expectedResponse) {
        CommonActions.clearTextField(expectedResponseField);
        CommonActions.sendKeys(expectedResponseField, expectedResponse);
        expectedResponseField.sendKeys(Keys.ENTER);
    }

    /**
     * Set the quantity to set actual cost.
     *
     * @param actualCost String with the quantity.
     */
    private void setActualCost(String actualCost) {
        CommonActions.clearTextField(actualCostField);
        CommonActions.sendKeys(actualCostField, actualCost);
    }


    /**
     * Set the quantity to budgeted cost field.
     *
     * @param budgetedCost String with the quantity.
     */
    private void setBudgetedCost(String budgetedCost) {
        CommonActions.clearTextField(budgetedCostField);
        CommonActions.sendKeys(budgetedCostField, budgetedCost);
    }

    /**
     * set the quantity.
     *
     * @param quantity String whit the quantity.
     */
    public void setRevenue(final String quantity) {
        CommonActions.clearTextField(revenueCampaignTextField);
        CommonActions.sendKeys(revenueCampaignTextField, quantity);
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate  Map
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet().forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
