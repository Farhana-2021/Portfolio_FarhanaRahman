package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObjects.Base_PO;
//import org.apache.commons.lang3.RandomStringUtils;


public class Registration_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("I access the application registration page")
    public void i_access_the_application_registration_page() {
        //driver.get("https://testapp1.andresfloresv.com/index.php?controller=registration");
        navigateTo_URL("https://testapp1.andresfloresv.com/index.php?controller=registration");
    }
    @When("I click on Mrs check box for social title")
    public void i_click_on_Mrs_check_box_for_social_title() {
        driver.findElement(By.xpath("//input[@id='field-id_gender-2']")).click();
    }
    @When("I click on Mr check box for social title")
    public void i_click_on_Mr_check_box_for_social_title() {
        driver.findElement(By.xpath("//input[@id='field-id_gender-1']")).click();
    }
    @And("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@id='field-firstname']")).sendKeys(firstName);
    }
    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@id='field-lastname']")).sendKeys(lastName);
    }
    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        driver.findElement(By.xpath("//input[@id='field-email']")).sendKeys(email);
    }
    @And("I enter a specific password {}")
    public void i_enter_a_specific_password(String password) {
        driver.findElement(By.xpath("//input[@id='field-password']")).sendKeys(password);
    }
    @And("i enter a specific birthdate {}")
    public void i_enter_a_specific_birthdate(String birthdate) {
        driver.findElement(By.xpath("//input[@id='field-birthday']")).sendKeys(birthdate);
    }
    @And("I click on all the checkboxes")
    public void i_click_on_all_the_checkboxes() {
        driver.findElement(By.xpath("//input[@name='optin']")).click();
        driver.findElement(By.xpath("//input[@name='psgdpr']")).click();
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@name='customer_privacy']")).click();
    }
    @When("I click on the checkbox for Offers")
    public void i_click_on_the_checkbox_for_offers() {
        driver.findElement(By.xpath("//input[@name='optin']")).click();
    }
    @When("I click on the checkbox for Newsletter")
    public void i_click_on_the_checkbox_for_newsletter() {
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
    }
    @When("I click on the checkbox for Data Privacy")
    public void i_click_on_the_checkbox_for_data_privacy() {
        driver.findElement(By.xpath("//input[@name='customer_privacy']")).click();
    }
    @And("I  click on the save button")
    public void i_click_on_the_save_button() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary form-control-submit float-xs-right']")).click();
    }
    @Then("I should be presented with the customer account name on home page")
    public void i_should_be_presented_with_the_customer_account_name_on_home_page() {
        WebElement registration_Info_Saved = driver.findElement(By.xpath("//a[@class='account]"));
        Assert.assertEquals(registration_Info_Saved.getText(),"Farhana Rahman");
    }
    @Then("I should be presented with an error message in the unfilled mandatory field")
    public void i_should_be_presented_with_an_error_message_in_the_unfilled_mandatory_field() {
        //String unfilled_Field_Message = driver.switchTo().alert().getText();
        WebElement unfilled_Field_Message = driver.findElement(By.xpath("//input[@for='field-password]"));
        Assert.assertEquals(unfilled_Field_Message, "Please fill out this field.");
    }
    @Then("I should be presented with an error message in the Terms and Conditions checkbox")
    public void i_should_be_presented_with_an_error_message_in_the_terms_and_conditions_checkbox() {
        WebElement unchecked_Checkbox_Message = driver.findElement(By.xpath("//input[@name='psgdpr']"));
        Assert.assertEquals(unchecked_Checkbox_Message, "Please check this box if you want to proceed");
    }
}
