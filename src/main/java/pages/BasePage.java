package pages;

import blocks.LanguageBlock;
import blocks.NewsLetterBlock;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Getter
@Setter
public abstract class BasePage {

  private static By languageContainer = By.xpath("ul[@class='dropdown-menu hidden-sm-down']");

  Actions actions = new Actions(driver);
  private static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }



  NewsLetterBlock newsLetterBlock = new NewsLetterBlock(getDriver());
  LanguageBlock languageBlock = new LanguageBlock(getDriver());
}
