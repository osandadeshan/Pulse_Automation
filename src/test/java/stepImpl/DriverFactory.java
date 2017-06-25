package stepImpl;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by Osanda on 4/26/2017.
 */


public class DriverFactory {

    private static final String CHROME = "chrome";
    private static final String IE = "ie";
    private static final String DEFAULT = "firefox";
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void Setup() {
        // Uses firefox driver by default
        String browser = System.getenv("BROWSER");
        if (browser == null) {
            browser = DEFAULT;
        }

        if (browser.toLowerCase().equals(CHROME)) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.toLowerCase().equals(IE)) {
            InternetExplorerDriverManager.getInstance().setup();
            driver = new InternetExplorerDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

    @AfterSuite
    public void TearDown() {
        driver.close();
    }

}
