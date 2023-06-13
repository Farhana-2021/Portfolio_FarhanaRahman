package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    //create static variable "ThreadLocal" and object "webDriver". ThreadLocal is used to execute cucumber tests in parallel
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (webDriver.get() == null){
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    //create static method
    private static WebDriver createDriver() {
        WebDriver driver = null;

        //String browserType = "chrome";//create variable; change to "firefox" if firefox browser used
        // then case "chrome" will be false and case "firefox" will be true
        switch (getBrowserType()) {//change the variable from browserType to getBrowserType)
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //firefoxOptions.addArguments("--remote-allow-origins=*");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType(){
        String browserType = null;

        try{//tell java we intend to use properties file, to locate and read inputs of the config file we use FileInputStream
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(file);
            browserType =  properties.getProperty("browser").toLowerCase().trim();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return browserType;
    }
    //create a method to get, close and remove the browser instance from ThreadLocal variable
    public static void cleanupDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }
}

