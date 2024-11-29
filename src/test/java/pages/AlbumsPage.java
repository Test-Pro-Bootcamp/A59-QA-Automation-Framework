package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlbumsPage extends BasePage{
    public AlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By choosePlayFirstSong = By.xpath("//section[@id='albumsWrapper']//article[1]//a[@class='control control-play font-size-0']");



    public WebElement getChoosePlayFirstSong(){
        return findElement(choosePlayFirstSong);}
    public void playFirstSong(){
        getChoosePlayFirstSong().click();
    }

}
