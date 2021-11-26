package testcases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CityInfoPage;
import pages.HomePage;
import service.BrowserUtils;
import utilities.BaseUtils;

import java.io.IOException;
import java.rmi.Remote;
import java.util.HashMap;


public class GetWeatherInfo extends BrowserUtils {
    String pressureUI;
    Integer pressureAPI;

    Integer temperatureUI;
    Float temperatureAPI;

    Double delta=1.00;
    HashMap<String,String>map;
    BaseUtils utils=new BaseUtils();
    HomePage homepage=new HomePage(driver);
    CityInfoPage cityInfoPage=new CityInfoPage(driver);


    @BeforeMethod
    public void setUp() throws IOException {
        map=new HashMap<>();
        RestAssured.baseURI=utils.readFromProperty("apiURL");
        map.put("q","chennai");
        map.put("appid",utils.readFromProperty("key"));
    }

    @Test
    public void get_weather_info_UI() throws IOException {

        launchBrowser(utils.readFromProperty("uiURL"), utils.readFromProperty("browser"));
        homepage.typeCityName();
        cityInfoPage.clickMoreDetails();
        String temperature = cityInfoPage.getTemperature();
        temperatureUI= Integer.parseInt(temperature.replaceAll("\\D",""));
        pressureUI = cityInfoPage.getPressure();
        getWeatherInfo();
        utils.compareTemperature(temperatureUI,temperatureAPI);
        utils.variance(temperatureUI,temperatureAPI,delta);
    }

    public void getWeatherInfo(){
        Response response = RestAssured.given().log().all()
                .when()
                .params(map)
                .get("/data/2.5/weather")
                .then().log().all().statusCode(200).extract().response();

        JsonPath jsonPath = response.jsonPath();
        temperatureAPI = jsonPath.get("main.temp");
        pressureAPI =jsonPath.get("main.pressure");

    }

}
