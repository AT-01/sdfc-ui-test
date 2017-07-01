package org.fundacionjala.sfdc.pages.leads;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;

/**
 * This class represent the Form to create a new LeadHome.
 */
public class LeadForm extends FormBase {

    @FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement lastNameTextField;

    @FindBy(xpath = "//a[@aria-label='Lead Status']")
    @CacheLookup
    private WebElement leadStatustTextField;

    @FindBy(css = "a[role='menuitemradio']")
    @CacheLookup
    private List<WebElement> leatStatusItems;

    @FindBy(xpath = "//span[text()='Company']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement companyTextField;

    @FindBy(xpath = "//span[text()='First Name']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement firstNameTextField;

    @FindBy(xpath = "//span[text()='Street']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement streetTextField;

    @FindBy(xpath = "//span[text()='City']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement cityTextField;

    @FindBy(css = "a[aria-label='Salutation']")
    @CacheLookup
    private WebElement nameSalutationSelect;

    @FindBy(css = "a[role='menuitemradio']")
    @CacheLookup
    private List<WebElement> nameSalutationItems;

    @FindBy(xpath = "//span[text()='Title']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement titleField;

    @FindBy(xpath = "//a[@aria-label='Lead Source']")
    @CacheLookup
    private WebElement leadSourceSelect;

    @FindBy(css = "a[role='menuitemradio']")
    @CacheLookup
    private List<WebElement> leadSourceItems;

    @FindBy(css = "a[aria-label='Industry']")
    @CacheLookup
    private WebElement industrySelect;

    @FindBy(css = "a[role='menuitemradio']")
    @CacheLookup
    private List<WebElement> industrySelectItems;

    @FindBy(xpath = "//span[text()='Annual Revenue']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement annualRevenueTextField;

    @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement phoneTextField;

    @FindBy(xpath = "//span[text()='Mobile']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement mobileTextField;

    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement faxTextField;

    @FindBy(css = "input[type='email']")
    @CacheLookup
    private WebElement emailTextField;

    @FindBy(xpath = "//span[text()='Website']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement websiteTextField;

    @FindBy(css = "a[aria-label='Rating']")
    @CacheLookup
    private WebElement ratingTextField;

    @FindBy(css = "a[role='menuitemradio']")
    @CacheLookup
    private List<WebElement> ratingItems;

    @FindBy(xpath = "//span[text()='No. of Employees']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement numEmployeesTextField;

    @FindBy(css = "input[placeholder='State/Province']")
    @CacheLookup
    private WebElement stateTextField;

    @FindBy(css = "input[placeholder='Zip/Postal Code']")
    @CacheLookup
    private WebElement zipCodeTextField;

    @FindBy(css = "input[placeholder='Country']")
    @CacheLookup
    private WebElement countryTextField;

    @FindBy(css = "a[aria-label='Product Interest']")
    @CacheLookup
    private WebElement productInterestSelect;

    @FindBy(css = "a[role='menuitemradio']")
    @CacheLookup
    private List<WebElement> productInterestItems;

    @FindBy(xpath = "//span[text()='SIC Code']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement sicCodeTextField;

    @FindBy(xpath = "//span[text()='Number of Locations']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement numLocationsTextField;

    @FindBy(xpath = "//span[text()='Current Generator(s)']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement currentGeneratorsTextField;

    @FindBy(css = "a[aria-label='Primary']")
    @CacheLookup
    private WebElement primarySelect;

    @FindBy(css = "a[role='menuitemradio']")
    @CacheLookup
    private List<WebElement> primaryItems;

    /*Others*/
    @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement descriptionTextArea;

    @FindBy(id = "lea21")
    @CacheLookup
    private WebElement assignRuleCheckBox;

    @FindBy(id = "lea20_lkwgt")
    private WebElement campaignIcon;

    @FindBy(css = "button[title='Save & New']")
    private WebElement saveAndNewButton;

    @FindBy(css = "button[title='Save']")
    private WebElement saveButton;


    private LeadBuilder leadBuilder;

    private Map<String, String> mapValues;

    /**
     * Constructor that call the parent constructor.
     */
    public LeadForm() {
        super();
    }

    /**
     * Constructor that initialize the values.
     *
     * @param leadBuilder the builder class.
     */
    private LeadForm(final LeadBuilder leadBuilder) {
        mapValues = new HashMap<>();
        this.leadBuilder = leadBuilder;
    }

    /**
     * Method that save the LeadFields Form.
     *
     * @return {@link LeadDetails}.
     */
    public LeadDetails saveLead() {
        mapValues = leadBuilder.getStrategyMap();
        fillTheForm(mapValues);
        return clickSaveButton();
    }

    /**
     * Method that return the built Map int the LeadBuilder class.
     *
     * @return the Map with the Form data Info.
     */
    public Map<String, String> getLeadValues() {
        return mapValues;
    }

    /**
     * This method selects the campaign where the LeadHome is take in account.
     *
     * @param campaignLookupText the campaign name.
     */
    private void selectCampaign(final String campaignLookupText) {
        wait.until(ExpectedConditions.elementToBeClickable(this.campaignIcon));
        campaignIcon.click();
        LookUpWindow campaignLookup = new LookUpWindow();
        campaignLookup.selectCampaignWithName(campaignLookupText);
    }

    /**
     * This method sets the Last name in the field.
     *
     * @param lastName the last name of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setLastNameTextField(final String lastName) {
        CommonActions.sendKeys(lastNameTextField, lastName);
        return this;
    }

    /**
     * This method sets the Status of the LeadHome.
     *
     * @param status the status of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setStatusField(final String status) {
        CommonActions.sendKeys(leadStatustTextField, status);
        return this;
    }

    /**
     * This method sets the company name of the LeadHome.
     *
     * @param company the company where the lead is working.
     * @return {@link LeadForm}
     */
    public LeadForm setCompanyTextField(final String company) {
        CommonActions.sendKeys(companyTextField, company);
        return this;
    }

    /**
     * This method sets the first name of the LeadHome.
     *
     * @param firstName the first name info.
     * @return {@link LeadForm}
     */
    public LeadForm setFirstNameTextField(final String firstName) {
        CommonActions.sendKeys(firstNameTextField, firstName);
        return this;
    }

    /**
     * This method set the Street of the LeadHome.
     *
     * @param street the street info of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setStreetTextField(final String street) {
        CommonActions.sendKeys(streetTextField, street);
        return this;
    }

    /**
     * This method set the city of the LeadHome.
     *
     * @param city the city info of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setCityTextField(final String city) {
        CommonActions.sendKeys(cityTextField, city);
        return this;
    }

    /**
     * Method that check the field "Assign Rule" if the sent data is "Yes".
     *
     * @param assignRule if this data is "yes" the field is checked
     */
    public void setAssignRule(final String assignRule) {
        if (String.valueOf(assignRule).equals("yes")) {
            CommonActions.check(assignRuleCheckBox);
        }
    }

    /**
     * Method to fill the form given a Json file or the builder class.
     *
     * @param valuesMapCreate Map with the Json or builder map values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        //System.out.println(String.format().);
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method to give a format the Json, according this new Json is built according the details Page.
     *
     * @param valuesMap Original Json.
     * @return the new Json that was formatted.
     */
    public Map<String, String> formatJson(final Map<String, String> valuesMap) {
        String fullName = valuesMap.get(LeadFields.NAME_SALUTATION.toString()) + " "
                + valuesMap.get(LeadFields.FIRST_NAME.toString()) + " "
                + valuesMap.get(LeadFields.LAST_NAME.toString());
        fullName = formatString(fullName);

        String address = formatAddress(valuesMap);

        if (valuesMap.containsKey(LeadFields.ANNUAL_REVENUE.toString())) {
            String annualRevenueFormatted = formatNumber(valuesMap.get(LeadFields.ANNUAL_REVENUE.toString()));
            valuesMap.put(LeadFields.ANNUAL_REVENUE.toString(), annualRevenueFormatted);
        }

        valuesMap.put(LeadFields.FULL_NAME.toString(), fullName);
        valuesMap.put(LeadFields.ADDRESS.toString(), address);

        valuesMap.remove(LeadFields.NAME_SALUTATION.toString());
        valuesMap.remove(LeadFields.FIRST_NAME.toString());
        valuesMap.remove(LeadFields.LAST_NAME.toString());
        valuesMap.remove(LeadFields.CAMPAIGN.toString());

        valuesMap.remove(LeadFields.STREET.toString());
        valuesMap.remove(LeadFields.CITY.toString());
        valuesMap.remove(LeadFields.STATE_PROVINCE.toString());
        valuesMap.remove(LeadFields.ZIP_CODE.toString());
        valuesMap.remove(LeadFields.COUNTRY.toString());

        valuesMap.remove(LeadFields.ASSIGN_RULE.toString());

        return valuesMap;
    }

    /**
     * Method that give format to a number.
     *
     * @param number String with the number to be Formatted.
     * @return a String with the number formatted.
     */
    private String formatNumber(final String number) {
        return NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(number));
    }

    /**
     * Method that give a format to an Address.
     *
     * @param valuesMap Map that contain the address values to be formatted.
     * @return a String with the formatted address.
     */
    private String formatAddress(final Map<String, String> valuesMap) {
        String address = "";
        if (String.valueOf(valuesMap.get(LeadFields.ZIP_CODE.toString())).equals("null")) {
            address = valuesMap.get(LeadFields.STREET.toString()) + "\n"
                    + valuesMap.get(LeadFields.CITY.toString())
                    + ", " + valuesMap.get(LeadFields.STATE_PROVINCE.toString())
                    + "\n" + valuesMap.get(LeadFields.COUNTRY.toString());
        } else {
            address = valuesMap.get(LeadFields.STREET.toString()) + "\n"
                    + valuesMap.get(LeadFields.CITY.toString())
                    + ", " + valuesMap.get(LeadFields.STATE_PROVINCE.toString())
                    + " " + valuesMap.get(LeadFields.ZIP_CODE.toString())
                    + "\n" + valuesMap.get(LeadFields.COUNTRY.toString());
        }
        return formatString(address);
    }

    /**
     * Method that give a format to a string.
     *
     * @param value String with the value data.
     * @return the string formatted.
     */
    private String formatString(final String value) {
        String result = value.replaceAll("null", "").trim();
        if (result.startsWith(",")) {
            result = result.replaceAll(",", "").trim();
        }
        return result;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public LeadForm selectNameSalutation(final String item) {
        CommonActions.clickElement(nameSalutationSelect);
        CommonActions.selectAnElement(nameSalutationItems, item).click();
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public LeadForm selectLeadSource(final String item) {
        CommonActions.clickElement(leadSourceSelect);
        CommonActions.selectAnElement(leadSourceItems, item).click();
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public LeadForm selectIndustry(final String item) {
        CommonActions.clickElement(industrySelect);
        CommonActions.selectAnElement(industrySelectItems, item).click();
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public LeadForm selectLeadStatus(final String item) {
        CommonActions.clickElement(leadStatustTextField);
        CommonActions.selectAnElement(leatStatusItems, item).click();
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public LeadForm selectRating(final String item) {
        CommonActions.clickElement(ratingTextField);
        CommonActions.selectAnElement(ratingItems, item).click();
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public LeadForm selectProductInterest(final String item) {
        CommonActions.clickElement(productInterestSelect);
        CommonActions.selectAnElement(productInterestItems, item).click();
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public LeadForm selectPrimary(final String item) {
        CommonActions.clickElement(primarySelect);
        CommonActions.selectAnElement(primaryItems, item).click();
        return this;
    }

    /**
     * Method to sets the values to create a new LeadFields.
     *
     * @param values Map with the information to be mapped.
     * @return a Map with the corresponding values.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(LeadFields.NAME_SALUTATION.toString(),
                () -> selectNameSalutation(values.get(LeadFields.NAME_SALUTATION.toString())));
        strategyMap.put(LeadFields.FIRST_NAME.toString(),
                () -> setFirstNameTextField(values.get(LeadFields.FIRST_NAME.toString())));
        strategyMap.put(LeadFields.LAST_NAME.toString(),
                () -> setLastNameTextField(values.get(LeadFields.LAST_NAME.toString())));
        strategyMap.put(LeadFields.COMPANY.toString(),
                () -> setCompanyTextField(values.get(LeadFields.COMPANY.toString())));
        strategyMap.put(LeadFields.TITLE.toString(),
                () -> CommonActions.sendKeys(titleField, values.get(LeadFields.TITLE.toString())));
        strategyMap.put(LeadFields.LEAD_SOURCE.toString(),
                () ->  selectLeadSource(values.get(LeadFields.LEAD_SOURCE.toString())));
        //strategyMap.put(CAMPAIGN.toString(),
          //      () -> selectCampaign(values.get(CAMPAIGN.toString())));
        strategyMap.put(LeadFields.INDUSTRY.toString(),
                () ->  selectIndustry(values.get(LeadFields.INDUSTRY.toString())));
        strategyMap.put(LeadFields.ANNUAL_REVENUE.toString(),
                () -> CommonActions.sendKeys(annualRevenueTextField, values.get(LeadFields.ANNUAL_REVENUE.toString())));
        strategyMap.put(LeadFields.PHONE.toString(),
                () -> CommonActions.sendKeys(phoneTextField, values.get(LeadFields.PHONE.toString())));
        strategyMap.put(LeadFields.MOBILE.toString(),
                () -> CommonActions.sendKeys(mobileTextField, values.get(LeadFields.MOBILE.toString())));
        strategyMap.put(LeadFields.FAX.toString(),
                () -> CommonActions.sendKeys(faxTextField, values.get(LeadFields.FAX.toString())));
        strategyMap.put(LeadFields.EMAIL.toString(),
                () -> CommonActions.sendKeys(emailTextField, values.get(LeadFields.EMAIL.toString())));
        strategyMap.put(LeadFields.WEBSITE.toString(),
                () -> CommonActions.sendKeys(websiteTextField, values.get(LeadFields.WEBSITE.toString())));
        strategyMap.put(LeadFields.LEAD_STATUS.toString(),
                () -> selectLeadStatus(values.get(LeadFields.LEAD_STATUS.toString())));
        strategyMap.put(LeadFields.RATING.toString(),
                () -> selectRating(values.get(LeadFields.RATING.toString())));
        strategyMap.put(LeadFields.NUM_EMPLOYEES.toString(),
                () -> CommonActions.sendKeys(numEmployeesTextField, values.get(LeadFields.NUM_EMPLOYEES.toString())));
        strategyMap.put(LeadFields.STREET.toString(),
                () -> CommonActions.sendKeys(streetTextField, values.get(LeadFields.STREET.toString())));
        strategyMap.put(LeadFields.CITY.toString(),
                () -> CommonActions.sendKeys(cityTextField, values.get(LeadFields.CITY.toString())));
        strategyMap.put(LeadFields.STATE_PROVINCE.toString(),
                () -> CommonActions.sendKeys(stateTextField, values.get(LeadFields.STATE_PROVINCE.toString())));
        strategyMap.put(LeadFields.ZIP_CODE.toString(),
                () -> CommonActions.sendKeys(zipCodeTextField, values.get(LeadFields.ZIP_CODE.toString())));
        strategyMap.put(LeadFields.COUNTRY.toString(),
                () -> CommonActions.sendKeys(countryTextField, values.get(LeadFields.COUNTRY.toString())));
        strategyMap.put(LeadFields.PRODUCT_INTEREST.toString(),
                () ->  selectProductInterest(values.get(LeadFields.PRODUCT_INTEREST.toString())));
        strategyMap.put(LeadFields.SICCODE.toString(),
                () -> CommonActions.sendKeys(sicCodeTextField, values.get(LeadFields.SICCODE.toString())));
        strategyMap.put(LeadFields.NUMBER_LOCATIONS.toString(),
                () -> CommonActions.sendKeys(numLocationsTextField,
                        values.get(LeadFields.NUMBER_LOCATIONS.toString())));
        strategyMap.put(LeadFields.CURRENT_GENERATORS.toString(),
                () -> CommonActions.sendKeys(currentGeneratorsTextField,
                        values.get(LeadFields.CURRENT_GENERATORS.toString())));
        strategyMap.put(LeadFields.PRIMARY.toString(),
                () -> selectPrimary(values.get(LeadFields.PRIMARY.toString())));
        strategyMap.put(LeadFields.DESCRIPTION.toString(),
                () -> CommonActions.sendKeys(descriptionTextArea, values.get(LeadFields.DESCRIPTION.toString())));
        strategyMap.put(LeadFields.ASSIGN_RULE.toString(),
                () -> setAssignRule(values.get(LeadFields.ASSIGN_RULE.toString())));

        return strategyMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadForm clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new LeadForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadDetails clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new LeadDetails();
    }

    /**
     * Inner class that manage the values to be built.
     */
    public static class LeadBuilder {

        private Map<String, String> strategyMap;

        /**
         * Constructor that set the required values for the Lead Form.
         *
         * @param lastName Last Name required value.
         * @param company  company data.
         */
        public LeadBuilder(final String lastName, final String company) {
            strategyMap = new HashMap<>();
            strategyMap.put(LeadFields.LAST_NAME.toString(), lastName);
            strategyMap.put(LeadFields.COMPANY.toString(), company);
        }

        /**
         * Method that set the Salutation for the Lead.
         *
         * @param nameSalutation Salutation info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNameSalutation(final String nameSalutation) {
            strategyMap.put(LeadFields.NAME_SALUTATION.toString(), nameSalutation);
            return this;
        }

        /**
         * Method that set the first name data.
         *
         * @param firstName String with the first name info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setFirstName(final String firstName) {
            strategyMap.put(LeadFields.FIRST_NAME.toString(), firstName);
            return this;
        }

        /**
         * Method that set the Last name data.
         *
         * @param lastName String with the Last Name info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLastName(final String lastName) {
            strategyMap.put(LeadFields.LAST_NAME.toString(), lastName);
            return this;
        }

        /**
         * Method that set the Lead company.
         *
         * @param company String with the company info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCompany(final String company) {
            strategyMap.put(LeadFields.COMPANY.toString(), company);
            return this;
        }

        /**
         * Method that sets the Lead title data.
         *
         * @param title String with the title info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setTitle(final String title) {
            strategyMap.put(LeadFields.TITLE.toString(), title);
            return this;
        }

        /**
         * Method that sets the Lead source info.
         *
         * @param leadSource String with the source info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLeadSource(final String leadSource) {
            strategyMap.put(LeadFields.LEAD_SOURCE.toString(), leadSource);
            return this;
        }

        /**
         * Method that sets the Lead campaign.
         *
         * @param campaign String with the Campaign name.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCampaign(final String campaign) {
            strategyMap.put(LeadFields.CAMPAIGN.toString(), campaign);
            return this;
        }

        /**
         * Method that sets the Lead industry.
         *
         * @param industry String with the industry data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setIndustry(final String industry) {
            strategyMap.put(LeadFields.INDUSTRY.toString(), industry);
            return this;
        }

        /**
         * Method that sets the Lead Annual Revenue info.
         *
         * @param annualRevenue String with the annual revenue data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setAnnualRevenue(final String annualRevenue) {
            strategyMap.put(LeadFields.ANNUAL_REVENUE.toString(), annualRevenue);
            return this;
        }

        /**
         * Method that sets the Lead phone number.
         *
         * @param phone String with the phone data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setPhone(final String phone) {
            strategyMap.put(LeadFields.PHONE.toString(), phone);
            return this;
        }

        /**
         * Method that sets the Lead mobile number.
         *
         * @param mobile String with the phone data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setMobile(final String mobile) {
            strategyMap.put(LeadFields.MOBILE.toString(), mobile);
            return this;
        }

        /**
         * Method that sets the Lead Fax number.
         *
         * @param fax String with the fax data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setFax(final String fax) {
            strategyMap.put(LeadFields.FAX.toString(), fax);
            return this;
        }

        /**
         * Method that sets the Lead Email info.
         *
         * @param email String with the email data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setEmail(final String email) {
            strategyMap.put(LeadFields.EMAIL.toString(), email);
            return this;
        }

        /**
         * Method that sets the Lead website.
         *
         * @param website String with the website data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setWebsite(final String website) {
            strategyMap.put(LeadFields.WEBSITE.toString(), website);
            return this;
        }

        /**
         * Method that sets the Lead status.
         *
         * @param leadStatus String with the status data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLeadStatus(final String leadStatus) {
            strategyMap.put(LeadFields.LEAD_STATUS.toString(), leadStatus);
            return this;
        }

        /**
         * Method that sets the Lead rating.
         *
         * @param rating String with the Rating data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setRating(final String rating) {
            strategyMap.put(LeadFields.RATING.toString(), rating);
            return this;
        }

        /**
         * Method that sets the Lead employee number.
         *
         * @param numEmployees String with the employee data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNumEmployees(final String numEmployees) {
            strategyMap.put(LeadFields.NUM_EMPLOYEES.toString(), numEmployees);
            return this;
        }

        /**
         * Method that sets the Lead street.
         *
         * @param street String with the street data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setStreet(final String street) {
            strategyMap.put(LeadFields.STREET.toString(), street);
            return this;
        }

        /**
         * Method that sets the Lead city.
         *
         * @param city String with the city data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCity(final String city) {
            strategyMap.put(LeadFields.CITY.toString(), city);
            return this;
        }

        /**
         * Method that sets the Lead State or Province.
         *
         * @param stateProvince String with the state/province data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setStateProvince(final String stateProvince) {
            strategyMap.put(LeadFields.STATE_PROVINCE.toString(), stateProvince);
            return this;
        }

        /**
         * Method that sets the Lead Zip code.
         *
         * @param zipCode String with the zip code data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setZipCode(final String zipCode) {
            strategyMap.put(LeadFields.ZIP_CODE.toString(), zipCode);
            return this;
        }

        /**
         * Method that sets the Lead country.
         *
         * @param country String with the country data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCountry(final String country) {
            strategyMap.put(LeadFields.COUNTRY.toString(), country);
            return this;
        }

        /**
         * Method that sets the Lead product interest.
         *
         * @param productInterest String with the product interest data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setProductInterest(final String productInterest) {
            strategyMap.put(LeadFields.PRODUCT_INTEREST.toString(), productInterest);
            return this;
        }

        /**
         * Method that sets the Lead siccode.
         *
         * @param sicCode String with the sic code data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setSicCode(final String sicCode) {
            strategyMap.put(LeadFields.SICCODE.toString(), sicCode);
            return this;
        }

        /**
         * Method that sets the Lead number locations.
         *
         * @param numberLocations String with the number locations data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNumberLocations(final String numberLocations) {
            strategyMap.put(LeadFields.NUMBER_LOCATIONS.toString(), numberLocations);
            return this;
        }

        /**
         * Method that sets the current generators.
         *
         * @param currentGenerators String with the current generator data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCurrentGenerators(final String currentGenerators) {
            strategyMap.put(LeadFields.CURRENT_GENERATORS.toString(), currentGenerators);
            return this;
        }

        /**
         * Method that sets the Lead primary.
         *
         * @param primary String with the primary data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setPrimary(final String primary) {
            strategyMap.put(LeadFields.PRIMARY.toString(), primary);
            return this;
        }

        /**
         * Method that sets the Lead description.
         *
         * @param description String with the description data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setDescription(final String description) {
            strategyMap.put(LeadFields.DESCRIPTION.toString(), description);
            return this;
        }

        /**
         * Method that sets the assign rule.
         *
         * @param assignRule String with the assign rule info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setAssignRule(final String assignRule) {
            strategyMap.put(LeadFields.ASSIGN_RULE.toString(), assignRule);
            return this;
        }

        /**
         * Method that return the map with the values sent to fill the lead form.
         *
         * @return the Map with the saved values.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        /**
         * Method that build the Lead.
         *
         * @return {@link LeadForm}
         */
        public LeadForm build() {
            return new LeadForm(this);
        }
    }

}
