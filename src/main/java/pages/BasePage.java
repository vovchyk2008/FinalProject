package pages;

import blocks.LanguageAndLoginBlock;
import blocks.NewsLetterBlock;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Getter
@Setter
public abstract class BasePage {

  //Actions actions = new Actions(driver);

  private static WebDriver driver;
  public static WebDriver getDriver() {
    return driver;
  }
  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  NewsLetterBlock newsLetterBlock = new NewsLetterBlock(getDriver());
  LanguageAndLoginBlock languageAndLoginBlockBlock = new LanguageAndLoginBlock(getDriver());



}
