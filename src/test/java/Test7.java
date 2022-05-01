import blocks.ProductBlock;
import java.util.List;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PricesDrop;

public class Test7 extends BaseTest{

  @Test
  public void checkThatEveryProductHasOldAndNewPriceAndTheyAreCorrectTest() {

    MainPage mainPage = new MainPage();
    List<ProductBlock> allProductsFromPage = mainPage.openMainPage()
        .clickOnPricesDropButton()
        .getAllProductsFromPage();

    PricesDrop pricesDrop = new PricesDrop();
    List<ProductBlock> allProductWithOldAndNewPrice = pricesDrop
        .getAllProductWithOldAndNewPrice(allProductsFromPage);

    //Check that every product has old and new price

    softAssertions.assertThat(allProductWithOldAndNewPrice)
        .as("")
        .isEqualTo(allProductsFromPage);

    List<ProductBlock> allProductWithCorrectPrice = pricesDrop
        .getAllProductWithCorrectPrice(allProductWithOldAndNewPrice);

    //Check that promo price for every product calculates correct

    softAssertions.assertThat(allProductWithCorrectPrice)
        .as("")
        .isEqualTo(allProductWithOldAndNewPrice);

    softAssertions.assertAll();


  }
}
//1.Go to the https://demo.prestashop.com/
//    2.At the bottom of the page click on 'Prices drop' link
//    3.Check that every product has old and new price
//    4.Check that promo price for every product calculates correct