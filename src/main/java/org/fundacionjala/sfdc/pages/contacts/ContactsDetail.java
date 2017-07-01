package org.fundacionjala.sfdc.pages.contacts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.DetailBase;

/**
 * This method represent to contact detail.
 */
public class ContactsDetail extends DetailBase {

    @FindBy(xpath = "//span[contains(text(), 'Name')]/parent::div/following-sibling::div/span/span")
    private WebElement nameLabel;

    @FindBy(xpath = "//span[contains(text(), 'Phone')]/parent::div/following-sibling::div/span/span")
    private WebElement phoneLabel;

    @FindBy(xpath = "//span[contains(text(), 'Account Name')]/parent::div/following-sibling::div/span/div/a")
    private WebElement accountNameLabel;

    @FindBy(xpath = "//span[contains(text(), 'Title')]/parent::div/following-sibling::div/span/span")
    private WebElement titleLabel;

    @FindBy(xpath = "//span[contains(text(), 'Department')]/parent::div/following-sibling::div/span/span")
    private WebElement departmentLabel;

    @FindBy(xpath = "//span[contains(text(), 'Birthdate')]/parent::div/following-sibling::div/span/span")
    private WebElement birthDateLabel;

    @FindBy(xpath = "//span[contains(text(), 'Reports To')]/parent::div/following-sibling::div/span/div/a")
    private WebElement reportToLabel;

    @FindBy(xpath = "//span[contains(text(), 'Lead Source')]/parent::div/following-sibling::div/span/span")
    private WebElement leadSorceLabel;

    @FindBy(xpath = "//span[contains(text(), 'Mailing Address')]/parent::div/following-sibling::div/span/a")
    private WebElement mailingAddressLabel;

    @FindBy(xpath = "//span[contains(text(), 'Language')]/parent::div/following-sibling::div/span/span")
    private WebElement languagesLabel;

    @FindBy(xpath = "//span[contains(text(), 'Home Phone')]/parent::div/following-sibling::div/span/span")
    private WebElement homePhoneLabel;

    @FindBy(xpath = "//span[contains(text(), 'Mobile')]/parent::div/following-sibling::div/span/span")
    private WebElement mobileLabel;

    @FindBy(xpath = "//span[contains(text(), 'Other Phone')]/parent::div/following-sibling::div/span/span")
    private WebElement otherPhoneLabel;

    @FindBy(xpath = "//span[contains(text(), 'Fax')]/parent::div/following-sibling::div/span/span")
    private WebElement faxLabel;

    @FindBy(xpath = "//span[contains(text(), 'Email')]/parent::div/following-sibling::div/span/span/a")
    private WebElement emailLabel;

    @FindBy(xpath = "//span[contains(text(), 'Assistant')]/parent::div/following-sibling::div/span/span")
    private WebElement assistandLabel;

    @FindBy(xpath = "//span[contains(text(), 'Asst. Phone')]/parent::div/following-sibling::div/span/span")
    private WebElement assistandPhoneLabel;

    @FindBy(xpath = "//span[contains(text(), 'Other Address')]/parent::div/following-sibling::div/span/a")
    private WebElement otherAdressLabel;

    @FindBy(xpath = "//span[contains(text(), 'Level')]/parent::div/following-sibling::div/span/span")
    private WebElement levelAdress;

    @FindBy(xpath = "//span[text()='Details']")
    private WebElement datails;

    @FindBy(css = "a[title='Show more actions for this record']")
    private WebElement showOptionsButton;

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String[] getCompleteName() {
        return nameLabel.getText().split(" ");
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getDepartmentLabel() {
        return departmentLabel.getText();
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getTitleLabel() {
        return titleLabel.getText();
    }

    /**
     * This method gets name label.
     *
     * @return a name label.
     */
    public String getBirthDateLabel() {
        return birthDateLabel.getText();
    }

    /**
     * This method gets lead source label.
     *
     * @return a name label.
     */
    public String getLeadSourceLabel() {
        return leadSorceLabel.getText();
    }


    /**
     * This method gets other street label.
     *
     * @return a other street label.
     */
    private String getOtherAddresLabel() {
        return otherAdressLabel.getText().split(",")[0];
    }

    /**
     * This method gets mailing street label.
     *
     * @return a mailing street label.
     */


    private String getMailingAdressLabel() {
        return mailingAddressLabel.getText().split(",")[0];

    }

    /**
     * This method gets mail label.
     *
     * @return a mail street label.
     */
    private String getMailLabel() {
        return emailLabel.getText();
    }

    /**
     * This method gets name label.
     *
     * @param contact String with the contact name.
     * @return a name label.
     */
    public boolean isContactDisplayed(final String contact) {
        WebElement contactContainer;
        try {
            contactContainer = driver.findElement(By.xpath("//span[contains(.,'" + contact + "')]"));
        } catch (WebDriverException e) {
            return false;
        }
        return isElementPresent(contactContainer);

    }

    /**
     * Click.
     */
    public void clickOnDetails() {
        CommonActions.clickElement(datails);
    }

    /**
     * This method gets name label.
     *
     * @param webElement the element to find in the page.
     * @return a name label.
     */
    public boolean isElementPresent(final WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public ContactForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new ContactForm();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public MainApp clickDeleteButton() {

        return new MainApp();
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of contact edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();

        strategyMap.put(ContactFields.FIRST_NAME_CATEGORY.getValue(), this::getFirstNameCategoryLabel);
        strategyMap.put(ContactFields.CONTACT_NAME.getValue(), this::getNameLabel);
        strategyMap.put(ContactFields.LAST_NAME.getValue(), this::getLastNameLabel);
        strategyMap.put(ContactFields.TITLE.getValue(), this::getTitleLabel);
        strategyMap.put(ContactFields.DEPARTMENT.getValue(), this::getDepartmentLabel);
        strategyMap.put(ContactFields.BIRTH_DATE.getValue(), this::getBirthDateLabel);
        strategyMap.put(ContactFields.LEAD_SOURCE.getValue(), this::getLeadSourceLabel);
        strategyMap.put(ContactFields.MAIL.getValue(), this::getMailLabel);
        strategyMap.put(ContactFields.MAILING_STREET.getValue(), this::getMailingAdressLabel);
        strategyMap.put(ContactFields.OTHER_STREET.getValue(), this::getOtherAddresLabel);
        strategyMap.put(ContactFields.PHONE.getValue(), this::getPhoneLabel);
        strategyMap.put(ContactFields.HOME_PHONE.getValue(), this::getHomePhoneLabel);
        strategyMap.put(ContactFields.MOBILE.getValue(), this::getMobileLabel);
        strategyMap.put(ContactFields.OTHER_PHONE.getValue(), this::getOtherPhoneLabel);
        strategyMap.put(ContactFields.ASSISTANT.getValue(), this::getAssistandLabel);
        strategyMap.put(ContactFields.ASSISTANT_PHONE.getValue(), this::getAssistandPhoneLabel);
        strategyMap.put(ContactFields.MAILING_CITY.getValue(), this::getMailingCity);
        strategyMap.put(ContactFields.MAILING_STATE.getValue(), this::getMailingState);
        strategyMap.put(ContactFields.OTHER_CITY.getValue(), this::getOtherCity);
        strategyMap.put(ContactFields.MAILING_ZIP.getValue(), this::getMailingZip);
        strategyMap.put(ContactFields.MAILING_COUNTRY.getValue(), this::getMailingCountry);
        strategyMap.put(ContactFields.OTHER_ZIP.getValue(), this::getOtherZip);
        strategyMap.put(ContactFields.OTHER_STATE.getValue(), this::getOtherState);
        strategyMap.put(ContactFields.OTHER_COUNTRY.getValue(), this::getOtherCoutry);
        strategyMap.put(ContactFields.LANGUAGES.getValue(), this::getLanguagesLabel);
        strategyMap.put(ContactFields.LEVEL.getValue(), this::getLevelAdress);

        return strategyMap;
    }

    /**
     * Click.
     *
     * @return label text.
     */
    private String getMailingState() {
        return mailingAddressLabel.getText().split(",")[2].split(" ")[1];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    private String getLastNameLabel() {
        return getCompleteName()[getCompleteName().length - 1];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    private String getMailingZip() {
        return mailingAddressLabel.getText().split(",")[2].split(" ")[2];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    private String getMailingCountry() {
        return mailingAddressLabel.getText().split(",")[2].split(" ")[3];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    private String getOtherZip() {
        return otherAdressLabel.getText().split(",")[2].split(" ")[2];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    private String getOtherState() {
        return otherAdressLabel.getText().split(",")[2].split(" ")[1];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    private String getOtherCoutry() {
        return otherAdressLabel.getText().split(",")[2].split(" ")[3];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    private String getFirstNameCategoryLabel() {
        return getCompleteName()[0];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getMailingCity() {
        return mailingAddressLabel.getText().split(",")[1].trim();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getOtherCity() {
        return otherAdressLabel.getText().split(",")[1].trim();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getNameLabel() {
        return getCompleteName()[1];
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getPhoneLabel() {
        return phoneLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getAccountNameLabel() {
        return accountNameLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getReportToLabel() {
        return reportToLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getLanguagesLabel() {
        return languagesLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getHomePhoneLabel() {
        return homePhoneLabel.getText();
    }

    /**
     * Click.
     * @return label text.
     */
    public String getMobileLabel() {
        return mobileLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getOtherPhoneLabel() {
        return otherPhoneLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getFaxLabel() {
        return faxLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getAssistandLabel() {
        return assistandLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getAssistandPhoneLabel() {
        return assistandPhoneLabel.getText();
    }

    /**
     * Click.
     *
     * @return label text.
     */
    public String getLevelAdress() {
        return levelAdress.getText();
    }
}
