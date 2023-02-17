package pages;

import blocks.CartBlock;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;


public class CartPage extends BasePage {

  private static final By totalPriceOfAllProducts = By
      .xpath("//div[@class='cart-summary-line cart-total']//span[@class='value']");
  private static final By proceedToCheckoutButton = By.xpath("//div[@class='text-sm-center']/a");
  private static final By cartsContainer = By.xpath("//ul[@class='cart-items']/li");

  public List<CartBlock> getAllProductsFromCartPage() {
    Utils.waitUntilPresents(cartsContainer, 10);
    List<CartBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(cartsContainer);
    for (WebElement container : containers) {
      CartBlock cartBlock = new CartBlock(container);
      products.add(cartBlock);
    }
    return products;
  }

  public double getTotalPriceOfAllProducts() {
    List<CartBlock> allProductsFromCartPage = getAllProductsFromCartPage();
    double price = 0.0;
    for (CartBlock productBlock : allProductsFromCartPage) {
      price += productBlock.getActualPriceAsDouble();
    }
    String string = Double.toString(price);
    double total = Double.parseDouble(string.substring(0, 5));
    return total;
  }

  public double getTotalCartsPrice(){
    WebElement totalPrice = Utils.find(totalPriceOfAllProducts);
    return Double.parseDouble(totalPrice.getText().substring(1));
  }

  public PersonalInformationPage clickOnProceedToCheckoutButton(){
    Utils.waitUntilPresents(proceedToCheckoutButton, 10);
    Utils.find(proceedToCheckoutButton).click();
    return new PersonalInformationPage();
  }



}
