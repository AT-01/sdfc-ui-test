package org.fundacionjala.saleforceuitest.pages.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.saleforceuitest.framework.common.CommonActions;
import org.fundacionjala.saleforceuitest.pages.base.FormBasePage;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class LeadDetailsPage extends FormBasePage {

    //region Locators

    /*Lead Information*/
    @FindBy(id = "lea1_ileinner")
    @CacheLookup
    WebElement owner;

    @FindBy(id = "lea2_ileinner")
    @CacheLookup
    WebElement name;

    @FindBy(id = "lea3_ileinner")
    @CacheLookup
    WebElement company;

    @FindBy(id = "lea4_ileinner")
    @CacheLookup
    WebElement title;

    @FindBy(id = "lea5_ileinner")
    @CacheLookup
    WebElement leadSource;

    @FindBy(id = "lea6_ileinner")
    @CacheLookup
    WebElement industry;

    @FindBy(id = "lea7_ileinner")
    @CacheLookup
    WebElement annualRevenue;

    @FindBy(id = "lea8_ileinner")
    @CacheLookup
    WebElement phone;

    @FindBy(id = "lea9_ileinner")
    @CacheLookup
    WebElement mobile;

    @FindBy(id = "lea10_ileinner")
    @CacheLookup
    WebElement fax;

    @FindBy(id = "lea11_ileinner")
    @CacheLookup
    WebElement email;

    @FindBy(id = "lea12_ileinner")
    @CacheLookup
    WebElement website;

    @FindBy(id = "lea13_ileinner")
    @CacheLookup
    WebElement leadStatus;

    @FindBy(id = "lea14_ileinner")
    @CacheLookup
    WebElement rating;

    @FindBy(id = "lea15_ileinner")
    @CacheLookup
    WebElement numEmployees;

    /*Address Information*/
    @FindBy(id = "lea16_ileinner")
    @CacheLookup
    WebElement address;

    /*additional information*/
    @FindBy(xpath = "//td[contains(.,'Product Interest')]/following::div")
    @CacheLookup
    WebElement productInterest;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::div")
    @CacheLookup
    WebElement SICcode;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::div")
    @CacheLookup
    WebElement numLocations;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::div")
    @CacheLookup
    WebElement currentGenerators;

    @FindBy(xpath = "//td[contains(.,'Primary')]/following::div")
    @CacheLookup
    WebElement primary;

    /*Others*/
    @FindBy(id = "lea17_ileinner")
    @CacheLookup
    WebElement description;

    @FindBy(id = "lea20")
    @CacheLookup
    WebElement campaign;

    @FindBy(id = "CreatedBy_ileinner")
    @CacheLookup
    WebElement createdBy;

    @FindBy(id = "LastModifiedBy_ileinner")
    @CacheLookup
    WebElement lastModifiedBy;

    //endregion


    /*Lead Information*/
    public String getOwner() {
        return owner.getText();
    }

    public String getName() {
        System.out.println("name: "+name.getText());
        return name.getText();
    }

    public String getCompany() {
        return company.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getLeadSource() {
        return leadSource.getText();
    }

    public String getIndustry() {
        return industry.getText();
    }

    public String getAnnualRevenue() {
        return annualRevenue.getText();
    }

    public String getPhone() {
        return phone.getText();
    }

    public String getMobile() {
        return mobile.getText();
    }

    public String getFax() {
        return fax.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getWebsite() {
        return website.getText();
    }

    public String getLeadStatus() {
        return leadStatus.getText();
    }

    public String getRating() {
        return rating.getText();
    }

    public String getNumEmployees() {
        return numEmployees.getText();
    }

    /*Address Information*/
    public String getAddress() {
        return address.getText();
    }

    /*additional information*/
    public String getProductInterest() {
        return productInterest.getText();
    }

    public String getSICcode() {
        return SICcode.getText();
    }

    public String getNumLocations() {
        return numLocations.getText();
    }

    public String getCurrentGenerators() {
        return currentGenerators.getText();
    }

    public String getPrimary() {
        return primary.getText();
    }

    /*Others*/
    public String getDescription() {
        return description.getText();
    }

    public String getCampaign() {
        return campaign.getText();
    }

    public String getCreatedBy() {
        return createdBy.getText();
    }

    public String getLastModifiedBy() {
        return lastModifiedBy.getText();
    }
/*
    public LeadForm clickEditBtn() {
        CommonActions.clickEditButton();
        return new LeadForm(this.driver);
    }
*/

    public LeadAbstractPagePage deleteLead() {
        CommonActions.deleteMe(driver);
        return new LeadAbstractPagePage();

    }
}