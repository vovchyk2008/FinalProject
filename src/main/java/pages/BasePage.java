package pages;

import blocks.TopBarBlock;
import blocks.NewsLetterBlock;
import blocks.MainMenuBlock;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

@Data
public abstract class BasePage {

  private final By contentWrapper = By.id("wrapper");
  private static final By pricesDropButton = By.id("link-product-page-prices-drop-1");
  private static final By searchInput = By.xpath("//input[@aria-label='Search']");

  Actions actions = new Actions(driver);
  private static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  NewsLetterBlock newsLetterBlock = new NewsLetterBlock(getDriver());
  TopBarBlock topBarBlock = new TopBarBlock(getDriver());
  MainMenuBlock mainMenuBlock = new MainMenuBlock(getDriver());

  public PricesDrop clickOnPricesDropButton() {
    Utils.waitUntilPresents(pricesDropButton, 10);
    Utils.scrollToElement(driver, pricesDropButton);
    Utils.find(pricesDropButton).click();
    return new PricesDrop();
  }

  public SearchResultPage enterSearchName(String searchName) {
    Utils.waitUntilPresents(searchInput, 20);
    Utils.scrollToElement(driver, searchInput);
    getDriver().findElement(searchInput).sendKeys(searchName);
    getDriver().findElement(searchInput).sendKeys(Keys.ENTER);
    return new SearchResultPage();
  }


}