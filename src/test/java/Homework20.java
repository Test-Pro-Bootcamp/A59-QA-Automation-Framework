import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework20 extends BaseTest {

    @Test

    public void deletePlayList() {         // Without 'Thread.sleep(s)'

        String playListName = "Playlist 78";

        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
        //Thread.sleep(4000);

        WebElement addPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        //WebElement addPlayList = driver.findElement(By.cssSelector("#playlists i[role='button']"));
        addPlayList.click();
        //Thread.sleep(3000);

        WebElement createPlayListBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        //WebElement createPlayListBtn = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        createPlayListBtn.click();

        WebElement playListNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='create-simple-playlist-form']>input")));
        //WebElement playListNameInput = driver.findElement(By.cssSelector("[name='create-simple-playlist-form']>input"));
        playListNameInput.sendKeys(playListName);
        playListNameInput.sendKeys(Keys.ENTER);
        //Thread.sleep(3000);

        //WebElement choosePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li//a[text()='Playlist 78']")));
        WebElement choosePlayList = driver.findElement(By.xpath("//section[@id='playlists']//li//a[text()='Playlist 78']"));
        choosePlayList.click();
        //Thread.sleep(3000);

        //Delete Play list
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'del btn-delete-playlist')]")));
        //WebElement deleteBtn = driver.findElement(By.xpath("//button[contains(@class, 'del btn-delete-playlist')]"));
        deleteBtn.click();
        //Thread.sleep(3000);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@id='playlists']//li//a[text()='Playlist 78']")));
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@id='playlists']//li//a[text()='Playlist 78']"))));


    }

}
