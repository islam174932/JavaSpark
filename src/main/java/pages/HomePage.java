package pages;

import Drivermanager.DriverManager;
import Pageobjects.HomepageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        driver = DriverManager.getDriver();
        System.out.println("User is now on the home Page");
    }

    @When("User clicks on the Digtial Download")
    public void user_clicks_on_the_admin() throws InterruptedException {
        HomepageObject homepageObject = new HomepageObject();
        homepageObject.checkDownload();
    }

    @When("User click on option")
    public void user_writes_as_the_name_of_the_profile() {
        WebElement dropdownElement = driver.findElement(By.id("products-orderby"));

        // Create a Select object from the WebElement
        Select dropdown = new Select(dropdownElement);

        // Select option by visible text
        dropdown.selectByVisibleText("Price: High to Low");

    }


}
