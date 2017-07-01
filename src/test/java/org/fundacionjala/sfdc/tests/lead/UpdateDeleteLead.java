package org.fundacionjala.sfdc.tests.lead;


import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadFields;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadHome;

import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;
import static org.testng.Assert.assertFalse;

/**
 * This class update and delete LeadHome.
 */
public class UpdateDeleteLead {

    public static final String LEAD_DATA_PATH = "lead/CreateLeadData.json";
    private LeadDetails leadDetails;
    private LeadHome leadHomePage;
    private LeadForm leadForm;
    private Map<String, String> valuesMapJson;

    /**
     * This method execute the preconditions to make the validation for update and delete test.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(LEAD_DATA_PATH);
        leadHomePage = Navigator.goToLead();
        leadForm = leadHomePage.clickNewButton();
        leadDetails = leadForm
                .setFirstNameTextField(valuesMapJson.get(LeadFields.FIRST_NAME.toString()))
                .setLastNameTextField(valuesMapJson.get(LeadFields.LAST_NAME.toString()))
                .setCompanyTextField(valuesMapJson.get(LeadFields.COMPANY.toString()))
                .clickSaveButton();
    }

    /**
     * This test verify the delete process for Lead.
     */
    @Test
    public void deleteLead() {
        leadDetails.clickDeleteButton();
        assertFalse(leadHomePage.isLeadDisplayed(valuesMapJson.get(LeadFields.FIRST_NAME.toString())),
                "The Lead was not deleted");
    }

    /**
     * This test update the created Lead and make the corresponding assertions.
     */
    @Test
    public void updateLead() {
        final String companyNameEdited = "CompanyName UPDATED";
        final String lastNameEdited = "LastName UPDATED";
        final String firstNameEdited = "firstName UPDATED";
        leadDetails.clickEditButton();
        leadForm = new LeadForm.LeadBuilder(lastNameEdited, companyNameEdited)
                .setFirstName(firstNameEdited)
                .setCity(valuesMapJson.get(LeadFields.CITY.toString()))
                .setStateProvince(valuesMapJson.get(LeadFields.STATE_PROVINCE.toString()))
                .setZipCode(valuesMapJson.get(LeadFields.ZIP_CODE.toString()))
                .setCountry(valuesMapJson.get(LeadFields.COUNTRY.toString()))
                .build();
        leadDetails = leadForm.saveLead();
        assertDetailValues(leadDetails, leadForm.formatJson(leadForm.getLeadValues()));
    }

    /**
     * This method delete the Lead that was created in the precondition method.
     */
    @AfterClass
    public void tearDown() {
        leadDetails.clickDeleteButton();
    }
}
