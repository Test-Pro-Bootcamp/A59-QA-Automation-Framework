import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

         // WHEN
        // Performing actions: login, select playlist, delete playlist,verify deleted message.
        login("india.messam@testpro.io", "slcTalgy");
        Thread.sleep(2000);
        choosePlaylist("First user playlist");
        driver.quit();
    }


    // Method to choose a playlist by name.
    public void choosePlaylist(String FirstUserPlaylist) throws InterruptedException {
        // Locating and clicking the playlist with the specified name.
        WebElement playlist = driver.findElement(By.cssSelector("[href='#!/playlist/95502']"));
        playlist.click();
        Thread.sleep(2000);

    }
    public void clickDeletePlaylistBtn(String DeletePlaylist) throws InterruptedException{
        WebElement deleteBtn = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        deleteBtn.click();
        Thread.sleep(2000);
    }
    // Method to get the success message after adding to the playlist.
    public String getDeletePlaylistSuccessMsg() {
        // Locating and retrieving the success message.
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }


    }














