package blocks;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class ProductBlock {
  //div[@class='thumbnail-container reviews-loaded']

  private WebElement img;
  private WebElement nameAsWebElement;
  private String nameAsString;
  private String discount;
  private String actualPrice;
  private Double actualPriceAsDouble;
  private String oldPrice;
  private WebElement addToWishList;

  public ProductBlock(WebElement container) {

    try {
      this.img = container.findElement(By.xpath(".//div[@class='thumbnail-top']/a"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.nameAsWebElement = container.findElement(By.xpath(".//h3[@class='h3 product-title']/a"));
    } catch (NoSuchElementException e) {
      this.nameAsWebElement = null;
    }

    try {
      this.nameAsString = container.findElement(By.xpath(".//h3[@class='h3 product-title']/a")).getText();
    } catch (NoSuchElementException e) {
      this.nameAsWebElement = null;
    }

    try {
      this.discount = container.findElement(By.xpath(".//li[@class='product-flag discount']")).getText();
    } catch (NoSuchElementException e) {
      this.discount = null;
    }

    try {
      this.actualPrice = container.findElement(By.xpath(".//span[@class='price']")).getText();
      this.actualPriceAsDouble = Double.parseDouble(actualPrice.substring(1));
    } catch (NoSuchElementException e) {
      this.actualPrice = null;
      this.actualPriceAsDouble = null;
    }

    try {
      this.oldPrice = container.findElement(By.xpath(".//span[@class='regular-price']")).getText();
    } catch (NoSuchElementException e) {
      this.oldPrice = null;
    }

    try {
      this.addToWishList = container.findElement(By.xpath(".//i[@class='material-icons']"));
    } catch (NoSuchElementException e) {
      this.addToWishList = null;
    }
  }
}
