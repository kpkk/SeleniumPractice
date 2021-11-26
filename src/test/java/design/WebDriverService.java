package design;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface WebDriverService {

    void click(WebElement ele);
    void type(WebElement ele, String text);
    WebElement locateElement(String locatorType, String locatorValue);
    List<WebElement> locateElements(String locatorType, String locatorValue);
    void explicitWait(WebElement ele,WebDriver driver, int seconds);

}
