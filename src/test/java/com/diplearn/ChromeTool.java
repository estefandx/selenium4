package com.diplearn;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.emulation.Emulation;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.performance.Performance;
import org.openqa.selenium.devtools.v114.performance.model.Metric;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

public class ChromeTool  extends  BaseTest{

    @Test
    public void simulateLocation () throws InterruptedException {

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
                Optional.of(13.4501),
                Optional.of(1)));
        driver.get("https://my-location.org/");
        Thread.sleep(15000);
    }

    @Test
    public void diviceMode() throws InterruptedException {
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
// Dimensiones de un Iphone 11
        devTools.send(Emulation.setDeviceMetricsOverride(375,
                812,
                50,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        driver.get("https://getbootstrap.com/docs/3.4/css/");
        Thread.sleep(20000);
    }

    @Test
    public void metric(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = devTools.send(Performance.getMetrics());

        driver.get("https://google.com");
        driver.quit();

        for(Metric m : metricList) {
            System.out.println(m.getName() + " = " + m.getValue());
        }
    }

    @Test
    public void blockUrl(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // Enable the Network domain
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.css","*.jpg")));


        // Navigate to the webpage where you want to block CSS styles
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
    }
}
