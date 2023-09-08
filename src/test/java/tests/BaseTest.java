package tests;

import configuration.DriverManager;
import configuration.MyConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static configuration.DriverManager.closeDriver;

public class BaseTest {
    static final MyConfig properties = ConfigFactory.create(MyConfig.class);

    //временная мера для адреса
    private String url = "https://auth.sberclass.ru/auth/realms/EduPowerKeycloak/protocol/openid-connect/auth?client_id=school21&redirect_uri=https%3A%2F%2Fedu.21-school.ru%2F&state=9074721c-9e10-40ef-bac6-d0182986d63c&response_mode=fragment&response_type=code&scope=openid&nonce=f1663452-5092-4632-8244-627223a06276";


    public void open(String url) {
        DriverManager.getInstance().getDriver().get(url);
    }

    public void authorize(String login, String password) {
        open(url);
        new LoginPage().loginAttempt(login, password);
    }

    @AfterTest
    public void tearDown() {
        closeDriver();
    }

}
