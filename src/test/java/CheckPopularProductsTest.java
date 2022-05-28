import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckPopularProductsTest extends BaseTest {

  @Test(description = "Check Names And Prices In Popular Products Test")
  public void checkNamesAndPricesInPopularProductsTest() {

    int expectedCountOfProduct = 8;
    double priceBiggerThen = 0.00;

    MainPage mainPage = new MainPage();
    List<ProductBlock> allProductsFromMainPage = mainPage.openMainPage()
        .getAllProductsFromMainPage();

    //Check that 8 products exist in 'POPULAR PRODUCTS' section
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(allProductsFromMainPage)
        .as("We are waiting that: " + expectedCountOfProduct
            + " will be exist in 'POPULAR PRODUCTS' section")
        .hasSize(expectedCountOfProduct);

    List<String> allNamesFromProducts = mainPage.getAllNamesFromProducts(allProductsFromMainPage);

    //Check that every product has name

    softAssertions.assertThat(allNamesFromProducts)
        .as("We are waiting that every name from: " + allNamesFromProducts + "is not null")
        .allMatch(s -> s != null);

    //Check that every product has price

    List<Double> allPricesFromProducts = mainPage
        .getAllPricesFromProducts(allProductsFromMainPage);

    softAssertions.assertThat(allPricesFromProducts)
        .as("We are waiting that every price from: " + allPricesFromProducts + "is not null")
        .allMatch(aDouble -> aDouble != null);

    //Check that all prices bigger than 0.00

    softAssertions.assertThat(allPricesFromProducts)
        .as("We are waiting that every price from: " + allPricesFromProducts + "is bigger then" + priceBiggerThen)
        .allMatch(aDouble -> aDouble > priceBiggerThen);

    softAssertions.assertAll();
  }
}