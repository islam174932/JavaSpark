package Pageobjects;

import Drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpageObject {

    private WebDriver driver;
    By loginbutton = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By usernameField = By.xpath("//*[@id=\"Emails\"]");
    By passwordField = By.xpath("//*[@id=\"Password\"]");


    public void login (String username, String password) throws InterruptedException {
        driver = DriverManager.getDriver();
        Thread.sleep(2000);
        driver.findElement(loginbutton).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

    }

}
