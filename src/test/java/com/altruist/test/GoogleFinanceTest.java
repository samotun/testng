package com.altruist.test;


import com.altruist.pages.GoogleFinancePages;
import com.altruist.utilities.Driver;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import org.testng.annotations.*;


import static com.altruist.utilities.Driver.getDriver;


public class GoogleFinanceTest {


    @Test
    public void displayGooglThickerType() {
        Driver.getDriver().get("https://www.google.com/finance");
        GoogleFinancePages googleFinancePages = new GoogleFinancePages();
        Assert.assertTrue(getDriver().getTitle().contains("Google Finance"), "The page is not loaded as expected!");
        Actions action = new Actions(getDriver());
        action.sendKeys(googleFinancePages.searchBox, "GOOGL").sendKeys(Keys.RETURN).perform();
        System.out.println(googleFinancePages.getPreviousPrice.getText());
        Driver.closeDriver();
    }

}
