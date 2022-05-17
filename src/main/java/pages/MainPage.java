package pages;

import blocks.ProductBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

@Getter
public class MainPage extends BasePage {

  private static final By mainFrame = By.id("framelive");
  private static final By loadingImage = By.id("loadingMessage");
  private static final By productContainer = By
      .xpath("//div[@class='thumbnail-container reviews-loaded']");
  private static final By allProductsButton = By
      .xpath("//a[@class='all-product-link float-xs-left float-md-right h4']");

  @Step("Open [MainPage]")
  public MainPage openMainPage() {
    getDriver().get("https://demo.prestashop.com/");
    getDriver().switchTo().frame("framelive");
    Utils.waitUntilInvisible(loadingImage, 10);
    return this;
  }

  public List<ProductBlock> getAllProductsFromMainPage() {
    Utils.waitUntilVisible(productContainer, 20);
    Utils.scrollToElement(getDriver(), productContainer);
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      ProductBlock productBlock = new ProductBlock(container);
      products.add(productBlock);
    }
    return products;
  }

  public List<ProductBlock> getAllProductWithName(List<ProductBlock> allProducts) {
    List<ProductBlock> productsWithName = new ArrayList<>();
    for (ProductBlock productBlock : allProducts) {
      if (productBlock.getNameAsString() != null) {
        productsWithName.add(productBlock);
      }
    }
    return productsWithName;
  }

  public List<ProductBlock> getAllProductsWithPrice(List<ProductBlock> allProducts){
    List<ProductBlock> productsWithPrise = new ArrayList<>();
    for (ProductBlock productBlock : allProducts) {
      if (productBlock.getActualPrice()!=null){
        productsWithPrise.add(productBlock);
      }
    }return productsWithPrise;
  }

  public List<ProductBlock> getAllProductsWithPriceMoreThanZero(List<ProductBlock> productsWithPrices){
    List<ProductBlock> productsWithPrise = new ArrayList<>();
    for (ProductBlock productBlock : productsWithPrices) {
      if (productBlock.getActualPriceAsDouble()>0.00){
        productsWithPrise.add(productBlock);
      }
    }return productsWithPrise;
  }

  @Step("Click On [All Products Button]")
  public AllProductsPage clickOnAllProductsButton(){
    Utils.waitUntilPresents(allProductsButton, 10);
    Utils.scrollToElement(getDriver(), allProductsButton);
    Utils.find(allProductsButton).click();
    return new AllProductsPage();
  }
}
