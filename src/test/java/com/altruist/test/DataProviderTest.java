package com.altruist.test;

import com.altruist.pages.GoogleFinancePages;
import com.altruist.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import static com.altruist.utilities.Driver.getDriver;

public class DataProviderTest {
    @BeforeMethod
    public void setup() {
        getDriver().get("https://www.google.com/finance");
    }

    @DataProvider
    public Object[][] getData() {
        String[][] getThickerData = {
                {"Tesla Inc", "TSLA"},
                {"Amazon.com, Inc.", "AMZN"},
                {"Apple Inc", "AAPL"},
                {"Alphabet Inc Class A", "GOOGL"}};
        return getThickerData;
    };

    @Test(dataProvider = "getData")
    public void displayGooglThickerType(String name, String thicker) {
        System.err.println("this test is running for : " + name);
        GoogleFinancePages googleFinancePages = new GoogleFinancePages();
        Assert.assertTrue(getDriver().getTitle().contains("Google Finance"), "The page is not loaded as expected!");
        Actions action = new Actions(getDriver());
        action.sendKeys(googleFinancePages.searchBox, thicker).sendKeys(Keys.RETURN).perform();
        System.out.println(googleFinancePages.getPreviousPrice.getText());
        System.err.println(googleFinancePages.companyName.getText());
        Assert.assertEquals(googleFinancePages.companyName.getText(), name , "expected company name didn't return");
        Assert.assertEquals(googleFinancePages.getPrimaryExchange.getText(),"NASDAQ");
    }

//
//    @Test(priority = 2)
//    public void displayGooglThickerApple() {
//        GoogleFinancePages googleFinancePages = new GoogleFinancePages();
//        Assert.assertTrue(getDriver().getTitle().contains("Google Finance"), "The page is not loaded as expected!");
//        Actions action = new Actions(getDriver());
//        action.sendKeys(googleFinancePages.searchBox, "GOOGL").sendKeys(Keys.RETURN).perform();
//        System.out.println(googleFinancePages.getPreviousPrice.getText());
//
//    }
//
//    @Test(priority = 3)
//    public void displayGooglThickerBanana() {
//        GoogleFinancePages googleFinancePages = new GoogleFinancePages();
//        Assert.assertTrue(getDriver().getTitle().contains("Google Finance"), "The page is not loaded as expected!");
//        Actions action = new Actions(getDriver());
//        action.sendKeys(googleFinancePages.searchBox, "GOOGL").sendKeys(Keys.RETURN).perform();
//        System.out.println(googleFinancePages.getPreviousPrice.getText());
//    }

    @AfterMethod
    public void closeDriver() {
        Driver.closeDriver();
    }
}
