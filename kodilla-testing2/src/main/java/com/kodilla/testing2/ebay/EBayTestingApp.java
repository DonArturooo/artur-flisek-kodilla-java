package com.kodilla.testing2.ebay;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EBayTestingApp {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.ebay.com");

        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchField.sendKeys("Laptop");
        driver.findElement(By.xpath("//button[@id=\"gh-search-btn\"]")).click();

        driver.quit();
    }
}
