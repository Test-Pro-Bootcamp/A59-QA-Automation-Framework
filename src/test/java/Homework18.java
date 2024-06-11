import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// Use appropriate XML file to specify which suites, tests, classes, methods to run.
// For this homework, use the Homework18.xml file.
// Use build.gradle to specify which suites to run.
// Then open terminal, navigate to repository directory, run: gradle clean test

public class Homework18 extends BaseTest {

    @Test (enabled = true)
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail(email);
        providePassword(password);
        loginSubmit();
        playNext();
        play();
        checkPlaying();
    }

    private void checkPlaying() {
        WebElement pauseBtn = driver.findElement(By.xpath("//span[@data-testid='pause-btn']"));
        System.out.println(pauseBtn.getAttribute("data-testid"));
        Assert.assertEquals(pauseBtn.getAttribute("data-testid"), "pause-btn");
    }

    private void play() {
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playBtn.click();
    }

    private void playNext() {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextBtn.click();
    }

    private void checkAddedSongMessage() {
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

    private void provideSearch(String searchTerm) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(searchTerm);
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