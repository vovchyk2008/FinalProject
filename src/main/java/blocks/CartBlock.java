package blocks;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class CartBlock {

  private WebElement productNameAsWebElement;
  private String nameAsString;
  private String actualPriceAsString;
  private Double actualPriceAsDouble;
  private String oldPrice;
  private Double oldPriceAsDouble;
  private String discount;
  private Double discountAsDouble;
  private Integer productQuantity;
  private Double productTotalPrice;


  public CartBlock(WebElement container) {
    try {
      this.productNameAsWebElement = container.findElement(By.xpath(".//a[@class='label']"));
      this.nameAsString = productNameAsWebElement.getText();
    } catch (NoSuchElementException e) {
      this.productNameAsWebElement = null;
      this.nameAsString = null;
    }

    try {
      this.actualPriceAsString =
          container.findElement(By.xpath(".//div[@class='current-price']/span")).getText()
              .substring(1);
      this.actualPriceAsDouble = Double.parseDouble(actualPriceAsString);
    } catch (NoSuchElementException e) {
      this.actualPriceAsString = null;
      this.actualPriceAsDouble = null;
    }

    try {
      this.oldPrice =
          container.findElement(By.xpath(".//span[@class='regular-price']")).getText();
      this.oldPriceAsDouble = Double.parseDouble(actualPriceAsString);
    } catch (NoSuchElementException e) {
      this.oldPrice = null;
      this.oldPriceAsDouble = null;
    }

    try {
      this.discount =
          container.findElement(By.xpath(".//span[@class='regular-price']")).getText();
      this.discountAsDouble = Double.parseDouble(actualPriceAsString);
    } catch (NoSuchElementException e) {
      this.discount = null;
      this.discountAsDouble = null;
    }

    try {
      this.productQuantity = Integer
          .parseInt(container.findElement(By.xpath(".//input")).getAttribute("value"));
    } catch (NoSuchElementException e) {
      this.productQuantity = null;
    }

    try {
      this.productTotalPrice = Double.parseDouble(
          container.findElement(By.xpath(".//strong")).getText()
              .substring(1));
    } catch (NoSuchElementException e) {
      this.productTotalPrice = null;
    }

  }
}