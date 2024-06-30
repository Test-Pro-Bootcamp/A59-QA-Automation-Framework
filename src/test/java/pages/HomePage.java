package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    String newPlaylistName = "Sample Edited Playlist";
    String expectedRenameVerificationMsg = "Updated playlist \"" + newPlaylistName + ".\"" ;
    String playlistName = "TestPro Playlist";

    //Constructor

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    @FindBy(css = "li a.songs")
    private WebElement allSongsList;

    @FindBy(css = "img[alt='Sound bars']")
    private WebElement getSoundBars;

    @FindBy(css = "section#playlistWrapper td.title")
    private List<WebElement> getSongCount;



//    @FindBy(xpath = "//a[contains(text(), 'TestPro Playlist')]")
    @FindBy(xpath = "//a[contains(text(), playlistName)]")
    private WebElement getPlayListToEdit;

    @FindBy(xpath = "//*[starts-with(@data-testid,\"playlist-context-menu-edit\")]")
    private WebElement getPlayListToEditBtn;

    @FindBy(xpath = "//input[starts-with(@data-testid, \"inline-playlist-name-input\")]")
    private WebElement getPlayListToEditField;

    @FindBy(xpath = "//*[contains(text(), 'Updated playlist '\"'  + newPlaylistName + '\" + '.')]")
    private WebElement getRenameVerificationMsg;  // Recheck this later

//    @FindBy(xpath = "//a[contains(text(),\"' + playlistName + \"')]")
    @FindBy(xpath = "//a[contains(text(),'TestPro Playlist')]")
//    @FindBy(xpath = "//a[contains(text(),'TestPro Playlist')]")
//    @FindBy(xpath = "//a[contains(text(),'" + playlistName + "')]")
    private WebElement getPlayList;               // Recheck this later

    @FindBy(xpath = "//span[@class=\"album-thumb-wrapper\"]")
    private WebElement getPlayBtn;

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement getFirstPlaylist;

    @FindBy(css = "[name='name']")
    private WebElement getPlaylistNameField;

    @FindBy(css = "div.success.show")
    private WebElement getPlaylistSuccessMsg;

    @FindBy(css = "[data-testid = 'sound-bar-play'")
    private WebElement getIsSongPlaying;

    @FindBy(css = "span.meta.text-secondary span.meta")
    private WebElement getPlaylistDetails;

    @FindBy(css = "a.view-profile")
    private WebElement profileIcon;

    ///////////////////////

    @FindBy(css = "[data-testid='play-next-btn']")
    private WebElement getPlayNextSongBtn;

    @FindBy(css = "[data-testid='play-btn']")
    private WebElement getPlaySongBtn;


    //Methods

    public HomePage clickProfileIcon() {
        click(profileIcon);
        return this;
    }

    public String selectPlaylistDetails() {

        return getPlaylistDetails.getText();
    }

    public void selectDisplayAllSongs() {

        System.out.println("Number of Songs found:  " + getSongCount.size());

        for (WebElement e: getSongCount) {
            System.out.println(e.getText());
        }
    }

    public int selectSongCount() {

        //count and display song names
//        System.out.println("Number of Songs found:  " + songsCount());
//        System.out.println("Number of Songs found:  " + getSongCount.size());
//
//        for (WebElement e: getSongCount) {
//            System.out.println(e.getText());
//        }

        return getSongCount.size();
    }

    public WebElement getUserAvatar() {

        return userAvatarIcon;
    }

    public void mouseOverBtn() {

        mouseOver(getPlayList);
    }

    public void mouseOverPlayBtn() {

        mouseOver(getPlayBtn);

    }

    public void mouseOverPlayNextBtn() {

//        waitForVisibility(getPlayNextSongBtn);
        mouseOver(getPlayNextSongBtn);
    }

    public void selectPlayNextBtnToSingleClick() {

        singleClickBtn(getPlayNextSongBtn);
    }

    public void chooseAllSongsList() {

        allSongsList.click();
    }

    public String selectRenamePlaylistSuccessMsg() {

        return getRenameVerificationMsg.getText();
    }


    public void selectPlayBtnToSingleClick() {

        singleClickBtn(getPlayBtn);
    }

    public void selectPlayBtnToDoubleClick() {

        doubleClickBtn(getPlayBtn);
    }

    public void selectPlaylistToSingleClick() {

        singleClickBtn(getPlayList);
    }

    public void selectPlaylistToDoubleClick() {

        doubleClickBtn(getPlayList);
    }

    public void selectPlaylistToEdit() {

        getPlayListToEdit.click();
    }

    public void selectPlaylistToEditBtn() {

        getPlayListToEditBtn.click();
    }

    public void selectPlaylistByName() {

        getPlayList.click();
    }

    public boolean selectIsSongPlaying() {

        return getIsSongPlaying.isDisplayed();
    }

    public void selectPlaylistFieldName() {

        getPlayListToEditField.sendKeys(Keys.chord(Keys.CONTROL,"A"), Keys.BACK_SPACE);
        getPlayListToEditField.sendKeys(newPlaylistName);
        getPlayListToEditField.sendKeys(Keys.ENTER);
    }

    public void selectPlaylistAndClick() {

        getPlayList.click();
    }

    public void selectPlaylistAndMoveMouseTo() {

        getPlayList.click();
    }

    public WebElement selectSoundBars() {

        return getSoundBars;
    }

    public String selectRenameVerifyNotificationMsg() {

        return getRenameVerificationMsg.getText();
    }

    public void setGetSongCount(WebElement getSongCount) {

//        this.getSongCount = getSongCount;
    }

    public boolean isNotDisplayedUserAvatarIcon() {
        // Utilizes the waitForElementToBeNotVisible method to check if the user avatar icon is not visible
        return waitForElementToBeNotVisible(userAvatarIcon);
    }
}
