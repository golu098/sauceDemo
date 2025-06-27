package org.sauceDemo.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.sauceDemo.driver.DriverManager;
import org.sauceDemo.pages.LoginPage;
import org.sauceDemo.pages.ProductPage;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;

public class ProductSteps {

    ProductPage productPage;

    @Given("user is logged in")
    public void user_is_logged_in() {
        // ✅ Reuse existing login setup
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        new LoginPage(driver).login("standard_user", "secret_sauce");
    }

    @When("user sorts products by {string}")
    public void user_sorts_products_by(String sortType) {
        productPage = new ProductPage(DriverManager.getDriver());
        productPage.sortBy(sortType);
    }

    @Then("product prices should be sorted in ascending order")
    public void product_prices_should_be_sorted_in_ascending_order() {
        List<Double> actualPrices = productPage.getAllProductPrices();
        List<Double> expectedPrices = actualPrices.stream().sorted().toList();

        Assert.assertEquals(actualPrices, expectedPrices, "Prices are not sorted correctly.");
    }
    @Then("product prices should be sorted in descending order")
    public void product_prices_should_be_sorted_in_descending_order() {
        List<Double> actualPrices = productPage.getAllProductPrices();
        List<Double> expectedPrices = actualPrices.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        Assert.assertEquals(actualPrices, expectedPrices, "Prices are not sorted in descending order.");
    }

    @Then("product names should be sorted in ascending order")
    public void product_names_should_be_sorted_in_ascending_order() {
        List<String> actualNames = productPage.getAllProductNames();
        List<String> expectedNames = actualNames.stream().sorted().toList();

        Assert.assertEquals(actualNames, expectedNames, "Names are not sorted A to Z.");
    }

    @Then("product names should be sorted in descending order")
    public void product_names_should_be_sorted_in_descending_order() {
        List<String> actualNames = productPage.getAllProductNames();
        List<String> expectedNames = actualNames.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        Assert.assertEquals(actualNames, expectedNames, "Names are not sorted Z to A.");
    }

}
