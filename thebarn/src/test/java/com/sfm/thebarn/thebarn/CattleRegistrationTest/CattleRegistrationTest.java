package com.sfm.thebarn.thebarn.CattleRegistrationTest;

import com.sfm.thebarn.thebarn.ThebarnApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.*;

import java.time.Duration;

import static org.junit.Assert.*;


// This testing class is deprecated, don't use it anymore

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CattleRegistrationTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void settingUp() {
        SpringApplication.run(ThebarnApplication.class);
    }


    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("http://localhost:8080/cattle_registration");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void RegisterCorrectDataAndThereIsNoIssues() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("selfId")));
        driver.findElement(By.name("selfId")).sendKeys("HU-12345");
        driver.findElement(By.name("sex")).sendKeys("false");
        driver.findElement(By.name("breed")).sendKeys("30");
        driver.findElement(By.name("birthDate")).sendKeys("2024.11.13");
        driver.findElement(By.name("type")).sendKeys("1");
        driver.findElement(By.name("colour")).sendKeys("1");
        driver.findElement(By.name("motherId")).sendKeys("");
        driver.findElement(By.name("fatherId")).sendKeys("");
        driver.findElement(By.name("holdingId")).sendKeys("HU-12345-12345");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        // Click the button
        element.click();
        // wait to register
        Thread.sleep(1000);
        assertEquals("http://localhost:8080/search_interface",driver.getCurrentUrl());
    }

    /*The here failed*/

    @Test
    public void RegisterWithMissingDatas() throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        element.click();
        Thread.sleep(5000);
        assertNotEquals("http://localhost:8080/search_interface",driver.getCurrentUrl());
    }

    /*Test Failed Here also*/
    @Test
    public void RegisterWithoutId() throws InterruptedException {
        driver.findElement(By.name("sex")).sendKeys("false");
        driver.findElement(By.name("breed")).sendKeys("30");
        driver.findElement(By.name("birthDate")).sendKeys("2024.11.13");
        driver.findElement(By.name("type")).sendKeys("1");
        driver.findElement(By.name("colour")).sendKeys("1");
        driver.findElement(By.name("motherId")).sendKeys("");
        driver.findElement(By.name("fatherId")).sendKeys("");
        driver.findElement(By.name("holdingId")).sendKeys("HU-12345-12345");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        // Click the button
        element.click();
        Thread.sleep(5000);
        assertNotEquals("http://localhost:8080/search_interface",driver.getCurrentUrl());
    }

    @Test
    public void RegisterWithNonExistingHolderId() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("selfId")));
        driver.findElement(By.name("selfId")).sendKeys("HU-12345");
        driver.findElement(By.name("sex")).sendKeys("false");
        driver.findElement(By.name("breed")).sendKeys("30");
        driver.findElement(By.name("birthDate")).sendKeys("2024.11.13");
        driver.findElement(By.name("type")).sendKeys("1");
        driver.findElement(By.name("colour")).sendKeys("1");
        driver.findElement(By.name("motherId")).sendKeys("");
        driver.findElement(By.name("fatherId")).sendKeys("");
        driver.findElement(By.name("holdingId")).sendKeys("HU-12345-123445");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        element.click();
        Thread.sleep(5000);
        assertEquals("http://localhost:8080/cattle_registration",driver.getCurrentUrl());
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
