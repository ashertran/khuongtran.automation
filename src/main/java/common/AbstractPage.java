package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    private int timeouts = 20;
    private By by;

    protected static void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> expectationLoad = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(3000);
            WebDriverWait waitForLoad = new WebDriverWait(driver, 33);
            waitForLoad.until(expectationLoad);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    protected void waitForControlVisible(WebDriver driver, String locator) {
        String str_locator = String.format(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        By by = By.cssSelector(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void waitForControlPresence(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        By by = By.xpath(locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    protected void clearAndSendKeyToElemenTextbox(WebDriver driver, String locator, String value) {
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.clear();
        element.sendKeys(value);
    }

    protected String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // Web Element
    protected void clickToElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.click();
    }

    protected String getTextElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.cssSelector(locator));
        return element.getText();
    }

    protected String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected void selectItemInDropdownSpecial(WebDriver driver, String locatorDropdown, String locator, String value) {
        WebElement dropdown = driver.findElement(By.xpath(locatorDropdown));
        dropdown.click();
        List<WebElement> list = driver.findElements(By.xpath(locator));
        for (WebElement element : list) {
            if (element.getText().equalsIgnoreCase(value)) {
                element.click();
                break;
            }
        }

    }

    protected boolean resultFilter(WebDriver driver, String locator, String status) {
        List<WebElement> list = driver.findElements(By.xpath(locator));
        int length = list.size();
        for (int i = 0; i < length; i++) {
            if (!status.equals(list.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    protected void clickSortHeader(WebDriver driver, String locator) {
        WebElement sortDropdownIcon = driver.findElement(By.xpath(locator));
        sortDropdownIcon.click();

    }

    protected void clickSortIcon(WebDriver driver, String locator) {
        WebElement sortIcon = driver.findElement(By.cssSelector(locator));
        sortIcon.click();
    }

    protected List<String> getOriginalList(WebDriver driver, String locator) {
        List<WebElement> originalList = driver.findElements(By.cssSelector(locator));
        List<String> originalNameList = new ArrayList<>();
        int length = originalList.size();
        for (int i = 0; i < length; i++) {
            originalNameList.add(originalList.get(i).getText());
        }
        return originalNameList;
    }

    protected List<String> getSortedDescList(WebDriver driver, String locator) {
        List<WebElement> sortedList = driver.findElements(By.cssSelector(locator));
        List<String> sortedNameList = new ArrayList<>();
        int length = sortedList.size();
        for (int i = 0; i < length; i++) {
            sortedNameList.add(sortedList.get(i).getText());
        }
        return sortedNameList;
    }

    protected boolean sortElementDescending(List<String> originalList, List<String> sortedList) {
        Collections.sort(originalList);
        Collections.reverse(originalList);
        boolean returnValue = originalList.equals(sortedList);
        return returnValue;
    }

    protected boolean sortElementAcsending(List<String> originalList, List<String> sortedList) {

        Collections.sort(originalList);
        boolean returnValue = originalList.equals(sortedList);

        return returnValue;
    }
}
