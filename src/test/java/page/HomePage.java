package page;

import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {

    //CONSTRUCTOR

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //LOCATOR
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsList = By.cssSelector("li a.songs");
    By addToBtn = By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']");
    By allBtn = By.xpath("//button[@data-test='view-all-songs-btn']");
    By playlistFiled = By.cssSelector("[name='name']");
    //METHODS
    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }


    public void chooseAllSongsList() {

        findElement(allSongsList).click();

    }
        public void clickAddToBtn() {
            findElement(addToBtn).click();

    }
      public void viewAllBtn() {
          findElement(allBtn).click();
      }



      }






