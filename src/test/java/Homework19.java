import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test

    public void deletePlayList() throws InterruptedException {


        String expectedDeletePlaylistMessage = "Deleted playlist \"Playlist 78.\"";

        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();

        //Choose to delete Play list 78
        clickChoosePlayList();
        clickRemovePlayList();

        //actual vs expected - Assert
        Assert.assertEquals(getDeletePlaylistMessage(),expectedDeletePlaylistMessage);

    }


    public String getDeletePlaylistMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    private void clickRemovePlayList() {
        WebElement removePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        //WebElement removePlayList = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        removePlayList.click();

    }

    private void clickChoosePlayList() {
        WebElement choosePlayList = driver.findElement(By.xpath("[href='\\#\\!\\/playlist\\/96410']"));

        choosePlayList.click();
    }


}
