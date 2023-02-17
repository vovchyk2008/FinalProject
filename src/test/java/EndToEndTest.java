import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import pages.PaymentPage;

public class EndToEndTest extends BaseTest {

  String searchingName1 = "Mug";
  String searchingName2 = "T-Shirt";
  String clickOnName1 = "Customizable Mug";
  String clickOnName2 = "Hummingbird Printed T-Shirt";
  String customizationMessage = "Best mug ever";
  String selectedColorOfTShirt = "Black";
  int quantityOfMugs = 1;
  String expectedStatusName = "YOUR ORDER IS CONFIRMED";

  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();
  String email = faker.internet().emailAddress();
  String password = faker.internet().password(10,72);
  String companyName = faker.company().name();
  String vatNumber = faker.finance().iban();
  String address = faker.address().fullAddress();
  String addressComplement = faker.address().secondaryAddress();
  String zipCod = faker.address().zipCode().substring(0,5);
  String city = faker.address().city();
  String phone = faker.phoneNumber().cellPhone();



  @Test
  public void checkEndToEndTest() {

    MainPage mainPage = new MainPage();
    double totalProductsPrice = mainPage
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
        .clickOnProceedToCheckoutButton()
        .getTotalPriceOfAllProducts();

    CartPage cartPage = new CartPage();
    double totalCartsPrice = cartPage.getTotalCartsPrice();

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(totalProductsPrice)
        .as("")
        .isEqualTo(totalCartsPrice);

    double amountValue = cartPage
        .clickOnProceedToCheckoutButton()
        .checkSocialTitleRadioButton()
        .enterFirstName(firstName)
        .enterLastName(lastName)
        .enterEmail(email)
        .clickOnReceiveOffersCheckBox()
        .clickOnCustomerDataPrivacyCheckBox()
        .clickOnSignUpForOurNewsletterCheckBox()
        .clickOnAgreeToTheTermsCheckBox()
        .clickOnContinueButton()
        .enterCompanyName(companyName)
        .enterVatNumber(vatNumber)
        .enterAddress(address)
        .enterAddressComplement(addressComplement)
        .zipCode(zipCod)
        .enterCity(city)
        .enterPhone(phone)
        .clickOnContinueButton()
        .clickOnByCarrierRadioButton()
        .clickOnContinueButton()
        .clickOnPayByCheckRadioButton()
        .getAmountValue();

    double sumOfSubtotalAndShipping = new PaymentPage().getSumOfSubtotalAndShipping();

    softAssertions.assertThat(amountValue)
        .as("")
        .isEqualTo(sumOfSubtotalAndShipping);

    String textFromStatusName = new PaymentPage()
        .clickOnIAgreeCheckBox()
        .clickOnPlaceOrderButton()
        .getTextFromStatusName();

    softAssertions.assertThat(textFromStatusName)
        .as("")
        .isEqualTo(expectedStatusName);



    softAssertions.assertAll();


  }
}





//    27.Check that 'TOTAL' calculated correct