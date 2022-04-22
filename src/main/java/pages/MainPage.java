package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import utils.Utils;

@Getter
public class MainPage extends BasePage {

  private static final By mainFrame = By.id("framelive");
  private static final By loadingImage = By.id("loadingMessage");

  public MainPage openMainPage() {
    getDriver().get("https://demo.prestashop.com/");
    getDriver().switchTo().frame("framelive");
    Utils.waitUntilInvisible(loadingImage, 10);
    return this;
  }
}



//  public MainPage waitUntilMainPageWillBeDownload() {
//    Utils.waitUntilVisible(mainFrame, 15);
//    return this;
//  }
