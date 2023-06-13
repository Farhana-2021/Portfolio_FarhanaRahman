package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Login_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("I access the application Sign In page")
    public void i_access_the_application_sign_in_page() {
        navigateTo_URL("https://testapp1.andresfloresv.com/index.php?controller=authentication?back=https%3A%2F%2Ftestapp1.andresfloresv.com%2Findex.php%3Fcontroller%3Dauthentication%3Fback%3Dhttps%253A%252F%252Ftestapp1.andresfloresv.com%252Findex.php");
    }

    @When("I enter an email {}")
    public void i_enter_an_email(String email) {
        driver.findElement(By.xpath("//input[@id='field-email']")).sendKeys(email);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.xpath("//input[@id='field-password']")).sendKeys(password);
    }

    @And("I click on Sign In button")
    public void i_click_on_sign_in_button() {
        driver.findElement(By.xpath("//button[@id='submit-login']")).click();
    }

    @Then("I should be displayed with home page")
    public void i_should_be_displayed_with_home_page() {
        navigateTo_URL("https://testapp1.andresfloresv.com/index.php");
    }

    @Then("I should be presented with an unsuccessful login message")
    public void i_should_be_presented_with_an_unsuccessful_login_message() {
        String login_UnSuccessful_Message = driver.findElement(By.xpath("//li[@class='alert alert-danger']")).getText();
        Assert.assertEquals(login_UnSuccessful_Message, "Authentication failed.");
    }

    @Then("I should be displayed with home page or unsuccessful login message{}")
    public void i_should_be_displayed_with_home_page_or_unsuccessful_login_message(String expectedURLorMessage) {
    }

}