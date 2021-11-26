package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import service.BrowserUtils;
import utilities.BaseUtils;

import java.io.IOException;

public class HomePage extends BrowserUtils{
    BaseUtils utils=new BaseUtils();

    public HomePage(WebDriver driver){
        PageFactory.initElements(this.driver, this);
    }

        public void typeCityName() throws IOException {
            WebElement findElement = findElement("xpath", utils.readFromProperty("enterCity"));
            findElement.sendKeys("Chennai, Tamil Nadu, IN", Keys.ENTER);
        }


}
