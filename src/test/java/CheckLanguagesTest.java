import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckLanguagesTest extends BaseTest {

  @Test(description = "Check Languages Test")
  public void checkLanguagesTest() {

    String expectedLanguage = "Українська";
    String expectedCountOfLanguages = "44";

    MainPage mainPage = new MainPage();
    List<String> namesOfLanguages = mainPage.openMainPage().getLanguageAndLoginBlockBlock()
        .clickOnLanguageButton()
        .getNamesOfLanguages();

    //Check that 44 languages exists in 'Language' dropdown in the top menu
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(namesOfLanguages.size())
        .as("We are waiting that 44 languages exists in 'Language' dropdown")
        .isEqualTo(expectedCountOfLanguages);

    //Check that 'Українська' language exist in dropdown

    softAssertions.assertThat(namesOfLanguages)
        .as("We are waiting that: " + expectedLanguage + " language is exist in dropdown")
        .contains(expectedLanguage);

    softAssertions.assertAll();
  }
}