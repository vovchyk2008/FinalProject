package blocks;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.Utils;

public class LanguageAndLoginBlock {

  //Buttons
  private static By languageButton = By.xpath("//i[@class='material-icons expand-more']");
  private static By signInButton = By.xpath("//a[@title='Log in to your customer account']");
  private static By userNameButton = By.xpath("//a[@class='account']//span[@class='hidden-sm-down']");

  //Attributes
  private static By languageContainer = By.xpath("//ul[@class='dropdown-menu hidden-sm-down']/li");

  private static WebDriver driver;

  public LanguageAndLoginBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  public LanguageAndLoginBlock clickOnLanguageButton() {
    Utils.waitUntilVisible(languageButton, 10);
    Utils.find(languageButton).click();
    return this;
  }

  public List<String> getNamesOfLanguages() {
    List<String> languages = new ArrayList<>();
    List<WebElement> elements = driver.findElements(languageContainer);
    for (WebElement element : elements) {
      String nameOfLanguage = element.getText();
      languages.add(nameOfLanguage);
    }
    return languages;
  }

  public LoginPage clickOnSignInButton(){
    Utils.waitUntilVisible(signInButton, 10);
    Utils.find(signInButton).click();
    return new LoginPage();
  }

  public String getTextFromUserNameButton(){
    Utils.waitUntilVisible(userNameButton, 10);
    return Utils.find(userNameButton).getText();
  }

}
