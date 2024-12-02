import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17 {
@Test
public void addSongToPL ()
{
String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

navigateToPage();
provideEmail("demo@testpro.io");
providePassword("tes$t$tudent");
clickSubmit();
Thread.sleep(2000)
        searchSong("Pluto");
clickViewBtn();
ClickFirstSongResult();

}

    private void clickSubmit() {
    }

    private void ClickFirstSongResult()  {

}

private void clickViewBtn() throws InterruptedException {

    WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"))
    addToButton.click();
    Thread.sleep(2000);

}
private void choosePlaylist () throws InterruptedException {
    WebElement playlist = driver.findElement(By.xpath("//section[@id='songsResultWrapper']//li[contains(text(),'Test Pro Playlist')]'));
}

public String getAddToPlaylistsuccessMsg() {
    WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
    return notification.getText();
}

    private Object providePassword(String tes$t$tudent) {
    }

    private void provideEmail(String s) {
    }

    private void navigateToPage() {
    }

    {
    }
}
