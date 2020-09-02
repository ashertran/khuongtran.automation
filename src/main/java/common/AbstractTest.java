package common;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

import static org.testng.Reporter.log;

public class AbstractTest {
    protected final Log log;
    WebDriver driver;

    protected AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    public WebDriver openMultiBrowser(String browser, String url, String version) {
        if (browser.equals("ie")) {
            InternetExplorerDriverManager.getInstance().version(version).setup();
            driver = new InternetExplorerDriver();
        } else if (browser.equals("chrome")) {
            ChromeDriverManager.getInstance().version(version).setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extendsions");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private boolean verifyPassed(boolean condition, boolean flag) {
        boolean pass = true;
        if (flag == false) {
            try {
                if (condition == true) {
                    log.info("===PASSED===");
                } else {
                    log.info("===FAILED===");
                }
                Assert.assertTrue(condition);
            } catch (Throwable e) {
                pass = false;
                throw  e;
                //System.out.println(e);
               // Reporter.getCurrentTestResult().setThrowable(e);
            }
        } else {
            Assert.assertTrue(condition);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return verifyPassed(condition, false);
    }

    private boolean verifyFailed(boolean condition, boolean flag) {
        boolean pass = true;
        if (flag == false) {
            try {
                if (condition == false)
                    log.info("===PASSED===");
                else
                    log.info("===FAILED===");
                  Assert.assertFalse(condition);
            } catch (Throwable e) {
                pass = false;
               // Reporter.getCurrentTestResult().setThrowable(e);
            }
        } else {
            Assert.assertFalse(condition);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return verifyFailed(condition, false);
    }

    private boolean verifyEquals(Object actual, Object expected, boolean flag) {
        boolean pass = true;
        if (flag == false) {
            try {
                Assert.assertEquals(actual, expected);
            } catch (Throwable e) {
                pass = false;
                log.info("===FAILED===");
                Reporter.getCurrentTestResult().setThrowable(e);
            }
        } else {
            Assert.assertEquals(actual, expected);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return verifyEquals(actual, expected, false);
    }


    public void closeBrowser() {
        driver.quit();
    }
}
