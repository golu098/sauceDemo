package org.sauceDemo.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.sauceDemo.driver.DriverFactory;
import org.sauceDemo.driver.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        WebDriver driver = DriverFactory.createInstance("edge");
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        DriverManager.quitDriver();
    }
}
