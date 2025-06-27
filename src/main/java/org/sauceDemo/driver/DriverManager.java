package org.sauceDemo.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {} // Prevent instantiation

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driverParam) {
        driver = driverParam;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
