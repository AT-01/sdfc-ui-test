package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Products.NewProductForm;
import Pages.Products.ProductView;
import Pages.Products.ProductsHome;


public class EditProductView {
	
	private ProductsHome productHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewProductForm productForm;
    private String productViewName = "testEditProductEdit";
    private String productViewUniqueName = "testEditProductUniqueEdit";  
    private String productEditedViewName = "testEditProductView123";
    private String productEditedViewUniqueName = "testEditProductUniqueView123";
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
	public void editProductViewTest(){
		productForm = productView.clickEditLnk();
		productForm.setViewName(productEditedViewName).setViewUniqueName(productEditedViewUniqueName);
		productView = productForm.clickSaveBtn();
		Assert.assertTrue(productView.isViewDisplayed(), "Product View Edited");	
		 
	}
	
	@AfterMethod
	public void deleteProductView() {
		productForm = productView.clickEditLnk();
		productForm.clickDeleteBtn();
		
	}	

}
