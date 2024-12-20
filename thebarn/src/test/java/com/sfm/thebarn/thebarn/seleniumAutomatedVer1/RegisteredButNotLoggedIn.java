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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegisteredButNotLoggedIn {

    WebDriver driver;

    // Establish SQL connection with JDBC
    Connection con = DriverManager.getConnection("jdbc:h2:file:./mydata_base","sa","");

    public RegisteredButNotLoggedIn() throws SQLException {
    }

    // Runs before every class
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
        // Load the most important H2 SQL Driver's class
        Class.forName("org.h2.Driver");
        // Insert data into e-mail field
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        // Insert data into password field
        driver.findElement(By.id("password")).sendKeys("SFM2024");
        // Wait for submit button to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        // Click the button
        element.click();
    }

    // Runs after every class
    @AfterClass
    public void tearDown() throws InterruptedException {
        // Close selenium environment
        driver.quit();
    }

    private ResultSet GetSQLQuery(String query) throws SQLException {
        // Set statement
        Statement st = con.createStatement();
        // Execute query
        ResultSet rs = st.executeQuery(query);
        return rs;
    }

    @Test
    public void CheckUserSQLField() throws InterruptedException, SQLException {
        // Wait to store the data
        Thread.sleep(2000);
        ResultSet rs = GetSQLQuery("select * from Users");
        String result = "";
        // Fetch data
        while (rs.next())
        {
            result = rs.getString("Passwd");
        }
        // Assert the fetched data with the expected result
        assertEquals(result, DigestUtils.sha256Hex("SFM2024"));
    }

    @Test
    public void CheckSessionManagement() throws InterruptedException, SQLException
    {
        // Wait SQL to store data
        Thread.sleep(2000);
        // Login
        driver.findElement(By.name("Email")).sendKeys("admin@example.com");
        driver.findElement(By.name("Password")).sendKeys("SFM2024");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        element.click();
        Thread.sleep(2000);
        ResultSet rs = GetSQLQuery("select * from SPRING_SESSION");
        String result = "";
        while (rs.next())
        {
            result = rs.getString("MAX_INACTIVE_INTERVAL");
        }
        assertEquals("20", result);
    }

    @Test
    public void CheckSessionManagementInvalidation() throws InterruptedException, SQLException
    {
        Thread.sleep(2000);
        ResultSet rs = GetSQLQuery("select * from SPRING_SESSION");
        if (!rs.wasNull())
        {
            driver.get("http://localhost:8080/logout");
        }
        // Wait SQL to store data
        Thread.sleep(2000);
        // Login
        driver.findElement(By.name("Email")).sendKeys("admin@example.com");
        driver.findElement(By.name("Password")).sendKeys("SFM2024");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        element.click();
        Thread.sleep(Duration.ofSeconds(30));
        driver.get(driver.getCurrentUrl());
        rs = GetSQLQuery("select * from SPRING_SESSION");
        String result = "";
        while (rs.next())
        {
            result = rs.getString("MAX_INACTIVE_INTERVAL");
        }
        assertEquals("", result);
    }

    @Test
    public void WithoutLoginGetAlwaysLoginWhenReachingLogout()
    {
        driver.get("http://localhost:8080/logout");
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/login");
    }

    @Test
    public void WithoutLoginGetAlwaysLoginWhenReachingRegister()
    {
        driver.get("http://localhost:8080/register");
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/login");
    }

    @Test
    public void WithoutLoginGetAlwaysLoginWhenReachingCsillamfasz()
    {
        driver.get("http://localhost:8080/csillamfasz");
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/login");
    }

    @Test
    public void WithoutLoginGetAlwaysLoginWhenReachingIndex()
    {
        driver.get("http://localhost:8080/");
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/login");
    }
}
