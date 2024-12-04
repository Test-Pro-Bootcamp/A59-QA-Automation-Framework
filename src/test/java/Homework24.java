import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework24 {
}

import core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GridTestSuite {
    private WebDriver driver;
    private WebDriverManager webDriverManager;

    @BeforeMethod
    public void setUp() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getWebDriver();
    }

    @Test
    public void testGridSearch() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium Grid");
        driver.findElement(By.name("q")).submit();

        System.out.println("Search performed on: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        webDriverManager.clearDriverCache();
    }
}