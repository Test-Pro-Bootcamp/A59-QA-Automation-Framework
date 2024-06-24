import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test

    public void deletePlayList() throws InterruptedException {

        String playListName = "Playlist 78";

        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
        Thread.sleep(4000);

        //Choose to delete Play list 78
        WebElement choosePlayList = driver.findElement(By.xpath("//section[@id='playlists']//li//a[text()='Playlist 78']"));
        choosePlayList.click();
        Thread.sleep(3000);

        //Delete Play list
        WebElement deleteBtn = driver.findElement(By.xpath("//button[contains(@class, 'del btn-delete-playlist')]"));
        deleteBtn.click();
        Thread.sleep(3000);

        Assert.assertFalse(choosePlayList.isDisplayed());


    }



}
