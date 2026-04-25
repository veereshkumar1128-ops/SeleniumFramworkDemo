package com.litigation.pages;

import com.litigation.utilities.Log;
import com.litigation.utilities.ReadProperties;
import com.litigation.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    //private WebDriver driver;
    private WaitHelper waits;
    private ReadProperties readProperties;
    public DashboardPage(WebDriver driver){
        //this.driver=driver;
        waits = new WaitHelper(driver);
    }

    By Myinfo = By.xpath("//span[text()='My Info']");


    public void clickMyInfo(WebDriver driver){
        waits.waitForclickable(Myinfo,5);
        driver.findElement(Myinfo).click();
        Log.info("Clicked MyInfo list item");
    }
}
