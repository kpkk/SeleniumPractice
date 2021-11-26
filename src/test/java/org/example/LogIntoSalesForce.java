package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogIntoSalesForce {

    @Test
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://testleaf-3d-dev-ed.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("earth@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Bootcamp$123");
        driver.findElement(By.id("Login")).click();

        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        driver.findElement(By.xpath("//span[text()='View All Key Deals']")).click();
        driver.findElement(By.xpath("//span[text()='Recently Viewed']")).click();
        driver.findElement(By.xpath("//span[text()='All Opportunities']")).click();
        driver.findElement(By.xpath("//div[text()='New']")).click();
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("marketing job");
        driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Ramkumar']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[4]")).click();
        driver.findElement(By.xpath("//span[text()='New Customer']")).click();
        driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[5]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();


    }
}
