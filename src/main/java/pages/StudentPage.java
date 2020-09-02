package pages;

import common.AbstractPage;
import interfaces.StudentPageUI;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class StudentPage extends AbstractPage {
    WebDriver driver;
    private StudentPageUI studentPageUI;

    public StudentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        waitForControlVisible(driver, StudentPageUI.userProfile);
        return getTextElement(driver, StudentPageUI.userProfile);
    }

    public void clickFilter() {
        clickToElement(driver, StudentPageUI.btnFilter);
    }

    public void selectStudentStatus(String status) {
        selectItemInDropdownSpecial(driver, StudentPageUI.dropRequestStatus, StudentPageUI.itemInactivated, status);
    }
    public void clickApplyFilter(){
        clickToElement(driver,studentPageUI.btnApplyFilter);
    }
    public Boolean checkStatus(String status) {
        return resultFilter(driver, StudentPageUI.requestStatus, status);

    }

    public void clickFirstNameHeader() {
        waitForPageLoaded(driver);
        clickSortHeader(driver, StudentPageUI.headFirstName);
    }

    public void clickSortIcon() {
        System.out.println("Click sort icon desc");
        waitForPageLoaded(driver);
        clickSortIcon(driver, StudentPageUI.sortIcon);
    }

    public List<String> getOriginalFistNameList() {
        return getOriginalList(driver, StudentPageUI.firstNameColumn);
    }

    public List<String> getSortedFirstName() {
        return getSortedDescList(driver, StudentPageUI.firstNameColumn);
    }

    public Boolean verifyElementDescending(List<String> originalList, List<String> sortedList) {
        return sortElementDescending(originalList, sortedList);
    }

    public Boolean verifyElementAscending(List<String> originalList, List<String> sortedList) {
        return sortElementAcsending(originalList, sortedList);
    }

}
