import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By addToCartLocator = By.id("add-to-cart-button");
    By cartContainerLocator = By.id("nav-cart-count-container");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {

        find(addToCartLocator);
        click(addToCartLocator);

    }

    public boolean onProductDetailPage() {
        return find(addToCartLocator).isDisplayed();
    }


    public void goToCart() {
        find(cartContainerLocator);
        click(cartContainerLocator);
    }
}
