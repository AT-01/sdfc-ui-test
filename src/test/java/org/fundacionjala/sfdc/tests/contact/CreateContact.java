package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.fundacionjala.sfdc.tests.Asserts;

/**
 * This class is a test to create a contact.
 */
public class CreateContact {

    static final String CONTACT_DATA_PATH = "contact/CreateContactData.json";
    private ContactHome contactsHome = new ContactHome();
    private ContactsDetail contactsDetail;
    private Map<String, String> valuesMapJson;


    /**
     * This method is a preconditions to create a contact.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(CONTACT_DATA_PATH);
        Navigator.goToContact();
    }

    /**
     * This a test to create a contact.
     */
    @Test
    public void createContact() {
        ContactForm contactForm = contactsHome.clickNewButton();
        contactForm.fillTheForm(valuesMapJson);
        contactsDetail = contactForm.clickSaveButton();
        contactsDetail.clickOnDetails();
        Asserts.assertDetailValues(contactsDetail, valuesMapJson);
    }

    /**
     * This is a post conditions of a contact.
     */
    @AfterMethod
    public void afterTest() {
        contactsDetail.clickDeleteButton();

    }
}
