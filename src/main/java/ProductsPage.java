import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductsPage extends BasePage {

    By climateFriendlyLocator = By.id("climatePledgeFriendlyRefinements");
    By featureLocator = By.id("p_n_feature_two_browse-bin/23746030011");
    By filterLocation= By.className("a-dropdown-prompt");
    By highPriceLocation= By.id("s-result-sort-select_2");
    By lowPriceLocation = By.id("s-result-sort-select_1");
    String fourStarURL = "https://www.amazon.com/s?k=headphones&i=electronics&rh=n%3A172541%2Cp_n_feature_two_browse-bin%3A23746030011%2Cp_72%3A1248879011&s=price-asc-rank&dc&ds=v1%3AflaCxUos2t7%2FGwbP9W5VMiIRYoxGugOxL6IgWmX6hQQ&crid=2455OPMPR3QA&qid=1674984397&rnid=1248877011&sprefix=he%2Caps%2C742&ref=sr_nr_p_72_1";
    By selectProductLocator = By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']");
    By stockLocator = By.xpath("//div[@class='a-size-medium a-color-success']");
    String stockText;
    By productNameLocator = By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']");
    By fourStarSelectLocator = By.className("a-size-small a color-base a-text-bold");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean onProductPage() { // sayfada olan unique bir şey
       return find(climateFriendlyLocator).isDisplayed();
    }
    public void selectFeature() {
        find(featureLocator);
        click(featureLocator);
    }
  /*  public boolean isThereFeature() {

    }*/

    public void sortProductHL() {
        find(filterLocation);
        click(filterLocation);

        find(highPriceLocation);
        click(highPriceLocation);
    }

    public void productPrint() throws IOException {
        File file1 = new File("highPriceProduct.txt");
        FileWriter fw = new FileWriter(file1);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Fiyatı en yüksek - Active Noise Cancelation - İlk 10 Tanesi");

        for(int i=0; i<=9 ; i++){

            System.out.println(findAll(productNameLocator).get(i).getText());
            pw.println(findAll(productNameLocator).get(i).getText()+ "\n");
        }
        pw.close();
    }

   /* public boolean printCorrectly() {

    }*/

    public void sortProductLH() {
        find(filterLocation);
        click(filterLocation);

        find(lowPriceLocation);
        click(lowPriceLocation);


    }

    public void chooseProductRating() {
        goToSite(fourStarURL);
    }

    public boolean isRatingSelected() {
        return  find(fourStarSelectLocator).isDisplayed();
    }

    public void selectProduct() {
       find(selectProductLocator);
       click(selectProductLocator);
    }

    public boolean isThereProduct() { //stokta var mı
        stockText = find(stockLocator).getText();

        if (stockText == "In Stock") return true;
        else return false;

    }
}
