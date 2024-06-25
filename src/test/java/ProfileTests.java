import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfileTests extends BaseTest {

    private void changeName(String name) throws InterruptedException {
        Thread.sleep(1000);
        enterNewName(name);
        saveChanges();
    }

    private void saveChanges() {
        WebElement saveButton = getDriver().findElement(By.cssSelector("btn-submit"));
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
        WebElement profileName = getDriver().findElement(By.cssSelector("span.name"));
        profileName.click();
    }
}
