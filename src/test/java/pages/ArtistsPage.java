package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArtistsPage extends BasePage{
    public ArtistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By chooseFirstSongPlaying = By.xpath("//section[@id='artistsWrapper']//article[1]//a[contains(text(),'artist')]");


    public WebElement getChooseFirstSongPlaying(){
        return findElement(chooseFirstSongPlaying);}
    public void firstSongPlaying(){
        getChooseFirstSongPlaying().click();
    }
}
