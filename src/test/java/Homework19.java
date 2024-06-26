import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

        WebElement addPlayList = driver.findElement(By.cssSelector("#playlists i[role='button']"));
        addPlayList.click();
        Thread.sleep(3000);

        WebElement createPlayListBtn = driver.findElement(By.cssSelector("li[data-test id='playlist-context-menu-create-simple']"));
        createPlayListBtn.click();

        WebElement playListNameInput = driver.findElement(By.cssSelector("[name='create-simple-playlist-form']>input"));
        playListNameInput.sendKeys(playListName);
        playListNameInput.sendKeys(Keys.ENTER);
        Thread.sleep(3000);


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
