package com.kodilla.testing2.crudapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    final static Map<String, String> MORSE = createMorseMap();

    private static Map<String, String> createMorseMap(){
        Map<String, String> morse = new HashMap<>();
        morse.put(".-", "A");
        morse.put("-...", "B");
        morse.put("-.-.", "C");
        morse.put("-..", "D");
        morse.put(".", "E");
        morse.put("..-.", "F");
        morse.put("--.", "G");
        morse.put("....", "H");
        morse.put("..", "I");
        morse.put(".---", "J");
        morse.put("-.-", "K");
        morse.put(".-..", "L");
        morse.put("--", "M");
        morse.put("-.", "N");
        morse.put("---", "O");
        morse.put(".--.", "P");
        morse.put("--.-", "Q");
        morse.put(".-.", "R");
        morse.put("...", "S");
        morse.put("-", "T");
        morse.put("..-", "U");
        morse.put("...-", "V");
        morse.put(".--", "W");
        morse.put("-..-", "X");
        morse.put("-.--", "Y");
        morse.put("--..", "Z");

        morse.put(".----", "1");
        morse.put("..---", "2");
        morse.put("...--", "3");
        morse.put("....-", "4");
        morse.put(".....", "5");
        morse.put("-....", "6");
        morse.put("--...", "7");
        morse.put("---..", "8");
        morse.put("----.", "9");
        morse.put("-----", "0");
        return morse;
    }


    public static String convertMorse(String input){
        StringBuilder result = new StringBuilder();

        Arrays.stream(input.split(" ")).forEach(
                code -> result.append(MORSE.getOrDefault(code, "?"))
        );

        return result.toString();
    }
}
