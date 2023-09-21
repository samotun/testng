package com.altruist.pages;

import com.altruist.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleFinancePages {

    public  GoogleFinancePages () {
        WebDriver driver = null;
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//input[@role='combobox'])[2]")
    public WebElement searchBox;

    @FindBy(xpath="//div[contains(text(),'Previous close')]/parent::span/following-sibling::div")
    public WebElement getPreviousPrice;

    @FindBy(className = "zzDege")
    public WebElement companyName;

    @FindBy(xpath = "//div[contains(text(), 'Primary exchange')]/parent::span/following-sibling::div")
    public WebElement getPrimaryExchange;

    //String SEARCHBOX = "(//input[@role='combobox'])[2]";
    //String SEARCHBOX2 = "(//input[@role='combobox2'])[2]";








}

// neden pagefactory
