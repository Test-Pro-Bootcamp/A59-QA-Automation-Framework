import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        //Given
        String nameSong = "pluto";

        String namePlaylist = "TestPro Playlist";
        String expectedSongAddMessage = "Added 1 song into \"" + namePlaylist + ".\"";


        //When
        login("demo@class.com", "te$t$tudent");
        Thread.sleep(2000);
        searchField();
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        chosePlaylist();


        //Then Asserting
        Assert.assertEquals(getAddToPlayListSuccessMsg(), expectedSongAddMessage);
    }

    public void searchField(String nameSong) throws InterruptedException {
        WebElement searchField = driver.findElement
                (By.cssSelector("div#searchFrom input[type='search']"));
        Thread.sleep(2000);

    }


    public void clickAddToBtn() throws InterruptedException {
        WebElement clickAddToBtn = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//button[[data-test='add-to-btn']]"));
        clickAddToBtn.click();
        Thread.sleep(2000);


    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement selectFirstSongResult = driver.findElement
                (By.xpath(" //section[@id='songResultWrapper']//tr[@class='song-item'][1]"));
        selectFirstSongResult.click();
        Thread.sleep(2000);
    }


    public void clickViewAllBtn() throws InterruptedException {
        WebElement clickViewAllBtn = driver.findElement
                (By.xpath("//button[@data-test='view-all-songs-btn']"));
        Thread.sleep(2000);
    }

    public void chosePlaylist(String namePlayList) throws InterruptedException {
        WebElement choosePlaylist = driver.findElement
                (By.xpath("//*[@id='songResultsWrapper']//*[contains9text(), '" + namePlayList + "')"));
        choosePlaylist.click();
        Thread.sleep(2000);
    }

    public String getAddToPlayListSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.Shows"));
        return notification.getText();


    }

}

