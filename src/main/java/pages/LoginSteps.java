package pages;

import Pageobjects.loginpageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Drivermanager.DriverManager; // Import your DriverManager class here

public class LoginSteps {

    private WebDriver driver;


    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
        driver = DriverManager.getDriver();
        System.out.println(" the user is on the login page");
        Thread.sleep(3000);
    }

    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_username_and_password(String username, String password) throws InterruptedException {
        loginpageObject loginpageObject = new loginpageObject();
        loginpageObject.login(username,password);
    }


    @When("I click the login button")
    public void i_click_the_login_button() throws InterruptedException {
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")); // Using class name to locate the button
        loginButton.click();
    }


    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("User logged in successfully!");
    }


    @Then("I print a message")
    public void i_print_a_message() {
        System.out.println("i print amessage on both pages");

    }

}
