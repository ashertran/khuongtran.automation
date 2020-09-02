package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FactoryPage extends AbstractPage {
    private static LoginPage loginPage;
    private static StudentPage studentPage;
    public static LoginPage getLoginPge(WebDriver driver){
        return (loginPage == null) ? new LoginPage(driver) : loginPage;
    }
    public static StudentPage newStudentPage(WebDriver driver){
        return (studentPage==null) ? new StudentPage(driver): studentPage;
    }
}
