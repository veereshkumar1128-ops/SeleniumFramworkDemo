package com.litigation.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.litigation.base.BaseClass;
import com.litigation.driverManager.DriverManager;
import com.litigation.pages.DashboardPage;
import com.litigation.pages.LoginPage;
import com.litigation.utilities.ExtentReportManager;
import com.litigation.utilities.ReadProperties;
import com.litigation.utilities.UIControls;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashboardPageTest extends BaseClass {
    //private ExtentTest extentTest;
    UIControls uiControls = new UIControls();
    private DashboardPage dashboardPage;
    private LoginPage loginPage;
//    @Parameters("browser")
//    @BeforeMethod
//    public void beforeMethod(String browser) {
//        ReadProperties readProperties = new ReadProperties();
//        DriverManager.getInstance().setDriver(browser);
//        DriverManager.getInstance().getDriver().get(readProperties.getValue("portalURL"));
//        DriverManager.getInstance().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        DriverManager.getInstance().getDriver().manage().window().maximize();
//    }
    @Test(priority = 1)
    public void testDashboard1(){
        ExtentTest extentTest = ExtentReportManager.getExtentReports().createTest("Test Dashboard1");
        loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        dashboardPage = new DashboardPage(DriverManager.getInstance().getDriver());
        loginPage.enterusername();
        extentTest.log(Status.INFO, "Entered Username");
        loginPage.enterpassword();
        extentTest.log(Status.INFO, "Entered Password");
        loginPage.clicklogin();
        extentTest.log(Status.INFO, "Clicked Login button");
        String screenshotpath=uiControls.getScreenshot(DriverManager.getInstance().getDriver(),"dashboard");
        extentTest.log(Status.PASS, extentTest.addScreenCaptureFromBase64String(screenshotpath).toString());
        dashboardPage.clickMyInfo(DriverManager.getInstance().getDriver());
        extentTest.log(Status.INFO, "Clicked MynInfo");
    }
    @Test(priority = 3)
    public void testDashboard2(){
        ExtentTest extentTest = ExtentReportManager.getExtentReports().createTest("Test Dashboard2");
        loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        dashboardPage = new DashboardPage(DriverManager.getInstance().getDriver());
        loginPage.enterusername();
        extentTest.log(Status.INFO, "Entered Username");
        loginPage.enterpassword();
        extentTest.log(Status.INFO, "Entered Password");
        loginPage.clicklogin();
        extentTest.log(Status.INFO, "Clicked Login button");
        String screenshotpath=uiControls.getScreenshot(DriverManager.getInstance().getDriver(),"dashboard");
        extentTest.log(Status.PASS, extentTest.addScreenCaptureFromBase64String(screenshotpath).toString());
        dashboardPage.clickMyInfo(DriverManager.getInstance().getDriver());
        extentTest.log(Status.INFO, "Clicked MynInfo");
    }
//    @AfterMethod
//    public void afterMethod(){
//        DriverManager.getInstance().quitDriver();
//    }
}
