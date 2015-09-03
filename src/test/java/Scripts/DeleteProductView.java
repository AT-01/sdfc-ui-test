package Scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Products.NewProductForm;
import Pages.Products.ProductView;
import Pages.Products.ProductsHome;

public class DeleteProductView {
	
	private ProductsHome productHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewProductForm productForm;
    private String productViewName = "testProductView1";
    private String productViewUniqueName = "testProductUniqueView1";
    private ProductView productView;
    
    @BeforeMethod
	public void createProductView() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        productHome = tabBar.clickProductsTab();
        productForm = (NewProductForm) productHome.clickNewViewLnk().setViewName(productViewName).setViewUniqueName(productViewUniqueName);
		productView = productForm.clickSaveBtn();
	}
	
	@Test
	public void deleteProductViewTest(){
		productForm = productView.clickEditLnk();
		productForm.clickDeleteBtn();
		Assert.assertFalse(productView.isViewDisplayed(), "Product View Deleted");	
		 
	}

}
