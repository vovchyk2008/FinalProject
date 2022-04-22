package blocks;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

@Getter
@Setter
public class NewsLetterBlock {

  private static By newsLetterTitleLabel = By.id("block-newsletter-label");
  private static By unsubscribeDescriptionLabel = By.xpath("//div[@class='col-xs-12']/p");
  private static By subscribeButton = By.xpath("//input[@value='Subscribe']");

  private static WebDriver driver;
  private static Actions actions;

  public NewsLetterBlock(WebDriver webDriver) {
    driver = webDriver;
    actions = new Actions(driver);
  }

  public String getTextFromNewsLetterTitleLabel() {
    Utils.waitUntilVisible(newsLetterTitleLabel, 10);
    Utils.scrollToElement(driver, newsLetterTitleLabel);
    return driver.findElement(newsLetterTitleLabel).getText();
  }

  public String getTextFromUnsubscribeDescriptionLabel() {
    return driver.findElement(unsubscribeDescriptionLabel).getText();
  }

  public String getTextFromSubscribeButton() {
    return driver.findElement(subscribeButton).getCssValue("text-transform");
  }
}
