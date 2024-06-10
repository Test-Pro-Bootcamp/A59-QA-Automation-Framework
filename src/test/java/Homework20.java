import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        login("giovanna.silva@testpro.io", "ShakaMaya1302!");

        // Explicit wait after login
        WebDriverWait waitAfterLogin = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitAfterLogin.until(ExpectedConditions.urlContains(".app/#!/home"));
        // Replace "your-desired-url" with the URL or part of the URL of the page you expect to be redirected to after login
        
        // Click to view playlist
        deletePlaylistAction();

        // Delete the playlist
        confirmDelete();

        // Assert Deletion Success
        Assert.assertTrue(getSuccessPopUp().isDisplayed());

        // Quitting the WebDriver session
        driver.quit();
    }

    public void deletePlaylistAction() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the overlaying element to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='play']")));

        try {
            // Locate and click on the playlist using JavaScript
            WebElement clickPlayList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[3]/a")));

            // Use the JavaScriptUtils class to click the element
            JavaScriptUtils.clickElement(driver, clickPlayList);
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("No playlist found to click. Exiting...");
            driver.quit();
            System.exit(0);
        }
    }

    public void confirmDelete() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            // Check if the delete button is present and clickable
            WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='del btn-delete-playlist']")));
            JavaScriptUtils.clickElement(driver, confirmDelete);
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("No playlist to delete. Exiting...");
            driver.quit();
            System.exit(0);
        }
    }

    public WebElement getSuccessPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Wait for the success popup to appear
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[2]/div[@class='success show']")));
        } catch (TimeoutException e) {
            System.out.println("Success popup not found. Exiting...");
            driver.quit();
            System.exit(0);
        }
        return null;
    }

    // Nested static class JavaScriptUtils
    public static class JavaScriptUtils {
        public static void clickElement(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
}
