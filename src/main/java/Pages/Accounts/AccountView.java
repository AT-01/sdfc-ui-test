package Pages.Accounts;

import Framework.CommonActions;
import Pages.Base.ViewBase;


public class AccountView extends ViewBase{
	
	public AccountView() {
		super();
	}
	
		
	public NewAccountForm clickEditLnk() {
		CommonActions.click(editLnk);
		return new NewAccountForm();	
	}

}
