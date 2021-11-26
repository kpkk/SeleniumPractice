package factorydesignpattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.stqa.selenium.factory.WebDriverPool;

public class FactoryDesignPattern {

    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void sampleTest() {
        WebDriver driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
// do something with the driver
        driver.get("http://seleniumhq.org/");
// destroy the instance (calls driver.quit() implicitly)
      //  WebDriverPool.DEFAULT.dismissDriver(driver);
    }

    @Test
    public void sampleTest1(){
     //   WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
// do something with the driver
        driver.get("http://seleniumhq.org/");

// obtain the same instance from the pool of the managed instances
        driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
// do something with the driver
        driver.get("http://selenium2.ru/");

// destroy the driver
       // WebDriverPool.DEFAULT.dismissDriver(driver);
    }

    @AfterSuite
    public void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}
