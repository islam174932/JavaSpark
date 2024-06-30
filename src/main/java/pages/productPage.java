package pages;

import Drivermanager.DriverManager;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class productPage {

    private WebDriver driver;

    @When("User clicks on the Computer Download")
    public void user_clicks_on_the_computer_download() throws InterruptedException {
        driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));

        // Navigate to the page or any necessary setup

        // Find the WebElement for "Computer" menu item
        WebElement computerMenu = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));

        // Create Actions instance
        Actions actions = new Actions(driver);

        // Perform mouse hover over "Computer" menu item
        actions.moveToElement(computerMenu).perform();

        // Wait for the "Notebooks" submenu item to be clickable
        WebElement notebookLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[2]/a")));

        // Click on the "Notebooks" link
        notebookLink.click();
        Thread.sleep(3000);
    }


}
