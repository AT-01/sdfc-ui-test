package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.fundacionjala.sfdc.tests.Asserts;
import static org.fundacionjala.sfdc.tests.contact.CreateContact.CONTACT_DATA_PATH;


/**
 * This method is a preconditions to edit and delete a contact.
 */
public class EditContact {

    private static final String CONTACT_DATA_EDIT_PATH = "contact/EditContactData.json";
    private static final String COMMA = ", ";
    private ContactsDetail contactsDetail;
    private ContactForm contactForm;
    private Map<String, String> valuesMapJson;
    private ContactHome contactHome = new ContactHome();

    /**
     * This method is a preconditions to edit and delete a contact.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(CONTACT_DATA_PATH);
        Navigator.goToContact();
        contactForm = contactHome.clickNewButton();
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

}
