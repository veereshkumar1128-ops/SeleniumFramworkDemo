package com.litigation.utilities;

import com.litigation.driverManager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class UIControls {
    WaitHelper waitHelper=new WaitHelper(DriverManager.getInstance().getDriver());
    public String captureScreenshot(WebDriver driver, String screenshotname){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        //String reportspath=System.getProperty("user.dir")+"\\reports\\extentreport.html";
        String dest = System.getProperty("user.dir")+"\\reports\\screenshots\\"+screenshotname+".png";
        File destFile = new File(dest);
        try {
            FileUtils.copyFile(source,destFile);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            Log.info("Screenshot Capture method failed");
            Log.error(e.getMessage());

        }
        return dest;
    }
    public void enterText(By locator, String text) {
        try {
            DriverManager.getInstance().getDriver().findElement(locator).clear();
            DriverManager.getInstance().getDriver().findElement(locator).sendKeys(text);
        } catch (Exception e) {
            Log.info("enterText method failed");
            Log.error(e.getMessage());
        }
    }
    public String getText(By locator) {
        try {
            waitHelper.waitForVisibility(locator, 5);
            return DriverManager.getInstance().getDriver().findElement(locator).getText();
        } catch (Exception e) {
            Log.info("getText method failed");
            Log.error(e.getMessage());
            return "";
        }
    }
    public boolean compareText(By locator,String expectedtext){
        waitHelper.waitForVisibility(locator, 5);
        if(DriverManager.getInstance().getDriver().findElement(locator).getText().equals(expectedtext)){
            return true;
        }
        else{
            return false;
        }
    }
    public String getScreenshot(WebDriver driver, String screenshotname){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"/reports/screenshots/"+screenshotname+".png";
        File fi=new File(dest);
        try {
            FileUtils.copyFile(source,fi);
        } catch (IOException e) {
            Log.info("Screenshot Capture method failed");
        }
        return dest;
    }
}
