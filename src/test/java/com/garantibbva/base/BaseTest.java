package com.garantibbva.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    static WebDriver driver = null;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "properties/driver/chromedriver.exe"); //kullanılacak driverin yolu seçilir
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("start-maximized");
        setDriver(new ChromeDriver(options));
        getDriver().navigate().to("https://www.trendyol.com");
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BaseTest.driver = driver;
    }

    @After
    public void tearDown() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        getDriver().quit();
    }
}
