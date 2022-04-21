package blocks;

import java.time.Duration;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.MainPage;

@Getter
@Setter
public class NewsLetterBlock {

  private static By newsLetterTitleLabel = By.xpath("//p[@id='block-newsletter-label']");
  private static By unsubscribeDescriptionLabel = By.xpath("//div[@class='col-xs-12']/p");
  private static By subscribeButton = By.xpath("//input[@value='Subscribe']");


  private static WebDriver driver;

  public NewsLetterBlock(WebDriver webDriver) {
    driver = webDriver;
  }
  public static void scrollToElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public String getTextFromNewsLetterTitleLabel(){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsLetterTitleLabel);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(newsLetterTitleLabel));
    String text = driver.findElement(newsLetterTitleLabel).getText();
    return text;
  }
  public String getTextFromUnsubscribeDescriptionLabel(){
    return driver.findElement(unsubscribeDescriptionLabel).getText();
  }

  public String getTextFromSubscribeButton(){
    return driver.findElement(subscribeButton).getAttribute("value");
  }

}
