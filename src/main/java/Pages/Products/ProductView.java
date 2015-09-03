package Pages.Products;

import Framework.CommonActions;
import Pages.Base.ViewBase;

public class ProductView extends ViewBase{
	
	public ProductView() {
		super();
	}
			
	public NewProductForm clickEditLnk() {
		CommonActions.click(editLnk);
		return new NewProductForm();	
	}

}
