package org.fundacionjala.sfdc.tests.product;


import java.util.Map;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.pages.products.ProductFields.NAME;
import static org.testng.Assert.assertFalse;

/**
 * This class handle deleted a product.
 */
public class DeleteProduct {

    private static final String PRODUCT_DATA_PATH = "product/CreateProductData.json";

    private Map<String, String> valuesMapJson;

    private ProductDetail productDetail;

    /**
     * This method is Before setup.
     */
    @BeforeMethod
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(PRODUCT_DATA_PATH);
        LoginPage.loginAsPrimaryUser();
        MainApp mainApp = new MainApp();
        AppLauncher appLauncher = mainApp.clickAppLauncher();
        ProductHome productHome = appLauncher.clickOnProductsHome();
        ProductForm newProductForm = productHome.clickNewButton();
        newProductForm.fillTheForm(valuesMapJson);
        productDetail = newProductForm.clickSaveButton();
    }

    /**
     * This method delete a product.
     */
    @Test
    public void deleteProduct() {
        productDetail.clickDeleteButton();
        assertFalse(productDetail.isProductDisplayed(valuesMapJson.get(NAME.toString())), "ProductHome Deleted");
    }
}
