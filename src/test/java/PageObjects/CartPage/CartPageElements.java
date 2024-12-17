package PageObjects.CartPage;

import org.openqa.selenium.By;


public class CartPageElements {
    // static locator

    //By PRODUCT_ROW=By.xpath("//tr[@id='product-1']");
    By REMOVE_BUTTON=By.xpath("//a [@data-product-id='1']");
    By MESSAGE_OF_EMPTY_CART=By.xpath("//span[@id='empty_cart']");
    By CART_INFO=By.xpath("//div[@id='cart_info']");


    //cart page elements when Proceed To Checkout
    By COMMENT_BOX=By.xpath("//textarea[@class='form-control']");
    By PROCEED_TO_CHECKOUT_BUTTON=By.xpath("//a[@class='btn btn-default check_out']");
    By ADDRESS_DETAILS_TITLE=By.xpath("/html/body/section/div/div[2]/h2");
    By ADDRESS_DETAILS_ROW=By.xpath("//div[@class='checkout-information']");
    By YOUR_ORDER=By.xpath("//div[@id='cart_info']");





    /*
    //dynamic locator law kont h add aktar mn element bs mafesh message when remove element mn kza haga


        // Dynamic locator for a specific product row in the cart
        public By getProductRow(String productId) {
            return By.xpath("//tr[@id='product-" + productId + "']");
        }

        // Dynamic locator for the remove button based on product ID
        public By getRemoveButton(String productId) {
            return By.xpath("//a[@data-product-id='" + productId + "']");
        }*/


}
