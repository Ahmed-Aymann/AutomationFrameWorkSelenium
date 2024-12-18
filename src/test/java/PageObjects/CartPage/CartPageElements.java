package PageObjects.CartPage;

import org.openqa.selenium.By;


public class CartPageElements {


    By REMOVE_BUTTON=By.xpath("//a [@data-product-id='1']");
    By MESSAGE_OF_EMPTY_CART=By.xpath("//span[@id='empty_cart']");
    By CART_INFO=By.xpath("//div[@id='cart_info']");
    By VerifyCartPage=By.xpath("//li[@class='active']");







}
