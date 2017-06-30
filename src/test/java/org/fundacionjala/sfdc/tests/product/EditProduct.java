package org.fundacionjala.sfdc.tests.product;

import java.util.Map;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;

/**
 * Class to verify the edition of product.
 */
public class EditProduct {

    private static final String PRODUCT_DATA_PATH = "product/CreateProductData.json";

    private static final String PRODUCT_EDIT = "product/EditProductData.json";

    private static final String NAME_TEST = "nameTestUpdate";

    private static final String DESCRIPTION_TEST = "description test update";

    private ProductDetail productDetail;

    private ProductForm productForm;

    /**
     * Method that define the preconditions before to execute the product edition test.
     */
    @BeforeMethod
    public void setup() {
        Map<String, String> valuesMapJson = JsonMapper.getMapJson(PRODUCT_DATA_PATH);
        LoginPage.loginAsPrimaryUser();
        MainApp mainApp = new MainApp();
        AppLauncher appLauncher = mainApp.clickAppLauncher();
        ProductHome productHome = appLauncher.clickOnProductsHome();
        ProductForm newProductForm = productHome.clickNewButton();
        newProductForm.fillTheForm(valuesMapJson);
        productDetail = newProductForm.clickSaveButton();
        productForm = productDetail.clickEditButton();
    }

    /**
     * Test to verify the edition of product given a Json file.
     */
    @Test
    public void editProductWithJson() {
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(PRODUCT_EDIT);
        productForm.fillTheForm(valuesMapEditJson);
        productDetail = productForm.clickSaveButton();
        assertDetailValues(productDetail, valuesMapEditJson);
    }

    /**
     * Test to verify the Edition of product using the builder pattern.
     */
    @Test
    public void editProduct() {
        productForm = new ProductForm.ProductBuilder(NAME_TEST)
                .setDescription(DESCRIPTION_TEST)
                .build();
        productDetail = productForm.saveProduct();
        assertDetailValues(productDetail, productForm.getValuesMap());
    }

    /**
     * Method that delete the create product in the precondition.
     */
    @AfterMethod
    public void afterTest() {
        productDetail.clickDeleteButton();
    }
}
