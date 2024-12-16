package PageObjects.AddProductsinCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddProductElements {
    // Locators for home page
    By homePageVisibleElement =By.xpath("//div[@id='slider-carousel']//div[@class='carousel-inner']");

    // Locators for first product
    By FirstProduct = By.xpath("//a[@data-product-id='1']");
    By addToCartFirstProduct  = By.xpath("//*[@id='product-1']");

    // Locators for second product
    By SecondProduct = By.xpath("//a[@data-product-id='2']");
    By addToCartSecondProduct   = By.xpath("//*[@id='product-2']");

    // Locators for navigation
    By productsButton = By.xpath("//a[contains(text(),'Products')]");

    // Locator for 'Continue Shopping' button
    By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    //By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block' and @data-dismiss='modal']");

    // Locator for 'View Cart' button
    By viewCartButton = By.xpath("//a//u[text()='View Cart']");

    // Locators for cart verification
    By firstProductInCart = By.xpath("//*[@id='product-1']");
    By secondProductInCart = By.xpath("//*[@id='product-2']");
    public By firstProductPrice = By.xpath("//*[@id='product-1']//td[@class='cart_price']");
    public By firstProductQuantity = By.xpath("//*[@id='product-1']//td[@class='cart_quantity']");
    public By firstProductTotal = By.xpath("//*[@id='product-1']//td[@class='cart_total']");
    public By secondProductPrice = By.xpath("//*[@id='product-2']//td[@class='cart_price']");
    public By secondProductQuantity = By.xpath("//*[@id='product-2']//td[@class='cart_quantity']");
    public By secondProductTotal = By.xpath("//*[@id='product-2']//td[@class='cart_total']");




}

