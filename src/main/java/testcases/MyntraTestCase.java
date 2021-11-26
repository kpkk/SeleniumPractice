package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyntraTestCase {

    String sareeName="";
    String sareeNameOnAddToBagPage="";
    double originalPrice;
    double discountedPrice;

    @Test
    public void buyAsaree(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://myntra.com");
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//a[text()='Women']"))).pause(1000).click(driver.findElement(By.xpath("//a[text()='Sarees']")));
        driver.findElement(By.xpath("(//ul[@class='brand-list']//li)[2]//input")).click();
        driver.findElement(By.xpath("//div[text()='Mitera']")).isDisplayed();
        act.moveToElement(driver.findElement(By.xpath("//div[@class='sort-sortBy']"))).click(driver.findElement(By.xpath("//ul[@class='sort-list']//li[4]//label//input")));
        driver.findElement(By.xpath("//div[@class='vertical-filters-filters'][2]//ul//li[1]//label//div")).click();
        sareeName=driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]/h4")).getText();
        driver.findElement(By.xpath("(//li[@class='product-base']//a)[1]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> windowHandlesList=new ArrayList<>();
        windowHandlesList.addAll(windowHandles);
        driver.switchTo().window(windowHandlesList.get(1));
        sareeNameOnAddToBagPage=driver.findElement(By.xpath("//div[@class='pdp-price-info']//h1[2]")).getText();
        Assert.assertEquals(sareeName,sareeNameOnAddToBagPage);

        String originalPriceText= driver.findElement(By.xpath("//span[@class='pdp-mrp']//s")).getText();
        originalPriceText = originalPriceText.replaceAll("\\W", "");
        originalPrice=Double.parseDouble(originalPriceText);

        String discountedPriceText=driver.findElement(By.xpath("//span[@class='pdp-price']//strong")).getText();
        discountedPriceText=discountedPriceText.replaceAll("\\W","");
        discountedPrice=Double.parseDouble(discountedPriceText);

       driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")).click();
       driver.findElement(By.xpath("//p[text()='Added to bag']")).isDisplayed();




    }
}
