import org.testng.annotations.Test;
import pages.MainPage;

public class EndToEndTest extends BaseTest {

  String searchingName1 = "Mug";
  String searchingName2 = "T-Shirt";
  String clickOnName1 = "Customizable Mug";
  String clickOnName2 = "Hummingbird Printed T-Shirt";
  String customizationMessage = "Best mug ever";
  String selectedColorOfTShirt = "Black";
  int quantityOfMugs = 1;

  @Test
  public void checkEndToEndTest() {

    MainPage mainPage = new MainPage();
    mainPage
        .openMainPage()
        .enterSearchName(searchingName1)
        .clickOnSearchingProduct(clickOnName1)
        .enterCustomizationMessage(customizationMessage)
        .clickOnSaveCustomizationButton()
        .selectQuantity(quantityOfMugs)
        .clickOnAddToCartButton()
        .clickOnContinueShoppingButton()
        .enterSearchName(searchingName2)
        .clickOnSearchingProduct(clickOnName2)
        .selectColor(selectedColorOfTShirt)
        .clickOnAddToCartButton()
        .clickOnProceedToCheckoutButton();


  }
}

//    14.On the 'SHOPPING CART' page check that 'Total' calculated correct
//    15.Click 'PROCEED TO CHECKOUT'
//    16.Fill 'PERSONAL INFORMATION' form with valid data (without password)
//    17.Click 'CONTINUE'
//    18.Fill the 'ADDRESSES' form with valid data
//    19.Click 'CONTINUE'
//    20.On the 'SHIPPING METHOD' section select 'My carrier'
//    21.Click 'CONTINUE'
//    22.On the 'PAYMENT' section select 'Pay by Check'
//    23.Check that Amount equal Subtotal+Shipping
//    24.Click on 'I agree..' checkbox
//    25.Click on 'Order with an obligation to pay'
//    26.Check that 'YOUR ORDER IS CONFIRMED' appeared on the next page
//    27.Check that 'TOTAL' calculated correct