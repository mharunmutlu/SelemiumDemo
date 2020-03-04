package com.garantibbva.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class n11Test {
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
        driver.navigate().to("https://www.n11.com/");
    }

    @Test
    public void n11SearchTest() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("btnSignUp"))); //
        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("btnSignUp"))); //
        clickElement(By.className("btnSignUp"));
        //Ad Soyad doldurma
        sendKeys(By.id("firstName"), "Mehmet Harun");
        sendKeys(By.id("lastName"), "Mutlu");
        //E-mail doldurma
        sendKeys(By.id("registrationEmail"), "harun.mutlu@testinium.com");
        //Şifre ve tekrar şifre doldurma
        sendKeys(By.id("registrationPassword"), "deneme");
        sendKeys(By.id("passwordAgain"), "deneme");
        //Telefon numarası doldurma
        clickElement(By.id("phoneNumber"));
        sendKeys(By.id("phoneNumber"), "386619221");
        //Cinsiyet seçme
        clickElement(By.className("genderArea"));
        //Doğum tarihi seçme
        selectOption(By.id("birthYear"), "1995");
        selectOption(By.id("birthMonth"), "Kasım");
        selectOption(By.id("birthDay"), "10");
        //Checkboxları seçme
        clickElement(By.className("buyerAgreement"));
        clickElement(By.className("smsAndCampaign"));
    }
    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    public void sendKeys(By by, String text){
        WebElement we = findElement(by);
        we.sendKeys(text);
    }
    public void clickElement(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void selectOption(By by, String text){
        Select select = new Select(findElement(by));
        select.selectByVisibleText(text);
    }

    @After
    public void after() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
    }
}