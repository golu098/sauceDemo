package org.sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By backpackAddBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By bikeLightAddBtn = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By backpackRemoveBtn = By.id("remove-sauce-labs-backpack");
    private final By bikeLightRemoveBtn = By.id("remove-sauce-labs-bike-light");
    private final By cartItemBackpack = By.xpath("//div[text()='Sauce Labs Backpack']");
    private final By cartItemBikeLight = By.xpath("//div[text()='Sauce Labs Bike Light']");

    public void addBackpack() {
        wait.until(ExpectedConditions.elementToBeClickable(backpackAddBtn)).click();
        System.out.println("Backpack added. Cart count: " + getCartCountSafely());
    }

    public void addBikeLight() {
        wait.until(ExpectedConditions.elementToBeClickable(bikeLightAddBtn)).click();
        System.out.println("Bike light added. Cart count: " + getCartCountSafely());
    }

    private String getCartCountSafely() {
        try {
            return getText(cartBadge);
        } catch (Exception e) {
            return "0";
        }
    }



    public String getCartCount() {
        return getText(cartBadge);
    }

    public void openCart() {
        click(cartIcon);
    }

    public boolean isBackpackInCart() {
        return isDisplayed(cartItemBackpack);
    }

    public boolean isBikeLightInCart() {
        return isDisplayed(cartItemBikeLight);
    }

    public void removeBackpack() {
        click(backpackRemoveBtn);
    }

    public void removeBikeLight() {
        click(bikeLightRemoveBtn);
    }

    public boolean isCartBadgeVisible() {
        return isDisplayed(cartBadge);
    }
}
