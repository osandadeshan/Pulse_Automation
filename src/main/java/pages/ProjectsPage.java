package pages;

import org.openqa.selenium.WebDriver;
import stepImpl.DriverFactory;

/**
 * Created by Osanda on 6/21/2017.
 */


public class ProjectsPage extends BasePage {

    public static String ProjectsPageUrl = URL.concat("?path_info=projects");
    WebDriver driver = DriverFactory.driver;

    public void goToProjects() throws InterruptedException {
        waitSeconds(2);
        driver.get(ProjectsPageUrl);
    }

    public void goToProjectTasks(String projectName) throws InterruptedException {
        waitSeconds(2);
        driver.get(ProjectsPageUrl + "%2F" + projectName + "%2Ftasks");
    }

}
