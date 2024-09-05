import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        // navigateToPage();
        login();
        Thread.sleep(1500);
        navigateToProfilePage();
        String uniqueName = generateUniqueName();
        changeName(uniqueName);
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);
    }

    private void login() throws InterruptedException {
        enterEmail("leon.poyau+2@testpro.io");
        enterPassword("N6wWY2Rx");
        submit();
    }

    private String getProfileName() {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.name")));
        //WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    private String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private void changeName(String name) throws InterruptedException {
        enterCurrentPassword("N6wWY2Rx");
        enterNewName(name);
        saveChanges();
        Thread.sleep(1000);
    }

    private void saveChanges() {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-submit")));
        //WebElement saveButton = driver.findElement(By.className("btn-submit"));
        saveButton.click();
    }

    private void enterNewName(String name) {
        WebElement newName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputProfileName")));
        //WebElement newName = driver.findElement(By.id("inputProfileName"));
        newName.clear();
        newName.sendKeys(name);
    }

    private void enterCurrentPassword(String password) {
        WebElement currentPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputProfileCurrentPassword")));
        //WebElement currentPasswordField = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.sendKeys(password);
    }

    private void navigateToProfilePage() {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.name")));
        //WebElement profileName = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.name")));
        // original line below using driver.findElement
        //WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        profileName.click();
    }
}
