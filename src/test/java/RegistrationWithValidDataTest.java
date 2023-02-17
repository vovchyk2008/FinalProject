import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationWithValidDataTest extends BaseTest {

  @Test(invocationCount = 5) //(description = "Check That User Name Appear Near Cart Button Test")
  public void checkThatUserNameAppearNearCartButtonTest() {

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(10,72);
    String expectedUserName = firstName + " " + lastName;

    MainPage mainPage = new MainPage();
    mainPage.openMainPage()
        .getTopBarBlock()
        .clickOnSignInButton()
        .clickOnCreateAccountButton()
        .clickOnSocialTitleRadioButton()
        .enterFirstName(firstName)
        .enterLastName(lastName)
        .enterEmail(email)
        .enterPassword(password)
        .clickOnReceiveOffersCheckBox()
        .clickOnCustomerDataPrivacyCheckBox()
        .clickOnSignUpForOurNewsletterCheckBox()
        .clickOnAgreeToTheTermsCheckBox()
        .clickOnSaveButtonWithValidData();

    String textFromUserNameButton = mainPage.getTopBarBlock()
        .getTextFromUserNameButton();

    //Check your name appear near cart button

    Assertions.assertThat(textFromUserNameButton)
        .as("We are waiting, that text near cart Button must be: " + expectedUserName)
        .isEqualTo(expectedUserName);
  }
}
