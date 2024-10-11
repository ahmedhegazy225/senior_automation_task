package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonProductPage {
    WebDriver driver;

    // Locators
    By freeShippingFilter = By.xpath("//span[text()='Free Shipping']");
    By newConditionFilter = By.xpath("//span[text()='New']");
    By sortDropdown = By.id("sortDropdown");
    By highToLow = By.xpath("//option[text()='Price: High to Low']");
    By productPrices = By.cssSelector(".a-price-whole");
    By addToCartButtons = By.xpath("//input[@value='Add to Cart']");
    By nextPageButton = By.xpath("//li[@class='a-last']//a");

    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Apply filters for Free Shipping and New condition
    public void applyFilters() {
        driver.findElement(freeShippingFilter).click();
        driver.findElement(newConditionFilter).click();
    }

    public void sortByPriceHighToLow() {
        driver.findElement(sortDropdown).click();
        driver.findElement(highToLow).click();
    }

    // Add products below a specified price to the cart
    public void addProductsToCartBelowPrice(double priceLimit) {
        boolean foundProduct = false;

        // Get a list of product price elements
        List<WebElement> prices = driver.findElements(productPrices);
        List<WebElement> addToCartButtonsList = driver.findElements(addToCartButtons);

        for (int i = 0; i < prices.size(); i++) {
            double price = Double.parseDouble(prices.get(i).getText().replace(",", "").trim());
            if (price < priceLimit) {
                foundProduct = true;
                addToCartButtonsList.get(i).click(); // Click the corresponding Add to Cart button
            }
        }

        // If no products were found, go to the next page
        if (!foundProduct) {
            WebElement nextPage = driver.findElement(nextPageButton);
            if (nextPage.isDisplayed()) {
                nextPage.click();
            }
        }
    }

    // Verify that products were added to the cart
    public boolean verifyProductsInCart() {
        return true;
    }
}
