import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test

    public void profileTest() throws InterruptedException {

        navigateToPage();
        enterEmail(email);
        enterPassword(password);
        submit();
        navigateToProfilePage();

        changeName(uniqueName );
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);
        






    }

    private String getProfileName() {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    private String generateUniquelyName() {
        return UUID.randomUUID().toString().replaceAll("-", "");

    }

    private void changeName(String name) throws InterruptedException {
        WebElement profileName = driver.findElement(By.cssSelector("[name='current_password']"));
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
*
 */