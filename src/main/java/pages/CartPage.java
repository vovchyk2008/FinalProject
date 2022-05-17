package pages;

import blocks.AddingToCartBlock;
import blocks.CartBlock;
import blocks.ProductBlock;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class CartPage extends BasePage {

  private static By cartProductContainer = By.xpath("//div[@class='product-line-grid']");

  public List<CartBlock> getAllProductsFromAllProductsPage() {
    Utils.waitUntilVisible(cartProductContainer, 20);
    Utils.scrollToElement(getDriver(), cartProductContainer);
    Utils.waitRefreshed(cartProductContainer, 20);
    List<CartBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(cartProductContainer);
    for (WebElement container : containers) {
      CartBlock cartBlock = new CartBlock(container);
      products.add(cartBlock);
    }
    return products;
  }


  public Double getActualTotalPrice() {
    Utils.waitUntilVisible(cartProductContainer, 20);
    List<CartBlock> products = new ArrayList<>();
    List<WebElement> elements = getDriver().findElements(cartProductContainer);
    for (WebElement element : elements) {
      CartBlock cartBlock = new CartBlock(element);
      products.add(cartBlock);
    }
    Double totalPrice=0.0;
    for (CartBlock product : products) {
      totalPrice+=product.getProductPrice()*product.getProductQuantity();
    }
    return totalPrice;

  }


}
