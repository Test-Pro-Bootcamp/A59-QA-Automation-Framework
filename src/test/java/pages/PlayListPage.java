package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlayListPage extends BasePage {

    // Constructors
    public PlayListPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    // Locators
    By getCreateNewPlayListBtn =    By.xpath("//i[@data-testid=\"sidebar-create-playlist-btn\"][@title=\"Create a new playlist\"][@class=\"fa fa-plus-circle create\"]");
    By getNewPlayListBtn =          By.xpath("//li[@data-testid=\"playlist-context-menu-create-simple\"][contains(text(), \"New Playlist\")]");
    By getTitleNameField =          By.xpath("//input [@placeholder=\"↵ to save\"][@name=\"name\"][@required=\"required\"]");
    By getPlayListToDelete =        By.xpath("//a[contains(text(), 'TestPro Playlist')]");
//  By getPlayListToDelete =        By.xpath("//a[contains(text(), namePlaylist)]");
    By getPlayListToDeleteBtn =     By.xpath("//button[@class=\"del btn-delete-playlist\"][@title=\"Delete this playlist\"]");
    By getPlayListToDeleteOkBtn =   By.xpath("//button[@class=\"ok\"][contains(text(), OK)]");
    By getFirstSong =               By.xpath("//*[@id=\"songResultsWrapper\"]//table[@class=\"items\"]");
    By getAddSongToBtn =            By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']");
    By getChoosePlayList =          By.xpath("//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playlistName)]");
    By getChoosePlayListField =     By.xpath("//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playlistName)]");

    By getCreatedVerificationMsg =  By.xpath("//*[contains(text(), 'Created playlist \""  + "TestPro Playlist" + ".\"')]");
    By getDeletedVerificationMsg =  By.xpath("//*[contains(text(), 'Deleted playlist \""  + "TestPro Playlist" + ".\"')]");
    By getAddedVerificationMsg =    By.xpath("//*[contains(text(), 'Added 1 song into \"" + "TestPro Playlist" + ".\"')]");

//    By getCreatedVerificationMsg =  By.xpath("//*[contains(text(), 'Created playlist \""  + "playlistName" + ".\"')]");
//    By getDeletedVerificationMsg =  By.xpath("//*[contains(text(), 'Deleted playlist \""  + "playlistName" + ".\"')]");
//    By getAddedVerificationMsg =    By.xpath("//*[contains(text(), 'Added 1 song into \"" + "playlistName" + ".\"')]");

//    By getCreatedVerificationMsg =  By.xpath("//*[contains(text(), '\"Created playlist \"\"  +  playlistName  + \".\"\"')]");
//    By getDeletedVerificationMsg =  By.xpath("//*[contains(text(), '\"Deleted playlist \"\"  +  playlistName  + \".\"\"')]");
//    By getAddedVerificationMsg =    By.xpath("//*[contains(text(), '\"Added 1 song into \"\" +  playlistName  + \".\"\"')]");

    By getSearchSongField =         By.cssSelector("input[type='search']");
    By getViewAllSongs =            By.cssSelector("button[data-test='view-all-songs-btn']");
    By getVerificationNoticeMsg =   By.cssSelector("div.success.show");

    // Page Methods
    // Very basic methods
    public void selectCreateNewPlayListBtn () {
        mouseOverAndClick(getCreateNewPlayListBtn);
    }

    public void selectNewPlayListBtn () {

        findElement(getNewPlayListBtn).click();
    }

    public void selectTitleNameField(String playListName) {

        findElement(getTitleNameField).clear();
        findElement(getTitleNameField).sendKeys(playListName + "\n");
    }

    public String selectVerificationNoticeMsg() {

        return findElement(getVerificationNoticeMsg).getText();
    }

    public String selectDeletedVerifyNotificationMsg() {

        return findElement(getDeletedVerificationMsg).getText();
    }

    public String selectAddedVerifyNotificationMsg() {

        return findElement(getAddedVerificationMsg).getText();
    }

    public String selectCreatedVerifyNotificationMsg() {

        return findElement(getCreatedVerificationMsg).getText();
    }

    public void selectPlayListToDelete () {

        findElement(getPlayListToDelete).click();
        findElement(getPlayListToDeleteBtn).click();
        waitForPresence(getPlayListToDeleteOkBtn).click();

//        findElement(getPlayListToDelete).click();
//        findElement(getPlayListToDeleteBtn).click();
//        waitForPresence(getPlayListToDeleteOkBtn).click();

//        mouseOverAndContextClick(getPlayListToDelete);
//        mouseOverAndClick(getPlayListToDeleteBtn);
//        mouseOverAndClick(getPlayListToDeleteOkBtn);

    }

    public void selectPlayListToDeleteBtn () {

        findElement(getPlayListToDeleteBtn).click();
    }

    public void selectSearchSongField (String songName) {

        findElement(getSearchSongField).sendKeys(songName + "\n");
    }

    public void selectViewAllSongs () {

        findElement(getViewAllSongs).click();
    }

    public void selectFirstSong () {

        findElement(getFirstSong).click();
    }

    public void selectAddSongToBtn () {

        findElement(getAddSongToBtn).click();
    }

    public void selectChoosePlayList () {

        findElement(getChoosePlayList).click();
    }

}