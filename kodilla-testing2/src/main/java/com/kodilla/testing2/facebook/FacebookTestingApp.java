package com.kodilla.testing2.facebook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class FacebookTestingApp {
    private static final String ACCEPT_COOKIES = "//div[2][@role='button' and contains(@aria-label,'cookie')]";
    private static final String CREATE_NEW_ACCOUNT = "//*[@id=\"login_form\"]/div/div[1]/div/div[5]/div/a";
    private static final String DAY = "//*[@id=\"_r_d_\"]/div/div";
    private static final String MONTH = "//*[@id=\"_r_j_\"]/div";
    private static final String YEAR = "//*[@id=\"_r_p_\"]/div";


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.facebook.com");

        wait.until(d -> d.findElement(By.xpath(ACCEPT_COOKIES)).isDisplayed());
        driver.findElement(By.xpath(ACCEPT_COOKIES)).click();

        wait.until(d -> d.findElement(By.xpath(CREATE_NEW_ACCOUNT)).isDisplayed());
        driver.findElement(By.xpath(CREATE_NEW_ACCOUNT)).click();
        driver.findElement(By.xpath(ACCEPT_COOKIES)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DAY))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\"20\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MONTH))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\"maja\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(YEAR))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\"1996\"]"))).click();
    }
}
