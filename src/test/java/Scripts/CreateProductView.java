package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Opportunities.NewOpportunityForm;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Opportunities.OpportunityView;
import Pages.Products.NewProductForm;
import Pages.Products.ProductView;
import Pages.Products.ProductsHome;

public class CreateProductView {
	
	private ProductsHome productHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewProductForm productForm;
    private String productViewName = "testProductView1";
    private String productViewUniqueName = "testProductUniqueView1";
    private ProductView productView;
    
    @BeforeMethod
	public void login() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        productHome = tabBar.clickProductsTab();    
	}
	
	@Test
	public void createProductViewTest(){
		
		productForm = (NewProductForm) productHome.clickNewViewLnk().setViewName(productViewName).setViewUniqueName(productViewUniqueName);
		productView = productForm.clickSaveBtn();
		Assert.assertTrue(productView.isViewDisplayed(), "Product View Displayed");	
		 
	}
	
	@AfterMethod
	public void deleteProductView() {
		productForm = productView.clickEditLnk();
		productForm.clickDeleteBtn();
		
	}	

}
