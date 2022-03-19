package com.course.tests;

import Pages.CheckOutPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CheckingOut extends TestUtil {

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
        public void checkOut (String userName, String password){
            LoginPage loginPage = new LoginPage(driver);
            ProductsPage productPage = loginPage.login(userName, password);
            productPage.addToCartByProductName("bolt-t-shirt");
            productPage.addToCartByProductName("onesie");
            WebElement btnShoppingCart = driver.findElement(By.className("shopping_cart_link"));
            btnShoppingCart.click();
            WebElement btnCheckOut = driver.findElement(By.id("checkout"));
            btnCheckOut.click();
            CheckOutPage checkingOut=new CheckOutPage(driver);


        }
    }