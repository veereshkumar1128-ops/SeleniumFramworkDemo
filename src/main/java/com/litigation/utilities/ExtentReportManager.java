package com.litigation.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportManager {
    public static ExtentReports report;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports getExtentReports() {
    if(report==null){
    String reportspath =System.getProperty("user.dir")+"/reports/extentreport.html";
    String screenshotpath=System.getProperty("user.dir")+"/reports/screenshots/";
    File f=new File(screenshotpath);
    f.mkdirs();
    report=new ExtentReports();
    sparkReporter = new ExtentSparkReporter(reportspath);
    report.attachReporter(sparkReporter);
    }
    return report;
}
    public static void reportflush(){
    report.flush();
}
}
