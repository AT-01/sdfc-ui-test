package org.fundacionjala.sfdc.pages.cases;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * This class manage the information page objects.
 */
public class CaseInformation extends AbstractBasePage {

    /**
     * @return CaseDetail .
     */
    public CaseDetail clickOndetailsPanelOption() {
        return new CaseDetail();
    }

}
