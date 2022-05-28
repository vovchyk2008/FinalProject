package pages;

import blocks.ProductBlock;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class PricesDrop extends BasePage{

  private static final By productContainer = By
      .xpath("//div[@class='thumbnail-container reviews-loaded']");

  @Step("Get All Products from page")
  public List<ProductBlock> getAllProductsFromPage() {
    Utils.waitUntilVisible(productContainer, 20);
    Utils.scrollToElement(getDriver(), productContainer);
    Utils.waitRefreshed(productContainer, 20);
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      ProductBlock productBlock = new ProductBlock(container);
      products.add(productBlock);
    }
    return products;
  }

  public List<ProductBlock> getAllProductWithOldAndNewPrice(List<ProductBlock> allProducts) {
    List<ProductBlock> productsWithPrices = new ArrayList<>();
    for (ProductBlock productBlock : allProducts) {
      if (productBlock.getActualPriceAsDouble() != null && productBlock.getOldPriceAsDouble()!=null) {
        productsWithPrices.add(productBlock);
      }
    } return productsWithPrices;
  }

  public List<ProductBlock> getAllProductWithCorrectPrice(List<ProductBlock> productsWithPrices) {
    List<ProductBlock> productsWithCorrectPrices = new ArrayList<>();
    for (ProductBlock productBlock : productsWithPrices) {
      double promoPrise = Double.parseDouble(String.format(Locale.ROOT, "%.2f",
          productBlock.getOldPriceAsDouble()
          - (productBlock.getOldPriceAsDouble() * productBlock.getDiscountAsDouble()) / 100));
      if (promoPrise==productBlock.getActualPriceAsDouble()) {
        productsWithCorrectPrices.add(productBlock);
      }
    }
    return productsWithCorrectPrices;
  }

}