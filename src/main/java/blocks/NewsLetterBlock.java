package blocks;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class NewsLetterBlock {

  private static By newsLetterTitleLabel = By.id("block-newsletter-label");
  private static By unsubscribeDescriptionLabel = By.xpath("//div[@class='col-xs-12']/p");
  private static By subscribeButton = By.xpath("//input[@value='Subscribe']");

  private static WebDriver driver;

  public NewsLetterBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  public String getTextFromNewsLetterTitleLabel() {
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", newsLetterTitleLabel);
    return driver.findElement(newsLetterTitleLabel).getText();
  }

  public String getTextFromUnsubscribeDescriptionLabel() {
    return driver.findElement(unsubscribeDescriptionLabel).getText();
  }

  public String getTextFromSubscribeButton() {
    return driver.findElement(subscribeButton).getAttribute("value");

  }

}
//  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(ExpectedConditions.visibilityOfElementLocated(newsLetterTitleLabel));