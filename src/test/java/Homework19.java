import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import page.AllSongsPage;
import page.HomePage;
import page.LoginPage;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() {

// Given: User is on login page
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

// GIVEN: Valid email and password and clicks submit user is set to home page
        loginPage.login();

//THEN: User is able to delete a playlist
        String deleteNotification = "Deleted playlist lazy days";
        clickLazyDays();
        allSongsPage.removePlaylist();


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


