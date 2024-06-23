import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String chosenPlayList = "LeonPlayList";
        navigateToHomePage();
        login();

        // Check initial length of playlist
        String len = checkPlayListLength(chosenPlayList);
        
        searchForSong();
        addSong(); // add first song on the returned list

        // Verify/validate Song was added to chosen playlist via assertion
        String len2 = checkPlayListLength(chosenPlayList); // Check length of playlist after add-song attempt
        Assert.assertNotSame(len2,len);
    }

    private String checkPlayListLength(String name) {
        String url = "https://qa.koel.app/#!/home";
        driver.get(url);
        WebElement playList =
                driver.findElement(By.xpath("//section[@id='playlists']/ul/li[3]/a[contains(text(),'LeonPlayList')]"));
        playList.click();
        WebElement songCountText = driver.findElement(By.xpath("//section[@id='playlistWrapper']//span[contains(text(),'song')]"));
        return songCountText.getText();
    }

    private void addSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//div[@class='item-container']//tr[1]"));
        firstSong.click();
        WebElement addToBtn = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addToBtn.click();
        // Find and select the playlist we want to add the song to
        WebElement chosenPlayList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//ul/li[contains(text(),chosenPlayList)]"));
        chosenPlayList.click(); // song added
    }

    private void searchForSong() {
        // Locate the Search Text Field Web Element
        driver.get("https://qa.koel.app/#!/search");
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("dark");

        // Locate "View All" button Web element
        // WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    private void login() throws InterruptedException {
        // Locate Web elements Email field and Password field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("leon.poyau@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("jTRCkwNf");
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }


    public void navigateToHomePage() throws InterruptedException {
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(1000);
    }
}
