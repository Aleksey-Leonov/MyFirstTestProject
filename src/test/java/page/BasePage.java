package page;

import configuration.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {


    public void click(By xpath) {
        getElement(xpath).click();
    }

    public void sendKeys(By xpath, String text) {
        getElement(xpath).sendKeys(text);
    }

    public void sendKeysBackspace(By xpath) {
        getElement(xpath).sendKeys(Keys.BACK_SPACE);
    }

    public WebElement getElement(By xpath) {
        explicitlyWaitingForElement(xpath, 10);
        return DriverManager.getInstance().getDriver().findElement(xpath);
    }

    public List<WebElement> getElements(By xpath) {
        explicitlyWaitingForElement(xpath, 10);
        return DriverManager.getInstance().getDriver().findElements(xpath);
    }

    public void explicitlyWaitingForElement(By xpath, int timeWait) {
        new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(timeWait))
                .until(ExpectedConditions.presenceOfElementLocated(xpath));
    }


}
