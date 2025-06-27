package org.sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By sortDropdown = By.className("product_sort_container");
    private final By priceList = By.className("inventory_item_price");

    public void sortBy(String visibleText) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(visibleText);
    }

    public List<Double> getAllProductPrices() {
        List<WebElement> prices = driver.findElements(priceList);
        return prices.stream()
                .map(e -> e.getText().replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
    public List<String> getAllProductNames() {
        List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
        return names.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
