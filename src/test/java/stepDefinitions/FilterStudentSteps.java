package stepDefinitions;

import common.AbstractTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.FactoryPage;
import pages.StudentPage;

public class FilterStudentSteps extends AbstractTest {
    WebDriver driver;
    public static StudentPage studentPage;
    public FilterStudentSteps(){
       driver = Hooks.openBrowser();
       studentPage = FactoryPage.newStudentPage(driver);
    }
    //Filter
    @Given("^I'm still in Student page with User Name is \"(.*?)\"$")
    public void i_m_still_in_Student_page_with_User_Name_is(String str_username) throws Throwable {
        verifyEquals(str_username, studentPage.getUserName());
    }
    @When("^I click to Filter button$")
    public void i_click_to_Filter_button() throws Throwable {
        studentPage.clickFilter();
    }

    @When("^I select Request Status is \"(.*?)\"$")
    public void i_select_Request_Status_is(String status) throws Throwable {
        studentPage.selectStudentStatus(status);
    }
    @When("^I click to Apply button$")
    public void iClickToApplyButton() throws Throwable {
        studentPage.clickApplyFilter();
    }
    @Then("^I see the result list filters all Status is \"(.*?)\"$")
    public void i_see_the_result_list_filters_all_Status_is(String status) throws Throwable {
        boolean condition = studentPage.checkStatus(status);
        verifyTrue(condition);
       //Assert.assertTrue(condition);
    }
}
