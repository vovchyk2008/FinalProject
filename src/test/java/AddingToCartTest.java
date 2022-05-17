import blocks.AddingToCartBlock;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class AddingToCartTest extends BaseTest {

  @Test(description = "Check That Sorting Is Correct Test")
  public void checkThatSortingIsCorrectTest() {

    String searchNameOnSearchBlock = "Bear";
    String name = "Brown Bear Notebook";
    String expectedStatusAfterAddedToCart = "Product successfully added to your shopping cart";
    String expectedPaperType = "Doted";
    int quantity = 5;

    MainPage mainPage = new MainPage();
    AddingToCartBlock productBlock = mainPage.openMainPage()
        .enterSearchName(searchNameOnSearchBlock)
        .clickOnSearchingProduct(name)
        .selectPaperType()
        .selectQuantity(quantity)
        .addToCartButton()
        .getProductInfo();

    SoftAssertions softAssertions = new SoftAssertions();

    //Check that new window with title 'Product successfully added to your shopping cart' appears

    softAssertions.assertThat(productBlock.getProductStatus())
        .as("We are waiting that: " + productBlock.getProductStatus() + "is equal to "
            + expectedStatusAfterAddedToCart)
        .isEqualTo(expectedStatusAfterAddedToCart);

    //Check that correct 'Paper Type' and 'Quantity' is shown on the left side of the window

    softAssertions.assertThat(productBlock.getPaperType())
        .as("We are waiting that Paper Type must be: " + expectedPaperType)
        .isEqualTo(expectedPaperType);

    softAssertions.assertThat(productBlock.getProductQuantity())
        .as("We are waiting that quantity of products must be: " + quantity)
        .isEqualTo(quantity);

    Double actualTotalPrice = productBlock.getProductPrice() * quantity;

    //Check that 'Total' calculated correct

    softAssertions.assertThat(productBlock.getTotalPrice())
        .as("We are waiting that Total prise must be: " + actualTotalPrice)
        .isEqualTo(actualTotalPrice);

    softAssertions.assertAll();

  }
}

//1.Go to the https://demo.prestashop.com/
//2.c enter 'Bear' and press 'Enter'+
//3.On the 'SEARCH RESULTS' page click on 'Brown Bear Notebook'+
//4.Change 'Paper type' to 'Doted'+
//5.Change 'Quantity' to '5'+
//6.Click 'ADD TO CART' button+
//7.Check that new window with title 'Product successfully added to your shopping cart' appears
//8.Check that correct 'Paper Type' and 'Quantity' is shown on the left side of the window
//9.Check that 'Total' calculated correct