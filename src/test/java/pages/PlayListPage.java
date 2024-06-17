package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlayListPage extends BasePage {

    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    private By getCreateNewPlayListBtn = By.xpath("//i[@data-testid=\"sidebar-create-playlist-btn\"][@title=\"Create a new playlist\"][@class=\"fa fa-plus-circle create\"]");
    private By getNewPlayListBtn = By.xpath("//li[@data-testid=\"playlist-context-menu-create-simple\"][contains(text(), \"New Playlist\")]");
    private By getTitleNameField = By.xpath("//input [@placeholder=\"↵ to save\"][@name=\"name\"][@required=\"required\"]");
    private By getVerifyNotificationMsg = By.cssSelector("div.success.show");
    private By getPlayListToDelete = By.xpath("//a[contains(text(), playListName)]");
    private By getPlayListToSelect= By.xpath("//a[contains(text(), playListName)]");
    private By getPlayListToDeleteBtn = By.xpath("//button[@class=\"del btn-delete-playlist\"][@title=\"Delete this playlist\"]");
    private By getPlayListToDeleteOkBtn = By.xpath("//button[@class=\"ok\"][contains(text(), OK)]");
    private By getSearchSongField = By.cssSelector("input[type='search']");
    private By getViewAllSongs = By.cssSelector("button[data-test='view-all-songs-btn']");
    private By getFirstSong = By.xpath("//*[@id=\"songResultsWrapper\"]//table[@class=\"items\"]");
    private By getAddSongToBtn = By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']");
    private By getChoosePlayList = By.xpath("//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playListName)]");
    private By getChoosePlayListField = By.xpath("//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playListName)]");

    // Page Methods

//    public void mouseOverAndClick(By by) {
//        WebElement element = driver.findElement(by);
//        actions.moveToElement(element).click().perform();
//
//    }

    public PlayListPage selectCreateNewPlayListBtn() {
        driver.findElement(getCreateNewPlayListBtn).click();
        return this;
    }

    public PlayListPage selectNewPlayListBtn () {
        driver.findElement(getNewPlayListBtn).click();
        return this;
    }

    public PlayListPage selectTitleNameField(String playListName) {
        driver.findElement(getTitleNameField).clear();
        driver.findElement(getTitleNameField).sendKeys(playListName + "\n");
        return this;
    }

    public String selectVerifyNotificationMsg() {
        return findElement(getVerifyNotificationMsg).getText();
    }

    public PlayListPage selectPlayListToDeleteBtn() {
        driver.findElement(getPlayListToDeleteBtn).click();
        driver.findElement(getPlayListToDeleteOkBtn).click();
        return this;
    }

    public PlayListPage selectSearchSongField (String songName) {
        driver.findElement(getSearchSongField).sendKeys(songName + "\n");
        return this;
    }

    public PlayListPage selectViewAllSongs() {
        driver.findElement(getViewAllSongs).click();
        return this;
    }

    public PlayListPage selectFirstSong() {
        driver.findElement(getFirstSong).click();
        return this;
    }

    public PlayListPage selectAddSongToBtn() {
        driver.findElement(getAddSongToBtn).click();
        return this;
    }

    public PlayListPage selectChoosePlayList(String playListName) {
        driver.findElement(getPlayListToSelect).click();
        return this;
    }

}