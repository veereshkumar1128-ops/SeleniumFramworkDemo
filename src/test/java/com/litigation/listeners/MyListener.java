package com.litigation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.litigation.driverManager.DriverManager;
import com.litigation.utilities.Log;
import com.litigation.utilities.UIControls;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    UIControls uiControls = new UIControls();
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    public void onTestStart(ITestResult result) {
        Log.info(String.format("Start test %s", result.getMethod().getMethodName()));
        //extentTest=extentReports.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        Log.info(String.format("Test successful %s", result.getMethod().getMethodName()));
        if(ITestResult.SUCCESS == result.getStatus()) {
            //extentTest=extentReports.createTest(result.getMethod().getMethodName());
            //uiControls = new UIControls();
            String screenshotpath=uiControls.getScreenshot(DriverManager.getInstance().getDriver(),result.getMethod().getMethodName());
            extentTest.addScreenCaptureFromPath(screenshotpath);
        }
    }

    public void onTestFailure(ITestResult result) {
        //uiControls = new UIControls();
        Log.error(String.format("Test failed %s", result.getMethod().getMethodName()));
        if(ITestResult.FAILURE == result.getStatus()) {
            //extentTest=extentReports.createTest(result.getMethod().getMethodName());
            String screenshotpath=uiControls.getScreenshot(DriverManager.getInstance().getDriver(),result.getMethod().getMethodName());
            extentTest.addScreenCaptureFromPath(screenshotpath);
        }
    }

    public void onTestSkipped(ITestResult result) {
        Log.info(String.format("Test skipped %s", result.getMethod().getMethodName()));
        if(ITestResult.SKIP == result.getStatus()) {
            //extentTest=extentReports.createTest(result.getMethod().getMethodName());
        }
    }
    public void onStart(ITestContext context) {
        Log.info(String.format("On Start %s", context.getName()));
    }

    public void onFinish(ITestContext context) {
        Log.info(String.format("On Finish %s", context.getName()));

    }
}
