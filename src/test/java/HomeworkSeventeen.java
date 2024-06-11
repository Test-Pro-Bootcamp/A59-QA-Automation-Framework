import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeworkSeventeen extends BaseTest {

    @Test(enabled = true)
    public void addSongToPlaylist() throws InterruptedException {

        navigateToPage();
        provideEmail(email);
        providePassword(password);
        loginSubmit();
        Thread.sleep(3000);
        provideSearch();
        Thread.sleep(1000);
        viewAllSubmit();
        firstSongResultSelect();
        addTo();
        Thread.sleep(3000);
        selectPlaylist();
        Thread.sleep(1000);
        WebElement successMessage = driver.findElement(By.cssSelector("div[class='success show']"));
        System.out.println(successMessage.getText());
        Assert.assertEquals(successMessage.getText(), "Added 1 song into \"Playlist1.\"");

    }

    private void selectPlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//header//div//div//section[@class='existing-playlists']//ul//li[@class='playlist'][1]"));
        playlist.click();
    }

    private void addTo() {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
    }

    private void firstSongResultSelect() {
        WebElement firstSong = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//div//div//table//tr[1]"));
        firstSong.click();
    }

    private void viewAllSubmit() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }

    private void loginSubmit() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    private void provideSearch() {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("Days");
    }

    private void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    private void navigateToPage() {
        driver.get(url);
    }
}