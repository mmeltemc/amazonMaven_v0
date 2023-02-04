import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{


    By searchProductLocator = By.id("twotabsearchtextbox");
    By searchEnteredLocator = By.id("nav-search-submit-button");
    By mailLocator = By.id("app_email");
    By continueLocator=By.id("continue");

    By passwordLocator = By.id("ap_password");

    By submitLocator = By.id("signInSubmit");

    String mail = "mujganmeltemcaglacullu@gmail.com";
    String password = "123456.";

    public HomePage(WebDriver driver) {

        super(driver);
    }
    public void sıgnIn() {


        find(mailLocator);
        click(mailLocator);
        find(mailLocator).sendKeys(mail);

        find(continueLocator);
        click(continueLocator);

        find(passwordLocator);
        click(passwordLocator);
        find(passwordLocator).sendKeys(password);


        find(submitLocator);
        click(submitLocator);
    }
    public void searchProduct() {
        find(searchProductLocator);
        click(searchProductLocator);

        sendKey(searchEnteredLocator,"headphones");
        click(searchEnteredLocator);


    }



}
