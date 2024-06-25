package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PlayListPage extends BasePage {

    // Constructors
    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//i[@data-testid=\"sidebar-create-playlist-btn\"][@title=\"Create a new playlist\"][@class=\"fa fa-plus-circle create\"]")
    private WebElement getCreateNewPlayListBtn;

    @FindBy(xpath = "//li[@data-testid=\"playlist-context-menu-create-simple\"][contains(text(), \"New Playlist\")]")
    private WebElement getNewPlayListBtn;

    @FindBy(xpath = "//input [@placeholder=\"↵ to save\"][@name=\"name\"][@required=\"required\"]")
    private WebElement getTitleNameField;

    @FindBy(xpath = "//a[contains(text(), 'TestPro Playlist')]")
    private WebElement getPlayListToDelete;

//  @FindBy(xpath = "//a[contains(text(), namePlaylist)]")
//  By getPlayListToDelete;

    @FindBy(xpath = "//button[@class=\"del btn-delete-playlist\"][@title=\"Delete this playlist\"]")
    private WebElement getPlayListToDeleteBtn;

    @FindBy(xpath = "//button[@class=\"ok\"][contains(text(), OK)]")
    private WebElement getPlayListToDeleteOkBtn;

    @FindBy(xpath = "//*[@id=\"songResultsWrapper\"]//table[@class=\"items\"]")
    private WebElement getFirstSong;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")
    private WebElement getAddSongToBtn;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playlistName)]")
    private WebElement getChoosePlayList;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playlistName)]")
    private WebElement getChoosePlayListField;

    @FindBy(xpath = "//*[contains(text(), 'Created playlist \""  + "TestPro Playlist" + ".\"')]")
    private WebElement getCreatedVerificationMsg;

    @FindBy(xpath = "//*[contains(text(), 'Deleted playlist \""  + "TestPro Playlist" + ".\"')]")
    private WebElement getDeletedVerificationMsg;

    @FindBy(xpath = "//*[contains(text(), 'Added 1 song into \"" + "TestPro Playlist" + ".\"')]")
    private WebElement getAddedVerificationMsg;

//    @FindBy(xpath = "//*[contains(text(), 'Created playlist \""  + "playlistName" + ".\"')]")
//    private WebElement getCreatedVerificationMsg;

//    @FindBy(xpath = "//*[contains(text(), 'Deleted playlist \""  + "playlistName" + ".\"')]")
//    private WebElement getDeletedVerificationMsg;

//    @FindBy(xpath = "//*[contains(text(), 'Added 1 song into \"" + "playlistName" + ".\"')]")
//    private WebElement getAddedVerificationMsg;

//    @FindBy(xpath = "//*[contains(text(), '\"Created playlist \"\"  +  playlistName  + \".\"\"')]")
//    private WebElement getCreatedVerificationMsg;

//    @FindBy(xpath = "//*[contains(text(), '\"Deleted playlist \"\"  +  playlistName  + \".\"\"')]")
//    private WebElement getDeletedVerificationMsg;

//    @FindBy(xpath = "//*[contains(text(), '\"Added 1 song into \"\" +  playlistName  + \".\"\"')]")
//    private WebElement getAddedVerificationMsg;

    @FindBy(css = "input[type='search']")
    private WebElement getSearchSongField;

    @FindBy(css = "button[data-test='view-all-songs-btn']")
    private WebElement getViewAllSongs;

    @FindBy(css = "div.success.show")
    private WebElement getVerificationNoticeMsg;

    // Page Methods
    // Very basic methods
    public void selectCreateNewPlayListBtn () {
        mouseOverAndClick(getCreateNewPlayListBtn);
    }

    public void selectNewPlayListBtn () {

        getNewPlayListBtn.click();
    }

    public void selectTitleNameField(String playListName) {

        getTitleNameField.clear();
        getTitleNameField.sendKeys(playListName + "\n");
    }

    public String selectVerificationNoticeMsg() {

        return getVerificationNoticeMsg.getText();
    }

    public String selectDeletedVerifyNotificationMsg() {

        return getDeletedVerificationMsg.getText();
    }

    public String selectAddedVerifyNotificationMsg() {

        return getAddedVerificationMsg.getText();
    }

    public String selectCreatedVerifyNotificationMsg() {

        return getCreatedVerificationMsg.getText();
    }

    public void selectPlayListToDelete () {

        getPlayListToDelete.click();
        getPlayListToDeleteBtn.click();
        waitForPresence(getPlayListToDeleteOkBtn).click();

//        findElement(getPlayListToDelete).click();
//        findElement(getPlayListToDeleteBtn).click();
//        waitForPresence(getPlayListToDeleteOkBtn).click();

//        mouseOverAndContextClick(getPlayListToDelete);
//        mouseOverAndClick(getPlayListToDeleteBtn);
//        mouseOverAndClick(getPlayListToDeleteOkBtn);

    }

    public void selectPlayListToDeleteBtn () {

        getPlayListToDeleteBtn.click();
    }

    public void selectSearchSongField (String songName) {

        getSearchSongField.sendKeys(songName + "\n");
    }

    public void selectViewAllSongs () {

        getViewAllSongs.click();
    }

    public void selectFirstSong () {

        getFirstSong.click();
    }

    public void selectAddSongToBtn () {

        getAddSongToBtn.click();
    }

    public void selectChoosePlayList () {

        getChoosePlayList.click();
    }

}