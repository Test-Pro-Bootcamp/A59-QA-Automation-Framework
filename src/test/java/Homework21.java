import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest {
    WebDriverWait wait;
    Actions actions;


    @Test
    public void renamePlaylist() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);

        //login
        enterEmail("apurva.singh@testpro.io");
        enterPassword("te$tpro$tudent1");
        submit();
        // create a new playlist
        createPlaylistAction();
        // Thread.sleep(5000);
        //rename a new playlist
        renamePlaylistAction();
        //  Thread.sleep(5000);
        //Assert
        Assert.assertTrue(getSuccessPopUp().isDisplayed());
        // Quitting the WebDriver session
        driver.quit();

    }


    public void renamePlaylistAction() {
        // Wait for the playlist element to be present and active
        WebElement renamePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[6]")));
        System.out.println("Found active playlist");

        // Double-click the playlist to make the input field appear
        actions.moveToElement(renamePlaylist).doubleClick().perform();
        System.out.println("double clicked the playlist");


        // Wait for the input field to be present
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        System.out.println("Input field found");

        // Clear the input field using Ctrl+A then Backspace

        actions.moveToElement(inputField).click().sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Cleared input field");

        actions.moveToElement(inputField).click().sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Cleared input field");

        //// Input the new name and press Enter
        inputField.sendKeys("RenamedList");
        inputField.sendKeys(Keys.RETURN);


    }


    public void createPlaylistAction() {
        WebElement addPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/h1/i")));
        addPlaylist.click();
        actions.moveToElement(addPlaylist).click().perform();
        System.out.println("Clicked add playlist icon");
        // click new playlist icon
        WebElement newPlaylistIcon = wait.until((ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"))));
        actions.moveToElement(newPlaylistIcon).click().perform();
        System.out.println("Clicked new playlist");

        //add name to new playlist
        WebElement addPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/form/input")));
        actions.moveToElement(addPlaylistName).click().sendKeys("My new list").sendKeys(Keys.RETURN).perform();
        System.out.println("Entered new playlist name and confirmed");
    }

    public WebElement getSuccessPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Wait for the success popup to appear
            WebElement successPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[2]/div[@class='success show']")));
            System.out.println("Success popup displayed");
            return successPopUp;
        } catch (TimeoutException e) {
            System.out.println("Success popup not found. Exiting...");
            driver.quit();
            System.exit(0);
            return null;
        }
    }
}
