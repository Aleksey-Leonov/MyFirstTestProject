package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverManager {
    private final static ThreadLocal<DriverManager> instance = ThreadLocal.withInitial(DriverManager::new);
    private static ThreadLocal<RemoteWebDriver> driver = ThreadLocal.withInitial(DriverManager::init);

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return instance.get();
    }

    private static RemoteWebDriver init() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        var driverRemote = driver.get();
        if (driverRemote == null) {
            driverRemote = init();
            driver.set(driverRemote);
        }
        return driverRemote;
    }


    public static void closeDriver() {
        var driverRemote = driver.get();
        if (driverRemote != null) {
            driverRemote.close();
            driver.remove();
        }

    }
}
