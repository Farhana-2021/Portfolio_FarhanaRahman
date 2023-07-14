package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Contact_Us_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        //driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
        navigateTo_URL("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Farhana");
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(7));
        sendKeys(By.xpath("//input[@name='first_name']"), "AutoFN" + generateRandomNumber(7));
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        //driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Rahman");
        //driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber(7));
        sendKeys(By.xpath("//input[@name='last_name']"), "AutoLN" + generateRandomNumber(7));
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(12) + "@mail.com");
        sendKeys(By.xpath("//input[@name='email']"), "AutoEmail" + generateRandomNumber(12) + "@mail.com");
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        //driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello world " + generateRandomString(20));
        sendKeys(By.xpath("//textarea[@name='message']"), "Hello world " + generateRandomString(20));
    }
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
       //System.out.println(firstName);
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        sendKeys(By.xpath("//input[@name='first_name']"), firstName);
    }
    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        //System.out.println(lastName);
        //driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
        sendKeys(By.xpath("//input[@name='last_name']"), lastName);
    }
    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
       //System.out.println(email);
        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        sendKeys(By.xpath("//input[@name='email']"), email);
    }
    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        //System.out.println(comment);
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
        sendKeys(By.xpath("//textarea[@name='message']"), comment);
    }
    @And("I click on submit button")
    public void i_click_on_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        //System.out.println("Test7");
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(),"Thank You for your Message!");
    }
}
