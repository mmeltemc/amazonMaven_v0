import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    WebDriver driver;
    public CharSequence text;

    public BasePage(WebDriver driver){//constructor //sınıfla aynı isim, return yok, classa bir şey alma yetisi sağlıyosun

        this.driver = driver;

    }
    public WebElement find(By locator){//ortak özellik
        return driver.findElement(locator);

    }
    public List<WebElement> findAll(By locator){//ortak özellik
        return driver.findElements(locator);

    }
    public void click(By locator){
        find(locator).click(); //bulup tıklamalı

    }
    public void sendKey(By locator, String text){

        find(locator).sendKeys(text);
    }

    public void goToSite(String text){
        driver.get(text);

    }


}
