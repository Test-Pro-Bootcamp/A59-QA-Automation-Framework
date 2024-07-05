package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayListPage extends BasePage {


    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By deleteBtn = By.xpath("//button[contains(@class, 'del btn-delete-playlist')]");

    public WebElement getDeletePlayListBtn(){
        return findElement(deleteBtn);
    }

    public void deletePlayList(){
//        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'del btn-delete-playlist')]")));
        getDeletePlayListBtn().click();

    }
}
