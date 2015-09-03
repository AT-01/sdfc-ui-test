package Pages.Campaigns;

import Framework.CommonActions;
import Pages.Base.ViewBase;

public class CampaignView extends ViewBase{
	
	public CampaignView() {
		super();
	}
	
		
	public NewCampaignForm clickEditLnk() {
		CommonActions.click(editLnk);
		return new NewCampaignForm();	
	}
	
}
