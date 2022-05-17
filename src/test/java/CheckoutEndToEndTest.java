import blocks.CartBlock;
import java.util.List;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckoutEndToEndTest extends BaseTest {

  @Test(description = "Check End To End Test")
  public void checkEndToEndTest() {

    String searchingName1 = "Mug";
    String searchingName2 = "T-Shirt";
    String productNameAfterSearching1 = "Customizable Mug";
    String productNameAfterSearching2 = "Hummingbird Printed T-Shirt";
    String message = "Best mug ever";
    String color = "Black";
    int quantity = 1;

    MainPage mainPage = new MainPage();
    mainPage.
        openMainPage()
        .enterSearchName(searchingName1)
        .clickOnSearchingProduct(productNameAfterSearching1)
        .enterCustomizationMessage(message)
        .clickOnSaveCustomizationButton()
        .selectQuantity(quantity)
        .addToCartButton()
        .clickOnContinueShoppingButton()
        .enterSearchName(searchingName2)
        .clickOnSearchingProduct(productNameAfterSearching2)
        .selectColor(color)
        .addToCartButton()
        .clickOnProceedToCheckoutButton();

  }
}
//1.Go to the https://demo.prestashop.com/+
//2.In the search field enter 'Mug' and press 'Enter'+
//3.On the 'SEARCH RESULTS' page click on 'Customizable Mug'+
//4.Enter 'Best mug ever' in 'Product customization' field+
//5.Click 'SAVE CUSTOMIZATION'+
//6.Change 'Quantity' to '1' if not '1' already+
//7.Click 'ADD TO CART' button+
//8.On the next window click 'CONTINUE SHOPPING'+
//9.In the search field enter 'T-Shirt' and press 'Enter'+
//10.On the 'SEARCH RESULTS' page click on 'Hummingbird Printed T-Shirt'+
//11.Select 'Black' color+
//12.Click 'ADD TO CART' button+
//13.On the next window click 'PROCEED TO CHECKOUT'+
//14.On the 'SHOPPING CART' page check that 'Total' calculated correct
//15.Click 'PROCEED TO CHECKOUT'
//16.Fill 'PERSONAL INFORMATION' form with valid data (without password)
//17.Click 'CONTINUE'
//18.Fill the 'ADDRESSES' form with valid data
//19.Click 'CONTINUE'
//20.On the 'SHIPPING METHOD' section select 'My carrier'
//21.Click 'CONTINUE'
//22.On the 'PAYMENT' section select 'Pay by Check'
//23.Check that Amount equal Subtotal+Shipping
//24.Click on 'I agree..' checkbox
//25.Click on 'Order with an obligation to pay'
//26.Check that 'YOUR ORDER IS CONFIRMED' appeared on the next page
//27.Check that 'TOTAL' calculated correct