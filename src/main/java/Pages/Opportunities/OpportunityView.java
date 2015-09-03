package Pages.Opportunities;

import Framework.CommonActions;
import Pages.Base.ViewBase;

public class OpportunityView extends ViewBase{
	
	public OpportunityView() {
		super();
	}
	
		
	public NewOpportunityForm clickEditLnk() {
		CommonActions.click(editLnk);
		return new NewOpportunityForm();	
	}

}
