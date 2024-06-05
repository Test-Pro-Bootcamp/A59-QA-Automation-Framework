import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest{
@Test
  public void  addSongToPlaylist(){

  String expectedAddedSongMsg = "Added 1 song into \"NewPlaylist.\"";
  navigateToPage();
  enterEmail();
  enterPassword();
  submit();
  searchSong("dark");
  selectSong();
  selectPlaylist();
  Assert.assertEquals(getPlaylistSuccessMsg(), expectedAddedSongMsg);


    }

    public void searchSong(String songName){
      WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));

      searchField.clear();
      searchField.sendKeys(songName);
      WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
      viewAllBtn.click();
    }

    public void selectSong (){
  WebElement firstSong = driver.findElement(By.xpath
          ("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
  firstSong.click();
  WebElement addToBtn = driver.findElement(By.cssSelector("button[data-test=\"add-to-btn\"]"));
  addToBtn.click();
    }

    public void selectPlaylist(){
  WebElement playlist = driver.findElement
          (By.xpath("//*[@id=\"songResultsWrapper\"]//li[contains(text(), \"NewPlaylist\")]"));
  playlist.click();
    }

    public String getPlaylistSuccessMsg(){
  WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
  return notification.getText();
    }
}
