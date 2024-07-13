package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends page.BasePage {

    //CONSTRUCTOR

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //LOCATOR
    By userAvatarIcon = By.cssSelector("img.avatar");

    // By allSongsList = By.cssSelector("li a.songs");
    // By clickAddToBtn = By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']");
    // By allBtn = By.xpath("//button[@data-test='view-all-songs-btn']");


    @FindBy(css = "li a.songs")
    WebElement allSongsList;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")
    WebElement addToBtn;

    @FindBy(xpath = "//button[@data-test='view-all-songs-btn']")
    WebElement allBtn;


    //METHODS
    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }


    public void chooseAllSongsList() {
        allSongsList.click();
        //findElement(allSongsList).click();
    }

    public void clickAddToBtn() {
        addToBtn.click();
    }

    public void viewAllBtn() {
        allBtn.click();
    }

}



