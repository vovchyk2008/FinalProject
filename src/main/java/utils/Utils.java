package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {

  private static WebDriver driver;

  public static void setDriver(WebDriver webdriver) {
    driver = webdriver;
  }

  public static void scrollToElement(WebDriver driver, By element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
  }

  public static WebElement waitUntilVisible(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }
  public static WebElement waitUntilClickable(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.elementToBeClickable(locator));
  }

  public static WebElement waitUntilPresents(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public static boolean waitUntilInvisible(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

}
