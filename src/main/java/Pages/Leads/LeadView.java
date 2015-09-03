package Pages.Leads;

import Framework.CommonActions;
import Pages.Base.ViewBase;

public class LeadView extends ViewBase {
	
	public LeadView() {
		super();
	}
	
	public NewLeadForm clickEditLnk() {
		CommonActions.click(editLnk);
		return new NewLeadForm();	
	}

}
