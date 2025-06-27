package org.sauceDemo.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sauceDemo.driver.DriverManager;
import org.sauceDemo.pages.LoginPage;
import org.sauceDemo.utils.ConfigReader;

import java.time.Duration;

public class LoginSteps {

    @Given("user is on login page")
    public void user_is_on_login_page() {
        String baseUrl = ConfigReader.getProperty("base.url");
        DriverManager.getDriver().get(baseUrl);
    }



    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        new LoginPage(DriverManager.getDriver()).login(username, password);
    }

    @Then("user should be navigated to the products page")
    public void user_should_be_navigated_to_the_products_page() {
        String url = DriverManager.getDriver().getCurrentUrl();
        assert url.contains("inventory") : "Expected to be on inventory page, but URL was: " + url;
    }

    @Then("user should see an error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        String actualMessage = new LoginPage(DriverManager.getDriver()).getErrorMessage();
        assert actualMessage.contains(expectedMessage) : "Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'";
    }

    @And("verify potential image or UI glitches")
    public void verifyPotentialImageOrUIGlitches() {
        String imageSrc = DriverManager.getDriver()
                .findElement(By.cssSelector("img.inventory_item_img"))
                .getAttribute("src");

        if (imageSrc.contains("sl-404")) {
            System.out.println("Glitch detected: Image is broken for problem_user as expected.");
        } else {
            System.out.println("Image loaded correctly.");
        }
    }


    @And("page load may be slower than usual")
    public void pageLoadMayBeSlowerThanUsual() {
        long startTime = System.currentTimeMillis();

        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Page load time: " + duration + "ms");
        assert duration > 1000 : "Expected slower page load for performance_glitch_user, but it loaded quickly";
    }

    @And("application might behave unexpectedly")
    public void applicationMightBehaveUnexpectedly() {
        boolean isPresent = DriverManager.getDriver()
                .findElements(By.className("inventory_list"))
                .size() > 0;
        assert isPresent : "Unexpected behavior: Product list is not visible";
    }

    @And("verify visual elements rendering properly")
    public void verifyVisualElementsRenderingProperly() {
        WebElement item = DriverManager.getDriver().findElement(By.className("inventory_item"));
        int height = item.getSize().getHeight();
        int width = item.getSize().getWidth();

        assert height > 0 && width > 0 : "Visual layout of products is broken or improperly rendered";
    }

}
