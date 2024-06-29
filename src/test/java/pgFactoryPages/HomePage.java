package pgFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locators
    @FindBy(css="img.avatar")
    private WebElement userAvatarIcon;

    @FindBy(css="li a.songs")
    private WebElement allSongsList;

    //Methods
    public boolean isUserAvatarDisplayed() {
        return userAvatarIcon.isDisplayed();
    }

    public void chooseAllSongsList(){
        allSongsList.click();
    }
}