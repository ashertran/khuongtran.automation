package stepDefinitions;

import common.AbstractTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.FactoryPage;
import pages.LoginPage;
import pages.StudentPage;

public class LoginSteps extends AbstractTest {
    WebDriver driver;
    private LoginPage loginPage;
   // private StudentPage studentPage;

    public LoginSteps(){

        driver = Hooks.openBrowser();
        loginPage = FactoryPage.getLoginPge(driver);
    }
    @Given("^Launch to the web app testing$")
    public void launch_to_the_web_app_testing() {
        System.out.println("Starting Web Testing");
    }

    @When("^I input to email textbox with variable data \"(.*?)\"$")
    public void i_input_to_email_textbox_with_variable_data(String str_email) throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.clearAndInputDataEmail(str_email);
    }

    @When("^I input to password textbox with variable data \"(.*?)\"$")
    public void i_input_to_password_textbox_with_variable_data(String str_password) throws Throwable {
        loginPage.clearAndInputDataPass(str_password);
    }

    @When("^I click to Login button$")
    public void i_click_to_Login_button() throws Throwable {
        loginPage.clickLogin();
    }


}
