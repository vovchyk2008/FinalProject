package blocks;

import java.util.List;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

@Getter
public class MainMenuBlock {

  //Top Menu
  private static By clothesButton = By.id("category-3");
  private static By accessoriesButton = By.id("category-6");
  private static By artButton = By.id("category-9");

  //Sub Menu
  private static By clothesSubMenu
      = By.xpath("//li[@id='category-3']/div[contains(@id,'top_sub_menu')]/ul/li/a");
  private static By menButton = By.id("category-4");
  private static By womenButton = By.id("category-5");

  private static By accessoriesSubMenu
      = By.xpath("//li[@id='category-6']/div[contains(@id,'top_sub_menu')]/ul/li/a");
  private static By stationeryButton = By.id("category-7");
  private static By homeAccessoriesButton = By.id("category-8");
  private static By home = By.xpath("//li[@id='category-6']/a");


  private static WebDriver driver;
  private static Actions actions;

  public MainMenuBlock(WebDriver webDriver) {
    driver = webDriver;
    actions = new Actions(driver);
  }

  public MainMenuBlock hoverToClothesButton() {
    Utils.hoverToButton(clothesButton);
    return this;
  }

  public MainMenuBlock hoverToAccessoriesButton() {
    Utils.hoverToButton(accessoriesButton);
    return this;
  }

  public MainMenuBlock hoverToArtButton() {
    Utils.hoverToButton(artButton);
    return this;
  }

  public List<String> geTextFromButtonsOfClothesSubMenu1() {
    return Utils.getNamesFromButtons(clothesSubMenu);
  }

  public List<String> geTextFromButtonsOfAccessoriesSubMenu1() {
    return Utils.getNamesFromButtons(accessoriesSubMenu);
  }



}
