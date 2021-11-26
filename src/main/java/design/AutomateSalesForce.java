package design;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import service.BrowserUtils;

public class AutomateSalesForce extends BrowserUtils {



    public static void main(String[] args) {
        BrowserUtils utils=new BrowserUtils();
        utils.launchBrowser("https://testleaf-3d-dev-ed.my.salesforce.com/");
        WebElement username = utils.findElement("xpath", "//input[@id='username']");
        utils.sendKeys(username,"earth@testleaf.com");
        WebElement password = utils.findElement("xpath", "//input[@id='password']");
        utils.sendKeys(password,"Bootcamp$123");
        WebElement login = utils.findElement("id", "Login");
        utils.click(login);
    }
}
