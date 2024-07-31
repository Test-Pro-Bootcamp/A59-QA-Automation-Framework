import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NewSmartPlayList extends BaseTest{
    @Test
    public void startNewSmartPlayList() throws InterruptedException {
        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        btnPlayList();
        btnCreateNewSmartList();
        Assert.assertTrue(btnNewNameSmartList());
    }

    public void btnPlayList(){
        WebElement clickBtnCreateNewSmartPlayListe = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Create a new playlist']")));
        clickBtnCreateNewSmartPlayListe.click();
    }
    public void btnCreateNewSmartList(){
        WebElement clickBtnNewSmartList =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-smart']")));
        clickBtnNewSmartList.click();
    }
    public boolean btnNewNameSmartList(){
        WebElement clickBtnNameSmatrPlayList =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        clickBtnNameSmatrPlayList.click();
        clickBtnNameSmatrPlayList.clear();
        clickBtnNameSmatrPlayList.sendKeys("G2G");
        clickBtnNameSmatrPlayList.clear();
        return clickBtnNameSmatrPlayList.isDisplayed();
    }



}
