package pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class CreateAnAccountPage extends BasePage {

  private static By socialTitleRadioButton = By.id("field-id_gender-1");
  private static By firstNameField = By.id("field-firstname");
  private static By lastNameField = By.id("field-lastname");
  private static By emailField = By.id("field-email");
  private static By passwordField = By.id("field-password");
  private static By birthdayDateField = By.id("field-birthday");
  private static By receiveOffersCheckBox = By.xpath("//input[@name='optin']");
  private static By customerDataPrivacyCheckBox = By.xpath("//input[@name='customer_privacy']");
  private static By signUpForOurNewsletterCheckBox = By.xpath("//input[@name='newsletter']");
  private static By saveButton = By.xpath("//button[@data-link-action='save-customer']");
  private static By dangerPopUp = By.xpath("//li[@class='alert alert-danger']");


  public CreateAnAccountPage checkSocialTitleRadioButton() {
    Utils.waitUntilPresents(socialTitleRadioButton, 10);
    Utils.find(socialTitleRadioButton).click();
    return this;
  }

  public CreateAnAccountPage enterFirstName(String firstName) {
    Utils.find(firstNameField).sendKeys(firstName);
    return this;
  }

  public CreateAnAccountPage enterLastName(String lastName) {
    Utils.find(lastNameField).sendKeys(lastName);
    return this;
  }

  public CreateAnAccountPage enterEmail(String email) {
    Utils.find(emailField).sendKeys(email);
    return this;
  }

  public CreateAnAccountPage enterPassword(String password) {
    Utils.find(passwordField).sendKeys(password);
    return this;
  }

  public CreateAnAccountPage enterBirthdayDate(String birthdayDate) {
    Utils.find(birthdayDateField).sendKeys(birthdayDate);
    return this;
  }

  public CreateAnAccountPage clickOnReceiveOffersCheckBox() {
    Utils.find(receiveOffersCheckBox).click();
    return this;
  }

  public CreateAnAccountPage clickOnCustomerDataPrivacyCheckBox() {
    Utils.find(customerDataPrivacyCheckBox).click();
    return this;
  }

  public CreateAnAccountPage clickOnSignUpForOurNewsletterCheckBox() {
    Utils.find(signUpForOurNewsletterCheckBox).click();
    return this;
  }

  public MainPage clickOnSaveButton() {
    Utils.find(saveButton).click();
    return new MainPage();
  }

  public String getBorderColorFromFirstNameField() {
    return StringUtils.substringAfter(Utils.find(firstNameField).getCssValue("border").trim(), "1px solid ");  }

  public List<String> getTextFromDangerPopUp() {
    List<String> textFromAlertDanger = new ArrayList<>();
    List<WebElement> elements = getDriver().findElements(dangerPopUp);
    for (WebElement element : elements) {
      textFromAlertDanger.add(element.getText());
    }
    return textFromAlertDanger;
  }

}
