package pages;

import common.AbstractPage;
import interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    WebDriver driver;
    private LoginPageUI loginPageUI;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void clearAndInputDataEmail(String email) {
        waitForControlVisible(driver, LoginPageUI.UserID);
        clearAndSendKeyToElemenTextbox(driver, LoginPageUI.UserID, email);
    }

    public void clearAndInputDataPass(String password) {
        waitForControlVisible(driver, LoginPageUI.Password);
        clearAndSendKeyToElemenTextbox(driver, LoginPageUI.Password, password);
    }

    public void clickLogin() {
        clickToElement(driver, LoginPageUI.btnLogin);
    }
}
