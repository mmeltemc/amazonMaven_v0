
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Test_Add_product_to_cart extends BaseTest{

    //POM dizayn
    HomePage homePage; //ana sayfa
    ProductsPage productsPage; //ürünü arattıktan sonraki sayfa
    ProductDetailPage productDetailPage; //ürünü seçtiğim sayfa
    CartPage cartPage; // sepet sayfası

    @Test
    @Order(1)

    public void giris(){
        homePage = new HomePage(driver); //initialize
        homePage.sıgnIn();

    }
    @Test
    @Order(2)
    public void search_Product(){


        productsPage = new ProductsPage(driver);
        homePage.searchProduct();
        Assertions.assertTrue(productsPage.onProductPage(),"Not on products page");

    }

    @Test
    @Order(3)
    public void select_Feature(){ //özellik seç

        productsPage = new ProductsPage(driver);
        productsPage.selectFeature();
      //  Assertions.assertTrue(productsPage.isThereFeature(),"The desired product was not found");
    }
    @Test
    @Order(4)
    public void sort_Product_HL(){
        productsPage.sortProductHL();
       // Assertions.assertTrue(productsPage.isInOrderHL(),"Sort operation did not work corrrectly");
    }
    @Test
    @Order(5)
    public void product_print() throws IOException {
        productsPage.productPrint();
        //Assertions.assertTrue(productsPage.printCorrectly(),"Write operation failed.");
    }
    @Test
    @Order(6)
    public void sort_Product_LH(){
        productsPage.sortProductLH();
        // Assertions.assertTrue(productsPage.isInOrderLH(),"Sort operation did not work corrrectly");
    }
    @Test
    @Order(7)
    public void choose_ProductRating(){
        productsPage.chooseProductRating();
        Assertions.assertTrue(productsPage.isRatingSelected(),"Rating not selected.");
    }
    @Test
    @Order(8)
    public void select_Product(){
        productsPage.selectProduct();
        Assertions.assertTrue(productsPage.isThereProduct(),"The desired product is out of stock.");
    }
    @Test
    @Order(9)
    public void add_to_cart(){
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addToCart();
        Assertions.assertTrue(productDetailPage.onProductDetailPage(),"Not on product detail page");
    }
    @Test
    @Order(10)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        productDetailPage.goToCart();
        Assertions.assertTrue(cartPage.onCartPage(),"Not on cart page");
    }

}
