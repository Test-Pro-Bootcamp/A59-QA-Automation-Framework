package pgFactoryPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
        //new
        PageFactory.initElements(givenDriver, this); // Initialize WebElements
    }

    //Locators
    @FindBy(css="img.avatar")
   // @FindBy(xpath = "//*[@id='userBadge']/a[1]/img")
    private WebElement userAvatarIcon;

    @FindBy(css="li a.songs")
    private WebElement allSongsList;

    //Methods
    public WebElement getUserAvatar(){
        return userAvatarIcon;

    }

    public void chooseAllSongsList(){
        allSongsList.click();
    }
}