import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationWithValidDataTest extends BaseTest {

  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();
  String email = faker.internet().emailAddress();
  String password = faker.internet().password();
  String birthdayDateField = "12/02/1990";

  @Test(description = "Check That User Name Appear Near Cart Button Test")
  public void checkThatUserNameAppearNearCartButtonTest() {

    String expectedUserName = firstName + " " + lastName;

    MainPage mainPage = new MainPage();
    mainPage.openMainPage()
        .getLanguageAndLoginBlockBlock()
        .clickOnSignInButton()
        .clickOnCreateAccountButton()
        .checkSocialTitleRadioButton()
        .enterFirstName(firstName)
        .enterLastName(lastName)
        .enterEmail(email)
        .enterPassword(password)
        .enterBirthdayDate(birthdayDateField)
        .clickOnReceiveOffersCheckBox()
        .clickOnCustomerDataPrivacyCheckBox()
        .clickOnSignUpForOurNewsletterCheckBox()
        .clickOnSaveButton();

    String textFromUserNameButton = mainPage.getLanguageAndLoginBlockBlock()
        .getTextFromUserNameButton();

    //Check your name appear near cart button

    Assertions.assertThat(textFromUserNameButton)
        .as("We are waiting, that text near cart Button must be: " + expectedUserName)
        .isEqualTo(expectedUserName);
  }
}
