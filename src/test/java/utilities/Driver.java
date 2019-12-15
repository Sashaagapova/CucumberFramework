package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // to initialize the driver
    // to keep driver static so we can run it in every test

    public static WebDriver driver;

        public static WebDriver driverSetup(String browser){

            if(driver!=null){
             return driver;
            }

            switch(browser.toLowerCase()){
                case "chrome":
                   WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "ff":
                    // GeckoDriver
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// time is unpredictable and can not be combined

// what is headless driver
            return driver;
        }

        public static void closeDriver(){
            WebDriver driver = null;
            if(driver!=null){
                driver.quit();
                driver= null;
            }
        }
    }









