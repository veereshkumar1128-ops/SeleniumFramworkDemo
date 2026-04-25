package com.litigation.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
  private static DriverManager INSTANCE;
  private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
  public static DriverManager getInstance() {
      if(INSTANCE == null) {
          INSTANCE = new DriverManager();
      }
      return INSTANCE;
  }
  public synchronized void setDriver(String browser){
      switch(browser){
          case "chrome":driver.set(new ChromeDriver());break;
          case "firefox":driver.set(new FirefoxDriver());break;
          default:throw new IllegalArgumentException("Invalid browser");
      }
  }
  public synchronized WebDriver getDriver(){
      return driver.get();
  }
  public void quitDriver(){
      if(driver.get()!=null){
          driver.get().quit();
          driver.remove();
      }
  }
}
