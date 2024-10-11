package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonProductPage;
import utils.DriverFactory;
import utils.ExcelUtils;

import java.util.List;

public class AmazonTest {

    WebDriver driver;
    AmazonLoginPage loginPage;
    AmazonHomePage homePage;
    AmazonProductPage productPage;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.amazon.eg/");
        driver.manage().window().maximize();
        loginPage = new AmazonLoginPage(driver);
        homePage = new AmazonHomePage(driver);
        productPage = new AmazonProductPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata/AmazonLoginData.xlsx", "LoginData");
        List<String[]> data = excelUtils.getExcelData();
        excelUtils.closeWorkbook();
        return data.toArray(new Object[0][]);
    }

    @Test(dataProvider = "loginData")
    public void amazonProductSearchTest(String username, String password) {
        loginPage.login(username, password);
        homePage.navigateToAllVideoGames();
        productPage.applyFilters();
        productPage.sortByPriceHighToLow();
        productPage.addProductsToCartBelowPrice(15000);
        assert productPage.verifyProductsInCart();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
