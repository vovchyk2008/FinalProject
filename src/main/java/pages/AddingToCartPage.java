package pages;

import blocks.AddingToCartBlock;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;


public class AddingToCartPage extends BasePage {

  private static final By cartContainer = By
      .xpath("//div[@id='blockcart-modal']//div[@class='modal-content']");
  private static final By productName = By
      .xpath("//div[@id='blockcart-modal']//h6[@class='h6 product-name']");
  private static final By productStatus = By
      .xpath("//div[@id='blockcart-modal']//h4[@id='myModalLabel']");
  private static final By productQuantity = By
      .xpath("//div[@id='blockcart-modal']//span[@class='product-quantity']/strong");
  private static final By paperType = By
      .xpath("//div[@id='blockcart-modal']//span[@class='paper type']/strong");
  private static final By productPrice = By
      .xpath("//div[@id='blockcart-modal']//p[@class='product-price']");
  private static final By totalPrice = By
      .xpath("//div[@id='blockcart-modal']//span[@class='value']");
  private static final By continueShoppingButton = By
      .xpath("//div[@id='blockcart-modal']//button[text()='Continue shopping']");
  private static final By proceedToCheckoutButton = By
      .xpath("//div[@id='blockcart-modal']//a[text()='Proceed to checkout']");

  @Step("Get Product Info")
  public AddingToCartBlock getProductInfo() {
    Utils.waitUntilPresents(cartContainer, 10);
    WebElement container = getDriver().findElement(cartContainer);
    return new AddingToCartBlock(container);
  }

  public AddingToCartPage clickOnContinueShoppingButton() {
    Utils.waitUntilVisible(continueShoppingButton, 10);
    Utils.scrollToElement(getDriver(), continueShoppingButton);
    Utils.find(continueShoppingButton).click();
    return this;
  }

  public CartPage clickOnProceedToCheckoutButton() {

    Utils.waitUntilVisible(proceedToCheckoutButton, 10);
    Utils.find(proceedToCheckoutButton).click();
    return new CartPage();
  }

}

//    this.productName = container.findElement(By.xpath(".//")).getText();
//} catch (NoSuchElementException e) {
//    this.productName = null;
//    }
//
//    try {
//    this.productStatus = container.findElement(By.xpath(".")).getText().substring(1);
//    } catch (NoSuchElementException e) {
//    this.productStatus = null;
//    }
//
//    try {
//    this.productQuantity = Integer.parseInt(container.findElement(By.xpath(".")).getText());
//    } catch (NoSuchElementException e) {
//    this.productQuantity = null;
//    }
//
//    try {
//    this.paperType = container.findElement(By.xpath(".")).getText();
//    } catch (NoSuchElementException e) {
//    this.paperType = null;
//    }
//
//    try {
//    this.productPrice = Double.parseDouble(container.findElement(By.xpath(".")).getText().substring(1));
//    } catch (NoSuchElementException e) {
//    this.productPrice = null;
//    }
//
//    try {
//    this.totalPrice = Double.parseDouble(container.findElement(By.xpath(".")).getText().substring(1));
//    } catch (NoSuchElementException e) {
//    this.totalPrice = null;
//    }
//
//    try {
//    this.continueShoppingButton = container.findElement(By.xpath("."));
//    } catch (NoSuchElementException e) {
//    this.continueShoppingButton = null;
//    }
//
//    try {
//    this.proceedToCheckoutButton = container.findElement(By.xpath("."));
//  private String ;
//  private String ;
//  private Integer ;
//  private String ;
//  private Double ;
//  private Double ;
//  private WebElement ;
//  private WebElement ;