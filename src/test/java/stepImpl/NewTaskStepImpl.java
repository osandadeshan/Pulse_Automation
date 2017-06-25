package stepImpl;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.NewTaskPage;

/**
 * Created by Osanda on 6/21/2017.
 */


public class NewTaskStepImpl {

    WebDriver driver;
    NewTaskPage newTaskPage = PageFactory.initElements(driver, NewTaskPage.class);
    private static String taskName = System.getenv("TASK_NAME");

    @Step("Create a new Task")
    public void createNewTask() throws InterruptedException {
        newTaskPage.createNewTask(taskName);
    }

}
