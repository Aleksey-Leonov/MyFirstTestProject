package tests;

import configuration.DriverManager;
import page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();


    @Test(groups = "loginTest")
    public void testNegativeAuthorization() {
        authorize("qwe123", properties.password());
        Assert.assertNotEquals(DriverManager.getInstance().getDriver().getCurrentUrl(), properties.homePage());

//        loginPage.cleanUserNameAndPassword();
    }

    @Test(groups = "loginTest", dependsOnMethods = "testNegativeAuthorization")
    public void testAuthorization() {
        authorize(properties.page(), properties.password());
        Assert.assertEquals(DriverManager.getInstance().getDriver().getCurrentUrl(), properties.homePage());
    }


}
