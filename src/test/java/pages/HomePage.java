package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    //Constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locator
    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By addPlayList = By.cssSelector("i[data-testid='sidebar-create-playlist-btn']");
    private By createPlayListBtn = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    private By playListNameInput = By.cssSelector("[name='create-simple-playlist-form']>input");
    private By allSongsList = By.cssSelector("li a.songs");



    //Methods
    public WebElement getUserAvatar(){

        return findElement(userAvatarIcon);
    }
    public WebElement getAddPlaylist(){

        return findElement(addPlayList);
    }
    public WebElement getCreatePlayListBtn(){

        return findElement(createPlayListBtn);
    }
    public WebElement getPlayListNameInput(){
        return findElement(playListNameInput);
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
        findElement(allSongsList).click();
    }
}
