package cucumberOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Hooks {
    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());
    private static WebDriver driver;

    @Before
    public synchronized static WebDriver openBrowser() {
        String browser = System.getProperty("BROWSER");//"chrome";
        String version = System.getProperty("VERSION");//"2.37";
        String url = System.getProperty("URL"); // "http://ktvn-test.s3-website.us-east-1.amazonaws.com/" ;
        if (driver == null) {
            try {
                switch (browser) {
                    case "chrome":
                        ChromeDriverManager.getInstance().version(version).setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        FirefoxDriverManager.getInstance().version(version).setup();
                        driver = new FirefoxDriver();
                        break;
                    case "ie":
                        InternetExplorerDriverManager.getInstance().version(version).setup();
                        driver = new InternetExplorerDriver();
                        break;
                    default:
                        ChromeDriverManager.getInstance().version(version).setup();
                        driver = new ChromeDriver();
                }
            } catch (UnreachableBrowserException e) {
                ChromeDriverManager.getInstance().version(version).setup();
                driver = new ChromeDriver();
            } catch (WebDriverException e) {
                ChromeDriverManager.getInstance().version(version).setup();
                driver = new ChromeDriver();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("--------START BROWSER--------");
        }

        return driver;
    }

    public static void close() {
        try {
            openBrowser().quit();
            driver = null;
            LOGGER.info("Closing the browser");
        } catch (UnreachableBrowserException e) {
            LOGGER.info("Cannot close browser: unreachable browser");
        }
    }

    @After
    public void closeBrowser(WebDriver driver) {
        try {
            if (driver != null) {
                driver.quit();
                System.gc();
                if (driver.toString().toLowerCase().contains("chrome")) {
                    String cmd = "taskkill /IM chromedriver.exe /F";
                    Process process = Runtime.getRuntime().exec(cmd);
                    process.waitFor();
                }
                if (driver.toString().toLowerCase().contains("internetexplorer")) {
                    String cmd = "taskkill /IM IEDriverServer.exe /F";
                    Process process = Runtime.getRuntime().exec(cmd);
                    process.waitFor();
                }
                System.out.println("--------QUIT BROWSER--------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

}
