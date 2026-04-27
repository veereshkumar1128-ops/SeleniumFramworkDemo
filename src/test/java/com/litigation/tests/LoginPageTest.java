package com.litigation.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.litigation.base.BaseClass;
import com.litigation.driverManager.DriverManager;
import com.litigation.pages.LoginPage;
import com.litigation.utilities.ExtentReportManager;
import com.litigation.utilities.Log;
import com.litigation.utilities.ReadProperties;
import com.litigation.utilities.UIControls;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

public class LoginPageTest extends BaseClass {
    //public DriverManager driver;
    //private ExtentTest extentTest;
    UIControls uiControls = new UIControls();
    public LoginPage loginPage;

    @Test(priority = 2)
    public void testLogin1(){
        String screenshotpath=uiControls.getScreenshot(DriverManager.getInstance().getDriver(),"logintest");
        ExtentTest extentTest = ExtentReportManager.getExtentReports().createTest("Test Login1");
        loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.enterusername();
        extentTest.log(Status.PASS, extentTest.addScreenCaptureFromPath(screenshotpath).toString());
        extentTest.log(Status.INFO, "Entered Username for testLogin");
        loginPage.enterpassword();
        extentTest.log(Status.PASS, extentTest.addScreenCaptureFromPath(screenshotpath).toString());
        extentTest.log(Status.INFO, "Entered Password for testLogin");
        File fi= new File(screenshotpath);
        try {
            Allure.addAttachment("screenshot", FileUtils.openInputStream(fi));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.log(Status.PASS, extentTest.addScreenCaptureFromPath(screenshotpath).toString());
        loginPage.clicklogin();
        extentTest.log(Status.INFO, "Clicked Login for testLogin");
    }
    @Test
    public void testLogin2(){
        ExtentTest extentTest = ExtentReportManager.getExtentReports().createTest("Test Login2");
        loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.enterusername();
        extentTest.log(Status.INFO, "Entered Username for testLogin");
        loginPage.enterpassword();
        extentTest.log(Status.INFO, "Entered Password for testLogin");
        String screenshotpath=uiControls.getScreenshot(DriverManager.getInstance().getDriver(),"logintest");

        File f = new File(screenshotpath);
    extentTest.log(Status.PASS, extentTest.addScreenCaptureFromPath(screenshotpath).toString());
        try {
            Allure.addAttachment("screenshot", FileUtils.openInputStream(f));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loginPage.clicklogin();
        extentTest.log(Status.INFO, "Clicked Login for testLogin");
    }
}
