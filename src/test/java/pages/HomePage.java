package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        return chooseArtistsList;
    }
    public void artistsList(){
        getChooseArtistsList().click();
    }

    public void createPlayList(String playListName){
        actions.moveToElement(getAddPlaylist()).perform();
        getAddPlaylist().click();
        getCreatePlayListBtn().click();
        getPlayListNameInput().click();
        getPlayListNameInput().sendKeys(playListName);
        getPlayListNameInput().sendKeys(Keys.ENTER);

    }
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
