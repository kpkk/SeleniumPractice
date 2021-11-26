package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.WebDriverImplementation;

public class LoginPage extends WebDriverImplementation {


    LoginPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username")
    WebElement userName;
    @FindBy(id="password")
    WebElement password;
    @FindBy (id="Login")
    WebElement submit;

    public void login(){
        type(userName,"earth@testleaf.com");
        type(password,"");
        click(submit);
    }
}
