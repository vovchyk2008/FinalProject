import java.util.List;
import org.testng.annotations.Test;
import pages.MainPage;

public class Test5 extends BaseTest {

  @Test
  public void checkThatFirstNameHighlightedInRedTest() {

    String expectedTextFromMenButton = "MEN";
    String expectedTextFromWomenButton = "WOMEN";
    String expectedTextStationeryButton = "STATIONERY";
    String expectedTextFromHomeAccessoriesButton = "HOME ACCESSORIES";

    MainPage mainPage = new MainPage();
    List<String> textFromButtonsOfClothesSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToClothesButton()
        .geTextFromButtonsOfClothesSubMenu1();

    //Check that 'MEN' and 'WOMEN' sub menu items appears

    softAssertions.assertThat(textFromButtonsOfClothesSubMenu)
        .as("We are waiting that text on buttons will be: " + expectedTextFromMenButton
            + expectedTextFromWomenButton)
        .containsExactlyInAnyOrder(expectedTextFromMenButton, expectedTextFromWomenButton);

    List<String> textFromButtonsOfAccessoriesButton = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToAccessoriesButton()
        .geTextFromButtonsOfAccessoriesSubMenu1();

    //Check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears
    softAssertions.assertThat(textFromButtonsOfAccessoriesButton)
        .as("We are waiting that text on buttons will be: " + expectedTextStationeryButton
            + expectedTextFromHomeAccessoriesButton)
        .containsExactlyInAnyOrder(expectedTextStationeryButton,
            expectedTextFromHomeAccessoriesButton);

    mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToArtButton();

    softAssertions.assertAll();
  }
}