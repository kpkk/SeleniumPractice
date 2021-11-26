package design;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public interface BrowserMethods {


     void launchBrowser(String url);

     void launchBrowser(String url, String browser);

     void sendKeys(WebElement element,String keys);

     void click(WebElement element);

     String getText(WebElement element);

     WebElement findElement(String locator, String locatorValue);
     List<WebElement> findElements(String locator, String locatorValue);

     public void clickActions(WebElement element);

     public void refreshPage();





}
