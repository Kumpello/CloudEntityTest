import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class FirefoxTest {
    final String baseUrl = "https://cloudentity.com/";
    final String loginUrl = "https://authz.cloudentity.io/";
    //Path to your webDriver file
    final String pathToDriver = "/home/kumpel/Programs/geckodriver";

    public FirefoxTest() {
        System.setProperty("webdriver.gecko.driver", pathToDriver);
    }

    @Test
    public void TestTitle() {
        WebDriver driver = new FirefoxDriver();
        String correctTitle = "Cloudentity | Dynamic Authorization for Modern Apps";
        driver.get(baseUrl);
        waitForPageToLoad(driver, 15);
        Assertions.assertEquals(correctTitle, driver.getTitle());
        driver.close();
    }

    @Test
    public void TestWrongLoginCredentials() {
        WebDriver driver = new FirefoxDriver();
        driver.get(loginUrl);
        String login = generateRandomCharacters();
        String password = generateRandomCharacters();
        WebElement loginElement = driver.findElement(By.id("email"));
        WebElement passwordElement = driver.findElement(By.id("password"));
        loginElement.sendKeys(login);
        passwordElement.sendKeys(password);
        WebElement submitButton = driver.findElement(By.className("confirm-button"));
        submitButton.click();
        waitForPageToLoad(driver, 15);
        WebElement error = driver.findElement(By.className("error"));

        Assertions.assertEquals(error.getText(), "Invalid credentials.");
        driver.close();
    }

    @Test
    public void TestNavigation() {
        String whyCloudEntityTitle = "Dynamic Authorization, API Access and Data Security | Cloudentity";
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);
        waitForPageToLoad(driver, 15);
        WebElement menuLink = driver.findElement(By.id("menu-item-8844"));
        menuLink.click();
        waitForPageToLoad(driver, 15);

        Assertions.assertEquals(whyCloudEntityTitle, driver.getTitle());
        driver.close();
    }

    private void waitForPageToLoad(WebDriver driver, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState")));
    }

    private String generateRandomCharacters() {
        Random generator = new Random();
        int length = generator.nextInt(12) + 1;
        char[] characters = new char[length];
        for (int i = 0; i < length; i++) {
            characters[i] = (char) (generator.nextInt(26) + 97);
        }
        return String.valueOf(characters);
    }




}
