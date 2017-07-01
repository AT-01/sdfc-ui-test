package org.fundacionjala.sfdc.pages.campaigns;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.base.DetailBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is in charge to manage the element of the page.
 */

public class CampaignDetail extends DetailBase {

    @FindBy(className = "div.uiInput.uiInputText input")
    @CacheLookup
    private WebElement campaignNameLabel;

    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteButton;

    @FindBy(xpath = "//span[text()='Campaign Name']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement campaignName;

    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editButton;

    @FindBy(xpath = "//span[text()='Type']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement typeText;

    @FindBy(xpath = "//span[text()='Status']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement statusText;

    @FindBy(xpath = "//span[text()='Start Date']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement startDate;

    @FindBy(xpath = "//span[text()='End Date']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement endDate;

    @FindBy(xpath = "//span[text()='Budgeted Cost in Campaign']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement budgetedCostValue;

    @FindBy(xpath = "//span[text()='Actual Cost in Campaign']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement actualCostValue;

    @FindBy(css = ".uiOutputPercent")
    @CacheLookup
    private WebElement expectedResponseValue;

    @FindBy(xpath = "//span[text()='Expected Revenue in Campaign']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement revenueValue;

    @FindBy(xpath = "//span[text()='Description']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement descriptionValue;

    @FindBy(xpath = "//span[text()='Num Sent in Campaign']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement numSentInCampaignValue;

    /**
     * Gets the campaign label.
     *
     * @return String the name of the campaign.
     */
    public String getCampaignNameLabel() {
        return CommonActions.getText(campaignNameLabel);
    }

    /**
     * click on delete button.
     *
     * @return CampaignsHome.
     */
    public CampaignsHome clickDeleteButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(deleteBtn);
        CommonActions.clickElement(confirmDeleteButton);
        return new CampaignsHome();
    }

    /**
     * get the current url.
     *
     * @return String whit the url.
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * click on the edit button.
     *
     * @return CampaignForm.
     */
    @Override
    public CampaignForm clickEditButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(editBtn);
        return new CampaignForm();
    }

    /**
     * give us a tab bar class.
     *
     * @return AppLauncher class.
     */
    public AppLauncher toTabBar() {
        return new AppLauncher();
    }

    /**
     * Strategy use for the assertions.
     *
     * @return Map whit the values.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap();
        strategyMap.put("campaignName", this::getCampaignName);
        strategyMap.put("typeDropDown", this::getSelectedValue);
        strategyMap.put("statusDropDown", this::getSelectedStatus);
        strategyMap.put("startDate", this::getStartDate);
        strategyMap.put("endDate", this::getEndDate);
        strategyMap.put("revenue", this::getRevenueValue);
        strategyMap.put("budgetedCost", this::getBudgetedCostValue);
        strategyMap.put("actualCost", this::getActualCostValue);
        strategyMap.put("expectedResponse", this::getExpectedResponseValue);
        strategyMap.put("numSentInCampaign", this::getNumSentInCampaignValue);
        strategyMap.put("description", this::getDescriptionValue);
        return strategyMap;
    }

    /**
     * get description.
     *
     * @return String with the value.
     */
    private String getDescriptionValue() {
        return descriptionValue.getText();
    }

    /**
     * get num sent in campaign value.
     *
     * @return String with the value.
     */
    private String getNumSentInCampaignValue() {
        return numSentInCampaignValue.getText();
    }

    /**
     * get expected response value.
     *
     * @return String with the value.
     */
    private String getExpectedResponseValue() {
        return expectedResponseValue.getText();
    }

    /**
     * get actual cost value.
     *
     * @return String with the value.
     */
    private String getActualCostValue() {
        String quantity = actualCostValue.getText();
        return quantity.replace(quantity.substring(0, 1), "");
    }

    /**
     * get budgeted cost value.
     *
     * @return String with the value.
     */
    private String getBudgetedCostValue() {
        String quantity = budgetedCostValue.getText();
        return quantity.replace(quantity.substring(0, 1), "");
    }

    /**
     * get revenue value.
     *
     * @return String with the value.
     */
    private String getRevenueValue() {
        String quantity = revenueValue.getText();
        return quantity.replace(quantity.substring(0, 1), "");
    }

    /**
     * get the End date on the campaign.
     *
     * @return String whit the date.
     */
    private String getEndDate() {
        return endDate.getText();
    }

    /**
     * get the Start date on the campaign.
     *
     * @return String whit the date.
     */
    private String getStartDate() {
        return startDate.getText();
    }

    /**
     * Get the value of the status drop down list.
     *
     * @return String whit the value.
     */
    private String getSelectedStatus() {
        return statusText.getText();
    }

    /**
     * get the tipe of the campaign.
     *
     * @return String whi the type.
     */
    private String getSelectedValue() {
        return typeText.getText();
    }

    /**
     * get the campaign name.
     *
     * @return String whit the name of the campaign.
     */
    public String getCampaignName() {
        return campaignName.getText();
    }

    /**
     * Go to details tab.
     */
    public void clickDetails() {
        CommonActions.clickElement(detailsLinkButton);
    }
}
