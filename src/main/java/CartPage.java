import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By cartLocator= By.id("desktop-ptc-button-celWidget");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean onCartPage() {
        return find(cartLocator).isDisplayed();

    }
}
