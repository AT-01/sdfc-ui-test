package org.fundacionjala.sfdc.pages.contacts;

/**
 * This enum is to contact fields.
 */
public enum ContactFields {
    FIRST_NAME_CATEGORY("firstNameCategory"),
    CONTACT_NAME("contactName"),
    LAST_NAME("lastName"),
    TITLE("title"),
    DEPARTMENT("department"),
    BIRTH_DATE("birthDate"),
    LEAD_SOURCE("leadSource"),
    MAIL("mail"),
    MAILING_STREET("mailingStreet"),
    OTHER_STREET("otherStreet"),
    PHONE("phone"),
    HOME_PHONE("homePhone"),
    MOBILE("mobilePhone"),
    OTHER_PHONE("otherPhone"),
    ASSISTANT("assistant"),
    ASSISTANT_PHONE("assistantPhone"),
    MAILING_CITY("mailingCity"),
    MAILING_STATE("mailingState"),
    OTHER_CITY("otherCity"),
    MAILING_ZIP("mailingZip"),
    MAILING_COUNTRY("mailigCountry"),
    OTHER_ZIP("otherZip"),
    OTHER_STATE("otherState"),
    OTHER_COUNTRY("otherCountry"),
    LANGUAGES("languages"),
    LEVEL("level");


    private final String value;

    /**
     * This construct sets a string to the enums.
     *
     * @param value is a string of the enum.
     */
    ContactFields(final String value) {
        this.value = value;
    }

    /**
     * Method that return the value.
     *
     * @return the corresponding value.
     */
    public String getValue() {
        return value;
    }
}
