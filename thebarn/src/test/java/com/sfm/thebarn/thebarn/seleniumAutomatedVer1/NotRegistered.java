package com.sfm.thebarn.thebarn.seleniumAutomatedVer1;

import com.sfm.thebarn.thebarn.ThebarnApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotRegistered {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        SpringApplication.run(ThebarnApplication.class);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/register");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void GetRegisterOnLogin() {
        driver.get("http://localhost:8080/login");
        assertEquals("http://localhost:8080/register", driver.getCurrentUrl());
    }

    @Test
    public void GetRegisterOnCsillamfasz() {
        driver.get("http://localhost:8080/csillamfasz");
        assertEquals("http://localhost:8080/register", driver.getCurrentUrl());
    }

    @Test
    public void GetRegisterOnIndex() {
        driver.get("http://localhost:8080/");
        assertEquals("http://localhost:8080/register", driver.getCurrentUrl());
    }

    @Test
    public void GetRegisterOnLogout() {
        driver.get("http://localhost:8080/logout");
        assertEquals("http://localhost:8080/register", driver.getCurrentUrl());
    }
}
