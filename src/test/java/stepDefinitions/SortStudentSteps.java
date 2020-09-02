package stepDefinitions;

import common.AbstractTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pages.FactoryPage;
import pages.StudentPage;

import java.util.ArrayList;
import java.util.List;

public class SortStudentSteps extends AbstractTest {
    WebDriver driver;
    public static StudentPage studentPage;
    public static List<String> originalFirstNameList = new ArrayList<>();
    public static List<String> firstNameList = new ArrayList<>();

    public SortStudentSteps(){
        driver = Hooks.openBrowser();
       studentPage = FactoryPage.newStudentPage(driver);
        System.out.println("I'm in student page");
    }

    @When("^I click to sort icon in the First Name header$")
    public void i_click_to_sort_icon_in_the_First_Name_header() throws Throwable {
        originalFirstNameList = studentPage.getOriginalFistNameList();
        //System.out.println(originalFirstNameList);
        studentPage.clickFirstNameHeader();

    }

    @Then("^The result grid will be sort descending$")
    public void the_result_grid_will_be_sort_descending() throws Throwable {
        firstNameList = studentPage.getSortedFirstName();
       verifyTrue(studentPage.verifyElementDescending(originalFirstNameList,firstNameList));
    }

    @When("^I click to sort icon in the First Name header one time$")
    public void i_click_to_sort_icon_in_the_First_Name_header_one_time() throws Throwable {
        studentPage.clickSortIcon();
        firstNameList = studentPage.getSortedFirstName();
    }

    @Then("^The result grid will be sort ascending$")
    public void the_result_grid_will_be_sort_ascending() throws Throwable {
        verifyTrue(studentPage.verifyElementAscending(originalFirstNameList,firstNameList));
    }


}
