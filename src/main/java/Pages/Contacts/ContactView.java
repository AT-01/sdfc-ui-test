package Pages.Contacts;

import Framework.CommonActions;
import Pages.Base.ViewBase;

public class ContactView extends ViewBase{
	
	public ContactView() {
		super();
	}
		
	public NewContactForm clickEditLnk() {
		CommonActions.click(editLnk);
		return new NewContactForm();	
	}

}
