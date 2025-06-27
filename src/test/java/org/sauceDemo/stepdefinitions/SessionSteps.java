package org.sauceDemo.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sauceDemo.driver.DriverManager;
import org.testng.Assert;

public class SessionSteps {

    WebDriver driver = DriverManager.getDriver();

    @When("user refreshes the page")
    public void user_refreshes_page() {
        driver.navigate().refresh();
    }

    @Then("user should remain on the products page")
    public void user_should_remain_on_products_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"),
                "Expected to stay on products page but was on: " + currentUrl);
    }

    @When("user logs out")
    public void user_logs_out() {
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // Small wait to let menu load
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user should be redirected to the login page")
    public void user_should_be_redirected_to_login_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("saucedemo.com/"),
                "Expected to be on login page but was: " + currentUrl);
    }
}
