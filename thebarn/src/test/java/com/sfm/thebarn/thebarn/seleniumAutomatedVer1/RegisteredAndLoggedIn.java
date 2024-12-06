package com.sfm.thebarn.thebarn.seleniumAutomatedVer1;

import com.sfm.thebarn.thebarn.ThebarnApplication;
import org.apache.commons.codec.digest.DigestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.*;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegisteredAndLoggedIn {
    private WebDriver driver;
    @BeforeClass
    public void setUp() throws ClassNotFoundException, InterruptedException{
        // Load the Spring Boot-Web env
        SpringApplication.run(ThebarnApplication.class);
        // Start the automated Chrome app
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Set page timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // Set web address for our project
        driver.get("http://localhost:8080");
        List<String> email_id_set = new ArrayList<>(List.of("email","floatingInput"));
        List<String> passwd_id_set = new ArrayList<>(List.of("password","floatingPassword"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        for(int i = 0; i < email_id_set.size(); i++){
            driver.findElement(By.id(email_id_set.get(i))).sendKeys("admin@example.com");
            driver.findElement(By.id(passwd_id_set.get(i))).sendKeys("admin");
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
            element.click();
        }
    }

    @Test
    public void GetCsillamfaszOnIndex()
    {
        driver.get("http://localhost:8080/");
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/csillamfasz");
    }

    @Test
    public void GetCsillamfaszOnRegister()
    {
        driver.get("http://localhost:8080/register");
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/csillamfasz");
    }

    @Test
    public void GetCsillamfaszOnLogin()
    {
        driver.get("http://localhost:8080/login");
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/csillamfasz");
    }

    @Test
    public void GetLoginOnLogout(){
        driver.get("http://localhost:8080/logout");
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/login");
    }

    @AfterClass
    public void tearDown(){
        // Close selenium environment
        driver.quit();
    }
}
