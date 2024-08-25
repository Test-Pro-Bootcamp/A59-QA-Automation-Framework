import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String newPlayList = "Playlist for hw";

    @Test
public void renamePlayListHw(){

    String updPlayListMsg = "Updated playlist \"Playlist for hw.\"";
        //login
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
        //Choose Play list
        myPlayList("Test Playlist for HW21");

        //Double click on Play list Name
        doubleClickUserPlayList();

        //Enter New Name
        enterNewNamePlayList();

        Assert.assertEquals(successPlayListMessagePopup(),updPlayListMsg);

    }

    public String successPlayListMessagePopup(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void enterNewNamePlayList() {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        inputField.sendKeys(newPlayList);
        inputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickUserPlayList() {
        WebElement userPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(userPlayList).perform();
    }

    public void myPlayList(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }

}
