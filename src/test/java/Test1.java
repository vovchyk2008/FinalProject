import org.testng.annotations.Test;
import pages.MainPage;

public class Test1 extends BaseTest {

  @Test
  public void chekTheTextOnNewsLetterBlock() {

    String expectedTextFromNewsLetterTitleLabel = "Get our latest news and special sales";
    String expectedTextFromUnsubscribeDescriptionLabel = "You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.";
    MainPage mainPage = new MainPage();


    String textFromNewsLetterTitleLabel = mainPage.openMainPage().waitUntilMainPageWillBeDownload().getNewsLetterBlock()
        .getTextFromNewsLetterTitleLabel();

    softAssertions.assertThat(textFromNewsLetterTitleLabel)
        .as("Text near the email field equals must be: " + expectedTextFromNewsLetterTitleLabel)
        .isEqualTo(expectedTextFromNewsLetterTitleLabel);

    String textFromUnsubscribeDescriptionLabel = mainPage.getNewsLetterBlock()
        .getTextFromUnsubscribeDescriptionLabel();

    softAssertions.assertThat(textFromUnsubscribeDescriptionLabel)
        .as("Text under email field must contains: " + expectedTextFromUnsubscribeDescriptionLabel)
        .contains(expectedTextFromUnsubscribeDescriptionLabel);

    String textFromSubscribeButton = mainPage.getNewsLetterBlock().getTextFromSubscribeButton();

    softAssertions.assertThat(textFromSubscribeButton)
        .as("fd")
        .isUpperCase();

    softAssertions.assertAll();

  }
}
//text near the email field equals 'Get our latest news and special sales'