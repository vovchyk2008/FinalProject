import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PricesDrop;

public class CheckPricesTest extends BaseTest {

  @Test(description = "Check That Every Product Has Old And New Price And They Are Correct Test")
  public void checkThatEveryProductHasOldAndNewPriceAndTheyAreCorrectTest() {

    MainPage mainPage = new MainPage();
    List<ProductBlock> allProductsFromPage = mainPage.openMainPage()
        .clickOnPricesDropButton()
        .getAllProductsFromPage();

    PricesDrop pricesDrop = new PricesDrop();
    List<ProductBlock> allProductWithOldAndNewPrice = pricesDrop
        .getAllProductWithOldAndNewPrice(allProductsFromPage);

    //Check that every product has old and new price
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(allProductWithOldAndNewPrice)
        .as("We are waiting that " + allProductWithOldAndNewPrice + " and " + allProductsFromPage
            + " are equal to each other")
        .isEqualTo(allProductsFromPage);

    List<ProductBlock> allProductWithCorrectPrice = pricesDrop
        .getAllProductWithCorrectPrice(allProductWithOldAndNewPrice);

    //Check that promo price for every product calculates correct

    softAssertions.assertThat(allProductWithCorrectPrice)
        .as("We are waiting that " + allProductWithCorrectPrice + " and "
            + allProductWithOldAndNewPrice + " are equal to each other")
        .isEqualTo(allProductWithOldAndNewPrice);

    softAssertions.assertAll();


  }
}
//1.Go to the https://demo.prestashop.com/
//    2.At the bottom of the page click on 'Prices drop' link
//    3.Check that every product has old and new price
//    4.Check that promo price for every product calculates correct