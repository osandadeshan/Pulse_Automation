package stepImpl;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ProjectsPage;
import static stepImpl.DriverFactory.driver;

/**
 * Created by Osanda on 6/21/2017.
 */


public class ProjectsStepImpl {

    ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);
    private static String projectName = System.getenv("PROJECT_NAME");

    @Step("Expand projects section")
    public void goToProjects() throws InterruptedException {
        projectsPage.goToProjects();
    }

    @Step("Go to Project Tasks")
    public void goToProjectTasks() throws InterruptedException {
        projectsPage.goToProjectTasks(projectName);
    }

}
