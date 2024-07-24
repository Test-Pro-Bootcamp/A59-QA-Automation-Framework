import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AddSongsToPlayList extends BaseTest{

    @Test
    public void addSongsToPlayList() throws InterruptedException {
        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        newPlayList();
        btnNewPlaylist();
        Assert.assertTrue(createNewPlayList());
        Thread.sleep(1000);

    }
    private void newPlayList() throws InterruptedException {
        WebElement btnControl = driver.findElement(By.cssSelector("[title='Create a new playlist']"));
        Thread.sleep(1000);
        btnControl.click();

    }
    private  void btnNewPlaylist(){
        WebElement clickBtnNewPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        clickBtnNewPlaylist.click();
    }

    private boolean createNewPlayList () throws InterruptedException {
        WebElement btnCreateNewPlayList = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        btnCreateNewPlayList.click();
        btnCreateNewPlayList.clear();
        btnCreateNewPlayList.sendKeys("Nice");
        btnCreateNewPlayList.clear();
        Thread.sleep(500);
        return btnCreateNewPlayList.isDisplayed();
    }

}

