package pages;

import Drivermanager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;

import static Drivermanager.DriverManager.driverThreadLocal;


public class Hook {


    private WebDriver driver;
    @Before
public void pagesetup () throws InterruptedException {
             System.out.println("we are starting the testing here");
             driver = DriverManager.getDriver();
             driver.get("https://demowebshop.tricentis.com/");
            driver.manage().window().maximize();
            Thread.sleep(4000);


}


      @After

    public void quitedriver (){
        driverThreadLocal.remove();
        driver.quit();

    }


    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        driver = driverThreadLocal.get();
        if (driver != null && scenario.isFailed()) {
            // Take a screenshot and attach it to the report
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
    }

}
