package pages;

import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepImpl.DriverFactory;

import static stepImpl.DriverFactory.driver;

/**
 * Created by Osanda on 4/26/2017.
 */


public class TimeAndExpensesPage extends BasePage {

    private WebDriver driver = DriverFactory.driver;

    public TimeAndExpensesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Time and Expenses']")
    WebElement NEW_TIME_UPDATE;
    @FindBy(xpath = "//input[@name='item[record_date]']")
    WebElement DATE;
    @FindBy(xpath = "//input[@name='item[value]']")
    WebElement VALUE;
    @FindBy(xpath = "//input[@name='item[summary]']")
    WebElement SUMMARY;
    @FindBy(xpath = "//select[@name='item[billable_status]']")
    WebElement STATUS_DROPDOWN;
    @FindBy(xpath = "//select[@name='item[billable_status]']/following::button")
    WebElement ADD_BUTTON;

    public void navigateToUpdateTimeRecords(String taskName){
        WebElement TASK_NAME = driver.findElement(By.xpath("//table/tbody/tr[td//text() = '" + taskName + "']"));
        TASK_NAME.click();
        TASK_NAME.click();
        waitForElementClickable(NEW_TIME_UPDATE);
        NEW_TIME_UPDATE.click();
    }

    public void createNewTimeRecord(String date, String hours, String summary) throws InterruptedException {
        waitForElementClickable(DATE);
        DATE.click();
        DATE.clear();
        DATE.sendKeys(date);
        VALUE.sendKeys(hours);
        SUMMARY.sendKeys(summary);
        Select statusDropDown = new Select(STATUS_DROPDOWN);
        statusDropDown.selectByVisibleText("Billable");
        ADD_BUTTON.click();
        System.out.println("Time record has been added for the date of " + "\"" + date + "\"" + " as " + "\"" + hours + "\"" + ", with the description of " + "\"" + summary + "\"");
        Gauge.writeMessage("Time record has been added for the date of " + "\"" + date + "\"" + " as " + "\"" + hours + "\"" + ", with the description of " + "\"" + summary + "\"");
        waitSeconds(2);
    }

}


