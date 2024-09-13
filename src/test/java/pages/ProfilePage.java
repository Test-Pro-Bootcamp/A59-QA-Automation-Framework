package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.bouncycastle.oer.its.ieee1609dot2.CertificateId.name;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    String password = "ak1234!@#$";

By navigateToProfilePage = By.cssSelector("span.name");
By saveBtn = By.className("btn-submit");
By newName = By.id("inputProfileName");
By currentPassword = By.id("inputProfileCurrentPassword");
By profileEmail = By.cssSelector("input[id='inputProfileEmail']");
By profilePassword = By.cssSelector("input[id='inputProfileNewPassword']");
By errorMsg = By.cssSelector("div.error.show");

    public void getNavigateToProfilePage(){
        findElement(navigateToProfilePage);
    }

    public WebElement getErrorMsg(){ return findElement(errorMsg); }
    public WebElement getSaveBtn(){
        return findElement(saveBtn);
    }
    public WebElement getNewName(){
        return findElement(newName);
    }
    public WebElement getCurrentPassword(){
        return findElement(currentPassword);
    }

    public void updateProfileName(String uniqueName){
        actions.moveToElement(getCurrentPassword()).perform();
        getCurrentPassword().click();
        getCurrentPassword().clear();
        getCurrentPassword().sendKeys(password);
        getNewName().click();
        getNewName().clear();
        getNewName().sendKeys(uniqueName);
        getSaveBtn().click();
    }
    public WebElement getProfileEmail(){
        return findElement(profileEmail);
    }
    public WebElement getProfilePassword(){
        return findElement(profilePassword);
    }

    public void updateEmail(String newEmail){
        actions.moveToElement(getCurrentPassword()).perform();
        getCurrentPassword().click();
        getCurrentPassword().clear();
        getCurrentPassword().sendKeys(password);
        getProfileEmail().click();
        getProfileEmail().clear();
        getProfileEmail().sendKeys(newEmail);
        getSaveBtn().click();
    }
    public void updatePassword(String newPassword){
        actions.moveToElement(getCurrentPassword()).perform();
        getCurrentPassword().click();
        getCurrentPassword().clear();
        getCurrentPassword().sendKeys(password);
        getProfilePassword().click();
        getProfilePassword().clear();
        getProfilePassword().sendKeys(newPassword);
        getSaveBtn().click();
    }

    public void notValidPassword(String invalidPassword){
        actions.moveToElement(getCurrentPassword()).perform();
        getCurrentPassword().click();
        getCurrentPassword().clear();
        getCurrentPassword().sendKeys(password);
        getProfilePassword().click();
        getProfilePassword().clear();
        getProfilePassword().sendKeys(invalidPassword);
        getSaveBtn().click();
    }

}
