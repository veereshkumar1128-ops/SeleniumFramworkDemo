package com.litigation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.litigation.driverManager.DriverManager;
import com.litigation.utilities.ExtentReportManager;
import com.litigation.utilities.ReadProperties;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {
    protected static ReadProperties readProperties;
    protected ExtentReports extentReports;
    public ExtentTest extentTest;
    @BeforeSuite(alwaysRun = true)
    public void loadconfig(){
        ExtentReportManager.getExtentReports();
        readProperties = new ReadProperties();
    }
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser) {
        DriverManager.getInstance().setDriver(browser);
        DriverManager.getInstance().getDriver().get(readProperties.getValue("portalURL"));
        DriverManager.getInstance().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        DriverManager.getInstance().getDriver().manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        DriverManager.getInstance().quitDriver();

    }
    @AfterSuite
    public void afterSuite(){
        ExtentReportManager.reportflush();
    }
}
