import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    public void addSongToPlayList() throws InterruptedException {
        // navigate to koel login page
        navigateToPage();

        // login
        enterEmail("leon.poyau@testpro.io");
        enterPassword("jTRCkwNf");
        submit();

        // search for a song
        searchSong("dark");
        //click view-all button
        // select first song from search results
        // click Add-to button
        // choose a playlist from the menu
        // actual vs expected via assertion


    }

    public void searchSong(String name) {
    }
//    @Test
//    public void addSongToPlaylist() throws InterruptedException {
//        // Pre-requisite values
//        String chosenPlayList = "LeonPlayList";
//        String songToSearch = "dark";
//
//        navigateToHomePage();
//        login();
//
//        // Check initial length of playlist
//        //String len = checkPlayListLength(chosenPlayList);
//
//        searchForSong(songToSearch);
//        String actualString = addSong(); // add first song on the returned list
//
//        // Verify/validate Song was added to chosen playlist via assertion
//        // String len2 = checkPlayListLength(chosenPlayList); // Check length of playlist after add-song attempt
//        //Assert.assertNotSame(len2,len);
//        String expectedString = "Added 1 song into \"LeonPlayList.\"";
//        // Verify and validate that song was added to playlist via assertion of a message pop-up
//        Assert.assertEquals(actualString,expectedString);
//    }
//
//    private String checkPlayListLength(String songName) {
//        String url = "https://qa.koel.app/#!/home";
//        driver.get(url);
//        WebElement playList =
//                driver.findElement(By.xpath("//section[@id='playlists']/ul/li[3]/a[contains(text(),'LeonPlayList')]"));
////        WebElement playList =
////                driver.findElement(By.xpath("//section[@id='playlists']/ul/li[3]/a[contains(text(),songName)]"));
//        playList.click();
//        WebElement songCountText = driver.findElement(By.xpath("//section[@id='playlistWrapper']//span[contains(text(),'song')]"));
//        return songCountText.getText();
//    }
//
//    private String addSong() {
//        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//div[@class='item-container']//tr[1]"));
//        firstSong.click();
//        WebElement addToBtn = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
//        addToBtn.click();
//        // Find and select the playlist we want to add the song to
//        WebElement chosenPlayList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//ul/li[contains(text(),chosenPlayList)]"));
//        chosenPlayList.click(); // song added
//        WebElement songAddMessage = driver.findElement(By.xpath("//div[@class='alertify-logs top right']/div[@class='success show']"));
//        return songAddMessage.getText().toString();
//    }
//
//    private void searchForSong(String songToSearch) {
//        // Locate the Search Text Field Web Element
//        driver.get("https://qa.koel.app/#!/search");
//        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
//        searchField.clear();
//        searchField.sendKeys(songToSearch);
//
//        // Locate "View All" button Web element
//        // WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
//        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
//        viewAllBtn.click();
//    }
//
//    private void login() throws InterruptedException {
//        // Locate Web elements Email field and Password field
//        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
//        emailField.clear();
//        emailField.sendKeys("leon.poyau@testpro.io");
//
//        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
//        passwordField.clear();
//        passwordField.sendKeys("jTRCkwNf");
//        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
//        loginBtn.click();
//    }
//
//
//    public void navigateToHomePage() throws InterruptedException {
//        String url = "https://qa.koel.app/";
//        driver.get(url);
//        Thread.sleep(1000);
//    }
}
