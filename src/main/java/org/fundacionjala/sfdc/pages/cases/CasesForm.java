package org.fundacionjala.sfdc.pages.cases;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fundacionjala.sfdc.pages.cases.CasesFields.DESCRIPTION_TEXT;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.SLA_VIOLATION;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.SUBJECT_TEXT;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.ENGINEERING_NUMBER;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.POTENTIAL_LIABILITY;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.PRODUCT_VALUE;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.CASE_REASON;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.TYPE_VALUE;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.PRIORITY_VALUE;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.STATUS_DROOPDOWNLIST;
import static org.fundacionjala.sfdc.pages.cases.CasesFields.CASES_ORIGIN_DROOPDOWNLIST;

import static java.lang.String.valueOf;

/**
 * This class manage the cases form page objects.
 */
public class CasesForm extends FormBase {

    @FindBy(xpath = "//span[text()='Status']/../following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement statusDropDownList;

    @FindBy(css = "a[role=\"menuitemradio\"]")
    @CacheLookup
    private List<WebElement> statusDropDownListItemms;


    @FindBy(xpath = "//span[text()='Case Origin']/../following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement caseOriginDropDownList;

    @FindBy(css = "a[role=\"menuitemradio\"]")
    @CacheLookup
    private List<WebElement> caseOriginDropDownListItems;

    @FindBy(xpath = "//span[text()='SLA Violation']/../following::a")
    @CacheLookup
    private WebElement slaDropDownList;

    @FindBy(css = "a[role=\"menuitemradio\"]")
    @CacheLookup
    private List<WebElement> slaDropDownListItems;


    @FindBy(xpath = "//span[text()='Engineering Req Number']/../following::input")
    @CacheLookup
    private WebElement engieeneringNumberTextField;


    @FindBy(xpath = "//span[text()='Potential Liability']/../following::a")
    @CacheLookup
    private WebElement liabilityDropDownList;

    @FindBy(css = "a[role=\"menuitemradio\"]")
    @CacheLookup
    private List<WebElement> liabilityDropDownListItems;

    @FindBy(xpath = "//span[text()='Product']/../following::a")
    @CacheLookup
    private WebElement productDropDownList;


    @FindBy(css = "a[role=\"menuitemradio\"]")
    @CacheLookup
    private List<WebElement> productDropDownListItems;

    @FindBy(xpath = "//span[text()='Case Reason']/../following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement caseReasonDropDownList;

    @FindBy(css = "a[role=\"menuitemradio\"]")
    @CacheLookup
    private List<WebElement> caseReasonDropDownListItems;

    @FindBy(xpath = "//span[text()='Type']/../following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement typeDropDownList;

    @FindBy(css = "a[role=\"menuitemradio\"]")
    @CacheLookup
    private List<WebElement> typeDropDownListItems;


    @FindBy(xpath = "//span[text()='Priority']/../following-sibling::div/descendant::a")
    @CacheLookup
    private WebElement priorityDropDownList;

    @FindBy(css = "a[role=\"menuitemradio\"]")
    @CacheLookup
    private List<WebElement> priorityDropDownListItems;


    @FindBy(xpath = "//span[text()='Subject']/../.././input")
    @CacheLookup
    private WebElement subjectTextBox;

    @FindBy(xpath = "//span[text()='Description']/../following-sibling::textarea")
    @CacheLookup
    private WebElement descriptionTextBox;

    /**
     * {@inheritDoc}
     */
    @Override
    public CaseInformation clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new CaseInformation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickSaveNewButton() {
        return null;
    }

    /**
     * This method loads data to fill the form for a given Json file .
     *
     * @param valuesMapCreate Map
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * fill the map whit the sensed value.
     *
     * @param values Map whit the values.
     * @return Map whit the values.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();
        strategyMap.put(STATUS_DROOPDOWNLIST.getValue(),
                () -> setStatusDropDownList(valueOf(values.get(STATUS_DROOPDOWNLIST.getValue()))));
        strategyMap.put(CASES_ORIGIN_DROOPDOWNLIST.getValue(),
                () -> setCaseOriginDropDownList(valueOf(values.get(CASES_ORIGIN_DROOPDOWNLIST.getValue()))));
        strategyMap.put(PRIORITY_VALUE.getValue(),
                () -> setPriority(valueOf(values.get(PRIORITY_VALUE.getValue()))));
        strategyMap.put(TYPE_VALUE.getValue(), () -> setType(valueOf(values.get(TYPE_VALUE.getValue()))));
        strategyMap.put(CASE_REASON.getValue(), () -> setCaseReason(valueOf(values.get(CASE_REASON.getValue()))));
        strategyMap.put(PRODUCT_VALUE.getValue(), () -> setProduct(valueOf(values.get(PRODUCT_VALUE.getValue()))));
        strategyMap.put(POTENTIAL_LIABILITY.getValue(),
                () -> setPotentialLiability(valueOf(values.get(POTENTIAL_LIABILITY.getValue()))));
        strategyMap.put(ENGINEERING_NUMBER.getValue(),
                () -> setEngineeringNumber(valueOf(values.get(ENGINEERING_NUMBER.getValue()))));
        strategyMap.put(SLA_VIOLATION.getValue(),
                () -> setSlaViolation(valueOf(values.get(SLA_VIOLATION.getValue()))));
        strategyMap.put(SUBJECT_TEXT.getValue(),
                () -> setSubjectText(valueOf(values.get(SUBJECT_TEXT.getValue()))));
        strategyMap.put(DESCRIPTION_TEXT.getValue(),
                () -> setDescriptionText(valueOf(values.get(DESCRIPTION_TEXT.getValue()))));
        return strategyMap;
    }


    /**
     * set the description text.
     *
     * @param description String whit the text.
     * @return CasesForm class.
     */
    private CasesForm setDescriptionText(final String description) {
        CommonActions.sendKeys(descriptionTextBox, description);
        return this;
    }

    /**
     * set the subject text.
     *
     * @param subject String
     * @return CasesForm class.
     */
    private CasesForm setSubjectText(final String subject) {
        CommonActions.sendKeys(subjectTextBox, subject);
        return this;
    }

    /**
     * set the sla text.
     *
     * @param sla String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setSlaViolation(final String sla) {
        CommonActions.clickElement(slaDropDownList);
        CommonActions.selectAnElement(slaDropDownListItems, sla).click();
        return this;
    }

    /**
     * set the engineering Number.
     *
     * @param engieeneringNumber String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setEngineeringNumber(final String engieeneringNumber) {
        CommonActions.sendKeys(engieeneringNumberTextField, engieeneringNumber);
        return this;
    }

    /**
     * set the liability value.
     *
     * @param liability String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setPotentialLiability(final String liability) {
        CommonActions.clickElement(liabilityDropDownList);
        CommonActions.selectAnElement(liabilityDropDownListItems, liability).click();
        return this;
    }

    /**
     * set the product text.
     *
     * @param product String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setProduct(final String product) {
        CommonActions.clickElement(productDropDownList);
        CommonActions.selectAnElement(productDropDownListItems, product).click();
        return this;
    }

    /**
     * set te case Reason text.
     *
     * @param caseReason String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setCaseReason(final String caseReason) {
        CommonActions.clickElement(caseReasonDropDownList);
        CommonActions.selectAnElement(caseReasonDropDownListItems, caseReason).click();
        return this;
    }

    /**
     * set the type text.
     *
     * @param type String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setType(final String type) {
        CommonActions.clickElement(typeDropDownList);
        CommonActions.selectAnElement(typeDropDownListItems, type).click();
        return this;
    }

    /**
     * set the priority text.
     *
     * @param priority String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setPriority(final String priority) {
        CommonActions.clickElement(priorityDropDownList);
        CommonActions.selectAnElement(priorityDropDownListItems, priority).click();
        return this;
    }

    /**
     * set the case origin text.
     *
     * @param caseOrigin String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setCaseOriginDropDownList(final String caseOrigin) {
        CommonActions.clickElement(caseOriginDropDownList);
        CommonActions.selectAnElement(caseOriginDropDownListItems, caseOrigin).click();
        return this;
    }

    /**
     * set the estatus value.
     *
     * @param status String whit the value.
     * @return CasesForm class.
     */
    private CasesForm setStatusDropDownList(final String status) {

        CommonActions.clickElement(statusDropDownList);
        CommonActions.selectAnElement(statusDropDownListItemms, status).click();
        return this;
    }


}
