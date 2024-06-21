import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest {


    @Test
    public void changeProfileName() throws InterruptedException {
        //navigateToPage();
        login();
        navigateToProfilePage();
        String uniqueName = generateUniqueName();
        changeName(uniqueName);
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);

    }

    private void login() throws InterruptedException {
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
    }

    private String getProfileName() {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    private String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    private void changeName(String name) throws InterruptedException {
        enterCurrentPassword("ak1234!@#$");
        enterNewName(name);
        saveChages();
        Thread.sleep(1000);

    }

    private void saveChages() {
        WebElement saveButton = driver.findElement(By.className("btn-submit"));
        saveButton.click();
    }

    private void enterNewName(String name) {
        WebElement newName = driver.findElement(By.id("inputProfileName"));
        newName.clear();
        newName.sendKeys(name);
    }

    private void enterCurrentPassword(String password) {
        WebElement currentPasswordField = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.sendKeys(password);
    }

    private void navigateToProfilePage() {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        profileName.click();

    }
}