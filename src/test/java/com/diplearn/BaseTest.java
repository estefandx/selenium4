package com.diplearn;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("114");
        Map<String, Object> cloudOptions = new HashMap<>();
        cloudOptions.put("name", "Example test");
        browserOptions.setCapability("cloud:options", cloudOptions);
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}
