package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{
    private @FindBy(xpath ="text")
    WebElement username_TextField;
    private @FindBy(xpath ="text")
    WebElement uniqueUsername_TextField;
    private @FindBy(xpath = "password")
    WebElement password_TextField;
    private @FindBy(xpath = "password")
    WebElement uniquePassword_TextField;
    private @FindBy(xpath = "login-button")
    WebElement login_Button;
    public Login_PO(){//constructor for this page object
        super();//points to the parent constructor which is in Base_PO
    }
    public void navigateTo_WebDriverUniversity_Login_page(){
        navigateTo_URL("https://webdriveruniversity.com/Login-Portal/index.html");
    }
    public void setUsername(String username){
        sendKeys(username_TextField, username);
    }
    public void setUniqueUsername(String username){
        sendKeys(uniqueUsername_TextField, username);
    }
    public void setPassword(String password){
        sendKeys(password_TextField, password );
    }
    public void setUniquePassword(String password){
        sendKeys(uniquePassword_TextField, password );
    }
    public void clickOn_Login_Button(){
        waitForWebElementAndClick(login_Button);
    }
    public void validate_SuccessfulLogin_Message(){
        waitForAlert_And_ValidateText("validation succeeded");
    }
    public void validate_UnsuccessfulLogin_Message(){
        waitForAlert_And_ValidateText("validation failed");
    }

}
