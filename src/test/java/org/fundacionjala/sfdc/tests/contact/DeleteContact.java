package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.contacts.ContactFields;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import static org.fundacionjala.sfdc.tests.contact.CreateContact.CONTACT_DATA_PATH;
import static org.testng.Assert.assertFalse;

/**
 * Created by Juan P on 7/3/2017.
 */
public class DeleteContact {
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
     * This method is to delete a contact.
     */
    @Test
    public void xDeleteContact() {
        contactsDetail.clickDeleteButton();
        assertFalse(contactsDetail.isContactDisplayed(valuesMapJson.get(ContactFields.CONTACT_NAME.getValue())
                        .concat(COMMA).concat(valuesMapJson.get(ContactFields.CONTACT_NAME.getValue()))),
                "The contacts shouldn't to be displayed");
    }
}

