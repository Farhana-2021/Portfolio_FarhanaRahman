package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Login_Steps extends Base_PO {
    //private WebDriver driver =getDriver();
    private Login_PO login_po;//dependency logic class injected into step definition, login_po is the variable
    public Login_Steps(Login_PO login_po){//constructor for login steps class
        this.login_po = login_po;
    }//constructor for login_Steps class with dependency injection logic parameters

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        //driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
        //navigateTo_URL("https://webdriveruniversity.com/Login-Portal/index.html");
        login_po.navigateTo_WebDriverUniversity_Login_page();
    }
    @When("I enter a specific username {string}")
    public void i_enter_a_specific_username(String username) {
        //driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
        //sendKeys(By.xpath("//input[@id='text']"),username );
        login_po.setUsername(username);
    }

    @And("I enter a specific password {}")
    public void i_enter_a_specific_password(String password) {
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        //sendKeys(By.xpath("//input[@id='password']"),password);
        login_po.setPassword(password);
    }
    @And("I click on Login button")
    public void i_click_on_login_button() {
        //driver.findElement(By.xpath("//button[@id='login-button']")).click();
        login_po.clickOn_Login_Button();
    }
    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {
        //String login_Successful_Message = driver.switchTo().alert().getText();
        //Assert.assertEquals(login_Successful_Message,"validation succeeded");
        login_po.validate_SuccessfulLogin_Message();
    }
    @When("I enter a unique username")
    public void i_enter_a_unique_username() {
        //driver.findElement(By.xpath("//input[@id='text']")).sendKeys("AutoUN" + generateRandomString(20));
        //sendKeys(By.xpath("//input[@id='text']"),"AutoUN" + generateRandomString(20) );
        login_po.setUniqueUsername("AutoPW" + generateRandomNumber(7));
    }
    @And("I enter a unique password")
    public void i_enter_a_unique_password() {
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys("AutoPW" + generateRandomNumber(7));
        //sendKeys(By.xpath("//input[@id='password']"),"AutoPW" + generateRandomNumber(7));
        login_po.setUniquePassword("AutoPW" + generateRandomNumber(7));
    }
    @Then("I should be presented with an unsuccessful login message")
    public void i_should_be_presented_with_an_unsuccessful_login_message() {
        //String login_UnSuccessful_Message = driver.switchTo().alert().getText();
        //Assert.assertEquals(login_UnSuccessful_Message,"validation failed");
        login_po.validate_UnsuccessfulLogin_Message();
    }
    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
       //driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
        //sendKeys(By.xpath("//input[@id='text']"),username);
        login_po.setUsername(username);
    }
    @When("I enter a password {}")
    public void i_enter_a_password(String password) {
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        //sendKeys(By.xpath("//input[@id='password']"), password);
        login_po.setPassword(password);
    }
    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        //String login_message = driver.switchTo().alert().getText();
        //Assert.assertEquals(login_message, expectedMessage);
        waitForAlert_And_ValidateText(expectedMessage);
    }
}
