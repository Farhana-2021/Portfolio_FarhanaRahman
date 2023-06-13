package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Base_PO {
    //constructor
    public Base_PO(){

    }
    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }
    public void navigateTo_URL(String url){
        getDriver().get(url);
    }

}
