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
    By userAvatarIcon = By.cssSelector("img.avatar");
    By addPlayList = By.cssSelector("i[data-testid='sidebar-create-playlist-btn']");
    By createPlayListBtn = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playListNameInput = By.cssSelector("[name='create-simple-playlist-form']>input");


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
        //Thread.sleep(3000);
       // WebElement createPlayListBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        //WebElement createPlayListBtn = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));


//        WebElement playListNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='create-simple-playlist-form']>input")));
        //WebElement playListNameInput = driver.findElement(By.cssSelector("[name='create-simple-playlist-form']>input"));
    }
    public WebElement getPlayListByName(String playListName){
        return findElement(By.xpath(String.format("//section[@id='playlists']//li//a[text()='%s']", playListName)));

    }

    public void openPlayList(String playListName){
//        WebElement choosePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.xpath(String.format("//section[@id='playlists']//li//a[text()='%s']", playListName))));
//        choosePlayList.click();
        getPlayListByName(playListName).click();

    }

}
