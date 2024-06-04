import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.UUID;

public class Homework17 extends BaseTest {

    // ALso I could not figure out how to get ride of the red line under the Homework17

@Test
    public void addSongToPlaylist() {

    //navigate
    navigateToPage();
    //login
    enterEmail("demo@testpro.io");
    enterPassword("te$t$tudent");
    submit();
    //search for song
   searchField();
   //click view all button
    clickAllBtn();
    //click first song in results
    clickFirstSong();

    //click add button

    //chose a play list

    //actual vs expected






    }

    private void clickFirstSong() {
        WebElement clickFirstSong = driver.findElement(By.cssSelector(By.xpath());
        //i cant find the xpath and im stuck
    }

    public void clickAllBtn() {
        WebElement clickAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        clickAllBtn.click();
    }

    public void searchField() {
        WebElement searchFiled = driver.findElement(By.cssSelector("input[type='search']"));
        searchFiled.clear();
        searchFiled.sendKeys("music");
        submit();
    }


}

