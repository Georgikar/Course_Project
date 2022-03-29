package com.course.tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SuccessfulLogin extends TestUtil {


    @DataProvider(name = "userList")
    public static Object[][] readUsersFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/userList.csv"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }
    @Test(dataProvider = "userList")
    public void successfulLogin(String userName, String password)   {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productPage = loginPage.login(userName,password);

        WebElement productsMainLabel = driver.findElement(By.xpath("//span[text()='Products']"));

        Assert.assertTrue(productsMainLabel.isDisplayed());




    }
}
