import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;
/*
public class ProfileTests extends BaseTest{

    @Test

    public void profileTest() throws InterruptedException {

       // navigateToPage();
        loginInfo();
        navigateToProfilePage();

        String uniqueName = generateUniquelyName();
        changeName(uniqueName );
        String profileName = getProfileName();
        //Assert.assertEquals(profileName, uniqueName);
        






    }

    private void loginInfo() throws InterruptedException {
        enterPassword("jKV0uSX6z1dv");
        enterEmail("christina.taylor@testpro.io");
        submit();
    }

    private String getProfileName() {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    private String generateUniquelyName() {
        return UUID.randomUUID().toString().replace("-","");

    }

    private void changeName(String name) throws InterruptedException {

        enterCurrentPassword("jKV0uSX6z1dv");
        enterNewName(name);
        saveChanges();



    }

    private void saveChanges() {
        WebElement saveButton = driver.findElement(By.className("btn-submit"));
        saveButton.click();
    }

    private void enterNewName(String name) {
        WebElement newName = driver.findElement(By.id("inputProfileName"));
        newName.sendKeys(name);

    }

    private void enterCurrentPassword(String password) {
        WebElement currentPasswordField = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }


    private void navigateToProfilePage() {
        WebElement profilePage= driver.findElement(By.cssSelector("span.name"));
      profilePage.getText();

    }
}
*/