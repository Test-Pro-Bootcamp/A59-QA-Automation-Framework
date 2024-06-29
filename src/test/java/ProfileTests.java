import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;


public class ProfileTests extends BaseTest{

    @Test
   /* public void changeProfileName() throws InterruptedException {
        //navigateToPage();
        login();
        navigateToProfilePage();
        String uniqueName = generateUniqueName();
        changeName(uniqueName);
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);
    }

    */

    private void login() throws InterruptedException {
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
    }

    private String getProfileName() {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.name")));
                //getDriver().findElement(By.cssSelector("span.name"));

        return profileName.getText();
    }

    private String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private void changeName(String name) throws InterruptedException {
        enterCurrentPassword("te$t$tudent");
        enterNewName(name);
        saveChanges();
        Thread.sleep(1000);
    }

    private void saveChanges() {
        WebElement saveButton = getDriver().findElement(By.className("btn-submit"));
        saveButton.click();
    }

    private void enterNewName(String name) {
        WebElement newName = getDriver().findElement(By.id("inputProfileName"));
        newName.clear();
        newName.sendKeys(name);
    }

    private void enterCurrentPassword(String password) {
        WebElement currentPasswordField = getDriver().findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.sendKeys(password);
    }

    private void navigateToProfilePage() {
        WebElement profileName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.name")));
        profileName.click();
    }
}
