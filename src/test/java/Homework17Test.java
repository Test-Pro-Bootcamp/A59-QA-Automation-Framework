import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.invokers.ExpectedExceptionsHolder;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        //String expectedCreatedPlaylistMessage = "Created playlist \"Kristina.\"";
        String expectedSongAddedMessage = "Added 1 song into \"Kristina.\"";

        //navigateToPage();
        enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();
        //clickPlaylists();
        //clickNewPlaylist();
        //inputNewPlaylistName();
        //Assert.assertEquals(getCreatedPlaylistMessage(),expectedCreatedPlaylistMessage);
        searchForSong("dark");
        clickViewAllButton();
        clickFirstSong();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistMessage(), expectedSongAddedMessage);


    }


    public void clickAddToBtn() {
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        addToBtn.click();

    }

    public void choosePlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Kristina')]")));
        playlist.click();
    }

    public void clickViewAllButton() throws InterruptedException {
        WebElement clickViewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn']")));
        clickViewAllButton.click();

    }

    public void searchForSong(String songName) throws InterruptedException {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#searchForm input[type='search']")));
        searchInput.sendKeys(songName);
    }

    public void clickFirstSong() {
        WebElement clickSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        clickSong.click();
    }

    public void clickPlaylists() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']")));
        clickPlaylist.click();
    }

    public void clickNewPlaylist() {
        WebElement clickNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]")));
        clickNewPlaylistBtn.click();
    }

    public void inputNewPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/form/input")));
        newPlaylistName.sendKeys("Kristina");
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public String getAddToPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();

    }

    public String getCreatedPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}










