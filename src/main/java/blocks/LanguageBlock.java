package blocks;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class LanguageBlock {

  private static By languageButton = By.xpath("//i[@class='material-icons expand-more']");
  private static By languageContainer = By.xpath("//ul[@class='dropdown-menu hidden-sm-down']/li");

  private static WebDriver driver;

  public LanguageBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  public LanguageBlock clickOnLanguageDropShot() {
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


}
