package com.litigation.pages;

import com.litigation.base.BaseClass;
import com.litigation.driverManager.DriverManager;
import com.litigation.utilities.Log;
import com.litigation.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BaseClass {
    private WebDriver driver;
    private WaitHelper waits;
    //private ReadProperties readProperties;
    public LoginPage(WebDriver driver) {
        //readProperties = new ReadProperties();
        waits = new WaitHelper(driver);
        this.driver=driver;
        //PageFactory.initElements(driver, this);
    }
    private By  Username = By.name("username");
    private By Password = By.name("password");
    private By loginbutton = By.xpath("//*[@type='submit']");
//    @FindBy(name = "username")
//    private WebElement Username;

//    @FindBy(name="password")
//    private WebElement Password;

//    @FindBy(xpath="//*[@type='submit']")
//    private WebElement LoginButton;

    public void enterusername(){
        //waits.explicitwait(driver,Username);
        //Thread.sleep(5000);
        waits.waitForVisibility(Username,5);
        //DriverManager.getInstance().getDriver().get(readProperties.getValue("portalURL"));
        DriverManager.getInstance().getDriver().findElement(Username).sendKeys(readProperties.getValue("username"));
        //Username.sendKeys("admin");
        Log.info("Entered username");
        //extentTest.log(Status.INFO,"");

    }
    public void enterpassword(){
        waits.waitForVisibility(Password,5);
        DriverManager.getInstance().getDriver().findElement(Password).sendKeys(readProperties.getValue("password"));
        //Password.sendKeys("password");
        Log.info("Entered username");
    }
    public void clicklogin() {
        waits.waitForclickable(loginbutton,5);
        DriverManager.getInstance().getDriver().findElement(loginbutton).click();
        Log.info("Clicked login button");
    }

}
