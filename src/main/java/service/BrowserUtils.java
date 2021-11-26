package service;

import design.BrowserMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserUtils implements BrowserMethods {

    public static WebDriver driver;
    @Override
    public  void launchBrowser(String url) {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<String, Object>();

        // Set the notification setting it will override the default setting
        prefs.put("profile.default_content_setting_values.notifications", 2);

        // Create object of ChromeOption class
        ChromeOptions options = new ChromeOptions();

        // Set the experimental option
        options.setExperimentalOption("prefs", prefs);

        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Override
    public void launchBrowser(String url, String browser) {
       if(browser.equals("chrome")){
           WebDriverManager.chromedriver().setup();
           driver=new ChromeDriver();
       }else if(browser.equals("firefox")){
           WebDriverManager.firefoxdriver().setup();
           driver=new FirefoxDriver();
       }else if(browser.equals("safari")){
           WebDriverManager.safaridriver().setup();
           driver=new SafariDriver();
       }
       else if(browser.equals("edge")){
           WebDriverManager.edgedriver().setup();
           driver=new EdgeDriver();
       }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

    }

    @Override
    public void sendKeys(WebElement element, String keys) {
        try{
            element.sendKeys(keys);
        }catch (NoSuchElementException e){
            System.err.println("No such element exception occurred,unable to find the element"+e.getMessage());
        }
        catch (StaleElementReferenceException e){
            System.err.println("Stale element reference exception found, retry anothe time"+e.getMessage()+" "+e.getCause());
        }
    }

    @Override
    public void click(WebElement element) {
        element.click();

    }

    @Override
    public String getText(WebElement element) {
        return element.getText();
    }

    @Override
    public WebElement findElement(String locator, String locatorValue) {
        if (locator.equalsIgnoreCase("xpath")){
           return driver.findElement(By.xpath(locatorValue));
        }
        else if(locator.equalsIgnoreCase("id")){
            return driver.findElement(By.id(locatorValue));
        }
        else if(locator.equalsIgnoreCase("className")){
            return driver.findElement(By.className(locatorValue));
        }
        else if(locator.equalsIgnoreCase("linktext")){
            return driver.findElement(By.linkText(locatorValue));
        }
        else if(locator.equalsIgnoreCase("name")){
            return driver.findElement(By.name(locatorValue));
        }
        else if(locator.equalsIgnoreCase("tagName")){
            return driver.findElement(By.tagName(locatorValue));
        }
        return null;
    }

    @Override
    public List<WebElement> findElements(String locator, String locatorValue) {
        if (locator.equalsIgnoreCase("xpath")){
            return driver.findElements(By.xpath(locatorValue));
        }
        else if(locator.equalsIgnoreCase("id")){
            return driver.findElements(By.id(locatorValue));
        }
        else if(locator.equalsIgnoreCase("className")){
            return driver.findElements(By.className(locatorValue));
        }
        else if(locator.equalsIgnoreCase("linktext")){
            return driver.findElements(By.linkText(locatorValue));
        }
        else if(locator.equalsIgnoreCase("name")){
            return driver.findElements(By.name(locatorValue));
        }
        else if(locator.equalsIgnoreCase("tagName")){
            return driver.findElements(By.tagName(locatorValue));
        }
        return null;
    }

    @Override
    public void clickActions(WebElement element) {
        Actions act=new Actions(driver);
        act.moveToElement(element).click().build().perform();
    }

    @Override
    public void refreshPage() {
        driver.navigate().refresh();
    }


}
