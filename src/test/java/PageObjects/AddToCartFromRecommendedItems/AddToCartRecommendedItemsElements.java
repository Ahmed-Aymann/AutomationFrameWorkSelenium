package PageObjects.AddToCartFromRecommendedItems;
import org.openqa.selenium.By;

public class AddToCartRecommendedItemsElements {


        // Locators for recommended Items Section
        By recommendedItemsSection = By.xpath("//div[@class='recommended_items']");
        // Locator for 'Add to cart' button
        By addToCartButton =  By.xpath("//div[@class='recommended_items']//a[@class='btn btn-default add-to-cart']");
        // Locator for 'View Cart' button
        By viewCartButton = By.xpath("//a[@href='/view_cart']//u[text()='View Cart']");
        // Locator for product In Cart
        By productInCart = By.xpath("//td[@class='cart_description']");

    }


