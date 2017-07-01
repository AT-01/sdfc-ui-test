package org.fundacionjala.sfdc.pages.campaigns;

import java.util.HashMap;
import java.util.Map;

/**
 * The builder Pattern.
 */
public class Campaigns {

    private CampaignBuilder campaignBuilder;

    private Map<String, String> valuesMap;

    /**
     * constructor.
     *
     * @param campaignBuilder Product Builder.
     */
    public Campaigns(final CampaignBuilder campaignBuilder) {
        valuesMap = new HashMap<>();
        this.campaignBuilder = campaignBuilder;
    }

    /**
     * create  the campaign.
     *
     * @return campaign Form.
     */
    public CampaignDetail createCampaign() {
        CampaignForm campaignForm = new CampaignForm();
        valuesMap = campaignBuilder.getStrategyMap();
        campaignForm.fillTheForm(valuesMap);
        return campaignForm.clickSaveButton();
    }

    /**
     * get the value map.
     *
     * @return Map whit the values.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * builder Pattern.
     */
    public static class CampaignBuilder {

        private Map<String, String> strategyMap;

        /**
         * build the campaign.
         *
         * @return Campaign.
         */
        public Campaigns build() {
            return new Campaigns(this);
        }

        /**
         * constructor.
         *
         * @param name String the name of the campaign.
         */
        public CampaignBuilder(final String name) {
            strategyMap = new HashMap<>();
            strategyMap.put("campaignName", name);
        }

        /**
         * set the start date.
         *
         * @param startDate String whit the date.
         * @return campaign builder
         */
        public CampaignBuilder setStartDate(final String startDate) {
            strategyMap.put("startDate", startDate);
            return this;
        }

        /**
         * set the  type drop down list.
         *
         * @param typeDropDown String whit the value.
         * @return campaign builder.
         */
        public CampaignBuilder setTypeDropDown(final String typeDropDown) {
            strategyMap.put("typeDropDown", typeDropDown);
            return this;
        }

        /**
         * set the  status drop down list.
         *
         * @param statusDropDown String whit the value.
         * @return campaign builder.
         */
        public CampaignBuilder setStatusDropDown(final String statusDropDown) {
            strategyMap.put("statusDropDown", statusDropDown);
            return this;
        }

        /**
         * set the revenue value.
         *
         * @param revenue String with the value.
         * @return campaign builder.
         */
        public CampaignBuilder setRevenue(final String revenue) {
            strategyMap.put("revenue", revenue);
            return this;
        }

        /**
         * set the end date.
         *
         * @param endDate String with the date.
         * @return campaign builder.
         */
        public CampaignBuilder setEndDate(final String endDate) {
            strategyMap.put("endDate", endDate);
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

        /**
         * Set budgeted cost.
         *
         * @param budgetedCost String value.
         * @return value campaign.
         */
        public CampaignBuilder setBudgetedCost(final String budgetedCost) {
            strategyMap.put("budgetedCost", budgetedCost);
            return this;
        }

        /**
         * Set actual cost.
         *
         * @param actualCost String value.
         * @return value campaign.
         */
        public CampaignBuilder setActualCost(String actualCost) {
            strategyMap.put("actualCost", actualCost);
            return this;
        }

        /**
         * Set expected response.
         *
         * @param expectedResponse String value.
         * @return value to campaign.
         */
        public CampaignBuilder setExpectedResponse(String expectedResponse) {
            strategyMap.put("expectedResponse", expectedResponse);
            return this;
        }

        /**
         * Set num sent in campaign.
         *
         * @param numSentInCampaign String value.
         * @return value to campaign.
         */
        public CampaignBuilder setNumSentInCampaign(String numSentInCampaign) {
            strategyMap.put("numSentInCampaign", numSentInCampaign);
            return this;
        }

        /**
         * Set description to campaign.
         *
         * @param description string value.
         * @return description to campaign.
         */
        public CampaignBuilder setDescription(String description) {
            strategyMap.put("description", description);
            return this;
        }
    }

}
