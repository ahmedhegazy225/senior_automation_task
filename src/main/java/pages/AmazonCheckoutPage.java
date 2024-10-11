package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCheckoutPage {
    WebDriver driver;

    // Locators
    By cartButton = By.id("nav-cart");
    By proceedToCheckoutButton = By.name("proceedToCheckout");
    By enterAddressButton = By.xpath("//input[@aria-labelledby='enterAddressButton']");
    By cashOnDeliveryOption = By.xpath("//input[@value='Cash on Delivery']");
    By totalAmount = By.id("grand-total-amount"); // Adjust selector based on actual page


    public AmazonCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Proceed to checkout
    public void proceedToCheckout() {
        driver.findElement(cartButton).click();
        driver.findElement(proceedToCheckoutButton).click();
        driver.findElement(enterAddressButton).click();
    }

    // Select Cash on Delivery as payment method
    public void selectCashOnDelivery() {
        driver.findElement(cashOnDeliveryOption).click();
    }

    // Get the total amount displayed
    public double getTotalAmount() {
        String total = driver.findElement(totalAmount).getText();
        return Double.parseDouble(total.replace("EGP", "").trim());
    }

    // Verify the total amount including any shipping fees
    public boolean verifyTotalAmount(double expectedTotal) {
        double total = getTotalAmount();
        return total == expectedTotal;
    }
}
