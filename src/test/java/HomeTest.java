import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

  String newPlaylistName = "Sample Edited Playlist";

  @Test
    public void HoverPLayButtonAndPlaySongs() throws InterruptedException {

      //Login

      enterEmail("christina.taylor@testpro.io");
      enterPassword("jKV0uSX6z1dv");
      submit();
      Thread.sleep(1000);
      Assert.assertTrue(hoverPlay().isDisplayed());


    }


    @Test
    public void CountSongsInPLaylist() throws InterruptedException {


    //login

      enterEmail("christina.taylor@testpro.io");
      enterPassword("jKV0uSX6z1dv");
      submit();

      //Chose a playlist by name
      choosePlaylistByName("TestPro Playlist");
      Thread.sleep(1000);
      //DisplayAllSongs
      displayAllSongs();
      //Number of songs are  equal to number of songs displayed in the info section
      Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(songCount())));
      // above is checking if string 1 is equal to string 2

  }
@Test
  public void renamePlaylist() throws InterruptedException {

String updatedPlaylistMsg = "Updated playlist \" Sample Edited Playlist.\"";
//login
  enterEmail("christina.taylor@testpro.io");
  enterPassword("jKV0uSX6z1dv");
  submit();
  // double click on playlist name
  doubleClickPlaylist();
  Thread.sleep(2000);
  // enter new Name
  enterNewName();
  Thread.sleep(1000);
  // Assert
  Assert.assertEquals(getRenamePlaylistSuccessMgs(),updatedPlaylistMsg);
  Thread.sleep(1000);

}

  public void enterNewName() {
    WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.cssSelector("[name='name']")));
    playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A"),Keys.BACK_SPACE);
    playlistInputField.sendKeys(newPlaylistName);
    playlistInputField.sendKeys(Keys.ENTER);
  }

  public String getRenamePlaylistSuccessMgs() {
    WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.cssSelector("div.success.show")));
    return notification.getText();



  }

  public void doubleClickPlaylist() {

    WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.cssSelector(".playlist:nth-child(3)")));
    actions.doubleClick(playlist).perform();
  }

  public String getPlaylistDetails(){
    return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
  // helper method

  public int songCount(){

    return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();

  }

    public void displayAllSongs() {
    List<WebElement> songList = driver.findElements
              (By.cssSelector("section#playlistWrapper td.title"));
      System.out.println("Number of Songs found:" + songCount());
      for (WebElement e : songList) {
        System.out.println(e.getText());
      }

    }

  public void choosePlaylistByName(String playlistName) {
    wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();

  }

    public WebElement hoverPlay(){

      WebElement playBtn = driver.findElement
              (By.cssSelector("[data-testid= 'play-btn']"));
      actions.moveToElement(playBtn).perform();
      return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
}
