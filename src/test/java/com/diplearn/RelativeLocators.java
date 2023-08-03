package com.diplearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocators extends  BaseTest{

    @Test
    public void  aboveMethod() throws InterruptedException {
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        By torontoAvatar = RelativeLocator.with(By.tagName("li")).above(By.id("boston"));
        driver.findElement(torontoAvatar).click();
        Thread.sleep(10000);

        // usando xpath
        WebElement torontoAvatarold = driver.findElement(By.xpath("//li[@id='boston']/ancestor::ul/li[2]"));
        torontoAvatarold.click();
    }

    @Test
    public void belowMethod() throws InterruptedException {
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        By mountieAvatar = RelativeLocator.with(By.tagName("li")).below(By.id("boston"));
        driver.findElement(mountieAvatar).click();
        Thread.sleep(10000);

        // usando xpath
        WebElement torontoAvatarold = driver.findElement(By.xpath("//li[@id='boston']/ancestor::ul/li[@id='toronto']"));
        torontoAvatarold.click();

    }

    @Test
    public void RightofMethod() throws InterruptedException {
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        By BerlinAvatar = RelativeLocator.with(By.tagName("li")).toRightOf(By.id("boston"));
        driver.findElement(BerlinAvatar).click();
        driver.findElement(BerlinAvatar).click();
        Thread.sleep(10000);

    }

    @Test
    public void lefttofMethod() throws InterruptedException {
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        By LondonAvatar = RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("boston"));
        driver.findElement(LondonAvatar).click();
        Thread.sleep(10000);

    }
}
