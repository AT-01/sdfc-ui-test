package org.fundacionjala.sfdc.pages.cases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;

/**
 * This class manage the Detail page objects.
 */
public class CaseDetail extends DetailBase {

    @FindBy(xpath = "//span[text()='Case Origin']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement caseOriginTextField;

    @FindBy(xpath = "//span[text()='Status']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement statusTextField;

    @FindBy(xpath = "//span[text()='Priority']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement priorityLabel;

    @FindBy(xpath = "//span[text()='Type']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement typeLabel;

    @FindBy(xpath = "//span[text()='Case Reason']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement casesReasonLabel;

    @FindBy(xpath = "//span[text()='Product']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement productLabel;

    @FindBy(xpath = "//span[text()='Potential Liability']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement liabilityLabel;

    @FindBy(xpath = "//span[text()='Engineering Number']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement engineeringNumberLabel;

    @FindBy(xpath = "//span[text()='SLA Violation']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement slaLabel;

    @FindBy(xpath = "//span[text()='Subject']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement subjectLabel;

    @FindBy(xpath = "//span[text()='Description']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement descriptionLabel;

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditButton() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CasesHome clickDeleteButton() {
        CommonActions.clickElement(deleteBtn);
        return new CasesHome();
    }

    /**
     * fill the map.
     *
     * @return Map whi the values charged.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();
        strategyMap.put(CasesFields.CASES_ORIGIN.getValue(), this::getCasesOrigin);
        strategyMap.put(CasesFields.STATUS.getValue(), this::getStatus);
        strategyMap.put(CasesFields.PRIORITY.getValue(), this::getPriority);
        strategyMap.put(CasesFields.TYPE.getValue(), this::getType);
        strategyMap.put(CasesFields.CASE_REASON.getValue(), this::getCasesReason);
        strategyMap.put(CasesFields.PRODUCT.getValue(), this::getProduct);
        strategyMap.put(CasesFields.POTENTIAL_LIABILITY.getValue(), this::getLiability);
        strategyMap.put(CasesFields.ENGINEERING_NUMBER.getValue(), this::getEngineeringNumber);
        strategyMap.put(CasesFields.SLA_VIOLATION.getValue(), this::getSla);
        strategyMap.put(CasesFields.SUBJECT.getValue(), this::getSubject);
        strategyMap.put(CasesFields.DESCRIPTION.getValue(), this::getDescription);
        return strategyMap;
    }

    /**
     * get the description text.
     *
     * @return string whit the description.
     */
    private String getDescription() {
        return CommonActions.getText(descriptionLabel);
    }

    /**
     * get a subject text.
     *
     * @return String whit the subject text.
     */
    private String getSubject() {
        return CommonActions.getText(subjectLabel);
    }

    /**
     * get the sla value.
     *
     * @return String whit the sla value.
     */
    private String getSla() {
        return CommonActions.getText(slaLabel);
    }

    /**
     * get the engineering number.
     *
     * @return String whit the number.
     */
    private String getEngineeringNumber() {
        return CommonActions.getText(engineeringNumberLabel);

    }

    /**
     * get the liability text.
     *
     * @return String whit the value.
     */
    private String getLiability() {
        return CommonActions.getText(liabilityLabel);
    }

    /**
     * get the product name.
     *
     * @return String whit the name of the product.
     */
    private String getProduct() {
        return CommonActions.getText(productLabel);
    }

    /**
     * get the cases reason Text.
     *
     * @return String whit the value.
     */
    private String getCasesReason() {
        return CommonActions.getText(casesReasonLabel);
    }

    /**
     * get the type.
     *
     * @return String whit the type.
     */
    private String getType() {
        return CommonActions.getText(typeLabel);
    }

    /**
     * get the priority.
     *
     * @return String whit the value.
     */
    private String getPriority() {
        return CommonActions.getText(priorityLabel);
    }

    /**
     * get Case origin.
     *
     * @return String whit the value.
     */
    private String getCasesOrigin() {
        return CommonActions.getText(caseOriginTextField);
    }

    /**
     * get the status.
     *
     * @return String whit the status.
     */
    private String getStatus() {
        return CommonActions.getText(statusTextField);
    }


}
