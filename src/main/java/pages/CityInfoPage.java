package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import service.BrowserUtils;
import utilities.BaseUtils;

import java.io.IOException;

public class CityInfoPage extends BrowserUtils {
    BaseUtils utils=new BaseUtils();


    public CityInfoPage(WebDriver driver){
        PageFactory.initElements(this.driver, this);
    }

    public void clickMoreDetails() throws IOException {
        WebElement moredetails = findElement("xpath", utils.readFromProperty("moreDetails"));
        click(moredetails);
        refreshPage();
        WebElement moredetailsRetry = findElement("xpath", utils.readFromProperty("moreDetails"));
        click(moredetailsRetry);
    }
    public String getTemperature() throws IOException {
        WebElement temperatureElement = findElement("xpath", utils.readFromProperty("temperature"));
        return getText(temperatureElement);
    }
    public String getPressure() throws IOException {
        WebElement pressureElement = findElement("xpath", utils.readFromProperty("pressure"));
        return getText(pressureElement);
    }
}
