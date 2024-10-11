package tests;

import api.FoodicsLoginAPI;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.util.List;

public class FoodicsLoginAPITest {

    @DataProvider(name = "apiLoginData")
    public Object[][] getApiLoginData() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata/FoodicsLoginData.xlsx", "APIData");
        List<String[]> data = excelUtils.getExcelData();
        excelUtils.closeWorkbook();
        return data.toArray(new Object[0][]);
    }

    @Test(dataProvider = "apiLoginData")
    public void testLoginAPI(String email, String password) {
        FoodicsLoginAPI api = new FoodicsLoginAPI();
        String token = api.login(email, password);
        assert token != null && !token.isEmpty();
    }
}
