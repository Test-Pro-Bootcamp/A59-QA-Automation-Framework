import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfileTests  extends BaseTest{
    private void changeName(String name) throws InterruptedException {
        Thread.sleep(1000);
        }
    private void saveChanges() {
        WebElement saveButton = driver.findElement(By.cssSelector("btn-submit"));
    }
    private void enterNewName(String name){
        WebElement newName = driver.findElement(By.id("inputProfileName"));
        newName.clear();
        newName.sendKeys(name);
    }
    private void enterCurrentPassword(String password){
        WebElement currentPaswordField =driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPaswordField.sendKeys(password);
    }
    private void navigateToProfilePage(){
        WebElement profileName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.name")));
        profileName.click();
    }
}
