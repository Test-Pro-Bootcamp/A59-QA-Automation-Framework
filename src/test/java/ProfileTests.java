import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.UUID;

public class ProfileTests extends BaseTest {

    String password = "ak1234!@#$";

    @Test
    public void changeProfileName() {
        String uniqueName = generateUniqueName();
        loginPage.login();
        profilePage.updateProfileName(uniqueName);
        Assert.assertEquals(getProfileName(), uniqueName);

    }
    private String getProfileName() {
        WebElement profileName = getDriver().findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }
    private String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-","");
    }
}