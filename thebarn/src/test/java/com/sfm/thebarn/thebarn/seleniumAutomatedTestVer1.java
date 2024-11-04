package com.sfm.thebarn.thebarn;


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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class seleniumAutomatedTestVer1 {

    WebDriver driver;

    // Runs before every class
    @BeforeMethod
    public void setUp() throws ClassNotFoundException{
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
    @AfterMethod
    public void tearDown() {
        // Close selenium environment
        driver.quit();
    }

    @Test
    public void CheckUserSQLField() throws InterruptedException, SQLException {
        // Wait to store the data
        Thread.sleep(2000);
        // Establish SQL connection with JDBC
        Connection con = DriverManager.getConnection("jdbc:h2:file:./mydata_base","sa","");
        // Set statement
        Statement st = con.createStatement();
        String sql = "select * from Users";
        // Execute query
        ResultSet rs = st.executeQuery(sql);
        String result = "";
        // Fetch data
        while (rs.next())
        {
            result = rs.getString("Passwd");
        }
        // Assert the fetched data with the expected result
        assertEquals(result, DigestUtils.sha256Hex("SFM2024"));
    }
}
