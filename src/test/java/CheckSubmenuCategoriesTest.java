import blocks.MainMenuBlock.MainMenu;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckSubmenuCategoriesTest extends BaseTest {

  @Test(invocationCount = 5)//(description = "Check That First Name Highlighted In Red Test")
  public void checkThatMainMenuHasSubMenuTest() {

    String expectedTextFromMenButton = "MEN";
    String expectedTextFromWomenButton = "WOMEN";
    String expectedTextStationeryButton = "STATIONERY";
    String expectedTextFromHomeAccessoriesButton = "HOME ACCESSORIES";

    MainPage mainPage = new MainPage();
    List<String> textFromButtonsOfClothesSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToButton(MainMenu.CLOTHES)
        .getNamesOfSubmenuButtons(MainMenu.CLOTHES);

    //Check that 'MEN' and 'WOMEN' sub menu items appears
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(textFromButtonsOfClothesSubMenu)
        .as("We are waiting that text on buttons will be: " + expectedTextFromMenButton
            + expectedTextFromWomenButton)
        .containsExactlyInAnyOrder(expectedTextFromMenButton, expectedTextFromWomenButton);

    List<String> textFromButtonsOfAccessoriesSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToButton(MainMenu.ACCESSORIES)
        .getNamesOfSubmenuButtons(MainMenu.ACCESSORIES);

    //Check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears

    softAssertions.assertThat(textFromButtonsOfAccessoriesSubMenu)
        .as("We are waiting that text on buttons will be: " + expectedTextStationeryButton
            + expectedTextFromHomeAccessoriesButton)
        .containsExactlyInAnyOrder(expectedTextStationeryButton,
            expectedTextFromHomeAccessoriesButton);

    List<String> buttonsOfArtSubMenu = mainPage
        .openMainPage()
        .getMainMenuBlock()
        .hoverToButton(MainMenu.ART)
        .getNamesOfSubmenuButtons(MainMenu.ART);

    //Check that 'ART' has no submenu

    softAssertions.assertThat(buttonsOfArtSubMenu)
        .as("Button has no submenu if " + buttonsOfArtSubMenu.size() + "= 0")
        .hasSize(0);

    softAssertions.assertAll();
  }
}