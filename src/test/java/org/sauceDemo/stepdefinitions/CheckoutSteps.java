package org.sauceDemo.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sauceDemo.driver.DriverManager;
import org.sauceDemo.pages.CheckoutPage;
import org.sauceDemo.pages.LoginPage;
import org.testng.Assert;

import java.util.List;

public class CheckoutSteps {
    CheckoutPage checkoutPage;

    @Given("user is logged in for checkout")
    public void user_is_logged_in_for_checkout() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        new LoginPage(driver).login("standard_user", "secret_sauce");
        checkoutPage = new CheckoutPage(driver);
    }

    @When("user adds backpack and bike light and proceeds to checkout")
    public void user_adds_items_and_goes_to_checkout() {
        checkoutPage.addItemsToCart();
        Assert.assertEquals(checkoutPage.getCartBadgeCount(), "2");
        checkoutPage.openCart();
        Assert.assertTrue(checkoutPage.isItemInCart("Sauce Labs Backpack"));
        Assert.assertTrue(checkoutPage.isItemInCart("Sauce Labs Bike Light"));
        checkoutPage.proceedToCheckout();
    }

    @And("user fills in checkout form")
    public void user_fills_checkout_form() {
        checkoutPage.fillCheckoutForm("shiv", "kant", "008898");
    }

    @Then("summary should contain two items and pricing should be shown")
    public void verify_order_summary() {
        List<WebElement> items = checkoutPage.getSummaryItems();
        Assert.assertEquals(items.size(), 2);
        Assert.assertEquals(items.get(0).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(items.get(1).getText(), "Sauce Labs Bike Light");

        Assert.assertTrue(checkoutPage.getItemTotalText().contains("Item total: $"));
        Assert.assertTrue(checkoutPage.getTaxText().contains("Tax: $"));
        Assert.assertTrue(checkoutPage.getTotalText().contains("Total: $"));
    }

    @And("user finishes the checkout")
    public void user_finishes_checkout() {
        checkoutPage.finishCheckout();
        Assert.assertEquals(checkoutPage.getConfirmationText(), "Thank you for your order!");
    }
}
