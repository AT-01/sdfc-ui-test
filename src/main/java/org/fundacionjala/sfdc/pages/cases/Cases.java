package org.fundacionjala.sfdc.pages.cases;

import java.util.HashMap;
import java.util.Map;

/**
 * this class build a case.
 */
public class Cases {

    private Cases.CasesBuilder casesBuilder;

    private Map<String, String> valuesMap;

    /**
     * Constructor.
     *
     * @param casesBuilder Builder class.
     */
    public Cases(final CasesBuilder casesBuilder) {
        valuesMap = new HashMap<>();
        this.casesBuilder = casesBuilder;
    }

    /**
     * create a cse.
     *
     * @return CaseDetail class.
     */
    public CaseDetail createCases() {
        CasesForm casesForm = new CasesForm();
        valuesMap = casesBuilder.getStrategyMap();
        casesForm.fillTheForm(valuesMap);
        CaseInformation caseInformation = casesForm.clickSaveButton();
        return caseInformation.clickOndetailsPanelOption();
    }

    /**
     * get the map whit the values.
     *
     * @return Map whit the values.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * builder Pattern.
     */


    public static class CasesBuilder {

        private Map<String, String> strategyMap;

        /**
         * build case.
         *
         * @return Cases class.
         */
        public Cases build() {
            return new Cases(this);
        }

        /**
         * Constructor.
         * @param status String whit the status value.
         * @param caseOrigin String whit the case origin value.
         */
        public CasesBuilder(final String status, final String caseOrigin) {
            strategyMap = new HashMap<>();
            strategyMap.put("status", status);
            strategyMap.put("caseOrigin", caseOrigin);
        }

        /**
         * set the priority text.
         *
         * @param priority String whit the option.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setPriority(final String priority) {
            strategyMap.put("priority", priority);
            return this;
        }

        /**
         * set the type text.
         *
         * @param type String whit the value.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setTypeValue(final String type) {
            strategyMap.put("type", type);
            return this;
        }

        /**
         * set the case reason.
         *
         * @param caseReason String case Reasin text.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setCaseReason(final String caseReason) {
            strategyMap.put("caseReason", caseReason);
            return this;
        }

        /**
         * set the product value.
         *
         * @param product String whit the value.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setProductValue(final String product) {
            strategyMap.put("product", product);
            return this;
        }

        /**
         * set the potential liability text.
         *
         * @param potentialLiability String whit the text.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setPotentialLiability(final String potentialLiability) {
            strategyMap.put("potentialLiability", potentialLiability);
            return this;
        }

        /**
         * set the engineering number.
         *
         * @param engineeringNumber String whit the text.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setEngineeringNumber(final String engineeringNumber) {
            strategyMap.put("engineeringNumber", engineeringNumber);
            return this;
        }

        /**
         * set sla value.
         *
         * @param slaViolation String whit the value.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setSlaViolation(final String slaViolation) {
            strategyMap.put("slaViolation", slaViolation);
            return this;
        }

        /**
         * set the subject text.
         *
         * @param subject String whit the value.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setSubject(final String subject) {
            strategyMap.put("subject", subject);
            return this;
        }

        /**
         * set the description.
         *
         * @param description String whit the description.
         * @return Cases.CasesBuilder class.
         */
        public Cases.CasesBuilder setDescription(final String description) {
            strategyMap.put("description", description);
            return this;
        }

        /**
         * get the strategy map.
         *
         * @return Map whit the values.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

    }

}
