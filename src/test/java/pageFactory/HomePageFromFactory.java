package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageFactory.BasePageFromFactory;

public class HomePageFromFactory extends BasePageFromFactory {

    public HomePageFromFactory(WebDriver givenDriver) {
        super(givenDriver);
    }


    @FindBy(xpath = "//section[@id='playlists']//i[@class='fa fa-plus-circle create']")
    WebElement clickPlaylist;
    @FindBy(xpath = "//*[@id=\"playlists\"]/nav/ul/li[1]")
    WebElement clickNewPlaylist;
    @FindBy(xpath = "//*[@id=\"playlists\"]/form/input")
    WebElement enterNewPlaylistName;
    @FindBy(css = "div.success.show")
    WebElement getCreatedPlaylistMsg;

    public HomePageFromFactory clickPlaylists() {
        clickPlaylist.click();
        return this;
    }
    public HomePageFromFactory clickNewPlaylist() {
        clickNewPlaylist.click();
        return this;
    }
    public HomePageFromFactory enterNewPlaylistName() {
        enterNewPlaylistName.sendKeys("Kristina");
        enterNewPlaylistName.sendKeys(Keys.ENTER);
        return this;
    }
    public String getCreatedPlaylistMsg() {
        return getCreatedPlaylistMsg.getText();
    }
}
