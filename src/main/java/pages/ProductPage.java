package pages;


import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class ProductPage extends BasePage {

  private static final By selectPaperTypeButton = By.id("group_4");
  private static final By selectDotedTypeButton = By
      .xpath("//select[@id='group_4']//option[text()='Doted']");
  private static final By quantitySelect = By.id("quantity_wanted");
  private static final By addToCartButton = By
      .xpath("//button[@class='btn btn-primary add-to-cart']");

  private static final By customizationMessageInput = By
      .xpath("//textarea[@class='product-message']");
  private static final By saveCustomizationButton = By
      .xpath("//button[@name='submitCustomizedData']");
  private static final By selectColorRadioButton = By.xpath("//input[@class='input-color']");


  @Step("Enter Customization Message]")
  public ProductPage enterCustomizationMessage(String message) {
    Utils.waitUntilVisible(customizationMessageInput, 10);
    Utils.find(customizationMessageInput).sendKeys(message);
    return new ProductPage();
  }

  @Step("Click On [Save Customization] Button")
  public ProductPage clickOnSaveCustomizationButton() {
    Utils.find(saveCustomizationButton).click();
    return new ProductPage();
  }

  @Step("Select [Paper Type]")
  public ProductPage selectPaperType(String typeOfPaper) {
    Utils.waitUntilPresents(selectPaperTypeButton, 10);
    WebElement element = Utils.find(selectPaperTypeButton);
    Select select = new Select(element);
    select.selectByVisibleText(typeOfPaper);
//    Utils.find(selectPaperTypeButton).click();
//    Utils.waitUntilPresents(selectDotedTypeButton, 10);
//    Utils.find(selectDotedTypeButton).click();
    return this;
  }

  @Step("Select [Quantity")
  public ProductPage selectQuantity(int quantity) {
    String quantityString = Integer.toString(quantity);
    WebElement quantityInput = Utils.find(quantitySelect);
    quantityInput.sendKeys(Keys.CONTROL + "A");
    quantityInput.sendKeys(Keys.BACK_SPACE);
    quantityInput.sendKeys(quantityString);
    return this;
  }

  @Step("Click on [Add To Cart] Button")
  public AddingToCartPage clickOnAddToCartButton() {
    Utils.waitUntilPresents(addToCartButton, 10);
    Utils.scrollToElement(getDriver(), addToCartButton);
    Utils.waitUntilClickable(addToCartButton, 10);
    Utils.find(addToCartButton).click();
    return new AddingToCartPage();
  }

  @Step("Select [Color")
  public ProductPage selectColor(String color) {
    List<WebElement> typeOfColors = getDriver().findElements(selectColorRadioButton);
    for (WebElement typeOfColor : typeOfColors) {
      if (typeOfColor.getAttribute("title").equals(color)) {
        typeOfColor.click();
      }
    }
    return this;
  }
}
