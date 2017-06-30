package stepImpl;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.TimeAndExpensesPage;
import java.util.List;
import static stepImpl.DriverFactory.driver;

/**
 * Created by Osanda on 6/21/2017.
 */


public class TimeAndExpensesStepImpl {

    TimeAndExpensesPage timeAndExpensesPage = PageFactory.initElements(driver, TimeAndExpensesPage.class);
    private static String taskName = System.getenv("TASK_NAME");

    @Step("Navigate to add time records for the task")
    public void goToUpdateTimeRecords() throws InterruptedException {
        timeAndExpensesPage.navigateToUpdateTimeRecords(taskName);
    }

    @Step("Update time records for the date with worked hours and the summary from the following table <table>")
    public void createTimeRecord(Table table) throws InterruptedException {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            timeAndExpensesPage.createNewTimeRecord(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)));
        }
    }

}
