package org.fundacionjala.sfdc.tests.cases;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.cases.CaseDetail;
import org.fundacionjala.sfdc.pages.cases.CaseInformation;
import org.fundacionjala.sfdc.pages.cases.CasesForm;
import org.fundacionjala.sfdc.pages.cases.CasesHome;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertFalse;

/**
 * This is in charge to execute the test Delete Case .
 */
public class DeleteCases {
    private static final String CASES_DATA_PATH = "cases/CreateCasesData.json";
    private Map<String, String> valuesMapJson;
    private CasesHome casesHome;
    private CaseInformation caseInformation;
    private CaseDetail caseDetail;

    /**
     * This method is a preconditions to create a case.
     */
    @BeforeMethod
    public void setUp() {
        LoginPage.loginAsPrimaryUser();
        MainApp mainApp = new MainApp();
        AppLauncher appLauncher = mainApp.clickAppLauncher();
        casesHome = appLauncher.clickOnCasesHome();
        valuesMapJson = JsonMapper.getMapJson(CASES_DATA_PATH);
        CasesForm casesForm = casesHome.clickNewButton();
        casesForm.fillTheForm(valuesMapJson);
        caseInformation = casesForm.clickSaveButton();
    }

    /**
     * This method test the elimination of a Case.
     */
    @Test
    public void createCaseWhitJsonFile() {
        caseDetail = caseInformation.clickOndetailsPanelOption();
        casesHome = caseDetail.clickDeleteButton();
        casesHome.clickConfirmationDelete();
        assertFalse(casesHome.existCase(valuesMapJson.get("Subject")));
    }

}
