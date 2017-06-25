package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepImpl.DriverFactory;

/**
 * Created by Osanda on 4/26/2017.
 */


public class LoginPage extends BasePage {

    public static String LoginPageUrl = URL.concat("index.php");

    @FindBy(xpath = "//input[@placeholder='Email Address']")
    WebElement EMAIL_ADDRESS;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement PASSWORD;
    @FindBy(xpath = "//button[contains(text(), 'Sign In')]")
    WebElement SIGN_IN_BUTTON;

    public void navigateToLogin(){
        DriverFactory.driver.get(LoginPageUrl);
    }

    public void login(String email, String password){
        EMAIL_ADDRESS.sendKeys(email);
        PASSWORD.sendKeys(password);
        SIGN_IN_BUTTON.click();
    }

}
