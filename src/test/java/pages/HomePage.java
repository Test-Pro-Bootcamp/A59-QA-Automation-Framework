package pages;

import org.openqa.selenium.*;

public class HomePage extends BasePage{

    String newPlaylistName = "Sample Edited Playlist";
    String expectedRenameVerificationMsg = "Updated playlist \"" + newPlaylistName + ".\"" ;
    String playlistName = "TestPro Playlist";

    //Constructor

    public HomePage(WebDriver givenDriver){

        super(givenDriver);
    }

    //Locators

    By userAvatarIcon =             By.cssSelector("img.avatar");
    By allSongsList =               By.cssSelector("li a.songs");
    By getPlayListToEdit =          By.xpath("//a[contains(text(), 'TestPro Playlist')]");
    By getPlayListToEditBtn =       By.xpath("//*[starts-with(@data-testid,\"playlist-context-menu-edit\")]");
    By getPlayListToEditField =     By.xpath("//input[starts-with(@data-testid, \"inline-playlist-name-input\")]");
    By getRenameVerificationMsg =   By.xpath("//*[contains(text(), 'Updated playlist \""  + newPlaylistName + ".\"')]");
    By getPlayList =                By.xpath("//a[contains(text(),'" + playlistName +"')]");
    By getPlayBtn =                 By.xpath("//span[@class=\"album-thumb-wrapper\"]");
    By getSoundBars =               By.cssSelector("img[alt='Sound bars']");
    By getSongCount =               By.cssSelector("section#playlistWrapper td.title");


    //Methods

    public int selectSongCount() {
        return driver.findElements(getSongCount).size();
    }

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    public void mouseOverBtn() {
        mouseOver(getPlayList);
    }

    public void mouseOverPlayBtn() {
        mouseOver(getPlayBtn);
    }

    public void chooseAllSongsList() {
        findElement(allSongsList).click();
    }

    public String selectRenamePlaylistSuccessMsg() {
        return findElement(getRenameVerificationMsg).getText();
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
        findElement(getPlayListToEdit).click();
    }

    public void selectPlaylistToEditBtn() {
        findElement(getPlayListToEditBtn).click();
    }

    public void selectPlaylistByName() {
      findElement(getPlayList).click();
    }

    public void selectPlaylistFieldName() {
        findElement(getPlayListToEditField).sendKeys(Keys.chord(Keys.CONTROL,"A"), Keys.BACK_SPACE);
        findElement(getPlayListToEditField).sendKeys(newPlaylistName);
        findElement(getPlayListToEditField).sendKeys(Keys.ENTER);
    }

    public void selectPlaylistAndClick() {
        findElement(getPlayList).click();
    }

    public void selectPlaylistAndMoveMouseTo() {
        findElement(getPlayList).click();
    }

    public WebElement selectSoundBars() {
        return findElement(getSoundBars);
    }

    public String selectRenameVerifyNotificationMsg() {
        return findElement(getRenameVerificationMsg).getText();
    }
}
