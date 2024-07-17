import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlbumsPage extends BaseTest{

    @Test
    public void albumsPage() throws InterruptedException {
       enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$tstudent");
        clickSubmit();
        Assert.assertTrue( btnAlbumsPage());


    }
    public boolean btnAlbumsPage(){
        WebElement clickBtnAlbumsPAge = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='albums']")));
        return clickBtnAlbumsPAge.isDisplayed();
    }
}
