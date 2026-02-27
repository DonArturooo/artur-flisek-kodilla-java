package com.kodilla.testing2.crudapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CrudAppTestingApp {
    public static final String TASK_NAME_INPUT = "/html/body/main/section[1]/form/fieldset[1]/input";
    public static final String TASK_CONTENT_INPUT = "/html/body/main/section[1]/form/fieldset[2]/textarea";
    public static final String WAIT_FOR = "//select[1]";
    public static final String BOARD_LIST = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://donarturooo.github.io/artur-flisek-kodilla-java-tasks-frontend.github.io/");

        WebElement taskNameInput = driver.findElement(By.xpath(TASK_NAME_INPUT));
        taskNameInput.sendKeys("New robotic task");

        WebElement taskContentInput = driver.findElement(By.xpath(TASK_CONTENT_INPUT));
        taskContentInput.sendKeys("The robotic content");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(By.xpath(WAIT_FOR)).isDisplayed());

        WebElement selectBoardList = driver.findElement(By.xpath(BOARD_LIST));
        Select selectBoard = new Select(selectBoardList);
        selectBoard.selectByIndex(1);
    }
}
