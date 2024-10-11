package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
    WebDriver driver;

    By allMenu = By.id("nav-hamburger-menu");
    By videoGamesLink = By.xpath("//a[text()='Video Games']");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAllVideoGames() {
        driver.findElement(allMenu).click();
        driver.findElement(videoGamesLink).click();
    }
}
