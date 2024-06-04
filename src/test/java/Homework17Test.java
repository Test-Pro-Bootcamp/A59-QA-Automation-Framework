import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Kristina.\"";

        navigateToPage();
        enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();
        searchForSong("dark");
        clickViewAllButton();
        clickFirstSong();
        clickAddToBtn();
        Thread.sleep(2000);
        choosePlaylist();
        Thread.sleep(2000);
        Assert.assertEquals(getAddToPlaylistMessage(),expectedSongAddedMessage);


    }

    public String getAddToPlaylistMessage() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();

    }


    public void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Kristina')]"));
        playlist.click();
    }

    public void clickViewAllButton() throws InterruptedException {
        WebElement clickViewAllButton = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        clickViewAllButton.click();
        Thread.sleep(2000);

    }

    public void searchForSong(String songName) throws InterruptedException {
        WebElement searchInput = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchInput.sendKeys(songName);
        Thread.sleep(2000);
    }

    public void clickFirstSong() {
        WebElement clickSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        clickSong.click();
    }
}










