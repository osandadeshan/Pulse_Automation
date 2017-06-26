package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepImpl.DriverFactory;

import static stepImpl.DriverFactory.driver;

/**
 * Created by Osanda on 6/21/2017.
 */


public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//span[text()[contains(., 'Go to the Project')]]")
    WebElement GO_TO_PROJECT_BUTTON;

    public static String ProjectsPageUrl = URL.concat("?path_info=projects");
    WebDriver driver = DriverFactory.driver;

    public void goToProjects() throws InterruptedException {
        waitSeconds(2);
        driver.get(ProjectsPageUrl);
    }

    public void goToProjectTasks(String projectName) throws InterruptedException {
        waitSeconds(2);
        PageFactory.initElements(driver, this);
        WebElement PROJECT_NAME = driver.findElement(By.xpath("//table/tbody/tr[td//text()[contains(., '" + projectName + "')]]"));
        PROJECT_NAME.click();
        waitForElementClickable(GO_TO_PROJECT_BUTTON);
        GO_TO_PROJECT_BUTTON.click();
        driver.get(driver.getCurrentUrl() + "%2Ftasks");
    }

}
