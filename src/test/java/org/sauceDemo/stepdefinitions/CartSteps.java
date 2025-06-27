package org.sauceDemo.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.sauceDemo.driver.DriverManager;
import org.sauceDemo.pages.CartPage;
import org.sauceDemo.pages.LoginPage;
import org.testng.Assert;

public class CartSteps {

    CartPage cartPage;

    @Given("user is logged in on cart page")
    public void user_is_logged_in_on_cart_page() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        new LoginPage(driver).login("standard_user", "secret_sauce");
        cartPage = new CartPage(driver);
    }

    @When("user adds backpack and bike light to cart")
    public void user_adds_items_to_cart() {
        cartPage.addBackpack();
        cartPage.addBikeLight();
    }

    @Then("cart should show {int} items")
    public void cart_should_show_items(int expectedCount) {
        String actual = cartPage.getCartCount();
        Assert.assertEquals(actual, String.valueOf(expectedCount), "Cart count mismatch");
    }

    @When("user navigates to the cart")
    public void user_navigates_to_the_cart() {
        cartPage.openCart();
    }

    @Then("both backpack and bike light should be in the cart")
    public void items_should_be_present_in_cart() {
        Assert.assertTrue(cartPage.isBackpackInCart(), "Backpack not in cart");
        Assert.assertTrue(cartPage.isBikeLightInCart(), "Bike light not in cart");
    }

    @When("user removes backpack")
    public void user_removes_backpack() {
        cartPage.removeBackpack();
    }

    @Then("only bike light should remain in the cart")
    public void only_bike_light_should_remain() {
        Assert.assertFalse(cartPage.isBackpackInCart(), "Backpack should be removed");
        Assert.assertTrue(cartPage.isBikeLightInCart(), "Bike light should still be present");
        Assert.assertEquals(cartPage.getCartCount(), "1", "Cart badge not updated after removal");
    }

    @When("user removes bike light")
    public void user_removes_bike_light() {
        cartPage.removeBikeLight();
    }

    @Then("cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertFalse(cartPage.isCartBadgeVisible(), "Cart badge should disappear after removing all items");
    }
}
