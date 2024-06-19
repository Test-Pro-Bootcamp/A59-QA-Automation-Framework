import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {

        String deleteNotification = "Deleted playlist lazy days";

        enterEmail("christina.taylor@testpro.io");

        enterPassword("jKV0uSX6z1dv");
        submit();
        //select lazy days
        clickLazyDays();
        // delete button

        removePlaylist();

        // ok button to conform
        //Verify that the confirmation notification
        // displayed has the text, "Deleted playlist {playlist name}".

        // notification message


    }



        public String deletedPlaylist() {
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("div.success.show")));
            return notification.getText();


}

    public void removePlaylist() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("button[class='del btn-delete-playlist']")));
        deletePlaylist.click();
    }

    public void clickLazyDays() {
        WebElement lazyDays = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[class='playlist playlist']")));
        lazyDays.click();
    }
}


