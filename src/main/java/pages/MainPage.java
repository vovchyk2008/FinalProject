package pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MainPage extends BasePage {

  private static By mainFrame = By.id("framelive");

  public MainPage openMainPage() {
    getDriver().get("https://demo.prestashop.com/");
    return this;
  }

  public MainPage waitDown() {
    waitUntilVisible(mainFrame, 15);
    return this;
  }
}
