package pages;

import Drivermanager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static io.cucumber.shaded.gherkin.messages.internal.gherkin.Parser.RuleType.DataTable;

public class registerUser {

    private WebDriver driver;

    @Given("I am on the Register page")
    public void i_am_on_the_register_page() throws InterruptedException {
        driver = DriverManager.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        WebElement registerLink = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        registerLink.click();
        Thread.sleep(4000);

    }
    @When("A new user will register for a new account")
    public void aNewUserWillRegisterForANewAccount(List <String> details) {

             ArrayList<String> detailsList = new ArrayList<>(details);

            // Assuming detailsList has the required elements in the correct order
            String firstName = detailsList.get(0);
            String lastName = detailsList.get(1);
            String email = detailsList.get(2);
            String password = detailsList.get(3);
            String confirmPassword = detailsList.get(4);

            // Assuming you are using Selenium to interact with the web page
            WebElement firstNameElement = driver.findElement(By.xpath("//*[@id='FirstName']"));
            firstNameElement.sendKeys(firstName);

            WebElement lastNameElement = driver.findElement(By.xpath("//*[@id='LastName']"));
            lastNameElement.sendKeys(lastName);

            WebElement emailElement = driver.findElement(By.xpath("//*[@id='Email']"));
            emailElement.sendKeys(email);

            WebElement passwordElement = driver.findElement(By.xpath("//*[@id='Password']"));
            passwordElement.sendKeys(password);

            WebElement confirmPasswordElement = driver.findElement(By.xpath("//*[@id='ConfirmPassword']"));
            confirmPasswordElement.sendKeys(confirmPassword);

            // Add any additional actions needed to submit the registration form
        }



}


