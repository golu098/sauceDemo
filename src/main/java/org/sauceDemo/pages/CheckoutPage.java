package org.sauceDemo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By backpackAdd = By.id("add-to-cart-sauce-labs-backpack");
    private final By bikeLightAdd = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By checkoutBtn = By.id("checkout");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By itemNames = By.className("inventory_item_name");
    private final By itemTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By total = By.className("summary_total_label");
    private final By finishBtn = By.id("finish");
    private final By confirmationHeader = By.className("complete-header");

    public void addItemsToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(backpackAdd)).click();
        wait.until(ExpectedConditions.elementToBeClickable(bikeLightAdd)).click();
    }

    public String getCartBadgeCount() {
        return getText(cartBadge);
    }

    public void openCart() {
        click(cartIcon);
    }

    public boolean isItemInCart(String itemName) {
        return driver.findElements(By.xpath("//div[text()='" + itemName + "']")).size() > 0;
    }

    public void proceedToCheckout() {
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkout);
        checkout.click();
    }

    public void fillCheckoutForm(String fName, String lName, String zip) {
        sendKeys(firstName, fName);
        sendKeys(lastName, lName);
        sendKeys(postalCode, zip);
        click(continueBtn);
    }



    public List<WebElement> getSummaryItems() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemNames));
    }

    public String getItemTotalText() {
        return getText(itemTotal);
    }

    public String getTaxText() {
        return getText(tax);
    }

    public String getTotalText() {
        return getText(total);
    }

    public void finishCheckout() {
        click(finishBtn);
    }

    public String getConfirmationText() {
        return getText(confirmationHeader);
    }
}
