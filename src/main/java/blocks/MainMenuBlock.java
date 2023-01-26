package blocks;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

@Data
public class MainMenuBlock {

  //Top Menu
  private static final By clothesButton = By.id("category-3");
  private static final By accessoriesButton = By.id("category-6");
  private static final By artButton = By.id("category-9");

  //Sub Menu
  private static final By clothesSubMenu
      = By.xpath("//li[@id='category-3']//div[contains(@id,'top_sub_menu')]//a");
  private final By accessoriesSubMenu
      = By.xpath("//li[@id='category-6']//div[contains(@id,'top_sub_menu')]//a");
  private final By artSubMenu
      = By.xpath("//li[@id='category-9']//div[contains(@id,'top_sub_menu')]//a");


  private static WebDriver driver;
  private static Actions actions;

  public MainMenuBlock(WebDriver webDriver) {
    driver = webDriver;
    actions = new Actions(driver);
  }

  public enum MainMenu {
    CLOTHES,
    ACCESSORIES,
    ART
  }

  public MainMenuBlock hoverToButton(MainMenu buttons) {
    switch (buttons) {
      case CLOTHES:
        Utils.hoverToButton(clothesButton);
        break;
      case ACCESSORIES:
        Utils.hoverToButton(accessoriesButton);
        break;
      case ART:
        Utils.hoverToButton(artButton);
        break;
    }
    return this;
  }

  public List<String> getNamesOfSubmenuButtons(MainMenu buttons) {
    List<String> buttonsName = new ArrayList<>();
    switch (buttons) {
      case CLOTHES:
        buttonsName = Utils.getNamesFromButtons(clothesSubMenu);
        break;
      case ACCESSORIES:
        buttonsName = Utils.getNamesFromButtons(accessoriesSubMenu);
        break;
      case ART:
        buttonsName = Utils.getNamesFromButtons(artSubMenu);
        break;
    }
    return buttonsName;
  }
}