import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test

    public void changeProfileName() {

        navigateToPage();
        enterEmail("demo@testpro.com");
        enterPassword("te$t$tudent");
        submit();
        navigateToProfilePage();
        String uniqueName = generateUniqueName();
        changeName(uniqueName);
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);







    }

    private void navigateToProfilePage() {
        WebElement navigateToProfilePage = driver.findElement(By.cssSelector("span.name"));
    }

    private String getProfileName() {
        WebElement getProfileName = driver.findElement(By.cssSelector("span.name"));
        return getProfileName.getText();
    }

    private String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    private void changeName(String name) {
        enterCurrentPassword("te$t$tudent");
        enterNewName(name);
        saveChanges();

    }

    private void saveChanges() {

        WebElement saveButton = driver.findElement(By.className(".btn-submit"));
        saveButton.click();
    }

    private void enterNewName(String name) {
        WebElement newName= driver.findElement(By.id("inputProfileCurrentPassword"));
        newName.clear();
        newName.sendKeys("name");
    }

    private void enterCurrentPassword(String te$t$tudent) {
        WebElement enterCurrentPassword= driver.findElement(By.id("inputProfileCurrentPassword"));
        enterCurrentPassword.sendKeys("password");

    }

}
