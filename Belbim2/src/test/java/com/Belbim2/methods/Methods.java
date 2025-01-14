package com.Belbim2.methods;

import com.Belbim2.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> fluentWait;

    public Methods() {
        driver = Driver.driver;
        fluentWait = setFluentWait(10);
    }

    public void waitForUrl(String url) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(url));
    }

    public void pressEnter(By by) {
        findElement(by).sendKeys(Keys.ENTER);
    }

    public FluentWait<WebDriver> setFluentWait(long timeout) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement1(By by) {
        return driver.findElement(by);
    }

    public WebElement findElement(By by) {
        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void hoverElement(By by) {
        WebElement element = findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public boolean isElementVisible(By by, long timeout) {
        try {
            setFluentWait(timeout).until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitBySeconds(long seconds) {
        waitByMilliSeconds(1000 * seconds);
    }

    public void waitByMilliSeconds(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickCheckbox(By by) {
        WebElement checkbox = findElement(by);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void sekmeDegistir(String baslik) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().toLowerCase().contains(baslik.toLowerCase())) {
                break;
            }
        }
    }

    public boolean isAlertMessageVisible(By by) {
        try {
            WebElement element = findElement(by);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getMessageText(By by) {
        try {
            WebElement element = findElement(by);
            return element.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isAlertMessageDisplayed(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String waitForAlertMessageText(By by, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, expectedText)) ? driver.findElement(by).getText() : null;
    }

    public boolean isAlertMessageCorrect(By by, String expectedText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            String actualText = driver.findElement(by).getText();
            return actualText.equals(expectedText);
        } catch (TimeoutException e) {
            return false;
        }
    }


}
