package com.kodilla.testing2.crudapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static com.kodilla.testing2.crudapp.CrudAppTestingApp.convertMorse;
import static org.junit.jupiter.api.Assertions.*;

public class CruddAppTestSuite {
    private static final String BASE_URL = "https://donarturooo.github.io/artur-flisek-kodilla-java-tasks-frontend.github.io/";
    private WebDriver driver;
    private WebDriverWait wait;
    private Random generator;

    private String username;
    private String password;

    @BeforeEach
    void initTests() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(BASE_URL);
        generator = new Random();
        username = "artur.flisek@gmail.com";
        password = System.getenv("TRELLO_PASSWORD");
    }

    @AfterEach
    void cleanUpAfterTest() {
        driver.quit();
    }


    @Test
    void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        deleteCrudAppTestTask(taskName);
    }

    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.navigate().refresh();

        wait.until(driver -> driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> theForm.findElement(By.xpath(".//button[text()=\"Delete\"]")).click());

        Thread.sleep(500);
    }

    private boolean checkTaskExistsInTrello(String taskName) {
        boolean result;

        final String TRELLO_URL = "https://trello.com/login";
        WebDriver trelloDriver = new ChromeDriver();
        WebDriverWait trelloWait = new WebDriverWait(trelloDriver, Duration.ofSeconds(10));
        trelloDriver.get(TRELLO_URL);

        System.out.println(username + " " + password);

        trelloWait.until(ExpectedConditions.elementToBeClickable(By.id("username-uid1")));
        trelloDriver.findElement(By.id("username-uid1")).sendKeys(username);
        trelloDriver.findElement(By.id("login-submit")).click();
        trelloWait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        trelloDriver.findElement(By.id("password")).sendKeys(password);
        trelloDriver.findElement(By.id("login-submit")).click();

        trelloWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@title=\"Kodilla Application\"]"))).click();

        trelloWait.until(driver ->
                driver.findElement(By.id("list-6960ff850a9d9092648182da")).isDisplayed());

        result = trelloDriver.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        trelloDriver.quit();

        return result;
    }

    private void sendTestTaskToTrello(String taskName) {
        driver.navigate().refresh();

        wait.until(driver -> driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]")).click();
                });
    }


    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_TASK_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        wait.until(driver -> driver.findElement(By.xpath(XPATH_TASK_BUTTON)).isDisplayed());

        driver.findElement(By.xpath(XPATH_TASK_NAME)).sendKeys(taskName);

        driver.findElement(By.xpath(XPATH_TASK_CONTENT)).sendKeys(taskContent);

        driver.findElement(By.xpath(XPATH_TASK_BUTTON)).click();

        Thread.sleep(2000);

        return taskName;
    }


    @Test
    void testConvertMorse() {
        assertAll(
                () -> assertEquals("SOS", convertMorse("... --- ...")),
                () -> assertEquals("HELLO", convertMorse(".... . .-.. .-.. ---")),
                () -> assertEquals("MORSE", convertMorse("-- --- .-. ... .")),
                () -> assertEquals("ADAM", convertMorse(".- -.. .- --")),
                () -> assertEquals("KODILLA", convertMorse("-.- --- -.. .. .-.. .-.. .-"))
        );
    }


}