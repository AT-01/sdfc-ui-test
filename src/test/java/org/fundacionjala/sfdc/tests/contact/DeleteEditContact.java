package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.contacts.ContactFields;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.fundacionjala.sfdc.tests.Asserts;

import static org.fundacionjala.sfdc.tests.contact.CreateContact.CONTACT_DATA_PATH;
import static org.testng.Assert.assertFalse;

/**
 * This method is a preconditions to edit and delete a contact.
 */
public class DeleteEditContact {

    private static final String CONTACT_DATA_EDIT_PATH = "contact/EditContactData.json";
    private static final String COMMA = ", ";
    private ContactsDetail contactsDetail;
    private ContactForm contactForm;
    private Map<String, String> valuesMapJson;
    private MainApp mainApp = new MainApp();
    private AppLauncher appLauncher = new AppLauncher();

    /**
     * This method is a preconditions to edit and delete a contact.
     */
    @BeforeMethod
    public void setUp() {
        mainApp = new MainApp();
        LoginPage.loginAsPrimaryUser();
        appLauncher = mainApp.clickAppLauncher();
        valuesMapJson = JsonMapper.getMapJson(CONTACT_DATA_PATH);
        ContactHome contactsHome = appLauncher.clickOnContactsHome();
        contactForm = contactsHome.clickNewButton();
        contactForm.fillTheForm(valuesMapJson);
        contactsDetail = contactForm.clickSaveButton();

    }

    /**
     * This method is to edit a contact.
     */
    @Test
    public void editContact() {
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(CONTACT_DATA_EDIT_PATH);
        contactForm = contactsDetail.clickEditButton();
        contactForm.fillTheForm(valuesMapEditJson);
        contactsDetail = contactForm.clickSaveButton();
        contactsDetail.clickOnDetails();
        Asserts.assertDetailValues(contactsDetail, valuesMapEditJson);
        contactsDetail.clickDeleteButton();
    }

    /**
     * This method is to delete a contact.
     */
    @Test
    public void deleteContact() {
        contactsDetail.clickDeleteButton();
        assertFalse(contactsDetail.isContactDisplayed(valuesMapJson.get(ContactFields.CONTACT_NAME.getValue())
                        .concat(COMMA).concat(valuesMapJson.get(ContactFields.CONTACT_NAME.getValue()))),
                "The contacts shouldn't to be displayed");
    }
}
