package com.kodilla.testing2.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q";

    public static void main(String[] args) {

//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]")).click();

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
