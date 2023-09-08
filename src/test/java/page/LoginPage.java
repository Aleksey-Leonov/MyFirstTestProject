package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameField = By.xpath("//input[@name='username']");
    private final By passwordFiled = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By calendarField = By.xpath("//a[.='Calendar']");


    public void loginAttempt(String login, String password) {
        setLogin(login, password)
        .clickSignInButton();
    }

    public LoginPage setLogin(String username, String password) {
        sendKeys(usernameField, username);
        sendKeys(passwordFiled, password);
        return this;
    }

    public void cleanUserNameAndPassword() {
        sendKeysBackspace(usernameField);
        sendKeysBackspace(passwordFiled);
    }

    private void clickSignInButton() {
        click(loginButton);
    }

}
