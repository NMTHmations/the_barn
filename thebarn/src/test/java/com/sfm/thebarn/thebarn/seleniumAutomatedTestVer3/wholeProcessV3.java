package com.sfm.thebarn.thebarn.seleniumAutomatedTestVer3;

import com.sfm.thebarn.thebarn.ThebarnApplication;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class wholeProcessV3 {
    WebDriver driver;
    public void ClickTheButton()
    {
        if (driver.findElement(By.tagName("button")).isDisplayed())
        {
            driver.findElement(By.tagName("button")).click();
        }
    }

    @BeforeClass
    public void SetClassUp()
    {
        SpringApplication.run(ThebarnApplication.class);
    }

    @BeforeMethod
    public void MethodSetUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:8080/");
        if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/register")) {
            driver.findElement(By.id("email")).sendKeys("admin@example.com");
            driver.findElement(By.id("password")).sendKeys("SFM2024");
            ClickTheButton();
        }
        driver.findElement(By.id("floatingInput")).sendKeys("admin@example.com");
        driver.findElement(By.id("floatingPassword")).sendKeys("SFM2024");
        ClickTheButton();
    }

    @Test
    public void CheckErrorPage()
    {
        driver.get("http://localhost:8080/xde");
        assertTrue(driver.getPageSource().contains("Upszika"));
    }

    @Test
    public void TestLogout() throws InterruptedException {
        ChoosePlus();
        driver.findElement(By.id("logout")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/login");
    }

    public void ChoosePlus() throws InterruptedException
    {
        if (driver.findElement(By.id("plus_main")).isDisplayed())
        {
            driver.findElement(By.id("plus_main")).click();
        }
        sleep(5);
    }

    public void AddFarms() throws InterruptedException {
        List<RegForm> regForms = new ArrayList<>(List.of(new RegForm("test1@example.com","HU-12345-12345","Sample 1","Sample1","Sample street"),new RegForm("test2@example.com","HU-54321-54321","Sample 2","Sample2","Sample avenue")));
        for(int i = 0; i < regForms.size(); i++)
        {
            ChoosePlus();
            driver.findElement(By.id("farm-registration")).click();
            driver.findElement(By.id("floatingSelfId")).sendKeys(regForms.get(i).getFarmId());
            driver.findElement(By.id("farmName")).sendKeys(regForms.get(i).getFarmName());
            driver.findElement(By.id("zipCode")).sendKeys("1");
            driver.findElement(By.id("settlement")).sendKeys(regForms.get(i).getSettlement());
            driver.findElement(By.id("street")).sendKeys(regForms.get(i).getAddress());
            driver.findElement(By.id("streetNumber")).sendKeys("1");
            driver.findElement(By.id("username")).sendKeys(regForms.get(i).getUsername());
            driver.findElement(By.id("password")).sendKeys("SFM2024");
            if (driver.findElement(By.name("submit-button")).isDisplayed())
            {
                driver.findElement(By.name("submit-button")).click();
            }
        }
    }

    public void RegisterCattle() throws InterruptedException {
        List<CattleRegForm> cattle = new ArrayList<>(List.of(new CattleRegForm("HU-12345","true","5","1","3","002024-12-06","HU-12345-12345"),new CattleRegForm("HU-54321","false","2","1","3","002024-12-06","HU-54321-54321")));
        for (CattleRegForm cattleRegForm : cattle)
        {
            ChoosePlus();
            driver.findElement(By.id("cattle-registration")).click();
            driver.findElement(By.id("floatingSelfId")).sendKeys(cattleRegForm.getId());
            driver.findElement(By.id("floatingSex")).sendKeys(cattleRegForm.getSex());
            driver.findElement(By.id("floatingBreed")).sendKeys(cattleRegForm.getBreed());
            driver.findElement(By.id("floatingType")).sendKeys(cattleRegForm.getType());
            driver.findElement(By.id("floatingColour")).sendKeys(cattleRegForm.getColour());
            driver.findElement(By.id("floatingBirthdate")).sendKeys(cattleRegForm.getBirthdate());
            driver.findElement(By.id("floatingHoldingId")).sendKeys(cattleRegForm.getHolding());
            if (driver.findElement(By.name("submit-button")).isDisplayed())
            {
                driver.findElement(By.name("submit-button")).click();
            }
        }
    }

    @Test
    public void AddCattles() throws InterruptedException {
        AddFarms();
        RegisterCattle();
        assertTrue(driver.getPageSource().contains("HU-12345"));
        assertTrue(driver.getPageSource().contains("HU-54321"));
    }

    @Test
    public void SearchCattlesAsAdmin() throws InterruptedException {
        driver.get("http://localhost:8080/");
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        driver.findElement(By.name("query")).sendKeys("HU-12345-12345");
        if (driver.findElement(By.id("go-search")).isDisplayed())
        {
            driver.findElement(By.id("go-search")).click();
        }
        assertFalse(driver.getPageSource().contains("HU-54321"));
    }


    @Test
    public void DisplayCattlesAsNonAdmin() throws InterruptedException {
        driver.get("http://localhost:8080/");
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("logout")).click();
        driver.findElement(By.id("floatingInput")).sendKeys("test1@example.com");
        driver.findElement(By.id("floatingPassword")).sendKeys("SFM2024");
        ClickTheButton();
        assertFalse(driver.getPageSource().contains("HU-54321"));
    }

    @Test
    public void SearchCattlesAsNonAdmin() throws InterruptedException {
        DisplayCattlesAsNonAdmin();
        driver.findElement(By.name("query")).sendKeys("HU-54321");
        if (driver.findElement(By.id("go-search")).isDisplayed())
        {
            driver.findElement(By.id("go-search")).click();
        }
        assertFalse(driver.getPageSource().contains("HU-12345"));
    }

    @Test
    public void SearchCattlesSexAsNonAdmin() throws InterruptedException {
        DisplayCattlesAsNonAdmin();
        driver.findElement(By.name("option1")).click();
        if (driver.findElement(By.id("go-search")).isDisplayed())
        {
            driver.findElement(By.id("go-search")).click();
        }
        assertFalse(driver.getPageSource().contains("HU-12345"));
    }

    @Test
    public void RegisterAnimalWithExistingId() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("cattle-registration")).click();
        driver.findElement(By.id("floatingSelfId")).sendKeys("HU-12345");
        driver.findElement(By.id("floatingSex")).sendKeys("false");
        driver.findElement(By.id("floatingBreed")).sendKeys("5");
        driver.findElement(By.id("floatingType")).sendKeys("1");
        driver.findElement(By.id("floatingColour")).sendKeys("3");
        driver.findElement(By.id("floatingBirthdate")).sendKeys("002024-12-06");
        driver.findElement(By.id("floatingHoldingId")).sendKeys("HU-12345-12345");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getPageSource().contains("Már létezik marha ilyen azonosítóval!"));
    }

    @Test
    public void RegisterAnimalWithNonExistingFarmId() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("cattle-registration")).click();
        driver.findElement(By.id("floatingSelfId")).sendKeys("HU-12347");
        driver.findElement(By.id("floatingSex")).sendKeys("false");
        driver.findElement(By.id("floatingBreed")).sendKeys("5");
        driver.findElement(By.id("floatingType")).sendKeys("1");
        driver.findElement(By.id("floatingColour")).sendKeys("3");
        driver.findElement(By.id("floatingBirthdate")).sendKeys("002024-12-06");
        driver.findElement(By.id("floatingHoldingId")).sendKeys("HU-12345-123456");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getPageSource().contains("Nem létező tenyészet kódját adta meg!"));
    }

    @Test
    public void RegisterAnimalWithWrongMotherId() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("cattle-registration")).click();
        driver.findElement(By.id("floatingSelfId")).sendKeys("HU-23456");
        driver.findElement(By.id("floatingSex")).sendKeys("false");
        driver.findElement(By.id("floatingBreed")).sendKeys("5");
        driver.findElement(By.id("floatingType")).sendKeys("1");
        driver.findElement(By.id("floatingColour")).sendKeys("3");
        driver.findElement(By.id("floatingBirthdate")).sendKeys("002024-12-06");
        driver.findElement(By.id("floatingMotherId")).sendKeys("HU-12345");
        driver.findElement(By.id("floatingHoldingId")).sendKeys("HU-12345-12345");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getPageSource().contains("Nem létező Anya azonosító!"));
    }

    @Test
    public void RegisterAnimalWithWrongFatherId() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("cattle-registration")).click();
        driver.findElement(By.id("floatingSelfId")).sendKeys("HU-23456");
        driver.findElement(By.id("floatingSex")).sendKeys("false");
        driver.findElement(By.id("floatingBreed")).sendKeys("5");
        driver.findElement(By.id("floatingType")).sendKeys("1");
        driver.findElement(By.id("floatingColour")).sendKeys("3");
        driver.findElement(By.id("floatingBirthdate")).sendKeys("002024-12-06");
        driver.findElement(By.id("floatingFatherId")).sendKeys("HU-12346");
        driver.findElement(By.id("floatingHoldingId")).sendKeys("HU-12345-12345");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getPageSource().contains("Nem létező Apa azonosító!"));
    }

    @Test
    public void RegisterAnimalWithoutId() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("cattle-registration")).click();
        driver.findElement(By.id("floatingSex")).sendKeys("false");
        driver.findElement(By.id("floatingBreed")).sendKeys("5");
        driver.findElement(By.id("floatingType")).sendKeys("1");
        driver.findElement(By.id("floatingColour")).sendKeys("3");
        driver.findElement(By.id("floatingBirthdate")).sendKeys("002024-12-06");
        driver.findElement(By.id("floatingHoldingId")).sendKeys("HU-12345-12345");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertEquals("http://localhost:8080/cattle_registration",driver.getCurrentUrl());
    }

    @Test
    public void TestCsillamfasz()
    {
        driver.get("http://localhost:8080/csillamfasz");
        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/csillamfasz"));
    }

    @Test
    public void FillDiseaseFormOK() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("disease-registration")).click();
        driver.findElement(By.id("floatingAnimalId")).sendKeys("HU-12345");
        driver.findElement(By.id("floatingDiseaseType")).sendKeys("22");
        driver.findElement(By.id("floatingDate")).sendKeys("002024-12-06");
        driver.findElement(By.name("description")).sendKeys("Bendő felfújódás");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/"));
    }

    @Test
    public void FillDiseaseFormWithInvalidID() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("disease-registration")).click();
        driver.findElement(By.id("floatingAnimalId")).sendKeys("HU-12348");
        driver.findElement(By.id("floatingDiseaseType")).sendKeys("22");
        driver.findElement(By.id("floatingDate")).sendKeys("002024-12-06");
        driver.findElement(By.name("description")).sendKeys("Bendő felfújódás");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getPageSource().contains("A megadott állat nem létezik!"));
    }

    @Test
    public void FillDiseaseFormWithLongDescription() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        String OVB = """
                Elhagyom ezt a csoportot, mert sértő az elmúlt több mint 10 éves OVB-s tapasztalatom 
                és múltammal szemben (a válaszlehetőséget a sok agyalágyultnak még meghagyom, 
                vállalom teljes mellszélességgel). Én is egyetemistaként kezdtem és én is végigjártam 
                a ranglétrát, sőt én is hívtam fel barátomat, ismerősömet, akikkel már félévvel 
                azelőtt nem beszéltem. Lehet, én nem voltam olyan erőszakos (és itt köztetek néhányan 
                így élték meg a közeledést), mint mások, de hittem a cégben a működésében és a 
                vezetőmben, hogy jó degy, ami a lényeg, hogy azóta már 10 év eltelt és még mindig 
                ennél az - amúgy 5 éve piacvezető - cégnél dolgozom. Büszke vagyok rá, sőt nap, mint 
                nap tapasztalom a hálás ügyfeleimtől a rengeteg köszönetet, jah és nemhogy én nem 
                hívok ügyfeleket már 2 éve, de heti szinten keresnek idegen emberek az ügyfeleimre 
                hivatkozva.
                """;
        driver.findElement(By.id("disease-registration")).click();
        driver.findElement(By.id("floatingAnimalId")).sendKeys("HU-12345");
        driver.findElement(By.id("floatingDiseaseType")).sendKeys("22");
        driver.findElement(By.id("floatingDate")).sendKeys("002024-12-06");
        driver.findElement(By.name("description")).sendKeys(OVB);
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getPageSource().contains("Leírás túllépi a 255 karakternyi limitet!"));
    }

    @Test
    public void DisplayNonExistingCattle()
    {
        driver.get("http://localhost:8080/cattle-data/HU-98765");
        assertTrue(driver.getPageSource().contains("404"));
    }

    @Test
    public void EditNonExistingCattle() {
        driver.get("http://localhost:8080/cattle_edit/HU-98765");
        assertTrue(driver.getPageSource().contains("404"));
    }

    @Test
    public void EditCattle() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        driver.get("http://localhost:8080/cattle_edit/HU-12345");
        driver.findElement(By.id("floatingFatherId")).sendKeys("HU-54321");
        if (driver.findElement(By.name("submit-button")).isDisplayed()) {
            driver.findElement(By.name("submit-button")).click();
        }
        sleep(5000);
        driver.get("http://localhost:8080/cattle-data/HU-12345");
        assertTrue(driver.getPageSource().contains("HU-54321"));
    }

    @Test
    public void ReachCattleProfileAsAdmin() throws InterruptedException
    {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        driver.get("http://localhost:8080/cattle-data/HU-12345");
        assertTrue(driver.getPageSource().contains("HU-12345"));
    }

    @Test
    public void ReachCattleProfileSignedOut() throws InterruptedException
    {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("logout")).click();
        driver.get("http://localhost:8080/cattle-data/HU-12345");
        assertFalse(driver.getPageSource().contains("HU-12345"));
        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/login"));
    }

    @Test
    public void RegisterFarm() throws InterruptedException {
        ChoosePlus();
        driver.findElement(By.id("farm-registration")).click();
        driver.findElement(By.id("floatingSelfId")).sendKeys("HU-45678-45678");
        driver.findElement(By.id("farmName")).sendKeys("Minta 3");
        driver.findElement(By.id("zipCode")).sendKeys("1");
        driver.findElement(By.id("settlement")).sendKeys("Minta3");
        driver.findElement(By.id("street")).sendKeys("Sample street");
        driver.findElement(By.id("streetNumber")).sendKeys("1");
        driver.findElement(By.id("username")).sendKeys("test3@example.com");
        driver.findElement(By.id("password")).sendKeys("SFM2024");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/"));
    }

    @Test
    public void AddUserWithExistingID() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("farm-registration")).click();
        driver.findElement(By.id("floatingSelfId")).sendKeys("HU-12345-12345");
        driver.findElement(By.id("farmName")).sendKeys("Minta 3");
        driver.findElement(By.id("zipCode")).sendKeys("1");
        driver.findElement(By.id("settlement")).sendKeys("Minta3");
        driver.findElement(By.id("street")).sendKeys("Sample street");
        driver.findElement(By.id("streetNumber")).sendKeys("1");
        driver.findElement(By.id("username")).sendKeys("test3@example.com");
        driver.findElement(By.id("password")).sendKeys("SFM2024");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getPageSource().contains("A megadott tenyészetkód már létezik!"));
    }

    @Test
    public void AddUserWithInvalidID() throws InterruptedException {
        ChoosePlus();
        driver.findElement(By.id("farm-registration")).click();
        driver.findElement(By.id("floatingSelfId")).sendKeys("HU-12345-123455");
        driver.findElement(By.id("farmName")).sendKeys("Minta 3");
        driver.findElement(By.id("zipCode")).sendKeys("1");
        driver.findElement(By.id("settlement")).sendKeys("Minta3");
        driver.findElement(By.id("street")).sendKeys("Sample street");
        driver.findElement(By.id("streetNumber")).sendKeys("1");
        driver.findElement(By.id("username")).sendKeys("test3@example.com");
        driver.findElement(By.id("password")).sendKeys("SFM2024");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        Alert alert = driver.switchTo().alert();
        assertEquals("Helytelen tenyészetkód! Helyes formátum: HU-12345-12345", alert.getText());
        alert.accept();
    }

    @Test
    public void AddUserWithExistingMail() throws InterruptedException {
        if (!(driver.getPageSource().contains("HU-12345") || driver.getPageSource().contains("HU-54321"))) {
            AddFarms();
            RegisterCattle();
        }
        ChoosePlus();
        driver.findElement(By.id("farm-registration")).click();
        driver.findElement(By.id("floatingSelfId")).sendKeys("HU-67891-67891");
        driver.findElement(By.id("farmName")).sendKeys("Minta 3");
        driver.findElement(By.id("zipCode")).sendKeys("1");
        driver.findElement(By.id("settlement")).sendKeys("Minta3");
        driver.findElement(By.id("street")).sendKeys("Sample street");
        driver.findElement(By.id("streetNumber")).sendKeys("1");
        driver.findElement(By.id("username")).sendKeys("test1@example.com");
        driver.findElement(By.id("password")).sendKeys("SFM2024");
        if (driver.findElement(By.name("submit-button")).isDisplayed())
        {
            driver.findElement(By.name("submit-button")).click();
        }
        assertTrue(driver.getPageSource().contains("A megadott felhasználónév (e-mail cím) már létezik!"));
    }

    @AfterMethod
    public void TearDownTest()
    {
        driver.close();
        driver.quit();
    }

}
