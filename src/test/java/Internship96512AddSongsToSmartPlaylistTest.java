import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class Internship96512AddSongsToSmartPlaylistTest extends BaseTest {
    String newSmartPlaylistName = "My new smart playlist";

    @Test(priority = 1)
    public void createNewSmartPlaylist() {
        String expectedCreatedSmartPlaylistMessage = "Created playlist \"My new smart playlist.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Actions actions = new Actions(driver);

        loginPage.login();
        clickPlaylists();
        clickNewSmartPlaylist();
        inputNewSmartPlaylistName();
        clickAddGroupBtn();
        clickFirstCriteriaField();
        selectFirstCriteriaValue();
        clickSecondCriteriaField();
        selectSecondCriteriaValue();
        inputThirdCriteriaField();
        clickSaveBtn();
        Assert.assertEquals(getCreatedSmartPlaylistMessage(), expectedCreatedSmartPlaylistMessage);
    }

    public void clickPlaylists() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']")));
        clickPlaylist.click();
    }

    public void clickNewSmartPlaylist() {
        WebElement clickNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[2]")));
        clickNewPlaylistBtn.click();
    }

    public void inputNewSmartPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[1]/input")));
        newPlaylistName.sendKeys("My new smart playlist");
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public void clickAddGroupBtn() {
        WebElement clickAddGroupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/button")));
        clickAddGroupBtn.click();
    }

    public void clickFirstCriteriaField() {
        WebElement clickFirstCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]")));
        clickFirstCriteriaField.click();
    }

    public void selectFirstCriteriaValue() {
        WebElement selectFirstCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[2]")));
        selectFirstCriteriaValue.click();
    }

    public void clickSecondCriteriaField() {
        WebElement clickSecondCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]")));
        clickSecondCriteriaField.click();
    }

    public void selectSecondCriteriaValue() {
        WebElement selectSecondCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]/option[3]")));
        selectSecondCriteriaValue.click();
    }

    public void inputThirdCriteriaField() {
        WebElement inputThirdCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/span/input")));
        inputThirdCriteriaField.sendKeys("A");
        inputThirdCriteriaField.click();
    }

    public void clickSaveBtn() {
        WebElement clickSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/footer/button[1]")));
        clickSaveBtn.click();
    }

    public String getCreatedSmartPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    @Test(priority = 2, dependsOnMethods = "createNewSmartPlaylist")
    public void editSmartPlaylist() {
        String expectedUpdatedSmartPlaylistMessage = "Updated playlist \"My new smart playlist.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Actions actions = new Actions(driver);

        loginPage.login();
        selectExistedPlaylist();
        clickEditSmartPlaylist();
        changeFirstCriteriaField();
        changeFirstCriteriaValue();
        changeSecondCriteriaField();
        changeSecondCriteriaValue();
        changeThirdCriteriaField();
        addNewGroupBtn();
        inputSecondGroupOfCriteriaField();
        selectSecondGroupOfCriteriaValue();
        inputSecondGroupOfCriteriaSecondField();
        selectSecondGroupOfCriteriaSecondValue();
        inputSecondGroupCriteriaThirdField();
        clickSaveButton();
        getUpdatedSmartPlaylistMessage();
        Assert.assertEquals(getUpdatedSmartPlaylistMessage(), expectedUpdatedSmartPlaylistMessage);

    }

    public void selectExistedPlaylist() {
        WebElement selectExistedPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]")));
        actions.contextClick(selectExistedPlaylist).perform();
    }

    public void clickEditSmartPlaylist() {
        WebElement clickEditPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]")));
        clickEditPlaylist.click();
    }

    public void changeFirstCriteriaField() {
        WebElement changeFirstCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]")));
        changeFirstCriteriaField.click();
    }

    public void changeFirstCriteriaValue() {
        WebElement selectFirstCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[3]")));
        selectFirstCriteriaValue.click();
    }

    public void changeSecondCriteriaField() {
        WebElement changeSecondCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]")));
        changeSecondCriteriaField.click();
    }

    public void changeSecondCriteriaValue() {
        WebElement changeSecondCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]/option[5]")));
        changeSecondCriteriaValue.click();
    }

    public void changeThirdCriteriaField() {
        WebElement inputThirdCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/span/input")));
        inputThirdCriteriaField.clear();
        inputThirdCriteriaField.sendKeys("M");
        inputThirdCriteriaField.click();
    }

    public void addNewGroupBtn() {
        WebElement clickAddNewGroupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/button")));
        clickAddNewGroupBtn.click();
    }

    public void inputSecondGroupOfCriteriaField() {
        WebElement clickSecondGroupOfCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[1]")));
        clickSecondGroupOfCriteriaField.click();
    }

    public void selectSecondGroupOfCriteriaValue() {
        WebElement selectSecondGroupOfCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[1]/option[1]")));
        selectSecondGroupOfCriteriaValue.click();
    }

    public void inputSecondGroupOfCriteriaSecondField() {
        WebElement clickSecondGroupOfCriteriaSecondField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[2]")));
        clickSecondGroupOfCriteriaSecondField.click();
    }

    public void selectSecondGroupOfCriteriaSecondValue() {
        WebElement selectSecondGroupOfCriteriaSecondValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[2]/option[3]")));
        selectSecondGroupOfCriteriaSecondValue.click();
    }

    public void inputSecondGroupCriteriaThirdField() {
        WebElement inputSecondGroupCriteriaThirdField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/span/input")));
        inputSecondGroupCriteriaThirdField.sendKeys("H");
        inputSecondGroupCriteriaThirdField.click();
    }

    public void clickSaveButton() {
        WebElement clickSaveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/footer/button[1]")));
        clickSaveButton.click();
    }

    public String getUpdatedSmartPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    @Test(priority = 3, dependsOnMethods = "editSmartPlaylist")
    public void deleteSmartPlaylist() {
        String expectedDeletedSmartPlaylistMessage = "Deleted playlist \"My new smart playlist.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Actions actions = new Actions(driver);

        loginPage.login();
        selectPlaylist();
        clickDeleteSmartPlaylist();
        confirmDeletionOfSmartPlaylist();
        Assert.assertEquals(getDeletedSmartPlaylistMessage(), expectedDeletedSmartPlaylistMessage);


    }

    public void selectPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]")));
        actions.contextClick(selectPlaylist).perform();
    }

    public void clickDeleteSmartPlaylist() {
        WebElement clickDeletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[2]")));
        clickDeletePlaylist.click();
    }
    public void confirmDeletionOfSmartPlaylist() {
        WebElement clickOkDeletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/nav/button[2]")));
        clickOkDeletePlaylist.click();
    }

    public String getDeletedSmartPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}

