package Drivermanager;


import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @After
    public void tearDown() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver getDriver() {

        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            Properties properties = new Properties();
            try {
                FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            String browser = properties.getProperty("browser");
            String websiteUrl = properties.getProperty("websiteUrl");

            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Chrome\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\Firefox\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\Users\\User\\Desktop\\Edge\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.manage().window().maximize();
            driver.get(websiteUrl);
            driverThreadLocal.set(driver);
        }
        return driver;
    }
}