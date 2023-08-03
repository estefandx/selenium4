package com.diplearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class NewWindowTab extends BaseTest {

    @Test
    public void newWindowOld() {

        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/windows/");
        //almacenar el identificador de la  ventana original
        String originalWindow = driver.getWindowHandle();

        // verificar que no tenemos mas ventanar abiertas
        assert driver.getWindowHandles().size() == 1;

        // hacer click en el enlace para abrir las nueva ventana
        driver.findElement(By.linkText("new window")).click();

       //esperar que abran la nueva ventana
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(numberOfWindowsToBe(2));

        //hacer un ciclo  que recorra las ventanas hasta encontras la nueva ventana
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //validar el titulo de la ventana para validar que estamos en la ventana correcta
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(titleIs("Selenium"));
    }

    @Test
    public  void newWindow() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/windows/");
        driver.switchTo().newWindow(WindowType.TAB);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(numberOfWindowsToBe(2));
        driver.get("https://www.selenium.dev/");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(titleIs("Selenium"));
    }
}
