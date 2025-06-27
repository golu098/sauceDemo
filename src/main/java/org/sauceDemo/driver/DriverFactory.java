package org.sauceDemo.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver createInstance(String browser) {
        IDriver iDriver;

        switch (browser.toLowerCase()) {
            case "firefox":
                iDriver = new FirefoxDriverImpl();
                break;
            case "edge":
                iDriver = new EdgeDriverImpl();
                break;
            case "chrome":
            default:
                iDriver = new ChromeDriverImpl();
                break;
        }

        WebDriver driver = iDriver.createDriver();
        DriverManager.setDriver(driver);
        return driver;
    }
}
