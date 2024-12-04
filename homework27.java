import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.annotation.meta.When;

public class LoginSteps {
    private WebDriver driver = new ChromeDriver();

    @Given("I am on the login page")
    public void navigateToLogin() {
        driver.get("https://example.com/login");
    }

    @When("I login with {string} and {string}")
    public void login(String user, String pass) {
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("loginBtn")).click();
    }

    @Then("I should be logged in")
    public void verifyLogin() {
        Assert.assertTrue(driver.findElements(By.id("dashboard")).size() > 0);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}