import org.testng.annotations.Test;
import pages.MainPage;

public class Test1 extends BaseTest {

  @Test
  public void checkTheTextOnNewsLetterBlock() {

    String expectedTextFromNewsLetterTitleLabel = "Get our latest news and special sales";
    String expectedTextFromUnsubscribeDescriptionLabel = "You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.";
    MainPage mainPage = new MainPage();

    String textFromNewsLetterTitleLabel = mainPage.openMainPage()
        //.switchOnFrame()
        .waitUntilMainPageWillBeDownload()
        .getNewsLetterBlock()
        .getTextFromNewsLetterTitleLabel();

    //Check that text near the email field equals 'Get our latest news and special sales'

    softAssertions.assertThat(textFromNewsLetterTitleLabel)
        .as("Text near the email field equals must be: " + expectedTextFromNewsLetterTitleLabel)
        .isEqualTo(expectedTextFromNewsLetterTitleLabel);

    String textFromUnsubscribeDescriptionLabel = mainPage.getNewsLetterBlock()
        .getTextFromUnsubscribeDescriptionLabel();

    //check that text under email field contains 'You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.'

    softAssertions.assertThat(textFromUnsubscribeDescriptionLabel)
        .as("Text under email field must contains: " + expectedTextFromUnsubscribeDescriptionLabel)
        .contains(expectedTextFromUnsubscribeDescriptionLabel);

    String textFromSubscribeButton = mainPage.getNewsLetterBlock().getTextFromSubscribeButton();

    //Check that all characters on 'SUBSCRIBE' button in upper case

    softAssertions.assertThat(textFromSubscribeButton)
        .as("fd")
        .isUpperCase();

    softAssertions.assertAll();

  }
}
