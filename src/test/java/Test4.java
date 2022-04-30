import java.util.List;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.MainPage;

public class Test4 extends BaseTest {

  String firstName = "James8";
  String lastName = faker.name().lastName();
  String email = faker.internet().emailAddress();
  String password = faker.internet().password();
  String birthdayDateField = "12/02/1990";

  @Test
  public void checkThatFirstNameHighlightedInRedTest() {

    //rgba(0, 0, 0, 0.25) is equal "red"
    String expectedBorderColor = "rgba(0, 0, 0, 0.25)";
    String expectedTextOfPopUp = "Invalid name";

    MainPage mainPage = new MainPage();
    mainPage.openMainPage()
        .getLanguageAndLoginBlockBlock()
        .clickOnSignInButton()
        .clickOnNoAccountCreateAccountButton()
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

    CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

    String borderColorFromFirstNameField = createAnAccountPage.getBorderColorFromFirstNameField();

    //Check that 'First name' highlighted in red

    softAssertions.assertThat(borderColorFromFirstNameField)
        .as("We are waiting that 'First name' highlighted in: " + expectedBorderColor)
        .isEqualTo(expectedBorderColor);

    //Check that pop-up with text 'Invalid name' appear under field

    List<String> textFromDangerPopUp = createAnAccountPage.getTextFromDangerPopUp();

    softAssertions.assertThat(textFromDangerPopUp)
        .as("We are waiting that text on pop-up will be: " + expectedTextOfPopUp)
        .isEqualTo(expectedTextOfPopUp);

    softAssertions.assertAll();

  }
}