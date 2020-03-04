package com.garantibbva.test;

import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class hepsiburadaTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "properties/driver/chromedriver.exe"); //kullanılacak driverin yolu seçilir
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 60); //
        driver.navigate().to("https://www.hepsiburada.com/");
    }

    @Test
    public void n11SearchTest() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("links-global"))); //
        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("links-global"))); //

        //Assert.assertFalse("Belirtilen elemnt görüntülendi",
                //findElement(By.id("myAccount")).isDisplayed());
        try {
            findElement(By.id("myA1ccount")).isDisplayed();
        }catch (Exception e){
            Assert.fail("Element Görüntülenmedi!");
        }


        hoverElement(By.className("links-global"));
        clickElement(By.id("login"));
        sendKeys(By.id("email"), "mharunmutlu@gmail.com");


        sendKeys(By.id("password"), "Mharun_05386619221");
        clickElement(By.className("form-actions"));

        sendKeys(By.id("productSearch"), "Bilgisayar");
        clickElement(By.id("buttonProductSearch"));

        System.out.println("****Element Text: " + getText(By.className("user-name")));
        String isim = getText(By.className("user-name"));
        Assert.assertEquals("Mehmet Harun Mutlu", isim);

    }
    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); //
        return driver.findElement(by);
    }
    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }
    public void clickElement(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void selectOption(By by, String text){
        Select select = new Select(findElement(by));
        select.selectByVisibleText(text);
    }
    public void hoverElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public String getText(By by){
        return findElement(by).getText();
    }

    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(15);
        driver.quit();
    }
}
