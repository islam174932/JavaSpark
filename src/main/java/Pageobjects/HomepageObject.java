package Pageobjects;

import Drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepageObject {

    private WebDriver driver;
    By DigitalDownload = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[5]/a");

    public void checkDownload () throws InterruptedException {
        Thread.sleep(4000);
         driver = DriverManager.getDriver();
        WebElement digitalButton = driver.findElement(DigitalDownload);
        digitalButton.click();
        Thread.sleep(2000);

    }

}
