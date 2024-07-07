package pageFactory;

import org.openqa.selenium.By;
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

        @FindBy ( css = "li a.songs")
        WebElement allSongsList;

        //METHODS
        public WebElement getUserAvatarIcon() {
            return findElement(userAvatarIcon);
        }


        public void chooseAllSongsList() {
            allSongsList.click();

            //findElement(allSongsList).click();
        }
    }


