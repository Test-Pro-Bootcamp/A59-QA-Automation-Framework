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
    String newPassword = "Ilya!461";
    String newEmail = "11111hek@gmail.com";

By navigateToProfilePage = By.cssSelector("span.name");
By profileName = By.cssSelector("span.name");
By saveBtn = By.className("btn-submit");
By newName = By.id("inputProfileName");
By currentPassword = By.id("inputProfileCurrentPassword");
By profileEmail = By.cssSelector("input[id='inputProfileEmail']");
By profilePassword = By.cssSelector("input[id='inputProfileNewPassword']");

    public WebElement getNavigateToProfilePage(){
        return findElement(navigateToProfilePage);
    }
    public WebElement getProfileName(){
        return findElement(profileName);
    }
    public WebElement getSaveBtn(){
        return findElement(saveBtn);
    }
    public WebElement getNewName(){
        return findElement(newName);
    }
    public WebElement getCurrentPassword(String password){
        return findElement(currentPassword);
    }

    public void updateProfileName(String uniqueName){
        actions.moveToElement(getNavigateToProfilePage()).perform();
        getNewName().click();
        getNewName().clear();
        getNewName().sendKeys(uniqueName);
        getCurrentPassword(password).click();
        getCurrentPassword(password).sendKeys(password);
        getSaveBtn().click();
    }
    public WebElement getProfileEmail(){
        return findElement(profileEmail);
    }
    public WebElement getProfilePassword(){
        return findElement(profilePassword);
    }
    public void updateEmailPassword(String newEmail,String newPassword){
        actions.moveToElement(getNavigateToProfilePage()).perform();
        getCurrentPassword(password).click();
        getCurrentPassword(password).sendKeys(password);
        getProfileEmail().click();
        getProfileEmail().clear();
        getProfileEmail().sendKeys(newEmail);
        getProfilePassword().click();
        getProfilePassword().clear();
        getProfilePassword().sendKeys(newPassword);
        getSaveBtn().click();
    }


}
