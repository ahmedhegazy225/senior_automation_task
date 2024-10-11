package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.util.List;

public class ExcelUtilsTest {

    @Test
    public void testReadExcelData() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata/AmazonLoginData.xlsx", "LoginData");

        List<String[]> data = excelUtils.getExcelData();

        excelUtils.closeWorkbook();

        // Assert that data has been fetched and the first row is as expected
        Assert.assertNotNull(data, "Excel data should not be null");
        Assert.assertTrue(data.size() > 0, "Excel should contain data");
        Assert.assertEquals(data.get(0)[0], "", "First username should match");
        Assert.assertEquals(data.get(0)[1], "", "First password should match");
    }
}
