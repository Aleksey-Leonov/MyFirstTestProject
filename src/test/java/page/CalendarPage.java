package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarPage extends BasePage {
    private final By schedule = By.xpath("//*[.='Schedule']");
    private final By events = By.xpath("//*[.='Events']");
    private final By myEvents = By.xpath("//*[.='My events']");


    public void clickSchedule() {
        click(schedule);
    }

    public void clickEvents() {
        click(events);
    }

    public void clickMyEvents() {
        click(myEvents);
    }

    public List<WebElement> listOfDaysOfTheWeek(){
        return getElements(By.xpath("//div[@class='jss5149']//span[@class='jss5154']"));
    }



}
