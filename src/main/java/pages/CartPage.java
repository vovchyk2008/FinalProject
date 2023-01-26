package pages;

import blocks.CartBlock;
import blocks.ProductBlock;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;


public class CartPage extends BasePage{

  private static final By totalPriceOfAllProducts = By.xpath("//div[@class='cart-summary-line cart-total']//span[@class='value']");
  private static final By proceedToCheckoutButton = By.xpath("//div[@class='text-sm-center']/a");
  private static final By cartsContainer = By.xpath("//div[@class='product-line-grid']");

  public List<CartBlock> getAllProductsFromAllProductsPage() {
    Utils.waitUntilVisible(cartsContainer, 20);
    Utils.scrollToElement(getDriver(), cartsContainer);
    Utils.waitRefreshed(cartsContainer, 20);
    Utils.waitUntilPresents(cartsContainer, 10);
    List<CartBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(cartsContainer);
    for (WebElement container : containers) {
      CartBlock cartBlock = new CartBlock(container);
      products.add(cartBlock);
    }
    return products;
  }

//  public List<CartBlock> getTotalProductsPrice(){
//
//   getDriver().findElements(cartsContainer);
//
//  }



  }
