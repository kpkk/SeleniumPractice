package service;

import design.WebDriverService;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class WebDriverImplementation implements WebDriverService {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Override
    public void click(WebElement ele) {
        try{
            ele.click();
        }catch (NoSuchElementException e){
            System.out.println("element was not found"+e.getMessage());
        }catch (StaleElementReferenceException e){
            System.out.println("element was not attached to the DOM"+e.getMessage());
        }

    }

    @Override
    public void type(WebElement ele, String text) {
        try {
            ele.sendKeys(text);
        }catch (NoSuchElementException e){
            System.out.println("element was not found"+e.getMessage());
        }catch (StaleElementReferenceException e){
            System.out.println("element was not attached to the DOM"+e.getMessage());
        }

    }

    @Override
    public WebElement locateElement(String locatorType, String locatorValue) {

        try{
            switch (locatorType){
                case "id": return driver.findElement(By.id(locatorValue));
                case "xpath": return driver.findElement(By.xpath(locatorValue));
                case "className": return driver.findElement(By.className(locatorValue));
                case "linkText": return driver.findElement(By.linkText(locatorValue));
                case "tagName": return driver.findElement(By.tagName(locatorValue));
                case "cssSelector": return driver.findElement(By.cssSelector(locatorValue));
                case "name": driver.findElement(By.name(locatorValue));
            }
        }catch (NoSuchElementException e){
            System.out.println("element was not found"+e.getMessage());
        }catch (StaleElementReferenceException e){
            System.out.println("element was not attached to the DOM"+e.getMessage());
        }catch (WebDriverException e){
            System.out.println("unknown exception has occurred"+e.getMessage());
        }

        return null;
    }

    @Override
    public List<WebElement> locateElements(String locatorType, String locatorValue) {

        try{
            switch (locatorType){
                case "id": return driver.findElements(By.id(locatorValue));
                case "xpath": return driver.findElements(By.xpath(locatorValue));
                case "className": return driver.findElements(By.className(locatorValue));
                case "linkText": return driver.findElements(By.linkText(locatorValue));
                case "tagName": return driver.findElements(By.tagName(locatorValue));
                case "cssSelector": return driver.findElements(By.cssSelector(locatorValue));
                case "name": driver.findElements(By.name(locatorValue));
            }
        }catch (NoSuchElementException e){
            System.out.println("element was not found"+e.getMessage());
        }catch (StaleElementReferenceException e){
            System.out.println("element was not attached to the DOM"+e.getMessage());
        }catch (WebDriverException e){
            System.out.println("unknown exception has occurred"+e.getMessage());
        }
        return null;
    }

    @Override
    public void explicitWait(WebElement ele, WebDriver driver, int seconds) {
        try {
            wait.until(ExpectedConditions.visibilityOf(ele));
        }catch (NoSuchElementException e){
            System.out.println("element was not found"+e.getMessage());
        }catch (StaleElementReferenceException e){
            System.out.println("element was not attached to the DOM"+e.getMessage());
        }catch (WebDriverException e){
            System.out.println("unknown exception has occurred"+e.getMessage());
        }


    }
}
