package factorydesignpattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import ru.stqa.selenium.factory.WebDriverPool;

public class FactoryDesignpatternWithNewInstanceExmple {

    @Test
    public void testSomething() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
        // do something with the driver
        driver.get("http://seleniumhq.org/");
    }

    @Test
    public void testSomethingElse() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
        // do something with the driver
        driver.get("http://seleniumhq.org/");
    }

    @AfterSuite
    public void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}
