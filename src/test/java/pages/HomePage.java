package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    //Constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locator
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css = "i[data-testid='sidebar-create-playlist-btn']")
    private WebElement addPlayList;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    private WebElement createPlayListBtn;
    @FindBy(css = "[name='create-simple-playlist-form']>input")
    private WebElement playListNameInput;
    @FindBy(css = "li a.songs")
    private WebElement allSongsList;
    @FindBy(css = "a[class='queue active']")
    private WebElement clickCurrentQueueSongs;
    @FindBy(css = "a[class='artists']")
    private WebElement chooseAlbumsList;
    @FindBy(css = "section[current-view='Artists']")
    private WebElement chooseArtistsList;
    @FindBy(css = "div#searchForm input[type='search']")
    private WebElement searchSong;
    @FindBy(xpath = "//button[@data-test='view-all-songs-btn']")
    private WebElement viewAllBtn;
    @FindBy(xpath = "//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")
    private WebElement firstSong;
    @FindBy(xpath = "//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")
    private WebElement addToBtn;
    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[contains(text(),'Test Playlist 78')]")
    private WebElement addToPlayList;
    @FindBy(css = "div.success.show")
    private WebElement addToPlayListMessage;
    @FindBy(xpath = "//a[contains(text(),'\"+playlistName+\"')]")
    private WebElement myPlayList;
    @FindBy(css = ".playlist:nth-child(5)")
    private WebElement userPlayList;
    @FindBy(css = "[name='name']")
    private WebElement newNamePlayList;
    @FindBy(css = "div.success.show")
    private WebElement successPlayListMessagePopup;
    @FindBy(css = "[data-testid='play-btn']")
    private WebElement hoverPlay;
    @FindBy(css = "a[href='#!/playlist/99154']")
    private WebElement choosePlayListByName;
    @FindBy(css = ".playlist:nth-child(6)")
    private WebElement playList;
    @FindBy(css = "[name='name']")
    private WebElement playListInputField;
    @FindBy(css = "div.success.show")
    private WebElement renamePlayListSuccessMsg;

    //Methods
    public WebElement getUserAvatar(){
        return userAvatarIcon;
    }
    public WebElement getAddPlaylist(){
        return addPlayList;
    }
    public WebElement getCreatePlayListBtn(){
        return createPlayListBtn;
    }
    public WebElement getPlayListNameInput(){
        return playListNameInput;
    }
    public WebElement getClickCurrentQueueSongs(){
        return clickCurrentQueueSongs;}
    public void currentQueueSongs(){
        getClickCurrentQueueSongs().click();
    }
    public WebElement getChooseAlbumsList(){
        return chooseAlbumsList;
    }
    public void albumsList(){
        getChooseAlbumsList().click();
    }
    public WebElement getChooseArtistsList(){
        return chooseArtistsList;}
    public void artistsList(){
        getChooseArtistsList().click();}
    public WebElement getSearchSong(){
        return searchSong;}
    public WebElement getViewAllBtn(){
        return viewAllBtn;}
    public void clickViewAllBtn(){ getViewAllBtn().click();}
    public WebElement getFirstSong(){ return firstSong; }
    public void selectFirstSong(){getFirstSong().click();}
    public WebElement getAddToBtn(){ return addToBtn; }
    public void clickAddToBtn(){ getAddToBtn().click(); }
    public WebElement getAddToPlayList(){ return addToPlayList; }
    public void choosePlayList(){ getAddToPlayList().click(); }
    public WebElement getAddToPlayListMessage(){ return addToPlayListMessage; }
    public WebElement getMyPlayList(){ return myPlayList; }
    public void chooseMyPlayList(String currentPlayList){ getMyPlayList().click();}
    public WebElement getUserPlayList(){ return userPlayList; }
    public WebElement getNewNamePlayList(){ return newNamePlayList; }
    public WebElement getSuccessPlayListMessagePopup(String updPlayListMsg){ return successPlayListMessagePopup; }
    public WebElement getHoverPlay(){ return hoverPlay; }
    public WebElement getChoosePlayListByName(){ return choosePlayListByName; }
    public void clickChoosePlayListByName(String playListForTest){ getChoosePlayListByName().click();}
    public WebElement getPlayList(){ return playList; }
    public WebElement getPlayListInputField(){ return playListInputField; }
    public WebElement getRenamePlayListSuccessMsg(String updatedPlayListMsg){ return renamePlayListSuccessMsg; }

    public void enterNewNamePlayList(String playListName){
        actions.doubleClick(getPlayList()).perform();
        getPlayListInputField().sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        getPlayListInputField().sendKeys(playListName);
        getPlayListInputField().sendKeys(Keys.ENTER);

    }


    public void enterNamePlayList(String newPlayList){
        actions.doubleClick(getUserPlayList()).perform();
        getNewNamePlayList().sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        getNewNamePlayList().sendKeys(newPlayList);
        getNewNamePlayList().sendKeys(Keys.ENTER);
    }


    public void enterSearchSong(String songName){
        actions.moveToElement(getSearchSong()).perform();
        getSearchSong().click();
        getSearchSong().sendKeys(songName);
    }

    public void createPlayList(String playListName){
        actions.moveToElement(getAddPlaylist()).perform();
        getAddPlaylist().click();
        getCreatePlayListBtn().click();
        getPlayListNameInput().click();
        getPlayListNameInput().sendKeys(playListName);
        getPlayListNameInput().sendKeys(Keys.ENTER);}

    public WebElement getPlayListByName(String playListName){
        return findElement(By.xpath(String.format("//section[@id='playlists']//li//a[text()='%s']", playListName)));
    }
    public void openPlayList(String playListName){
        getPlayListByName(playListName).click();
    }

    public void chooseAllSongsList (){
        allSongsList.click();
    }
}
