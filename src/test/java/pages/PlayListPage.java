package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
//    @FindBy(xpath = "//a[contains(text(),'"+playlistName+"')]")
    private WebElement getPlayListToDelete;

    @FindBy(xpath = "//button[@class=\"del btn-delete-playlist\"][@title=\"Delete this playlist\"]")
    private WebElement getPlayListToDeleteBtn;

    @FindBy(xpath = "//button[@class=\"ok\"][contains(text(), OK)]")
    private WebElement getPlayListToDeleteOkBtn;

    @FindBy(xpath = "//*[@id=\"songResultsWrapper\"]//table[@class=\"items\"]")
    private WebElement getFirstSong;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")
    private WebElement getAddSongToBtn;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playlistName)]")
//    @FindBy(xpath = "//a[contains(text(), playlistName)]")
    private WebElement getChoosePlayList;

    @FindBy(xpath = "//*[contains(text(), 'Created playlist \""  + "TestPro Playlist" + ".\"')]")
//    @FindBy(xpath = "//*[contains(text(), 'Created playlist ' + playlistName + '.')]")
    private WebElement getCreatedVerificationMsg;

    @FindBy(xpath = "//*[contains(text(), 'Deleted playlist \""  + "TestPro Playlist" + ".\"')]")
//    @FindBy(xpath = "//*[contains(text(), 'Deleted playlist '  + \" + playlistName + '.' + \")]")
//    @FindBy(xpath = "//*[contains(text(),  'Deleted playlist \"" + playlistName + "."."')]")
//    @FindBy(xpath = String.format("//*[contains(text(), 'Deleted playlist %s.')]", playlistName))
    private WebElement getDeletedVerificationMsg;

    @FindBy(xpath = "//*[contains(text(), 'Added 1 song into \"" + "TestPro Playlist" + ".\"')]")
    private WebElement getAddedVerificationMsg;

    @FindBy(css = "input[type='search']")
    private WebElement getSearchSongField;

    @FindBy(css = "button[data-test='view-all-songs-btn']")
    private WebElement getViewAllSongs;

    @FindBy(css = "div.success.show")
    private WebElement getVerificationNoticeMsg;

    // Page Methods - Very basic methods

    public void selectCreateNewPlayListBtn () {

        waitForVisibility(getCreateNewPlayListBtn);
        mouseOverAndClick(getCreateNewPlayListBtn);
    }

    public void selectNewPlayListBtn () {

        waitForVisibility(getNewPlayListBtn).click();
    }

    public void selectTitleNameField(String playListName) {

        waitForVisibility(getTitleNameField).clear();
        getTitleNameField.sendKeys(playListName + "\n");
    }

    public String selectVerificationNoticeMsg() {

        return waitForPresence(getVerificationNoticeMsg).getText();
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

        waitForVisibility(getPlayListToDelete).click();

        waitForVisibility(getPlayListToDeleteBtn).click();

//        System.out.println("This is the output: " + getPlayListToDelete.getText());
        waitForVisibility(getPlayListToDeleteOkBtn);
        if(getPlayListToDeleteOkBtn.isDisplayed()) {
            getPlayListToDeleteOkBtn.click();
        }
    }

    public void selectSearchSongField (String songName) {

        getSearchSongField.sendKeys(songName + "\n");
    }

    public void selectViewAllSongs () {

        waitForVisibility(getViewAllSongs).click();
    }

    public void selectFirstSong () {

        waitForVisibility(getFirstSong).click();
    }

    public void selectAddSongToBtn () {

        waitForVisibility(getAddSongToBtn).click();
    }

    public void selectChoosePlayList () {

        waitForVisibility(getChoosePlayList).click();
        System.out.println("This is the output: " + getChoosePlayList);
    }

    public void selectPlayListToDeleteBtn () {

        getPlayListToDeleteBtn.click();
    }

    public WebElement getGetPlayListToDelete() {
        return getPlayListToDelete;
    }
}