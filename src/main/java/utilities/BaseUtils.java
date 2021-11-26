package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseUtils {

    public boolean compareTemperature(Integer temperatureUI, Float temperatureAPI){
        if(temperatureAPI.toString().equals(temperatureUI.toString())) return true;
        else return false;
    }

    public String variance(Integer temperatureUI, Float temperatureAPI, Double delta){
        if(Math.abs(temperatureAPI)-Math.abs(temperatureUI+273)<delta) return "Success";
        else{
            throw new RuntimeException("the temperatures are not equal, variance is beyond the range");
        }
    }
    public String readFromProperty(String key) throws IOException {
        Properties prop=new Properties();
        prop.load(new FileReader("./src/main/resources/application.properties"));
        return prop.getProperty(key);

    }

}
