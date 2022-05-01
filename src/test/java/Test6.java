import blocks.ProductBlock;
import java.util.List;
import org.testng.annotations.Test;
import pages.MainPage;

public class Test6 extends BaseTest {

  @Test
  public void checkNamesAndPricesInPopularProductsTest() {

    int expectedCountOfProduct = 8;

    MainPage mainPage = new MainPage();
    List<ProductBlock> allProductsFromMainPage = mainPage.openMainPage()
        .getAllProductsFromMainPage();

    //Check that 8 products exist in 'POPULAR PRODUCTS' section

    softAssertions.assertThat(allProductsFromMainPage.size())
        .as("We are waiting that: " + expectedCountOfProduct
            + " will be exist in 'POPULAR PRODUCTS' section")
        .isEqualTo(expectedCountOfProduct);

    List<ProductBlock> allProductWithName = mainPage.getAllProductWithName(allProductsFromMainPage);

    //Check that every product has name

    softAssertions.assertThat(allProductWithName)
        .as("We are waiting that: " + allProductWithName + "equals " + allProductsFromMainPage)
        .isEqualTo(allProductsFromMainPage);

    //Check that every product has price

    List<ProductBlock> allProductsWithPrice = mainPage
        .getAllProductsWithPrice(allProductsFromMainPage);

    softAssertions.assertThat(allProductsWithPrice)
        .as("We are waiting that: " + allProductsWithPrice + "equals " + allProductsFromMainPage)
        .isEqualTo(allProductsFromMainPage);

    List<ProductBlock> allProductsWithPriceMoreThanZero = mainPage
        .getAllProductsWithPriceMoreThanZero(allProductsWithPrice);

    //Check that all prices bigger than 0.00

    softAssertions.assertThat(allProductsWithPriceMoreThanZero)
        .as("We are waiting that: " + allProductsWithPriceMoreThanZero + "equals "
            + allProductsWithPrice)
        .isEqualTo(allProductsWithPrice);

    softAssertions.assertAll();
  }
}