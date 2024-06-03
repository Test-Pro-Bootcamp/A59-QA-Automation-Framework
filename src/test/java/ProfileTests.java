import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        navigateToPage();
        enterEmail(email);
        enterPassword(password);
        submit();
        navigateToProfilePage();
        String uniqueName = generateUniqueName();
        changeName(uniqueName);
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);
    }

    private String getProfileName() {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    private String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    private void changeName(String name) {
        enterCurrentPassword("te$t$tudent");
        enterNewName(name);
        saveChanges();
    }

    private void enterCurrentPassword(String password) {
        WebElement currentPasswordField = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    private void enterNewName(String name) {
        WebElement newName = driver.findElement(By.id("inputProfileName"));
        newName.clear();
        newName.sendKeys(name);
    }

    private void saveChanges() {
        WebElement saveButton = driver.findElement(By.className("btn-submit"));
        saveButton.click();
    }

    private void navigateToProfilePage(){
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        profileName.click();
    }


}
