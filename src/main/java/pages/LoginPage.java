package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class LoginPage extends BasePage{

  private static By createAccountButton = By.xpath("//div[@class='no-account']/a");

  public CreateAnAccountPage clickOnNoAccountCreateAccountButton(){
    Utils.waitUntilVisible(createAccountButton, 10);
    Utils.find(createAccountButton).click();
    return new CreateAnAccountPage();
  }

}
