package pages;

import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static stepImpl.DriverFactory.driver;

/**
 * Created by Osanda on 4/26/2017.
 */


public class NewTaskPage extends BasePage {

    @FindBy(xpath = "//a[@title='New Task']")
    WebElement NEW_TASK;
    @FindBy(xpath = "//input[@id='taskSummary']")
    WebElement TITLE;
    @FindBy(xpath = "//select[@name='task[category_id]']")
    WebElement CATEGORY_DROPDOWN;
    @FindBy(xpath = "//select[@class='select_visibility']")
    WebElement VISIBILITY_DROPDOWN;
    @FindBy(xpath = "//Select[@id='taskLabel']")
    WebElement LABEL_DROPDOWN;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement ADD_TASK_BUTTON;

    public void createNewTask(String title) {
        PageFactory.initElements(driver, this);
        NEW_TASK.click();
        waitForElementClickable(TITLE);
        TITLE.sendKeys(title);
        Select categoryDropDown = new Select(CATEGORY_DROPDOWN);
        categoryDropDown.selectByVisibleText("General");
        Select visibilityDropDown = new Select(VISIBILITY_DROPDOWN);
        visibilityDropDown.selectByVisibleText("Normal");
        Select labelDropDown = new Select(LABEL_DROPDOWN);
        labelDropDown.selectByVisibleText("BILLABLE");
        ADD_TASK_BUTTON.click();
        System.out.println("\"" + title + "\"" + " Task has been added successfully");
        Gauge.writeMessage("\"" + title + "\"" + " Task has been added successfully");
        try {
            waitSeconds(2);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

}
