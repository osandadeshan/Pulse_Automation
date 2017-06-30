package stepImpl;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import static stepImpl.DriverFactory.driver;

/**
 * Created by Osanda on 6/24/2017.
 */


public class LoginStepImpl {

    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    private static String email = System.getenv("EMAIL");
    private static String password = System.getenv("PASSWORD");

    @Step("Navigate to login page")
    public void navigateToLogin(){
        loginPage.navigateToLogin();
    }

    @Step("Login using the email and password")
    public void login(){
        loginPage.login(email, password);
    }

}